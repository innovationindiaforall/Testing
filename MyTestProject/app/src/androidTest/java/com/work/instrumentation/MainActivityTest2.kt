package com.work.instrumentation;

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.work.instrumentation.view.MainActivity
import com.work.instrumentation.R
import org.junit.*
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest2 {

    //Deprecated Format
    @Rule
    @JvmField
    var mActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java,
            true, false)

    @Before
    @Throws(Exception::class)
    fun setUp() {

        val intent = Intent()
        mActivityTestRule.launchActivity(intent)
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.work.instrumentation", appContext.packageName)
    }

    @Test
    fun test1_loginCredent() {

        onView(withId(R.id.etLoginMobileNo)).perform(typeText("1234567898"));
        onView(withId(R.id.etLogin6digitPwd)).perform(typeText("123456"), closeSoftKeyboard());

        //onView(withId(R.id.btnLogin)).check(matches(withText("Login")));
        Thread.sleep(2000)
        //onView(withText("Login")).perform(replaceText("Login Click"));
        onView(withText("Login")).perform(click());

        onView(withId(R.id.editTextTextPersonName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @After
    fun tearDown() {

    }

}
