package ru.sf;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreferentialMortgagePage {
    private final WebDriver webDriver;
    public PreferentialMortgagePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertThatUserSeesPage(String url) {
        final String currentUrl = webDriver.getCurrentUrl().substring(0, 20);
        assertEquals(url.substring(0, 20), currentUrl);
    }
}
