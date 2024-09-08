package br.com.ejrocha.mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "email-field")
    private WebElement emailField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(css = ".nav.ace-nav")
    private WebElement createTask;

    @FindBy(xpath = "//div[contains(@class, 'alert-danger')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/a")
    private WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"lost-password-form\"]/fieldset/input[2]")
    private WebElement send;

    @FindBy(css = "a.back-to-login-link.pull-left")
    private WebElement createAccount;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        waitForElementVisibility(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElementVisibility(passwordField).sendKeys(password);
    }

    public void enterEmail(String email) {
        waitForElementVisibility(emailField).sendKeys(email);
    }

    public void clickLogin() {
        waitForElementVisibility(loginButton).click();
    }

    public void clickCreateAccount() {
        waitForElementVisibility(createAccount).click();
    }

    public boolean checkButton() {
        return waitForElementVisibility(createTask).isDisplayed();
    }

    public String checkErrorMessage() {
        return waitForElementVisibility(errorMessage).getText();
    }

    private WebElement waitForElementVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
