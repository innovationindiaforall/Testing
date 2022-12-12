package com.work.instrumentation;

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.work.instrumentation.view.MainActivity
import com.work.instrumentation.R
import org.junit.*
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest0 {

    @get: Rule
    var activityScenarioRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.work.instrumentation", appContext.packageName)
    }

    @Test
    fun test1_loginCredent() {

        onView(withId(R.id.etLoginMobileNo)).perform(typeText("1234567898"));
        onView(withId(R.id.etLogin6digitPwd)).perform(typeText("123456"), closeSoftKeyboard());

        //onView(withId(R.id.btnLogin)).check(matches(isDisplayed()));
        //onView(withId(R.id.btnLogin)).check(matches(withText("Login")));
        Thread.sleep(2000)
        onView(withText("Login")).perform(click());
    }

    @After
    fun tearDown() {
        println("Running: tearDown");
    }


}