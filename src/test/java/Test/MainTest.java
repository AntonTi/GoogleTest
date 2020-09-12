package test.java.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.PO.HomePage;
import test.java.PO.SearchPage;

public class MainTest {

    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void checkHomePageTitle() {
        homePage.isShown();

        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void checkSearchPageTitle() {
        homePage.isShown();
        homePage.writeSearchWord();
        homePage.clickSearchBtn();

        Assert.assertEquals(driver.getTitle(), "Selenium - Поиск в Google");
    }

    @Test(invocationCount = 1)
    public void checkWikiPageTitle() {
        homePage.isShown();
        homePage.writeSearchWord();
        homePage.clickSearchBtn();
        searchPage.goToWikiPage();

        Assert.assertEquals(driver.getTitle(), "Selenium — Википедия");
    }


    @AfterMethod
    public void close() {
        driver.quit();
    }


}