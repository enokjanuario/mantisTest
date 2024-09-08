package br.com.ejrocha.mantis.cases;

import br.com.ejrocha.mantis.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest {

    protected WebDriver driver;
    protected Properties credentials;
    protected TestUtils testUtils;

    @BeforeEach
    public void setUp() throws IOException {
        credentials = new Properties();
        FileInputStream input = new FileInputStream("src/test/resources/credentials.properties");
        credentials.load(input);

        driver = new ChromeDriver();
        driver.manage().window().maximize();  // Maximizar a janela do navegador
        driver.get("https://mantis-prova.base2.com.br/login_page.php");
        testUtils = new TestUtils(driver);

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void loginAsUser() {
        String username = credentials.getProperty("MANTIS_USERNAME");
        String password = credentials.getProperty("MANTIS_PASSWORD");
        testUtils.performLogin(username, password);
    }

}
