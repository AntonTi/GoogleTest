package test.java.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiPage {
    WebDriver driver;
    WebDriverWait wait;

    public WikiPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
}
