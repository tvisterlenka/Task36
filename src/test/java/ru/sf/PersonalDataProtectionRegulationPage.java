package ru.sf;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonalDataProtectionRegulationPage {
    private final WebDriver webDriver;

    public PersonalDataProtectionRegulationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertUrlEqualsExpected(String url) {
        final String actualURL = webDriver.getCurrentUrl();
        assertEquals(url, actualURL);
    }
}
