package test.java.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseMainTest {

    @Test(description = "check HomePage Title")
    @Severity(SeverityLevel.NORMAL)
    public void checkHomePageTitle() {
        homePage.isShown();

        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test(description = "check SearchPage Title")
    @Severity(SeverityLevel.NORMAL)
    public void checkSearchPageTitle() {
        homePage.isShown();
        homePage.writeSearchWord();
        homePage.clickSearchBtn();

        Assert.assertEquals(driver.getTitle(), "Selenium - Поиск в Google");
    }

    @Test(description = "check WikiPage Title")
    @Severity(SeverityLevel.NORMAL)
    public void checkWikiPageTitle() {
        homePage.isShown();
        homePage.writeSearchWord();
        homePage.clickSearchBtn();
        searchPage.goToWikiPage();

        Assert.assertEquals(driver.getTitle(), "Selenium — Википедия");
    }

    @Test(description = "check WikiPage Heading")
    @Severity(SeverityLevel.CRITICAL)
    public void checkWikiPageHeading() {
        homePage.isShown();
        homePage.writeSearchWord();
        homePage.clickSearchBtn();
        searchPage.goToWikiPage();

        Assert.assertEquals(wikiPage.getWikiHeading(), "Selenium");
    }

}
