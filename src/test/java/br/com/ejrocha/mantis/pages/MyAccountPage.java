package br.com.ejrocha.mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyAccountPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private WebElement waitForElementVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    @FindBy(xpath = "//*[@id=\"account-update-form\"]/div[3]/div[2]/div/div/table/tbody/tr/td[1]")
    private WebElement projectName;

     public String getProjectname(){
        return waitForElementVisibility(projectName).getText();
    }

}
