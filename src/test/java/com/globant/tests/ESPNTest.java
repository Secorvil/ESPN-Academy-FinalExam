package com.globant.tests;

import com.globant.util.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ESPNTest extends BaseTest {

    @Test
    public void loginElementsExistTest() {
        log.info("Clicking \"Log In\" button");
        home.clickSideLogInButton();
        log.info("Switching to Login frame");
        driver.getDriver().switchTo().frame("oneid-iframe");
        log.info("Assert that logo and buttons are present");
        Assert.assertTrue(home.isElementVisible(home.getLogInESPNLogo()));
        Assert.assertTrue(home.isElementVisible(home.getFrameLogInButton()));
        Assert.assertTrue(home.isElementVisible(home.getFrameSignUpButton()));
    }

    @Test
    public void signupElementsExistTest() {
        log.info("Clicking \"Log In\" button");
        home.clickSideLogInButton();
        log.info("Switching to Login frame");
        driver.getDriver().switchTo().frame("oneid-iframe");
        log.info("Clicking frame \"Sign Up\" button");
        home.click(home.getFrameSignUpButton());
        log.info("Assert that title of \"Create Account\" frame matches expected title");
        Assert.assertEquals(home.getFrameSignUpTitle().getText(), "Create Account", "Expected title and actual title don't match");
        log.info("Assert each element of Sign Up form is present and visible");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(home.isElementVisible(home.getFirstNameInput()), "First name input is not present nor visible");
        softAssert.assertTrue(home.isElementVisible(home.getLastNameInput()), "Last name input is not present nor visible");
        softAssert.assertTrue(home.isElementVisible(home.getEmailInput()), "Email input is not present nor visible");
        softAssert.assertTrue(home.isElementVisible(home.getPasswordInput()), "Password input is not present nor visible");
        softAssert.assertTrue(home.isElementVisible(home.getSubmitSignUpButton()), "Sign up button is not present nor visible");
        softAssert.assertTrue(home.isElementVisible(home.getCloseButton()), "Close button is not present nor visible");
        softAssert.assertAll();
    }
}
