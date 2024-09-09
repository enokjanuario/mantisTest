package br.com.ejrocha.mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Locale;

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

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[1]/a")
    private WebElement myVision;

    @FindBy(xpath = "//div[@class='widget-menu']//a[@class='btn btn-primary btn-white btn-round btn-sm']")
    private WebElement seeIssues;

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[3]/a")
    private WebElement createIssue;

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[4]/a")
    private WebElement changelog;

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[5]/a")
    private WebElement planning;

    @FindBy(xpath = "//*[@id=\"bug_action\"]/div/div[1]")
    private WebElement viewTasksTable;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div")
    private WebElement reportDetails;

    @FindBy(xpath = "//*[@id=\"breadcrumbs\"]/ul/li/a")
    private WebElement userLogged;

    @FindBy(xpath = "//*[@id=\"unassigned\"]/div[1]")
    private WebElement timeLine;


    public void clickMyVision(){
        waitForElementVisibility(myVision).click();
    }

    public void clickViewIssues(){
        waitForElementVisibility(seeIssues).click();
    }

    public void clickCreateIssue(){
        waitForElementVisibility(createIssue).click();
    }

    public void clickChangeLog(){
        waitForElementVisibility(changelog).click();
    }

    public void clickPlanning(){
        waitForElementVisibility(planning).click();
    }

    public String getTitleFromTaskTable(){
        return viewTasksTable.getText().toLowerCase(Locale.ROOT);
    }

    public String getTitleFromTimeline(){
        return timeLine.getText().toLowerCase(Locale.ROOT);
    }

    public String getTitleFromReportTable(){
        return reportDetails.getText().toLowerCase(Locale.ROOT).split("\n")[0];
    }

    public void clickMyAccount(){
        waitForElementVisibility(userLogged).click();
    }

}
