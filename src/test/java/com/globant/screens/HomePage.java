package com.globant.screens;

import com.globant.util.screens.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * First visible page when application loads.
 *
 * @author sebastian.cv
 */
public class HomePage extends BasePage {

    @FindBy(css = "#sideLogin-left-rail button[tref=\"/members/v3_1/login\"]")
    private WebElement sideLogInButton;

    @FindBy(id = "logo")
    private WebElement LogInESPNLogo;

    /**
     * Basic constructor.
     *
     * @param driver WebDriver instance
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get left side "Log in" button.
     * @return WebElement Log in button
     */
    public WebElement getSideLogInButton() {
        return sideLogInButton;
    }

    /**
     * Set a WebElement as left side "Log in" button.
     * @param sideLogInButton new sideLogInButton element
     */
    public void setSideLogInButton(WebElement sideLogInButton) {
        this.sideLogInButton = sideLogInButton;
    }

    /**
     * Get ESPN logo from Login frame.
     * @return WebElement of ESPN logo
     */
    public WebElement getLogInESPNLogo() {
        return LogInESPNLogo;
    }

    /**
     * Set a WebElement as ESPN logo.
     * @param logInESPNLogo new logInESPNLogo element
     */
    public void setLogInESPNLogo(WebElement logInESPNLogo) {
        LogInESPNLogo = logInESPNLogo;
    }

    /**
     * @author Sebastián Correa
     *
     * This method scrolls down to click the left side "Log in" button.
     */
    public void clickSideLogInButton() {
        scroll(0, 500);
        click(sideLogInButton);
    }
}
