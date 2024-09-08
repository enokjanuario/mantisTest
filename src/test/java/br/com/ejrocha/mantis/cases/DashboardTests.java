package br.com.ejrocha.mantis.cases;


import br.com.ejrocha.mantis.pages.DashboardPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Dashboard Tests")
public class DashboardTests extends BaseTest{

    @Test
    public void testAccessToMyView(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginAsUser();
        dashboardPage.clickSeeIssues();
        assertTrue(dashboardPage.isTableMyVisionVisible());
    }

    @Test
    public void testAccessToCreateTask() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginAsUser();
        dashboardPage.clickCreateIssue();
        assertEquals(dashboardPage.getTitleFromTable(), "enter issue details");
    }

    @Test
    public void testAccessToChangelog(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginAsUser();
        dashboardPage.clickChangeLog();
    }

    @Test
    public void testAccessToPlanning(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginAsUser();
        dashboardPage.clickPlanning();
    }

}
