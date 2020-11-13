package test.java.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.PO.HomePage;
import test.java.PO.SearchPage;
import test.java.PO.WikiPage;
import test.java.Utils.ScreenShot;

public class BaseMainTest {
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    WikiPage wikiPage;

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        wikiPage = new WikiPage(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void close(ITestResult result) {
        ScreenShot screenShot = new ScreenShot(driver);
        screenShot.makeScreenShot(result);
        driver.quit();
    }

}
