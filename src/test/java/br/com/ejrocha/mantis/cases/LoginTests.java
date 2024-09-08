package br.com.ejrocha.mantis.cases;

import br.com.ejrocha.mantis.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Login Tests")
public class LoginTests extends BaseTest {

    @Test
    public void testLoginSuccessful() {
        try {
            LoginPage loginPage = new LoginPage(driver);

            String username = credentials.getProperty("MANTIS_USERNAME");
            String password = credentials.getProperty("MANTIS_PASSWORD");

            loginPage.enterUsername(username);
            loginPage.clickLogin();
            loginPage.enterPassword(password);
            loginPage.clickLogin();

            assertTrue(loginPage.checkButton());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    public void testInvalidCredentials() {
        try {
            LoginPage loginPage = new LoginPage(driver);

            loginPage.enterUsername("username");
            loginPage.clickLogin();
            loginPage.enterPassword("password");
            loginPage.clickLogin();

            assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.",
                    loginPage.checkErrorMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
