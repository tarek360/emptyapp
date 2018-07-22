package com.example.empty.emptyapp

class Factory {

  fun createPresenter(type: String): Presenter {

    val x = 7

    if (x == 2) {

    } else if (x == 3) {

    } else {

    }

    return if (type == "java") {
      JavaPresenter()
    } else {
      KotlinPresenter()
    }
  }
}