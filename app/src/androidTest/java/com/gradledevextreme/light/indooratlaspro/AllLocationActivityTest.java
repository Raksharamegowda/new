package com.gradledevextreme.light.indooratlaspro;

import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.gradledevextreme.light.indooratlaspro.View.Activities.Main.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Espresso Automation Testing for AllLocationActivity to navigate to all locations
 */

@RunWith(AndroidJUnit4.class)
public class AllLocationActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onViewPagerClick(){
        onView(withId(R.id.imageViewNav)).perform(click());
        onView(withIndex(withId(R.id.name),0 )).perform(click());
        onView(withId(R.id.map)).check(matches(isDisplayed()));
        Espresso.pressBack();
    }

    @Test
    public void viewPagerClickAfterOneSwipe(){
        onView(withId(R.id.imageViewNav)).perform(click());
        onView(withId(R.id.mPager)).perform(swipeLeft());
        SystemClock.sleep(5000);
        onView(withIndex(withId(R.id.name),1 )).perform(click());
        onView(withId(R.id.map)).check(matches(isDisplayed()));
        Espresso.pressBack();
    }

    @Test
    public void viewPagerClickAfterTwoSwipe(){
        onView(withId(R.id.imageViewNav)).perform(click());
        onView(withId(R.id.mPager)).perform(swipeLeft());
        onView(withId(R.id.mPager)).perform(swipeRight());
        SystemClock.sleep(5000);
        onView(withIndex(withId(R.id.name),0 )).perform(click());
        onView(withId(R.id.map)).check(matches(isDisplayed()));
        Espresso.pressBack();
    }

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }
}
