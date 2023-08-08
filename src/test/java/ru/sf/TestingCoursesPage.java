package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestingCoursesPage {
    private static final String QAJA = "#rec560876661 > div > div > div.t396__elem.tn-elem.tn-elem__5608766611679951555532 > a";
    private final WebDriver webDriver;
    public TestingCoursesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void clickQAJA() {
        webDriver.findElement(By.cssSelector(QAJA)).click();
        String parentHandle = webDriver.getWindowHandle();
        for (String handle: webDriver.getWindowHandles()) {
            if (!parentHandle.equals(handle))
                webDriver.switchTo().window(handle);
        }
    }
}
