package br.com.ejrocha.mantis.cases;

import br.com.ejrocha.mantis.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class TestUtils {

    private final WebDriver driver;

    public TestUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void performLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.clickLogin();
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
}
