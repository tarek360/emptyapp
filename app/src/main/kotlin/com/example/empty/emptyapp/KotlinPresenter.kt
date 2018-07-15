package com.example.empty.emptyapp

class KotlinPresenter : Presenter {

  override fun loadData(list: List<String>?): String {

    var data = ""
    if (list != null && !list.isEmpty()) {
      data = "loaded"
    }

    return data
  }
}
