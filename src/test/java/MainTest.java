package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private By btnLuck = By.cssSelector(".FPdoLc.tfB0Bf .gNO89b");
    private By btnSearch = By.cssSelector(".tfB0Bf .gNO89b");
    private By inputSearch = By.name("q");
    private By wikiRef = By.cssSelector("a.q.ruhjFe");
    private By wikiFooter = By.id("footer");
    private By wikiHeading = By.cssSelector("h1");

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

    }

    @Test
    public void checkHomePageTitle() {
        driver.get("http://www.google.com");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnLuck));

        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void checkSearchPageTitle() {
        driver.get("http://www.google.com");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnLuck));
        driver.findElement(inputSearch).sendKeys("Selenium");
        wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        driver.findElement(btnSearch).click();

        Assert.assertEquals(driver.getTitle(), "Selenium - Поиск в Google");
    }

    @Test(invocationCount = 1)
    public void checkWikiPageTitle() {
        driver.get("http://www.google.com");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnLuck));
        driver.findElement(inputSearch).sendKeys("Selenium");
        wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        driver.findElement(btnSearch).click();
        wait.until(ExpectedConditions.elementToBeClickable(wikiRef));
        driver.findElement(wikiRef).click();

        Assert.assertEquals(driver.getTitle(), "Selenium — Википедия");
    }

    @Test(invocationCount = 1)
    public void checkWikiPageHeading() {
        driver.get("http://www.google.com");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnLuck));
        driver.findElement(inputSearch).sendKeys("Selenium");
        wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        driver.findElement(btnSearch).click();
        wait.until(ExpectedConditions.elementToBeClickable(wikiRef));
        driver.findElement(wikiRef).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(wikiFooter));
        String wikiHead = driver.findElement(wikiHeading).getText();

        Assert.assertEquals(wikiHead, "Selenium");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }


}
