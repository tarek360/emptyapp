package com.example.empty.emptyapp

class PresenterKt {

  private fun loadData(list: List<String>?): String {

    var data = ""
    if (list != null && !list.isEmpty()) {
      data = "loaded"
    }

    return data
  }
}
