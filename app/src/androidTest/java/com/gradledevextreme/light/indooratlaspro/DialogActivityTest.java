package com.gradledevextreme.light.indooratlaspro;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.gradledevextreme.light.indooratlaspro.View.Activities.AddLocationActivity.AddLocationActivity;

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
 * Espresso Automation Testing for Dialog Activity to add location
 */

@RunWith(AndroidJUnit4.class)
public class DialogActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(AddLocationActivity.class);

    @Test
    public void addingLocation(){
        onView(withId(R.id.usingCurrentLocation)).perform(click());
        onView(withId(R.id.mName)).perform(typeText("Restroom"));
        onView(withId(R.id.okBtnId)).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
    }

    @Test
    public void cancelBtnClicked(){
        onView(withId(R.id.usingCurrentLocation)).perform(click());
        onView(withId(R.id.cancelBtnId)).perform(click());
        onView(withId(R.id.usingMapLocation)).check(matches(isDisplayed()));
    }

}
