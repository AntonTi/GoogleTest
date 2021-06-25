package test.java.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.PO.HomePage;
import test.java.PO.SearchPage;
import test.java.PO.WikiPage;

public class BaseMainTest {
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    WikiPage wikiPage;

    @BeforeMethod(description = "Initialize custom driver and Page factory")
    public void init(ITestContext context) {
        driver = new ChromeDriver();
        context.setAttribute("WebDriver", driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        wikiPage = new WikiPage(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod(description = "Finalize custom driver")
    public void close() {
        driver.quit();
    }

}
