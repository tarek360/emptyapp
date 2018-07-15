package com.example.empty.emptyapp;

import android.support.annotation.NonNull;
import java.util.List;

public class JavaPresenter implements Presenter {

  String data = "";

  @NonNull @Override public String loadData(List<String> list) {

    if (list != null && !list.isEmpty()) {
      data = "loaded";
    }

    return data;
  }
}
