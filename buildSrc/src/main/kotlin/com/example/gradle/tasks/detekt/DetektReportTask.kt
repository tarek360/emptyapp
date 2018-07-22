package com.example.gradle.tasks.detekt

import com.example.gradle.github.GithubCommitCommenter
import com.example.gradle.github.GithubStatusChecker
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class DetektReportTask : DefaultTask() {

  lateinit var sha: String
  lateinit var token: String

  @TaskAction
  fun report() {
    val report = ReportBuilder().build(sha)

    var commentUrl = ""
    if (!report.isPassed) {
      commentUrl = GithubCommitCommenter().createComment(token = token, message = report.body, sha = sha)
    }

    GithubStatusChecker().createStatus(token = token, sha = sha, isPassed = report.isPassed, targetUrl = commentUrl)
  }
}
