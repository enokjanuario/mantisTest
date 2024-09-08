package br.com.ejrocha.mantis.cases;


import br.com.ejrocha.mantis.pages.CreateIssuePage;
import br.com.ejrocha.mantis.pages.DashboardPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Create Issue Tests")
public class CreateIssueTests extends BaseTest {
    @Test
    public void testCreateIssueTaskSuccessful() throws InterruptedException {

        DashboardPage dashboardPage = new DashboardPage(driver);
        Integer indexCategory = 1;
        CreateIssuePage createIssuePage = new CreateIssuePage(driver);

        String summaryIssue = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus nec lacus "
                +"odio. Ut ac pellentesque arcu, vel fringilla orci. Lorem.";

        String descriptionIssue = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et purus convallis, " +
                "accumsan dolor id, semper lorem. Curabitur euismod sem ut aliquet lacinia. Praesent erat diam," +
                "vestibulum ut mollis venenatis, sagittis quis lectus. Morbi posuere urna eleifend augue dignissim, ut.";

        loginAsUser();
        dashboardPage.clickCreateIssue();

        createIssuePage.selectTestCategory(indexCategory);
        createIssuePage.enterSummary(summaryIssue);
        createIssuePage.enterDescription(descriptionIssue);
        createIssuePage.clickCreateissueButton();



    }

}
