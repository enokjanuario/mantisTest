package br.com.ejrocha.mantis.cases;


import br.com.ejrocha.mantis.pages.DashboardPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Dashboard Tests")
public class DashboardTests extends BaseTest{

    @Test
    public void testAccessToMyView(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginAsUser();
        dashboardPage.clickMyTasks();
    }

    @Test
    public void testAccessToCreateTask(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginAsUser();
        dashboardPage.clickCreateTask();
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
