package ru.sf;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefermentOfMilitaryServiceDuringMobilisationPage {
    private final WebDriver webDriver;
    public DefermentOfMilitaryServiceDuringMobilisationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertThatPageIsOpened(String url) {
        String currentUrl = webDriver.getCurrentUrl();
        assertEquals(url, currentUrl);
        webDriver.close();
    }
}
