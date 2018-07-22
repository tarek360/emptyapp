package com.example.gradle

import java.io.File

class DetektReportBuilder {

  companion object {
    const val FILE_PATH = "reports/detekt/output/detekt-plain.txt"
  }

  fun build(sha: String): Report {
    val commentTitle = "### ----------------------------- Detekt Issues ☠️ -----------------------------"

    val sb = StringBuilder(commentTitle)
    sb.append('\n')

    var isPassed = true

    File(FILE_PATH).forEachLine {
      val line = it.split(" at ")
      val issueTitle = line[0]
      val location = line[1].split(" - ")[0]
      val locationParts = location.split(":")
      val fileName = locationParts[0].split("/").last()
      val lineNumber = locationParts[1]
      //app/src/main/kotlin/com/example/empty/emptyapp/KotlinPresenter.kt:22:24]

//      https://github.com/tarek360/emptyapp/blob/b8e472b90b0f0beeaf42a19ab7d26dc2c9606793/Factory.kt#L11

//      /Users/tarek/AndroidStudioProjects/emptyapp/app/src/main/kotlin/com/example/empty/emptyapp/Factory.kt:11:21

      val fileUrl = "$FILE_BASE_URL/$sha/$fileName#L$lineNumber"
      val issue = "- [$issueTitle]($fileUrl)\n"
      sb.append(issue)
      isPassed = false
    }

    println("isPassed: $isPassed")

    return Report(sb.toString(), isPassed)
  }

}