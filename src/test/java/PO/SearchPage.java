package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    private final By wikiRef = By.cssSelector("a.ruhjFe.NJLBac.fl");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage goToWikiPage() {
        logger.info("Search Page go to Wiki Page");
        wait.until(ExpectedConditions.elementToBeClickable(wikiRef));
        driver.findElement(wikiRef).click();
        return this;
    }

}
