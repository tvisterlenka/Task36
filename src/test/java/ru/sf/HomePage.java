package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {

    private static final String TESTING = "#rec610368727 > div > div > div.t396__elem.tn-elem.tn-elem__6103687271679405234205.js-sbs-anim-trigger_hover > a";

    private final WebDriver webDriver;
    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void go(String url) {
        webDriver.get(url);
    }

    public void clickTesting() {
        webDriver.findElement(By.cssSelector(TESTING)).click();
    }
}
