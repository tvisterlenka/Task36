package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private static final String TESTING = "#rec623700412 > div > div > div > section > div.outer-wrapper > div > div.columns > div:nth-child(1) > div > ul > li:nth-child(4) > a";

    private final WebDriver webDriver;
    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void go(String url) {
        webDriver.get(url);
    }

    public void clickTesting() {
        webDriver.findElement(By.cssSelector(TESTING)).click();
        String parentHandle = webDriver.getWindowHandle();
        for (String handle: webDriver.getWindowHandles()) {
            if (!parentHandle.equals(handle))
                webDriver.switchTo().window(handle);
        }
    }
}
