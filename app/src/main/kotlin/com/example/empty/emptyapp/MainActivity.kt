package com.example.empty.emptyapp

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.fab
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.content_main.counterTextView

class MainActivity : AppCompatActivity() {

  private var counter = 1
  private val num = 7

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)

    fab.setOnClickListener { view ->
      counterTextView.text = (++counter).toString()
      if (counter >= 5) {
        counterTextView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
      } else {
        counterTextView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
      }
    }
  }
}
