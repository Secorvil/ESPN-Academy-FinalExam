package com.globant.util.tests;

import com.globant.drivers.Driver;
import com.globant.screens.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Test class for basic setup and/or common methods.
 *
 * @author sebastian.cv
 */
public class BaseTest {

    /** Application first page. */
    protected HomePage home;

    /** Multiple browser support custom driver. */
    public static Driver driver;

    /** Logger instance. */
    public Logger log = Logger.getLogger(BaseTest.class);

    /**
     * @author Sebastián Correa
     *
     * Set the first page.
     */
    public void setUpPage() {
        home = new HomePage(driver.getDriver());
    }

    /**
     * @author Sebastián Correa
     *
     * Required driver set up before running the tests suite.
     *
     * @param browser Name of the browser
     * @param url URL of the page that will be automated
     */
    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void setUpDriver(String browser, String url) {
        try {
            driver = new Driver(browser);
            driver.getDriver().manage().window().maximize();
            driver.getDriver().get(url);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        setUpPage();
    }

    /**
     * @author Sebastián Correa
     *
     * Delete cookies and close the driver session.
     */
    @AfterTest(alwaysRun = true)
    public void dispose() {
        if (driver.getDriver() != null) {
            driver.getDriver().manage().deleteAllCookies();
            driver.getDriver().quit();
        }
    }
}
