package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    private By wikiRef = By.cssSelector("a.q.ruhjFe");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage goToWikiPage() {
        wait.until(ExpectedConditions.elementToBeClickable(wikiRef));
        driver.findElement(wikiRef).click();
        return this;
    }

}
