package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.Utils.PropertyLoader;

public class HomePage extends BasePage {

    private final By btnLuck = By.xpath("//div[contains(@class, 'FPdoLc lJ9FBc')]//input[@name='btnI']");
    private final By btnSearch = By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']");
    private final By inputSearch = By.xpath("//input[@name='q']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage isShown() {
        logger.info("open Home Page");
        /*logger.trace("trace logger");
        logger.debug("debug logger");
        logger.warn("warn logger");
        logger.error("error logger");
        logger.fatal("fatal logger");*/
        driver.get(PropertyLoader.getProperty("url"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnLuck));
        return this;
    }

    public HomePage writeSearchWord() {
        logger.info("write Search Word");
        driver.findElement(inputSearch).sendKeys("Selenium");
        return this;
    }

    public HomePage clickSearchBtn() {
        logger.info("click Search Button");
        wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        driver.findElement(btnSearch).click();
        return this;
    }

}
