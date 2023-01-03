package com.example.bdd.test;

import android.content.Intent;
import android.os.SystemClock;

import androidx.test.espresso.web.webdriver.Locator;
import androidx.test.filters.SmallTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.example.bdd.LoginActivity;
import com.example.bdd.R;

import org.junit.Rule;
import org.junit.runner.RunWith;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static androidx.test.espresso.web.sugar.Web.onWebView;
import static androidx.test.espresso.web.webdriver.DriverAtoms.findElement;
import static androidx.test.espresso.web.webdriver.DriverAtoms.webClick;
import static androidx.test.espresso.web.webdriver.DriverAtoms.webKeys;
import static org.junit.Assert.assertNotNull;

@SmallTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Rule
    private LoginActivity activity;


    @Before("@login-feature")
    public void setup() {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
    }

    @After("@login-feature")
    public void tearDown() {
        SystemClock.sleep(3000);
        activityTestRule.finishActivity();
    }

    @Given("^I have a login activity")
    public void I_have_a_login_activity() {
        assertNotNull(activity);
    }

    @When("^I input username (\\S+)$")
    public void I_input_username(final String username) {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText(username));
    }

    @And("^I input password (\\S+)$")
    public void I_input_password(final String password) {
        onView(withId(R.id.editTextNumberPassword)).perform(typeText(password), closeSoftKeyboard());

    }

    @And("^I press submit button$")
    public void I_press_submit_button() {
        SystemClock.sleep(3000);
        onView(withId(R.id.button)).perform(click());
    }

    @Then("^I should see on next activity")
    public void I_should_see_on_next_activity() {
        String xPath="/html/body/div[1]/main/div/div[2]/div/button";
        SystemClock.sleep(3000);
        onView(withId(R.id.txtview_SecondBtn)).perform(click());
        SystemClock.sleep(3000);
        onWebView(withId(R.id.webview1)).forceJavascriptEnabled();
        SystemClock.sleep(3000);

        //onWebView().withElement(findElement(Locator.XPATH, xPath)).perform(webClick());
        //onWebView().withElement(findElement(Locator.ID, "OK")).perform(webClick()).reset();
        //onWebView().withElement(findElement(Locator.XPATH, "Sign in")).perform(webClick()).reset();

        onWebView().withElement(findElement(Locator.ID,"username")).perform(webKeys("Covid2021")); // working fine.
        SystemClock.sleep(1000);
        onWebView().withElement(findElement(Locator.ID,"password")).perform(webKeys("123456")); // working fine.
        SystemClock.sleep(1000);
        onWebView().withElement(findElement(Locator.ID,"Login")).perform(webClick()); // button not working properly..
        SystemClock.sleep(500);

        //onWebView().withElement(findElement(Locator.ID,"//*[@id=\"gb\"]/div/div[2]/a")).perform(webClick());
        //onWebView().withElement(findElement(Locator.XPATH,"/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[3]/input")).perform(webClick()).reset();

       /* Web.onWebView(ViewMatchers.withId(R.id.webview1))
                .withElement(DriverAtoms.findElement(Locator.XPATH, xPath))
                .withNoTimeout()
                .check(WebViewAssertions.webMatches(DriverAtoms.getText(),
                        Matchers.equalTo("Sign in")));*/
       /* onWebView().withElement(findElement(Locator.ID, "Sign in")).perform(webClick());*/
        //onWebView().withElement(findElement(Locator.ID,"Sign in")).perform(DriverAtoms.webClick());
        //onWebView().withElement(findElement(Locator.ID,"ALL")).perform(webClick()).reset();
        /*onWebView().withElement(findElement(Locator.ID, "Ok")).perform(webClick()).check(webMatches(getText(), containsString("Ok")));*/
        SystemClock.sleep(3000);
    }
}
