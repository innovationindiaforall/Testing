package com.work.instrumentation;

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.work.instrumentation.view.MainActivity
import com.work.instrumentation.R
import org.junit.*
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private var intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)

    @Rule
    @JvmField
    var activityScenarioRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var activity: MainActivity

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

  /*  @Test
    fun test2() {
        //onView(withText(startsWith("Login"))).perform(click());
        //onView(withId(R.id.btnLogin)).perform(click())
        //onView(withId(R.id.btnLogin)).check(matches(withText(activity?.getString(R.string.login_page_signin))));

        //onView(withId(R.id.btnLogin)).check(matches(withText("Login")));
        onView(withText("Login")).perform(click());
    }*/

    @Test
    fun test3() {

        //onView(withText(endsWith("value1"))).check(matches(isDisplayed()));
        //onView(withText("value1")).check(matches(withText("value1")));
    }

    @After
    fun tearDown() {
        println("Running: tearDown");
    }


}