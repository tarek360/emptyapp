package com.example.empty.emptyapp

class Factory {

  fun createPresenter(type: String): Presenter {
    return if (type == "java") {
      JavaPresenter()
    } else {
      KotlinPresenter()
    }
  }
}