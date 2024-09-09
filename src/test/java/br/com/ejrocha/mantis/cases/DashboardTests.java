package br.com.ejrocha.mantis.cases;

import br.com.ejrocha.mantis.pages.DashboardPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Dashboard Tests")
public class DashboardTests extends BaseTest{

    @Test
    public void testAccessToMyView(){
        try {

            DashboardPage dashboardPage = new DashboardPage(driver);
            loginAsUser();
            dashboardPage.clickMyVision();
            assertTrue(dashboardPage.getTitleFromTimeline().contains("unassigned"));

        } catch (AssertionError e){

            System.err.println("[Error] Assertion Failure. Stacktrace:");
            e.printStackTrace();
            throw e;

        }
    }

    @Test
    public void testAccessToSeeIssues(){
        try {

            DashboardPage dashboardPage = new DashboardPage(driver);
            loginAsUser();
            dashboardPage.clickViewIssues();
            assertTrue(dashboardPage.getTitleFromTaskTable().contains("viewing issues"));

        } catch (AssertionError e){

            System.err.println("[Error] Assertion Failure. Stacktrace:");
            e.printStackTrace();
            throw e;

        }
    }

    @Test
    public void testAccessToCreateTask() throws InterruptedException {
        try {

            DashboardPage dashboardPage = new DashboardPage(driver);
            loginAsUser();
            dashboardPage.clickCreateIssue();
            assertEquals(dashboardPage.getTitleFromReportTable(), "enter issue details");

        } catch (AssertionError e){

            System.err.println("[Error] Assertion Failure. Stacktrace:");
            e.printStackTrace();
            throw e;

        }
    }

    @Test
    public void testAccessToChangelog(){
        try {

            DashboardPage dashboardPage = new DashboardPage(driver);
            loginAsUser();
            dashboardPage.clickChangeLog();

        } catch (AssertionError e){
            System.err.println("[Error] Assertion Failure. Stacktrace:");
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    public void testAccessToPlanning(){
        try {

            DashboardPage dashboardPage = new DashboardPage(driver);
            loginAsUser();
            dashboardPage.clickPlanning();

        } catch (AssertionError e){

            System.err.println("[Error] Assertion Failure. Stacktrace:");
            e.printStackTrace();
            throw e;

        }

    }

}
