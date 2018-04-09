package com.gradledevextreme.light.indooratlaspro;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.gradledevextreme.light.indooratlaspro.View.Activities.AddLocationActivity.AddLocationActivity;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Espresso Automation Testing for Adding current location
 */


@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddLocationActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(AddLocationActivity.class);

    @Test
    public void addLocUsingCurrentLocBtn(){
        onView(withId(R.id.usingCurrentLocation)).perform(click());
        onView(withId(R.id.mName)).perform(typeText("cafeteria"));
    }

    @Test
    public void addLocUsingMap(){
        onView(withId(R.id.usingMapLocation)).perform(click());
         onView(withId(R.id.map)).check(matches(isDisplayed()));
    }
}
