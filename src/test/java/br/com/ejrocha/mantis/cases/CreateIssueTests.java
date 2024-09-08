package br.com.ejrocha.mantis.cases;


import br.com.ejrocha.mantis.pages.CreateIssuePage;
import br.com.ejrocha.mantis.pages.DashboardPage;
import org.openqa.selenium.WebElement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Create Issue Tests")
public class CreateIssueTests extends BaseTest {
    @Test

    public void testCreateIssueTaskSuccessful() throws InterruptedException {
        try {
            DashboardPage dashboardPage = new DashboardPage(driver);
            CreateIssuePage createIssuePage = new CreateIssuePage(driver);

            Integer indexCategory = 1;

            String summaryIssue = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus nec lacus "
                    + "odio. Ut ac pellentesque arcu, vel fringilla orci. Lorem.";

            String descriptionIssue = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et purus convallis, " +
                    "accumsan dolor id, semper lorem. Curabitur euismod sem ut aliquet lacinia. Praesent erat diam," +
                    "vestibulum ut mollis venenatis, sagittis quis lectus. Morbi posuere urna eleifend augue dignissim, ut.";

            loginAsUser();
            dashboardPage.clickCreateIssue();

            createIssuePage.selectTestCategory(indexCategory);
            createIssuePage.enterSummary(summaryIssue);
            createIssuePage.enterDescription(descriptionIssue);
            createIssuePage.clickCreateissueButton();
            assertEquals(createIssuePage.getSuccessMessage(), "Operation successful.");

        } catch (AssertionError e){
            System.err.println("[Error] Assertion Failure. Stacktrace:");
            e.printStackTrace();
            throw e;
        }

    }

    @Test
    public void testCreateIssueWithoutRequiredFields(){
        try {
            DashboardPage dashboardPage = new DashboardPage(driver);
            CreateIssuePage createIssuePage = new CreateIssuePage(driver);
            loginAsUser();
            dashboardPage.clickCreateIssue();

            String beforeUrl = driver.getCurrentUrl();

            createIssuePage.clickCreateissueButton();

            String afterUrl = driver.getCurrentUrl();

            assertEquals(beforeUrl, afterUrl);

        } catch (AssertionError e){
            System.err.println("[Error] Assertion Failure. Stacktrace:");
            e.printStackTrace();
            throw e;
        }
    }



}
