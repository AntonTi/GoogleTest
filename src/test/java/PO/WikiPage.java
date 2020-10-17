package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikiPage extends BasePage {

    private final By wikiFooter = By.id("footer");
    private final By wikiHeading = By.cssSelector("h1");

    public WikiPage(WebDriver driver) {
        super(driver);
    }

    public String getWikiHeading() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(wikiFooter));
        String wikiHead = driver.findElement(wikiHeading).getText();
        return wikiHead;
    }

}
