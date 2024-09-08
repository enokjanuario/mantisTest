package br.com.ejrocha.mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private WebElement waitForElementVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/a")
    private WebElement myTasks;

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[3]/a")
    private WebElement createTask;

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[4]/a")
    private WebElement changelog;

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[5]/a")
    private WebElement planning;

    public void clickMyTasks(){
        waitForElementVisibility(myTasks).click();
    }

    public void clickCreateTask(){
        waitForElementVisibility(createTask).click();
    }

    public void clickChangeLog(){
        waitForElementVisibility(changelog).click();
    }

    public void clickPlanning(){
        waitForElementVisibility(planning).click();
    }

}
