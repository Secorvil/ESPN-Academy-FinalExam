package com.globant.tests;

import com.globant.util.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ESPNTest extends BaseTest {

    @Test
    public void loginElementsExistTest() {
        home.clickSideLogInButton();
        driver.getDriver().switchTo().frame("oneid-iframe");
        Assert.assertTrue(home.isElementVisible(home.getLogInESPNLogo()));
    }
}
