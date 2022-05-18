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

    @FindBy(css = "button[data-testid=\"BtnSubmit\"]")
    private WebElement frameLogInButton;

    @FindBy(css = "button[data-testid=\"BtnCreateAccount\"]")
    private WebElement frameSignUpButton;

    @FindBy(css = "h2[data-testid=\"Title\"]")
    private WebElement frameSignUpTitle;

    @FindBy(className = "input-InputFirstName")
    private WebElement firstNameInput;

    @FindBy(className = "input-InputLastName")
    private WebElement lastNameInput;

    @FindBy(className = "input-InputEmail")
    private WebElement emailInput;

    @FindBy(className = "input-password-new")
    private WebElement passwordInput;

    @FindBy(css = "button[data-testid=\"BtnSubmit\"]")
    private WebElement submitSignUpButton;

    @FindBy(css = "button[data-testid=\"REGISTRATION-close\"]")
    private WebElement closeButton;

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
     * Get frame "Log In" button.
     * @return WebElement of the frame "Log In" button
     */
    public WebElement getFrameLogInButton() {
        return frameLogInButton;
    }

    /**
     * Set a WebElement as frame "Log In" button.
     * @param frameLogInButton new frameLogInButton element
     */
    public void setFrameLogInButton(WebElement frameLogInButton) {
        this.frameLogInButton = frameLogInButton;
    }

    /**
     * Get frame "Sign Up" button.
     * @return WebElement of the frame "Sign up" button
     */
    public WebElement getFrameSignUpButton() {
        return frameSignUpButton;
    }

    /**
     * Set a WebElement as frame "Sign up" button.
     * @param frameSignUpButton new frameSignUpButton element
     */
    public void setFrameSignUpButton(WebElement frameSignUpButton) {
        this.frameSignUpButton = frameSignUpButton;
    }

    /**
     * Get frame title.
     * @return WebElement of frame title
     */
    public WebElement getFrameSignUpTitle() {
        return frameSignUpTitle;
    }

    /**
     * Set a WebElement as frame title.
     * @param frameSignUpTitle new frameSignUpTitle element
     */
    public void setFrameSignUpTitle(WebElement frameSignUpTitle) {
        this.frameSignUpTitle = frameSignUpTitle;
    }

    /**
     * Get the sign-up form "First name" field.
     * @return WebElement of the "First name" input
     */
    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    /**
     * Set a WebElement as "First name" input.
     * @param firstNameInput new firstNameInput element
     */
    public void setFirstNameInput(WebElement firstNameInput) {
        this.firstNameInput = firstNameInput;
    }

    /**
     * Get the sign-up form "Last name" field.
     * @return WebElement of the "Last name" input
     */
    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    /**
     * Set a WebElement as "Last name" input.
     * @param lastNameInput new lastNameInput element
     */
    public void setLastNameInput(WebElement lastNameInput) {
        this.lastNameInput = lastNameInput;
    }

    /**
     * Get the sign-up form "Email" field.
     * @return WebElement of the "Email" input
     */
    public WebElement getEmailInput() {
        return emailInput;
    }

    /**
     * Set a WebElement as "Email" input.
     * @param emailInput new emailInput element
     */
    public void setEmailInput(WebElement emailInput) {
        this.emailInput = emailInput;
    }

    /**
     * Get the sign-up form "Password" field.
     * @return WebElement of the "Password" input
     */
    public WebElement getPasswordInput() {
        return passwordInput;
    }

    /**
     * Set a WebElement as "Password" input.
     * @param passwordInput new passwordInput
     */
    public void setPasswordInput(WebElement passwordInput) {
        this.passwordInput = passwordInput;
    }

    /**
     * Get the sign-up form submit button.
     * @return WebElement of "Sign Up" submit button
     */
    public WebElement getSubmitSignUpButton() {
        return submitSignUpButton;
    }

    /**
     * Set a WebElement as "Sign Up" submit button.
     * @param submitSignUpButton new submitSignUpButton element
     */
    public void setSubmitSignUpButton(WebElement submitSignUpButton) {
        this.submitSignUpButton = submitSignUpButton;
    }

    /**
     * Get the close (X) frame button.
     * @return WebElement of close frame button
     */
    public WebElement getCloseButton() {
        return closeButton;
    }

    /**
     * Set a WebElement as close frame button.
     * @param closeButton new closeButton element
     */
    public void setCloseButton(WebElement closeButton) {
        this.closeButton = closeButton;
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
