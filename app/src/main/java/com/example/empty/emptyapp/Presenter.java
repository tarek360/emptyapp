package com.example.empty.emptyapp;

import java.util.List;

public class Presenter {

  String data = "";

  String loadData(List<String> list) {

    if (list != null && !list.isEmpty()) {
      data = "loaded";
    }

    return data;
  }
}
