package br.com.ejrocha.mantis.cases;

import br.com.ejrocha.mantis.pages.LoginPage;
import br.com.ejrocha.mantis.pages.RegisterPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Register New User Tests")
public class RegisterTests extends BaseTest {

    @Test
    public void testRegisterWithoutCaptcha() {
        try {

            LoginPage loginPage = new LoginPage(driver);

            RegisterPage registerPage = new RegisterPage(driver);

            loginPage.clickCreateAccount();

            loginPage.enterUsername("new_user_username");
            loginPage.enterEmail("new_user_email");

            registerPage.clickSignUp();

            assertTrue(loginPage.checkErrorMessage().contains("Confirmation hash does not match."));

        } catch (AssertionError e){

            System.err.println("[Error] Assertion Failure. Stacktrace:");
            e.printStackTrace();
            throw e;

        }
    }
}
