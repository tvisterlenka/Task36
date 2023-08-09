package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QajaCoursePage {

    private static final String QAJA_COURSE_PAGE_URL = "https://skillfactory.ru/java-qa-engineer-testirovshik-po";
    private static final String APPLY_FOR_COURSE_BUTTON = "#rec359656457 > div > div > div.t396__elem.tn-elem.tn-elem__3596564571596261549401 > a";
    private static final String NAME_INPUT_BOX = "input_1495810359387";
    private static final String EMAIL_INPUT_BOX = "input_1495810354468";
    private static final String SELECT_PHONE_CODE = "#form581372890 > div.t-form__inputsbox > div.t-input-group.t-input-group_ph > div > div.t-input.t-input-phonemask__wrap > div.t-input-phonemask__select";
    private static final String KYRGYZ_PHONE_CODE = "t-phonemask_kg";
    private static final String ANOTHER_PHONE_CODE = "/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[3]/div/div[1]/div[2]/noindex/div[93]";
    private static final String EXPECTED_PHONE_CODE = "+996";
    private static final String ACTUAL_PHONE_CODE = "/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[3]/div/div[1]/div[1]/span[3]";
    private static final String PHONE_NUMBER_INPUT_BOX = "#form581372890 > div.t-form__inputsbox > div.t-input-group.t-input-group_ph > div > div.t-input.t-input-phonemask__wrap > input.t-input.t-input-phonemask";
    private static final String I_HAVE_PROMO_CODE = "#form581372890 > div.t-form__inputsbox > div.t-input-group.t-input-group_in > div > a";
    private static final String PROMO_CODE_INPUT_BOX = "#input_1650379112455";
    private static final String AGREEMENT_INPUT_BOX = "#form581372890 > div.t-form__inputsbox > div.t-input-group.t-input-group_cb > div > label > div.t-checkbox__indicator";
    private static final String SEND_APPLICATION = "#form581372890 > div.t-form__inputsbox > div.t-form__submit > button";
    private static final String CLOSE_APPLICATION_FORM_BUTTON = "#rec581372890 > div > div > div.t-popup__close.t-popup__block-close > button";
    private static final String APPLICATION_FORM_STATE = "/html/body/div[2]/div[6]/div/div";
    private static final String EXPECTED_STATE_NONE = "display: none;";
    private static final String EXPECTED_STATE_BLOCK = "display: block;";
    private static final String ACTUAL_STATE = "style";
    private static final String EXPECTED_NOTIFICATION = "Пожалуйста, заполните все обязательные поля";
    private static final String ACTUAL_NOTIFICATION = "/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[6]/div/div/p[2]";
    private static final String ACTUAL_SET_NAME_NOTIFICATION = "/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[6]/div/div/p[4]";
    private static final String ACTUAL_INCORRECT_EMAIL_NOTIFICATION = "/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[6]/div/div/p[3]";
    private static final String ACTUAL_INCORRECT_PHONE_NUMBER_NOTIFICATION = "js-rule-error-phone";
    private static final String ACTUAL_TOO_SHORT_PHONE_NUMBER_NOTIFICATION = "js-rule-error-minlength";
    private static final int EXPECTED_NUMBER_OF_DIGITS = 18;
    private static final String ACTUAL_NUMBER_OF_DIGITS = "/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[3]/div/div[1]/input[3]";
    private static final String VALUE = "value";
    private static final String ERROR_NOTIFICATION = "/html/body/div[2]/div[6]/div/div/div[1]/div/form/div[2]/div[5]/div/div";
    private static final String MORTGAGE_LINK = "#rec500843954 > div > div > div.t396__elem.tn-elem.tn-elem__5008439541665165235238 > div > a";
    private static final String DEFERMENT_OF_CONSCRIPTION_LINK = "#rec500843954 > div > div > div.t396__elem.tn-elem.tn-elem__5008439541665165235244 > div > a";
    private static final String DEFERMENT_OF_MOBILISATION_LINK = "#rec500843954 > div > div > div.t396__elem.tn-elem.tn-elem__5008439541665165235251 > div > a";
    private static final String SHOPILAND_LINK = "#rec550173884 > div > div > div.t396__elem.tn-elem.tn-elem__5501738841676022437368 > div > a";
    private static final String NAME_BOX = "#form358086231 > div.t-form__inputsbox > div.t-input-group.t-input-group_nm > div > input";
    private static final String EMAIL_BOX = "#form358086231 > div.t-form__inputsbox > div.t-input-group.t-input-group_em > div > input";
    private static final String PHONE_NUMBER_BOX = "/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[3]/div/div[1]/input[2]";
    private static final String SELECT_ANOTHER_PHONE_CODE = "/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[3]/div/div[1]/div[1]";
    private static final String PROMO_CODE_BOX = "#form358086231 > div.t-form__inputsbox > div.t-input-group.t-input-group_in > div > input";
    private static final String ACTUAL_PHONE_CODE_BOX = "/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[3]/div/div[1]/div[1]/span[3]";
    private static final String AGREEMENT_BOX = "#form358086231 > div.t-form__inputsbox > div.t-input-group.t-input-group_cb > div > label > div";
    private static final String ACTUAL_NOTIFICATION_BOX = "/html/body/div[5]/div[1]/p";
    private static final String ACTUAL_SET_NAME_NOTIFICATION_BOX = "#tilda-popup-for-error > div.t-form__errorbox-text.t-text.t-text_xs > p:nth-child(1)";
    private static final String ACTUAL_INCORRECT_EMAIL_NOTIFICATION_BOX = "#tilda-popup-for-error > div.t-form__errorbox-text.t-text.t-text_xs > p:nth-child(2)";
    private static final String ACTUAL_INCORRECT_PHONE_NUMBER_NOTIFICATION_BOX = "#tilda-popup-for-error > div.t-form__errorbox-text.t-text.t-text_xs > p:nth-child(2)";
    private static final String ACTUAL_TOO_SHORT_PHONE_NUMBER_NOTIFICATION_BOX = "#tilda-popup-for-error > div.t-form__errorbox-text.t-text.t-text_xs > p:nth-child(2)";
    private static final String ACTUAL_NUMBER_OF_DIGITS_BOX = "/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form/div[2]/div[3]/div/div[1]/input[3]";
    private static final String ERROR_NOTIFICATION_BOX = "/html/body/div[5]/div[1]/p";
    private static final String GET_PROGRAM_BUTTON = "#form358086231 > div.t-form__inputsbox > div.tn-form__submit > button";
    private static final String SUCCESS_URL = "/html/body/div[2]/div[32]/div/div/div[4]/div[1]/form";
    private static final String DATA_SUCCESS_URL = "data-success-url";
    private static final String PERSONAL_DATA_PROTECTION_REGULATION_URL_FORM = "#form581372890 > div.t-form__inputsbox > div.t-input-group.t-input-group_cb > div > label > div:nth-child(3) > a";
    private static final String PERSONAL_DATA_PROTECTION_REGULATION_URL = "#form358086231 > div.t-form__inputsbox > div.t-input-group.t-input-group_cb > div > label > span > a";
    private static final String PROMOTION_RULES_URL = "#rec522286097 > div > div > div.t396__elem.tn-elem.tn-elem__5222860971670230587922 > div > a";
    private static final String SUCCESS_STORIES_URL = "#rec493408831 > div > div > div.t396__elem.tn-elem.tn-elem__4934088311665392810483 > a";
    private static final String QAJA_FULL_PROGRAM_URL = "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou";

    private final WebDriver webDriver;

    public QajaCoursePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void go(String url) {
        webDriver.get(url);
    }

    public void assertThatUserGotQAJACoursePage() {
        String currentUrl = webDriver.getCurrentUrl();
        assertEquals(QAJA_COURSE_PAGE_URL, currentUrl);
    }

    public void applyForCourse() {
        webDriver.findElement(By.cssSelector(APPLY_FOR_COURSE_BUTTON)).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SEND_APPLICATION)));

        Set<String> handles = webDriver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            String subWindowHandler = iterator.next();
            webDriver.switchTo().window(subWindowHandler);
        }
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
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (QAJA_FULL_PROGRAM_URL.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
            }
        }
    }

    public void clickTheRegulationLink() {
        webDriver.findElement(By.cssSelector(PERSONAL_DATA_PROTECTION_REGULATION_URL_FORM)).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
            }
        }
    }

    public void closeApplicationForm() {
        webDriver.findElement(By.cssSelector(CLOSE_APPLICATION_FORM_BUTTON)).click();
    }

    public void assertThatTheApplicationFormIsClosed() {
        final String actualState = webDriver.findElement(By.xpath(APPLICATION_FORM_STATE)).getAttribute(ACTUAL_STATE);
        if (actualState.equals(EXPECTED_STATE_NONE)) {
            assertEquals(EXPECTED_STATE_NONE, actualState);
        }
        else {
            assertEquals(EXPECTED_STATE_BLOCK, actualState);
        }
    }

    public void clickGetProgram() {
        webDriver.findElement(By.cssSelector(GET_PROGRAM_BUTTON)).click();
    }

    public void assertUrlEqualsExpected(String url) {
        final String actualURL = webDriver.findElement(By.xpath(SUCCESS_URL)).getAttribute(DATA_SUCCESS_URL);
        assertEquals(url, actualURL);
    }

    public void assertThatThePhoneCodeIsCorrect() {
        final String actualPhoneCode = webDriver.findElement(By.xpath(ACTUAL_PHONE_CODE)).getText();
        assertEquals(EXPECTED_PHONE_CODE, actualPhoneCode);
    }

    public void assertUserGotNotification() {
        final String actualNotification = webDriver.findElement(By.xpath(ACTUAL_NOTIFICATION)).getText();
        assertEquals(EXPECTED_NOTIFICATION, actualNotification);
    }

    public void assertUserGotSetNameNotification(String setNameNotification) {
        final String actualSetNameNotification = webDriver.findElement(By.xpath(ACTUAL_SET_NAME_NOTIFICATION)).getText();
        assertEquals(setNameNotification, actualSetNameNotification);
    }

    public void theSiteIsOpenEnterEmail(String email) {
        webDriver.findElement(By.cssSelector(EMAIL_BOX)).sendKeys(email);
    }

    public void assertUserGotIncorrectEmailNotification(String incorrectEmailNotification) {
        final String actualIncorrectEmailNotification = webDriver.findElement(By.xpath(ACTUAL_INCORRECT_EMAIL_NOTIFICATION)).getText();
        assertEquals(incorrectEmailNotification, actualIncorrectEmailNotification);
    }

    public void assertUserGotIncorrectPhoneNumberNotification(String incorrectPhoneNumberNotification) {
        final String actualIncorrectPhoneNumberNotification = webDriver.findElement(By.className(ACTUAL_INCORRECT_PHONE_NUMBER_NOTIFICATION)).getText();
        assertEquals(incorrectPhoneNumberNotification, actualIncorrectPhoneNumberNotification);
    }

    public void assertUserGotTooShortPhoneNumberNotification(String tooShortPhoneNumberNotification) {
        final String actualTooShortPhoneNumberNotification = webDriver.findElement(By.className(ACTUAL_TOO_SHORT_PHONE_NUMBER_NOTIFICATION)).getText();
        assertEquals(tooShortPhoneNumberNotification, actualTooShortPhoneNumberNotification);
    }

    public void assertThatLengthOfPhoneNumberIsCorrect() {
        final int actualNumberOfDigits = webDriver.findElement(By.xpath(ACTUAL_NUMBER_OF_DIGITS)).getAttribute(VALUE).length();
        assertEquals(EXPECTED_NUMBER_OF_DIGITS, actualNumberOfDigits);
    }

    public void untickTheAgreementBox() {
        webDriver.findElement(By.cssSelector(AGREEMENT_INPUT_BOX)).click();
    }

    public void assertUserGotErrorNotification() {
        final String actualErrorNotification = webDriver.findElement(By.xpath(ERROR_NOTIFICATION)).getText();
        assertEquals(EXPECTED_NOTIFICATION, actualErrorNotification);
    }

    public void clickTheLinkИпотекаСоСтавкой() {
        webDriver.findElement(By.cssSelector(MORTGAGE_LINK)).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
            }
        }
    }

    public void clickTheLinkОтсрочкаОтПризываДо27Лет() {
        webDriver.findElement(By.cssSelector(DEFERMENT_OF_CONSCRIPTION_LINK)).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
            }
        }
    }

    public void clickTheLinkОтсрочкаОтЧастичнойМобилизации() {
        webDriver.findElement(By.cssSelector(DEFERMENT_OF_MOBILISATION_LINK)).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
            }
        }
    }

    public void clickTheLinkShopiland() {
        webDriver.findElement(By.cssSelector(SHOPILAND_LINK)).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
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
        webDriver.findElement(By.xpath(SELECT_ANOTHER_PHONE_CODE)).click();
        webDriver.findElement(By.xpath(ANOTHER_PHONE_CODE)).click();
    }

    public void assertThatThisPhoneCodeIsCorrect() {
        final String actualPhoneCode = webDriver.findElement(By.xpath(ACTUAL_PHONE_CODE_BOX)).getText();
        assertEquals(EXPECTED_PHONE_CODE, actualPhoneCode);
    }

    public void clickTheButtonПолучитьПрограмму() {
        webDriver.findElement(By.cssSelector(GET_PROGRAM_BUTTON)).click();
    }

    public void assertThatUserSeesNotification() {
        final String actualNotification = webDriver.findElement(By.xpath(ACTUAL_NOTIFICATION_BOX)).getText();
        assertEquals(EXPECTED_NOTIFICATION, actualNotification);
    }

    public void assertUserSeesSetNameNotification(String setNameNotification) {
        final String actualSetNameNotification = webDriver.findElement(By.cssSelector(ACTUAL_SET_NAME_NOTIFICATION_BOX)).getText();
        assertEquals(setNameNotification, actualSetNameNotification);
    }

    public void assertUserSeesIncorrectEmailNotification(String incorrectEmailNotification) {
        final String actualIncorrectEmailNotification = webDriver.findElement(By.cssSelector(ACTUAL_INCORRECT_EMAIL_NOTIFICATION_BOX)).getText();
        assertEquals(incorrectEmailNotification, actualIncorrectEmailNotification);
    }

    public void assertUserSeesIncorrectPhoneNumberNotification(String incorrectPhoneNumberNotification) {
        final String actualIncorrectPhoneNumberNotification = webDriver.findElement(By.cssSelector(ACTUAL_INCORRECT_PHONE_NUMBER_NOTIFICATION_BOX)).getText();
        assertEquals(incorrectPhoneNumberNotification, actualIncorrectPhoneNumberNotification);
    }

    public void assertUserSeesTooShortPhoneNumberNotification(String tooShortPhoneNumberNotification) {
        final String actualTooShortPhoneNumberNotification = webDriver.findElement(By.cssSelector(ACTUAL_TOO_SHORT_PHONE_NUMBER_NOTIFICATION_BOX)).getText();
        assertEquals(tooShortPhoneNumberNotification, actualTooShortPhoneNumberNotification);
    }

    public void assertThatLengthOfThisPhoneNumberIsCorrect() {
        final int actualNumberOfDigits = webDriver.findElement(By.xpath(ACTUAL_NUMBER_OF_DIGITS_BOX)).getAttribute(VALUE).length();
        assertEquals(EXPECTED_NUMBER_OF_DIGITS, actualNumberOfDigits);
    }

    public void theSiteIsOpenEnterLetters(String letters) {
        webDriver.findElement(By.xpath(PHONE_NUMBER_BOX)).sendKeys(letters);
    }
    public void assertThatLengthOfThisPhoneNumberIs(int length) {
        final int actualLength = webDriver.findElement(By.xpath(ACTUAL_NUMBER_OF_DIGITS_BOX)).getAttribute(VALUE).length();
        assertEquals(length, actualLength);
    }

    public void enterLettersIntoThePhoneBox(String letters) {
        webDriver.findElement(By.cssSelector(PHONE_NUMBER_INPUT_BOX)).sendKeys(letters);
    }
    public void assertThatLengthOfThePhoneNumberIs(int length) {
        final int actualLength = webDriver.findElement(By.xpath(ACTUAL_NUMBER_OF_DIGITS)).getAttribute(VALUE).length();
        assertEquals(length, actualLength);
    }
    public void theSiteIsOpenUntickTheAgreementBox() {
        webDriver.findElement(By.cssSelector(AGREEMENT_BOX)).click();
    }

    public void assertUserSeesErrorNotification() {
        final String actualErrorNotification = webDriver.findElement(By.xpath(ERROR_NOTIFICATION_BOX)).getText();
        assertEquals(EXPECTED_NOTIFICATION, actualErrorNotification);
    }

    public void clickTheLinkОбработкуПерсональныхДанных() {
        webDriver.findElement(By.cssSelector(PERSONAL_DATA_PROTECTION_REGULATION_URL)).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
            }
        }
    }

    public void theSiteIsOpenClickTheLinkПравилахАкции(String url) {
        webDriver.findElement(By.cssSelector(PROMOTION_RULES_URL)).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
            }
        }
    }

    public void theSiteIsOpenClickTheButtonВсеИсторииУспехаВБлоге() {
        webDriver.findElement(By.cssSelector(SUCCESS_STORIES_URL)).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
            }
        }
    }

}