package br.com.ejrocha.mantis.cases;

import br.com.ejrocha.mantis.pages.DashboardPage;
import br.com.ejrocha.mantis.pages.MyAccountPage;
import br.com.ejrocha.mantis.pages.ViewIssuesPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("View Issues Tests")
public class ViewIssuesTests extends BaseTest {

    @Test
    public void testOrderByPriority(){
        try {
            ViewIssuesPage viewIssuesPage = new ViewIssuesPage(driver);
            DashboardPage dashboardPage = new DashboardPage(driver);

            loginAsUser();
            dashboardPage.clickViewIssues();
            Thread.sleep(3000);
            String initialPriority = viewIssuesPage.getPriorityOfFirst();
            viewIssuesPage.clickPriority();
            Thread.sleep(3000);
            String finalPriority = viewIssuesPage.getPriorityOfFirst();

            assertEquals(finalPriority, initialPriority.equals("None") ? "urgent" : "None");

        } catch (AssertionError e){
            System.err.println("[Error] Assertion Failure. Stacktrace:");
            e.printStackTrace();
            throw e;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testExcelExport() throws InterruptedException {
        ViewIssuesPage viewIssuesPage = new ViewIssuesPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        loginAsUser();
        dashboardPage.clickMyAccount();

        String projectName = myAccountPage.getProjectname();

        dashboardPage.clickViewIssues();

        viewIssuesPage.clickExcelExport();

        Thread.sleep(5000);


        String userDevice = credentials.getProperty("USER");
        String downloadFilePath = "C:/Users/" + userDevice + "/Downloads/" + projectName + ".xml";
        File file = new File(downloadFilePath);

        assertTrue(file.exists(), "O arquivo de exportação não foi baixado.");

        if (file.exists()) {
            file.delete();
        }
    }

}
