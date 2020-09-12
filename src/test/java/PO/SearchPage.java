package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    private By wikiRef = By.cssSelector("a.q.ruhjFe");
    private By wikiFooter = By.id("footer");
    private By wikiHeading = By.cssSelector("h1");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public SearchPage goToWikiPage() {
        wait.until(ExpectedConditions.elementToBeClickable(wikiRef));
        driver.findElement(wikiRef).click();
        return this;
    }

}
