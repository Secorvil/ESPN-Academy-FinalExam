package com.globant.util.screens;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base page for shared methods across the web application pages and basic setup.
 *
 * @author sebastian.cv
 */
public class BasePage {

    /** Driver instance. */
    protected WebDriver driver;

    /** Logger instance. */
    public Logger log;

    /**
     * Constructor method.
     *
     * @param driver Driver instance
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.log = Logger.getLogger(BasePage.class);
        PageFactory.initElements(this.driver, this);
    }

    /**
     * @author Sebastián Correa
     *
     * This method waits until a WebElement is visible, and then clicks the element.
     *
     * @param element WebElement to be clicked
     */
    public void click(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * @author Sebastián Correa
     *
     * This method waits until a WebElement is visible, and then checks if it is displayed properly.
     *
     * @param element WebElement to be checked
     * @return true if the element is visible and properly displayed, otherwise false
     */
    public boolean isElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    /**
     * This method performs a scroll, both horizontally and vertically, using pixels as units.
     *
     * @param xAxisPixels number of pixels to scroll horizontally
     * @param yAxisPixels number of pixels to scroll vertically
     */
    public void scroll(int xAxisPixels, int yAxisPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(" + xAxisPixels + ", " + yAxisPixels + ")");
    }
}
