package com.example.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class DetektReportTask : DefaultTask() {

  lateinit var sha: String
  lateinit var token: String

  @TaskAction
  fun report() {
    val report = DetektReportBuilder().build(sha)

    GithubStatusChecker().createStatus(token, sha, report.isPassed)

    if (!report.isPassed) {
      GithubCommitCommenter().createComment(token = token, message = report.body, sha = sha)
    }
  }
}
