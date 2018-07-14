package com.example.empty.emptyapp;

import java.util.List;

public class Presenter {

  private String loadData(List<String> list) {

    String data = "";
    if (list != null && !list.isEmpty()) {
      data = "loaded";
    }

    return data;
  }
}
