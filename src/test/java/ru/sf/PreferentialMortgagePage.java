package ru.sf;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreferentialMortgagePage {
    private final WebDriver webDriver;
    public PreferentialMortgagePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertThatUserSeesPage(String url) {
        String currentUrl = webDriver.getCurrentUrl();
        assertEquals(url, currentUrl);
        webDriver.close();
    }


}
