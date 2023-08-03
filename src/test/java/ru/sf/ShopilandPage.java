package ru.sf;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopilandPage {

    private final WebDriver webDriver;
    public ShopilandPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertThatUserGetsPage(String url) {
        String currentUrl = webDriver.getCurrentUrl();
        assertEquals(url, currentUrl);
        webDriver.close();
    }
}
