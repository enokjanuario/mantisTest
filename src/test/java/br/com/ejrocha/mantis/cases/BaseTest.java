package br.com.ejrocha.mantis.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class BaseTest {

    protected WebDriver driver;
    protected Properties credentials;
    protected TestUtils testUtils;

    @BeforeEach
    public void setUp() throws IOException {
        credentials = new Properties();
        FileInputStream input = new FileInputStream("src/test/resources/credentials.properties");
        credentials.load(input);


        ChromeOptions options = new ChromeOptions();


        options.addArguments("user-data-dir=C:/Users/"+credentials.getProperty("USER")+"/AppData/Local/Google/Chrome/User Data/Default");
        options.addArguments("download.prompt_for_download=false");
        options.addArguments("download.directory_upgrade=true");
        options.addArguments("safebrowsing.enabled=true");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-download-notification");
        options.addArguments("disable-infobars");


        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
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