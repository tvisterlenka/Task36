package ru.sf;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromotionRulesPage {
    private final WebDriver webDriver;
    public PromotionRulesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertThatPageOpened(String url) {
        final String currentUrl = webDriver.getCurrentUrl();
        assertEquals(url, currentUrl);
    }
}
