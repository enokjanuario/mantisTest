package br.com.ejrocha.mantis.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import br.com.ejrocha.mantis.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Login Tests")
public class LoginTests {
    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);
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
        // Usando classe página
        LoginPage loginPage = new LoginPage(driver);

        // Recuperando o nome de usuário e senha do arquivo de propriedades
        String username = credentials.getProperty("MANTIS_USERNAME");
        String password = credentials.getProperty("MANTIS_PASSWORD");

        // Executando o login
        loginPage.enterUsername(username);
        loginPage.clickLogin();
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        // Validações
        assertTrue(loginPage.checkButton());
    }

    @AfterEach
    public void tearDown() {
        // Fechar o navegador após o teste
        driver.quit();
    }
}
