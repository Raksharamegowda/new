package com.gradledevextreme.light.indooratlaspro;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.gradledevextreme.light.indooratlaspro.View.Activities.DialogActivities.DialogActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Espresso Testing for Favorite Activity to add a location to favorite or not
 */

@RunWith(AndroidJUnit4.class)
public class FavoritesActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(DialogActivity.class);

    @Test
    public void addToFavorite(){
        onView(withId(R.id.mName)).perform(typeText("cafeteria"));
        onView(withId(R.id.okBtnId)).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.btnYes)).perform(click());
    }

    @Test
    public void doNotAddToFavorite(){
        onView(withId(R.id.mName)).perform(typeText("Restroom"));
        onView(withId(R.id.okBtnId)).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.btnNo)).perform(click());
    }

}
