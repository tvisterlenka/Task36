package ru.sf;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefermentOfMilitaryServiceDuringMobilisationPage {
    private final WebDriver webDriver;
    public DefermentOfMilitaryServiceDuringMobilisationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertThatPageIsOpened(String url) {
        final String currentUrl = webDriver.getCurrentUrl().substring(0, 30);
        assertEquals(url.substring(0, 30), currentUrl);
    }
}
