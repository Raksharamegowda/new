package com.gradledevextreme.light.indooratlaspro;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.gradledevextreme.light.indooratlaspro.View.Activities.Main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Espresso Automation Testing on Main Activity
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void allLocBtnClick(){
        onView(withId(R.id.imageViewNav)).perform(click());
        onView(withId(R.id.mPager)).check(matches(isDisplayed()));
    }

    @Test
    public void favLocBtnClick(){
        onView(withId(R.id.wayFindingNav)).perform(click());
        onView(withId(R.id.mPager)).check(matches(isDisplayed()));
    }

    @Test
    public void addLocClick(){
        onView(withId(R.id.addlocations)).perform(click());
        onView(withId(R.id.usingCurrentLocation)).check(matches(isDisplayed()));
        onView(withId(R.id.usingMapLocation)).check(matches(isDisplayed()));
    }
}
