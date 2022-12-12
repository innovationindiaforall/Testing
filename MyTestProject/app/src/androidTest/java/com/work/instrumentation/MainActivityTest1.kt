package com.work.instrumentation;

import android.app.Activity
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.work.instrumentation.view.MainActivity
import com.work.instrumentation.R
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest1 {

    private var intent =
        Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
    private var activity: Activity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
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

    }


}