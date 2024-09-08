package br.com.ejrocha.mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CreateIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CreateIssuePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "category_id")
    private WebElement category;

    @FindBy(id = "summary")
    private WebElement summary;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(xpath = "//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input")
    private WebElement createIssueButton;

    @FindBy(xpath = "//div[@class='alert alert-success center']//p[@class='bold bigger-110']")
    private WebElement sucessAlert;

    public void selectTestCategory(Integer index){
        Select select = new Select(category);
        select.selectByIndex(index);
    }

    public void enterSummary(String summaryText){
        summary.sendKeys(summaryText);
    }

    public void enterDescription(String descriptionIssue){
        description.sendKeys(descriptionIssue);
    }

    public void clickCreateissueButton(){
        createIssueButton.click();
    }

    public String getSuccessMessage(){
        return sucessAlert.getText();
    }

}
