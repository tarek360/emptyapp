package com.example.empty.emptyapp

class KotlinPresenter : Presenter {

  var data = ""

  override fun loadData(list: List<String>?): String {

    if (list != null && !list.isEmpty()) {
      data = "loaded"
    }

    return data
  }

  var num = 9

  fun myFunc(x: Any, y: Any, z: Any, a: Any, v: Any, b: Any, n: Any, m: Any, q: Any) {

    if (x == 2) {

    } else if (x == 3) {

    } else if (y == 9) {

    } else {

    }


    when {

    }

    when (x) {
      5 -> {

      }
    }


  }
}