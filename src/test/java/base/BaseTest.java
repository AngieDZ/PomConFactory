package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class BaseTest {

    protected WebDriver driver;
    protected HomePages homePages;
    protected CommoActionPages commoActionPages;
    protected SignupPage signupPage;
    protected RegisterPage registerPage;
    protected AllProducts allProducts;
    protected ContactPage contactPage;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        commoActionPages = new CommoActionPages(driver);
        homePages = new HomePages(driver);
        signupPage = new SignupPage(driver);
        registerPage = new RegisterPage(driver);
        allProducts = new AllProducts(driver);
        contactPage = new ContactPage(driver);

        homePages.visitarPagina("https://automationexercise.com/test_cases");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
