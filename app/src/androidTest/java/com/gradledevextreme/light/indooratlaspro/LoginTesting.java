package com.gradledevextreme.light.indooratlaspro;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.gradledevextreme.light.indooratlaspro.View.Activities.LoginActivities.LoginActivity;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Espresso Automation Testing On the Login Activity with valid and invalid credentials
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTesting {
   @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(LoginActivity.class);

   @Test
    public void loggingInWithBlankCredentials(){

       onView(withId(R.id.mEmployeeid)).perform(typeText(" "),closeSoftKeyboard());
       onView(withId(R.id.mEmployeepassword)).perform(typeText(" "),closeSoftKeyboard());
       onView(withId(R.id.btnLogin)).perform(click());
       onView(withText("OK")).check(matches(isDisplayed()));
    }

    @Test
    public void loggingInWithInvalidEmployeeId(){

        onView(withId(R.id.mEmployeeid)).perform(typeText("ABC"),closeSoftKeyboard());
        onView(withId(R.id.mEmployeepassword)).perform(typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withText("OK")).check(matches(isDisplayed()));
    }

    @Test
    public void loggingInWithInvalidPassword(){

        onView(withId(R.id.mEmployeeid)).perform(typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.mEmployeepassword)).perform(typeText("ABC"),closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withText("OK")).check(matches(isDisplayed()));
    }

    @Test
    public void loggingInWithValidCredentials(){
        onView(withId(R.id.mEmployeeid)).perform(typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.mEmployeepassword)).perform(typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        SystemClock.sleep(2000);
        onView(withId(R.id.imageViewNav)).check(matches(isDisplayed()));
    }


}
