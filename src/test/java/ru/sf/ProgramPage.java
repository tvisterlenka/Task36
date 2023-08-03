package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramPage {
    private static final String DETAILED_COURSE_PROGRAM = "#rec600706268 > div > div > div.t396__elem.tn-elem.tn-elem__6007062681677770138193 > div";

    private final WebDriver webDriver;

    public ProgramPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertThatUserGotDetailedProgram(String detailedCourseProgram) {
        final String actualString = webDriver.findElement(By.cssSelector(DETAILED_COURSE_PROGRAM)).getText();
        assertEquals (detailedCourseProgram, actualString);
    }
}
