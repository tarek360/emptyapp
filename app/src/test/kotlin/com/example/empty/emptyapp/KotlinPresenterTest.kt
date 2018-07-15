package com.example.empty.emptyapp

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.ArrayList

class KotlinPresenterTest {

  private lateinit var presenter: KotlinPresenter

  @Before
  fun setUp() {
    presenter = KotlinPresenter()
  }

  @Test
  fun testLoadData() {
    //Arrange
    val list = ArrayList<String>()
    list.add("info")

    //Act
    presenter.loadData(list)

    //Assert
    assertEquals("loaded", presenter.data)
  }

  @Test
  fun testLoadData_withNullList() {

    //Act
    presenter.loadData(null)

    //Assert
    assertEquals("", presenter.data)
  }
}