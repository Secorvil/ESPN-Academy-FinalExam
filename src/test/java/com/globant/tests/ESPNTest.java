package com.globant.tests;

import com.globant.screens.WatchPage;
import com.globant.util.data.RandomDataGenerator;
import com.globant.util.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class ESPNTest extends BaseTest {

    @BeforeMethod(groups = {"watchCarouselTest", "watchCardsTest", "logoutTest"})
    public void signUser(Object[] userInfo) {
        List<Object> randomUserData = Arrays.asList(userInfo);
        home.clickSideLogInButton();
        driver.getDriver().switchTo().frame("oneid-iframe");
        home.click(home.getFrameSignUpButton());
        String firstName = randomUserData.get(0).toString();
        String lastName = randomUserData.get(0).toString();
        String email = firstName + randomUserData.get(1).toString() + "@taemail.com";
        String password = "!" + firstName + randomUserData.get(1).toString() + "*";
        home.createUserAccount(firstName, lastName, email, password);
    }

    @Test(groups = "loginTest")
    public void loginElementsExistTest() {
        log.info("Clicking \"Log In\" button");
        home.clickSideLogInButton();
        log.info("Switching to Login frame");
        driver.getDriver().switchTo().frame("oneid-iframe");
        log.info("Assert that logo and buttons are present");
        Assert.assertTrue(home.isElementVisible(home.getLogInESPNLogo()), "ESPN logo is not present nor visible");
        Assert.assertTrue(home.isElementVisible(home.getFrameLogInButton()), "Frame \"Log In\" button is not present nor visible");
        Assert.assertTrue(home.isElementVisible(home.getFrameSignUpButton()), "Frame \"Sign Up\" button is not present nor visible");
    }

    @Test(groups = "signupTest")
    public void signupElementsExistTest() {
        log.info("Clicking \"Log In\" button");
        home.clickSideLogInButton();
        log.info("Switching to Login frame");
        driver.getDriver().switchTo().frame("oneid-iframe");
        log.info("Clicking frame \"Sign Up\" button");
        home.click(home.getFrameSignUpButton());
        log.info("Assert that title of \"Create Account\" frame matches expected title");
        Assert.assertEquals(home.getFrameSignUpTitle().getText(), "Create Account", "Expected title and actual title don't match");
        log.info("Assert each element of signup form is present and visible");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(home.isElementVisible(home.getFirstNameInput()), "First name input is not present nor visible");
        softAssert.assertTrue(home.isElementVisible(home.getLastNameInput()), "Last name input is not present nor visible");
        softAssert.assertTrue(home.isElementVisible(home.getEmailInput()), "Email input is not present nor visible");
        softAssert.assertTrue(home.isElementVisible(home.getPasswordInput()), "Password input is not present nor visible");
        softAssert.assertTrue(home.isElementVisible(home.getSubmitSignUpButton()), "Sign up button is not present nor visible");
        softAssert.assertTrue(home.isElementVisible(home.getCloseButton()), "Close button is not present nor visible");
        softAssert.assertAll();
    }

    @Test(dataProvider = "randomUserInfo", dataProviderClass = RandomDataGenerator.class, groups = "watchCarouselTest")
    public void watchCarouselTest(String name, String validationNumber) {
        log.info("Going to \"Watch\" screen");
        WatchPage watch = home.goToWatchPage();
        log.info("Assert that \"Live events\" carousel is displayed");
        Assert.assertTrue(watch.checkLiveEventsCarousel(), "\"Live events\" carousel is not displayed");
        log.info("Assert that each carousel card has a title and a description");
        Assert.assertTrue(watch.checkCarouselCardsAreDisplayed(), "Carousel cards don't contain title or description");
    }

    @Test(dataProvider = "randomUserInfo", dataProviderClass = RandomDataGenerator.class, groups = "watchCardsTest")
    public void watchCarouselCardsTest(String name, String validationNumber) {
        log.info("Going to \"Watch\" screen");
        WatchPage watch = home.goToWatchPage();
        log.info("Assert that first carousel is displayed");
        Assert.assertTrue(watch.isElementVisible(watch.getFirstCarousel()), "First carousel is not displayed");
        log.info("Clicking the second card of the carousel");
        watch.clickFirstCarouselSelectedCard(2);
        log.info("Assert that second card contains a close (X) button");
        Assert.assertTrue(watch.isElementVisible(watch.getCloseCardButton()), "Card doesn't contain a close button");
    }

    @Test(dataProvider = "randomUserInfo", dataProviderClass = RandomDataGenerator.class, groups = "logoutTest")
    public void userLogOutTest(String name, String validationNumber) {
        log.info("Waiting for the dropdown menu to appear");
        home.hoverOnElement(home.getUserAccessButton());
        log.info("Assert that user's first name is displayed");
        Assert.assertTrue(home.isElementVisible(home.getUserFirstNameSpan()), "User's first name is not displayed");
        log.info("Logging out");
        home.click(home.getLogOutButton());
        log.info("Assert that \"Log In\" button is present after user logged out");
        Assert.assertTrue(home.checkIfUserLoggedOut(), "\"Log In\" button is not present");
    }
}
