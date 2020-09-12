package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    By btnLuck = By.cssSelector(".FPdoLc.tfB0Bf .gNO89b");
    By btnSearch = By.cssSelector(".tfB0Bf .gNO89b");
    By inputSearch = By.name("q");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public HomePage isShown() {
        driver.get("http://www.google.com");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnLuck));
        return this;
    }

    public HomePage writeSearchWord(){
        driver.findElement(inputSearch).sendKeys("Selenium");
        return this;
    }

    public HomePage clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        driver.findElement(btnSearch).click();
        return this;
    }


}
