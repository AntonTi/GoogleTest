package test.java.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseMainTest {

    @Test
    public void checkHomePageTitle() {
        homePage.isShown();

        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void checkSearchPageTitle() {
        homePage.isShown();
        homePage.writeSearchWord();
        homePage.clickSearchBtn();

        Assert.assertEquals(driver.getTitle(), "Selenium - Поиск в Google");
    }

    @Test(invocationCount = 1)
    public void checkWikiPageTitle() {
        homePage.isShown();
        homePage.writeSearchWord();
        homePage.clickSearchBtn();
        searchPage.goToWikiPage();

        Assert.assertEquals(driver.getTitle(), "Selenium — Википедия");
    }

    @Test
    public void checkWikiPageHeading() {
        homePage.isShown();
        homePage.writeSearchWord();
        homePage.clickSearchBtn();
        searchPage.goToWikiPage();

        Assert.assertEquals(wikiPage.getWikiHeading(), "Selenium");
    }

}
