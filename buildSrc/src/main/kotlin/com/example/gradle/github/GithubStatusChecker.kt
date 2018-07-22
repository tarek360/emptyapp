package com.example.gradle.github

import net.soundvibe.jkob.json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor

open class GithubStatusChecker {

  fun createStatus(token: String, sha: String, isPassed: Boolean, targetUrl:String) {
    val url = "$API_BASE_URL/repos/$OWNER_NAME/$REPO_NAME/statuses/$sha"

    val state: String
    val description: String
    val context = "Detekt"

    if (isPassed) {
      state = "success"
      description = "Build Passed"
    } else {
      state = "failure"
      description = "Check the report in the comment"
    }

    val bodyJson = json {
      "state" to state
      "target_url" to targetUrl
      "description" to description
      "context" to context
    }

    val body = RequestBody.create(MediaType.parse("application/json"), bodyJson.toString())

    val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { m -> println(m) })

    logger.level = HttpLoggingInterceptor.Level.BODY

    val okhttp = OkHttpClient.Builder().addInterceptor(logger).build()


    val request = Request.Builder()
        .url(url)
        .addHeader("Authorization", "token $token")
        .post(body)
        .build()
    okhttp.newCall(request).execute()
  }
}