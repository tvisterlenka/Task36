package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {

    private static final String CITY_FROM = "direction-from";
    private static final String SELECT_CITY_FROM = "rzd-suggestion";
    private static final String CITY_TO = "direction-to";
    private static final String SELECT_CITY_TO = "//*[contains(text(), '%s')]";
    private static final String DATE = "datepicker-from";
    private static final String SEARCH = "rzd-go-to-result-button";
    private static final String FROM_EMPTY = "tooltip-station-from-empty";
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

    /*public void enterCityFrom(String cityFrom) {
        webDriver.findElement(By.id(CITY_FROM)).sendKeys(cityFrom);
        webDriver.findElements(By.className(SELECT_CITY_FROM)).get(1).click();
    }

    public void enterCityTo(String cityTo) {
        webDriver.findElement(By.id(CITY_TO)).sendKeys(cityTo);
        webDriver.findElements(By.xpath(String.format(SELECT_CITY_TO, cityTo))).get(0).click();
    }

    public void enterDate(String depart) {
        webDriver.findElement(By.id(DATE)).sendKeys(depart);
    }

    public void search() {
        webDriver.findElement(By.className(SEARCH)).click();
    }

    public void assertThatUserGotTheMessage(String errorMessage) {
        final String actualMessage = webDriver.findElement(By.id(FROM_EMPTY)).getText();
        assertEquals (errorMessage, actualMessage);
    }*/
}
