package com.example.empty.emptyapp

class KotlinPresenter : Presenter {

  var data = ""

  override fun loadData(list: List<String>?): String {

    if (list != null && !list.isEmpty()) {
      data = "loaded"
    }

    return data
  }
}
