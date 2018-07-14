package com.example.empty.emptyapp;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest @RunWith(AndroidJUnit4.class) public class MainActivityTest {

  @Rule public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

  @Test public void mainActivityTest() {
    ViewInteraction floatingActionButton = getFloatingButton();

    floatingActionButton.perform(click());
    floatingActionButton.perform(click());
    floatingActionButton.perform(click());
    floatingActionButton.perform(click());
    floatingActionButton.perform(click());

    getTextView().check(matches(allOf(withText("5"), hasTextColor(android.R.color.holo_red_dark))));
  }

  private ViewInteraction getFloatingButton() {
    return onView(withId(R.id.fab));
  }

  private ViewInteraction getTextView() {
    return onView(withId(R.id.counterTextView));
  }
}
