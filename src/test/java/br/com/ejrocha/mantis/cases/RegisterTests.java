package br.com.ejrocha.mantis.cases;

import br.com.ejrocha.mantis.pages.LoginPage;
import br.com.ejrocha.mantis.pages.RegisterPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTests extends BaseTest {

    @Test
    public void testRegisterWithoutCaptcha() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        loginPage.clickCreateAccount();

        loginPage.enterUsername("new_user_username");
        loginPage.enterEmail("new_user_email");

        registerPage.clickSignUp();

        assertTrue(loginPage.checkErrorMessage().contains("Confirmation hash does not match."));
    }
}
