package br.com.ejrocha.mantis.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import br.com.ejrocha.mantis.pages.LoginPage;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Login Tests")
public class LoginTests {
    private WebDriver driver;
    private Properties credentials;

    @BeforeEach
    public void setUp() throws IOException {
        credentials = new Properties();
        FileInputStream input = new FileInputStream("src/test/resources/credentials.properties");
        credentials.load(input);

        driver = new ChromeDriver();
        driver.get("https://mantis-prova.base2.com.br/login_page.php");

    }

    @Test
    public void testLoginSuccessful() {

        LoginPage loginPage = new LoginPage(driver);

        String username = credentials.getProperty("MANTIS_USERNAME");
        String password = credentials.getProperty("MANTIS_PASSWORD");

        loginPage.enterUsername(username);
        loginPage.clickLogin();
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        assertTrue(loginPage.checkButton());
    }

    @Test
    public void testInvalidCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("username");
        loginPage.clickLogin();
        loginPage.enterPassword("password");
        loginPage.clickLogin();

        assertEquals(loginPage.checkErrorMessage(),"Your account may be disabled or blocked or the " +
                                                          "username/password you entered is incorrect.");
    }

    @Test
    public void testForgetPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("username");
        loginPage.clickLogin();

        loginPage.clickForgotMessage();

        loginPage.enterEmail("email");
        loginPage.clickSend();


        assertTrue(loginPage.checkErrorMessage().contains("Invalid e-mail address.\n" +
                "Please use the \"Back\" button in your web browser to return to the previous page. There you can " +
                "correct whatever problems were identified in this error or select another action. You can also " +
                "click an option from the menu bar to go directly to a new section."));
    }

    @AfterEach
    public void tearDown() {
        // Fechar o navegador após o teste
        driver.quit();
    }
}
