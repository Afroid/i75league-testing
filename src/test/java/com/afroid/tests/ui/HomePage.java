package com.afroid.tests.ui;

import com.afroid.automation.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String URL = "https://www.i75league.com";
    private static final By MAIN_HEADER = By.cssSelector("h1");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() throws InterruptedException {
        open(URL); // protected helper from BasePage
    }

    public String getMainHeaderText() {
        return getText(MAIN_HEADER);
    }
}
