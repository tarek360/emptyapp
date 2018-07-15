package com.example.empty.emptyapp

import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class FactoryTest {

  private lateinit var factory: Factory

  @Before
  fun setUp() {
    factory = Factory()
  }

  @Test
  fun testCreateJavaPresenter() {
    //Act
    val presenter = factory.createPresenter("java")

    //Assert
    assertThat(presenter, instanceOf(JavaPresenter::class.java))
  }

  @Test
  fun testCreateKotlinPresenter() {
    //Act
    val presenter = factory.createPresenter("kotlin")

    //Assert
    assertThat(presenter, instanceOf(KotlinPresenter::class.java))
  }


}