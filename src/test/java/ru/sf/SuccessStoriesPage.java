package ru.sf;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuccessStoriesPage {
    private final WebDriver webDriver;
    public SuccessStoriesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertThatUserSeesBlogPage(String url) {
        final String currentUrl = webDriver.getCurrentUrl().substring(0, 42);
        assertEquals(url, currentUrl);
    }
}
