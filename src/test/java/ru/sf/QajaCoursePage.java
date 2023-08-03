package ru.sf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QajaCoursePage {

    private static final String APPLY_FOR_COURSE_BUTTON = "#rec359656457 > div > div > div.t396__elem.tn-elem.tn-elem__3596564571596261549401 > a";
    private static final String NAME_INPUT_BOX = "input_1495810359387";
    private static final String EMAIL_INPUT_BOX = "input_1495810354468";
    private static final String SELECT_PHONE_CODE = "#form581372890 > div.t-form__inputsbox > div.t-input-group.t-input-group_ph > div > div.t-input.t-input-phonemask__wrap > div.t-input-phonemask__select";
    private static final String KYRGYZ_PHONE_CODE = "t-phonemask_kg";
    private static final String EXPECTED_PHONE_CODE = "+996";
    private static final String PHONE_NUMBER_INPUT_BOX = "#form581372890 > div.t-form__inputsbox > div.t-input-group.t-input-group_ph > div > div.t-input.t-input-phonemask__wrap > input.t-input.t-input-phonemask";
    private static final String EXPECTED_PHONE_NUMBER = "000000000";
    private static final String I_HAVE_PROMO_CODE = "#form581372890 > div.t-form__inputsbox > div.t-input-group.t-input-group_in > div > a";
    private static final String PROMO_CODE_INPUT_BOX = "#input_1650379112455";
    private static final String SEND_APPLICATION = "#form581372890 > div.t-form__inputsbox > div.t-form__submit > button";
    private static final String EXPECTED_URL = "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou";
    private static final int EXPECTED_NUMBER_OF_DIGITS = 16;
    private static final String CLOSE_APPLICATION_FORM_BUTTON = "#rec581372890 > div > div > div.t-popup__close.t-popup__block-close > button";
    private static final String EXPECTED_NOTIFICATION = "Пожалуйста, заполните все обязательные поля";
    private static final String NAME_BOX = "#form358086231 > div.t-form__inputsbox > div.t-input-group.t-input-group_nm > div > input";
    private static final String EMAIL_BOX = "#form358086231 > div.t-form__inputsbox > div.t-input-group.t-input-group_em > div > input";
    private static final String PHONE_NUMBER_BOX = "/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[3]/div/div[1]/input[2]";
    private static final String SELECT_ANOTHER_PHONE_CODE = "/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[3]/div/div[1]/div[1]";
    //private static final String ANOTHER_PHONE_CODE = "/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[3]/div/div[1]/div[2]/noindex/div[93]";
    private static final String PROMO_CODE_BOX = "#form358086231 > div.t-form__inputsbox > div.t-input-group.t-input-group_in > div > input";
    private static final String GET_PROGRAM_BUTTON = "#form358086231 > div.t-form__inputsbox > div.tn-form__submit > button";
    private final WebDriver webDriver;
    public QajaCoursePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void go(String url) {
        webDriver.get(url);
    }
    public void applyForCourse() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector(APPLY_FOR_COURSE_BUTTON)).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SEND_APPLICATION)));

        String parentWindowHandler = webDriver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;
        Set<String> handles = webDriver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        webDriver.switchTo().window(subWindowHandler);
        String text = webDriver.getCurrentUrl();
        System.out.println("URL of child2 window is " + text);
    }
    public void setName(String name) {
        webDriver.findElement(By.id(NAME_INPUT_BOX)).sendKeys(name);
    }
    public void setEmail(String email) {
        webDriver.findElement(By.id(EMAIL_INPUT_BOX)).sendKeys(email);
    }
    public void selectPhoneCode() {
        webDriver.findElement(By.cssSelector(SELECT_PHONE_CODE)).click();
        webDriver.findElement(By.id(KYRGYZ_PHONE_CODE)).click();
    }
    public void setPhoneNumber(String number) {
        webDriver.findElement(By.cssSelector(PHONE_NUMBER_INPUT_BOX)).sendKeys(number);
    }
    public void setPromoCode(String promoCode) {
        webDriver.findElement(By.cssSelector(I_HAVE_PROMO_CODE)).click();
        webDriver.findElement(By.cssSelector(PROMO_CODE_INPUT_BOX)).sendKeys(promoCode);
    }
    public void clickTheSubmitButton() {
        webDriver.findElement(By.cssSelector(SEND_APPLICATION)).click();
    }
    public void assertUrlEqualsExpected(String url) {
        final String actualURL = webDriver.getCurrentUrl();
        System.out.println(actualURL);
        assertEquals(EXPECTED_URL, actualURL);
        webDriver.close();
    }
    public void closeApplicationForm() {
        webDriver.findElement(By.cssSelector(CLOSE_APPLICATION_FORM_BUTTON)).click();
    }

    public void clickGetProgram() {
        webDriver.findElement(By.cssSelector(GET_PROGRAM_BUTTON)).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
                String text = webDriver.getCurrentUrl();
                System.out.println("URL of child3 window is " + text);
            }
        }
    }
    public void assertThatThePhoneNumberIsCorrect() {
        final String actualPhoneCode = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[3]/div/div[1]/div[1]/span[3]")).getText();
        assertEquals (EXPECTED_PHONE_CODE, actualPhoneCode);

        //WebElement phoneNumber = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[3]/div/div[1]/input[2]"));
        final String actualPhoneNumber = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[3]/div/div[1]/input[2]")).getAttribute("data-phonemask-current");
        System.out.println(actualPhoneNumber);
        assertEquals (EXPECTED_PHONE_NUMBER, actualPhoneNumber);
    }

    public void assertUserGotNotification() {
        final String actualNotification = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[6]/div/div/p[2]")).getText();
        System.out.println(actualNotification);
        assertEquals (EXPECTED_NOTIFICATION, actualNotification);
        webDriver.close();
    }
    public void assertUserGotSetNameNotification(String setNameNotification) {
        final String actualSetNameNotification = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[6]/div/div/p[4]")).getText();
        System.out.println(actualSetNameNotification);
        assertEquals (setNameNotification, actualSetNameNotification);
        webDriver.close();
    }

    public void assertUserGotIncorrectEmailNotification(String incorrectEmailNotification) {
        final String actualIncorrectEmailNotification = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[6]/div/div/p[3]")).getText();
        System.out.println(actualIncorrectEmailNotification);
        assertEquals (incorrectEmailNotification, actualIncorrectEmailNotification);
        webDriver.close();
    }

    public void assertUserGotIncorrectPhoneNumberNotification(String incorrectPhoneNumberNotification) {
        final String actualIncorrectPhoneNumberNotification = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[6]/div/div/p[3]")).getText();
        System.out.println(actualIncorrectPhoneNumberNotification);
        assertEquals (incorrectPhoneNumberNotification, actualIncorrectPhoneNumberNotification);
        webDriver.close();
    }

    public void assertUserGotTooShortPhoneNumberNotification(String tooShortPhoneNumberNotification) {
        final String actualTooShortPhoneNumberNotification = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[6]/div/div/p[3]")).getText();
        System.out.println(actualTooShortPhoneNumberNotification);
        assertEquals (tooShortPhoneNumberNotification, actualTooShortPhoneNumberNotification);
        webDriver.close();
    }

    public void assertThatLengthOfPhoneNumberIsCorrect() {
        final int actualNumberOfDigits = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[3]/div/div[1]/input[3]")).getAttribute("value").length();
        System.out.println(actualNumberOfDigits);
        assertEquals (EXPECTED_NUMBER_OF_DIGITS, actualNumberOfDigits);
        webDriver.close();
    }

    public void untickTheAgreementBox() {
        webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[5]/div/label/input")).click();
    }

    public void assertUserGotErrorNotification() {
        final String actualErrorNotification = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[5]/div/div")).getText();
        System.out.println(actualErrorNotification);
        assertEquals (EXPECTED_NOTIFICATION, actualErrorNotification);
        webDriver.close();
    }
    public void clickTheLinkИпотекаСоСтавкой() {
        webDriver.findElement(By.cssSelector("#rec500843954 > div > div > div.t396__elem.tn-elem.tn-elem__5008439541665165235238 > div > a")).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
                String text = webDriver.getCurrentUrl();
                System.out.println("URL of child4 window is " + text);
            }
        }
    }

    public void clickTheLinkОтсрочкаОтПризываДо27Лет() {
        webDriver.findElement(By.cssSelector("#rec500843954 > div > div > div.t396__elem.tn-elem.tn-elem__5008439541665165235244 > div > a")).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
                String text = webDriver.getCurrentUrl();
                System.out.println("URL of child5 window is " + text);
            }
        }
    }

    public void clickTheLinkОтсрочкаОтЧастичнойМобилизации() {
        webDriver.findElement(By.cssSelector("#rec500843954 > div > div > div.t396__elem.tn-elem.tn-elem__5008439541665165235251 > div > a")).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
                String text = webDriver.getCurrentUrl();
                System.out.println("URL of child5 window is " + text);
            }
        }
    }

    public void clickTheLinkShopiland() {
        webDriver.findElement(By.cssSelector("#rec550173884 > div > div > div.t396__elem.tn-elem.tn-elem__5501738841676022437368 > div > a")).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
                String text = webDriver.getCurrentUrl();
                System.out.println("URL of child5 window is " + text);
            }
        }
    }

    public void enterName(String name) {
        webDriver.findElement(By.cssSelector(NAME_BOX)).sendKeys(name);
    }
    public void enterEmail(String email) {
        webDriver.findElement(By.cssSelector(EMAIL_BOX)).sendKeys(email);
    }
    public void enterPhoneNumber(String number) {
        webDriver.findElement(By.xpath(PHONE_NUMBER_BOX)).sendKeys(number);
    }
    public void enterPromoCode(String promoCode) {
        webDriver.findElement(By.cssSelector(PROMO_CODE_BOX)).sendKeys(promoCode);
    }

    public void selectAnotherPhoneCode() {
        webDriver.findElement(By.cssSelector(SELECT_ANOTHER_PHONE_CODE)).click();
        webDriver.findElement(By.id(KYRGYZ_PHONE_CODE)).click();
    }

    public void assertThatThisPhoneNumberIsCorrect() {
        final String actualPhoneCode = webDriver.findElement(By.xpath("/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[3]/div/div[1]/div[1]/span[3]")).getText();
        assertEquals (EXPECTED_PHONE_CODE, actualPhoneCode);

        //WebElement phoneNumber = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[3]/div/div[1]/input[2]"));
        final String actualPhoneNumber = webDriver.findElement(By.xpath("/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[3]/div/div[1]/input[3]")).getAttribute("data-phonemask-current");
        System.out.println(actualPhoneNumber);
        assertEquals (EXPECTED_PHONE_NUMBER, actualPhoneNumber);
    }

    public void ClickTheButtonПолучитьПрограмму() {
        webDriver.findElement(By.cssSelector(GET_PROGRAM_BUTTON)).click();
    }

    public void assertThatUserSeesNotification(String notification) {
        final String actualNotification = webDriver.findElement(By.xpath("/html/body/div[5]/div[1]/p")).getText();
        System.out.println(actualNotification);
        assertEquals (EXPECTED_NOTIFICATION, actualNotification);
        webDriver.close();
    }

    public void assertUserSeesSetNameNotification(String setNameNotification) {
        final String actualSetNameNotification = webDriver.findElement(By.xpath("//html/body/div[5]/div[1]/p[1]")).getText();
        System.out.println(actualSetNameNotification);
        assertEquals (setNameNotification, actualSetNameNotification);
        webDriver.close();
    }

    public void assertUserSeesIncorrectEmailNotification(String incorrectEmailNotification) {
        final String actualIncorrectEmailNotification = webDriver.findElement(By.xpath("/html/body/div[5]/div[1]/p[2]")).getText();
        System.out.println(actualIncorrectEmailNotification);
        assertEquals (incorrectEmailNotification, actualIncorrectEmailNotification);
        webDriver.close();
    }

    public void assertUserSeesIncorrectPhoneNumberNotification(String incorrectPhoneNumberNotification) {
        final String actualIncorrectPhoneNumberNotification = webDriver.findElement(By.xpath("/html/body/div[5]/div[1]/p[2]")).getText();
        System.out.println(actualIncorrectPhoneNumberNotification);
        assertEquals (incorrectPhoneNumberNotification, actualIncorrectPhoneNumberNotification);
        webDriver.close();
    }

    public void assertUserSeesTooShortPhoneNumberNotification(String tooShortPhoneNumberNotification) {
        final String actualTooShortPhoneNumberNotification = webDriver.findElement(By.xpath("/html/body/div[5]/div[1]/p[2]")).getText();
        System.out.println(actualTooShortPhoneNumberNotification);
        assertEquals (tooShortPhoneNumberNotification, actualTooShortPhoneNumberNotification);
        webDriver.close();
    }

    public void assertThatLengthOfThisPhoneNumberIsCorrect() {
        final int actualNumberOfDigits = webDriver.findElement(By.xpath("/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[3]/div/div[1]/input[3]")).getAttribute("value").length();
        System.out.println(actualNumberOfDigits);
        assertEquals (EXPECTED_NUMBER_OF_DIGITS, actualNumberOfDigits);
        webDriver.close();
    }

    public void theSiteIsOpenUntickTheAgreementBox() {
        webDriver.findElement(By.xpath("/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[5]/div/label/input")).click();
    }

    public void assertUserSeesErrorNotification() {
        final String actualErrorNotification = webDriver.findElement(By.xpath("/html/body/div[5]/div[1]/p")).getText();
        System.out.println(actualErrorNotification);
        assertEquals (EXPECTED_NOTIFICATION, actualErrorNotification);
        webDriver.close();
    }

    public void theSiteIsOpenEnterEmailTestGmailCom(String email) {
        webDriver.findElement(By.cssSelector(EMAIL_BOX)).sendKeys(email);
    }

    public void clickTheButtonВыбратьТарифБазовый() {
        webDriver.findElement(By.cssSelector("#sbs-426327183-1620729847547 > a")).click();
    }
    public void assertThatUserSeesPage1(String header1) {
        final String currentPopUpPage = webDriver.findElement(By.xpath("/html/body/div[2]/div[86]/div/div/div[1]/div/div/div")).getText();
        System.out.println(currentPopUpPage);
        assertEquals (header1, currentPopUpPage);
        webDriver.close();
    }

    public void theSiteIsOpenClickTheButtonВыбратьТарифОптимальный() {
        webDriver.findElement(By.cssSelector("#sbs-426327183-1620730172361 > a")).click();
    }

    public void assertThatUserSeesPage2(String header2) {
        final String currentPopUpPage = webDriver.findElement(By.xpath("/html/body/div[2]/div[87]/div/div/div[1]/div/div/div")).getText();
        System.out.println(currentPopUpPage);
        assertEquals (header2, currentPopUpPage);
        webDriver.close();
    }

    public void theSiteIsOpenClickTheButtonВыбратьТарифVIP() {
        webDriver.findElement(By.cssSelector("#sbs-426327183-1620730221326 > a")).click();
    }

    public void assertThatUserSeesPage3(String header3) {
        final String currentPopUpPage = webDriver.findElement(By.xpath("/html/body/div[2]/div[88]/div/div/div[1]/div/div/div")).getText();
        System.out.println(currentPopUpPage);
        assertEquals (header3, currentPopUpPage);
        webDriver.close();
    }

}
