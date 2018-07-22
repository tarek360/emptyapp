package com.example.empty.emptyapp

class Factory {

  fun createPresenter(type: String): Presenter {

    val x = 0

    if (x == 2) {

    } else if (x == 3) {

    }

    return if (type == "java") {
      JavaPresenter()
    } else {
      KotlinPresenter()
    }
  }
}