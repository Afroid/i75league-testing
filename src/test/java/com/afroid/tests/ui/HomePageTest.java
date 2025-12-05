package com.afroid.tests.ui;

import com.afroid.automation.ui.UiTestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HomePageTest extends UiTestBase {

    @Test
    void homePageLoadsAndHasHeader() throws InterruptedException{
        HomePage homePage = new HomePage(driver);

        homePage.open();

        String title = driver.getTitle();
        System.out.println("Page title: " + title);

        // Very loose sanity check so it doesn't break if you tweak the site text later
        assertTrue(title.toLowerCase().contains("i75"),
                "Expected title to contain 'i75', but was: " + title);
    }
}
