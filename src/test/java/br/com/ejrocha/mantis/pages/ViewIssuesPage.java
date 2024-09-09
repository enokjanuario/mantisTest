package br.com.ejrocha.mantis.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ViewIssuesPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private WebElement waitForElementVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    @FindBy(xpath = "//*[@id=\"buglist\"]/thead/tr/th[3]/a")
    private WebElement priority;

    @FindBy(xpath = "//*[@id=\"buglist\"]/tbody/tr[1]/td[3]/i")
    private WebElement priorityOfFirst;

    @FindBy(xpath = "//*[@id=\"bug_action\"]/div/div[2]/div[1]/div/div[1]/a[3]")
    private WebElement excelExportButton;

    public void clickPriority(){
        waitForElementVisibility(priority).click();
    }

    public String getPriorityOfFirst(){
        try {
            return priorityOfFirst.getAttribute("title").toLowerCase();
        } catch (NoSuchElementException e) {
            return "None";
        }
    }

    public void clickExcelExport(){
        excelExportButton.click();
    }
}
