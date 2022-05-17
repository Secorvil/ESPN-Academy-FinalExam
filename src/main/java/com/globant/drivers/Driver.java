package com.globant.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Driver class that allows multiple browser support.
 *
 * @author sebastian.cv
 */
public class Driver {

    /** WebDriver instance */
    private WebDriver driver;

    /**
     * Constructor with multiple browser support.
     *
     * @param browser Name of the browser
     */
    public Driver(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./src/main/java/com/globant/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./src/main/java/com/globant/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                break;
        }
    }

    /**
     * @author Sebastián Correa
     *
     * Get the driver.
     * @return WebDriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * @author Sebastián Correa
     *
     * Set a new WebDriver as the driver instance.
     *
     * @param driver The new WebDriver object
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
