package com.example.empty.emptyapp;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PresenterTest {

  private Presenter presenter;

  @Before public void setUp() {
    presenter = new Presenter();
  }

  @Test public void testLoadData() {
    //Arrange
    ArrayList<String> list = new ArrayList<>();
    list.add("info");

    //Act
    presenter.loadData(list);

    //Assert
    assertEquals("loaded", presenter.data);
  }

  @Test public void testLoadData_withNullList() {

    //Act
    presenter.loadData(null);

    //Assert
    assertEquals("", presenter.data);
  }
}