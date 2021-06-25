package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikiPage extends BasePage {

    private final By wikiFooter = By.id("footer");
    private final By wikiHeading = By.cssSelector("h1");

    public WikiPage(WebDriver driver) {
        super(driver);
    }

    @Step("get Wiki Heading")
    public String getWikiHeading() {
        logger.info("get Wiki Heading");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(wikiFooter));
        String wikiHead = driver.findElement(wikiHeading).getText();
        return wikiHead;
    }

}
