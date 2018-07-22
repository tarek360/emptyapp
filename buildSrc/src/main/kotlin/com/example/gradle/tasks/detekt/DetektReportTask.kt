package com.example.gradle.tasks.detekt

import com.example.gradle.github.GithubCommitCommenter
import com.example.gradle.github.GithubStatusChecker
import com.example.gradle.github.GithubStatusChecker.State.FAILURE
import com.example.gradle.github.GithubStatusChecker.State.SUCCESS
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class DetektReportTask : DefaultTask() {

  lateinit var sha: String
  lateinit var token: String

  @TaskAction
  fun report() {
    val report = ReportBuilder().build(sha)
    val state: GithubStatusChecker.State

    val message: String

    if (report.isPassed) {
      state = SUCCESS
      message = "✅ Detekt: Great Stuff! 👍"
    } else {
      state = FAILURE
      message = report.body
    }

    val commentUrl = GithubCommitCommenter().createComment(token = token, message = message, sha = sha)

    GithubStatusChecker().createStatus(token = token, sha = sha, state = state, targetUrl = commentUrl)
  }
}
