package ru.sf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    static final WebDriver webDriver;
    public static final HomePage homePage;
    public static final TestingCoursesPage testingCoursesPage;
    public static final QajaCoursePage qajaCoursePage;
    public static final ProgramPage programPage;
    public static final PreferentialMortgagePage preferentialMortgagePage;
    public static final DefermentOfConscriptionPage defermentOfConscriptionPage;
    public static final DefermentOfMilitaryServiceDuringMobilisationPage defermentOfMilitaryServiceDuringMobilisationPage;
    public static final ShopilandPage shopinlandPage;
    public static final PromotionRulesPage promotionRulesPage;
    public static final SuccessStoriesPage successStoriesPage;

    static {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        homePage = new HomePage(webDriver);
        testingCoursesPage = new TestingCoursesPage(webDriver);
        qajaCoursePage = new QajaCoursePage(webDriver);
        programPage = new ProgramPage(webDriver);
        preferentialMortgagePage = new PreferentialMortgagePage(webDriver);
        defermentOfConscriptionPage = new DefermentOfConscriptionPage(webDriver);
        defermentOfMilitaryServiceDuringMobilisationPage = new DefermentOfMilitaryServiceDuringMobilisationPage(webDriver);
        shopinlandPage = new ShopilandPage(webDriver);
        promotionRulesPage = new PromotionRulesPage(webDriver);
        successStoriesPage = new SuccessStoriesPage(webDriver);
    }

    @Given("url of SkillFactory: {string}")
    public void url_of_skill_factory(String url) {
        homePage.go(url);
    }
    @When("the site is open click the tag Тестирование")
    public void the_site_is_open_click_the_tag_тестирование() {
        homePage.clickTesting();
    }
    @Then("click Тестировщик на Java")
    public void click_тестировщик_на_java() {
        testingCoursesPage.clickQAJA();
    }
    @Then("click the button Записаться на курс")
    public void clickTheButtonЗаписатьсяНаКурс() {
        qajaCoursePage.applyForCourse();
    }
    @Then("set name {string}")
    public void set_name(String name) {
        qajaCoursePage.setName(name);
    }
    @Then("set email {string}")
    public void set_email(String email) {
        qajaCoursePage.setEmail(email);
    }
    @Then("set phone number {string}")
    public void set_phone_number(String number) {
        qajaCoursePage.setPhoneNumber(number);
    }

    @Given("url of QAJA course page: {string}")
    public void urlOfQAJACoursePage(String url) {
        qajaCoursePage.go(url);
    }
    
    @When("the site is open click the button Записаться на курс")
    public void theSiteIsOpenClickTheButtonЗаписатьсяНаКурс() {
        qajaCoursePage.applyForCourse();
    }

    @And("set promo code {string}")
    public void setPromoCodeTest(String promoCode) {
        qajaCoursePage.setPromoCode(promoCode);
    }

    @Then("select kyrgyz phone code")
    public void selectKyrgyzPhoneCode() {
        qajaCoursePage.selectPhoneCode();
    }

    @Then("click the button Отправить заявку")
    public void clickTheButtonОтправитьЗаявку() {
        qajaCoursePage.clickTheSubmitButton();
    }

    @Then("assert that user goes to page {string}")
    public void assertThatUserGoesToPage(String url) {
        qajaCoursePage.assertUrlEqualsExpected(url);
//      Заменить на
//        programPage.assertUrlEqualsExpected(url);
//      если нет капчи.
        /*if (actualState.equals(EXPECTED_STATE_NONE)) {
            assertEquals(EXPECTED_STATE_NONE, actualState);
        }
        else {
            assertEquals(EXPECTED_STATE_BLOCK, actualState);
        }*/
    }

    @Then("close the application form")
    public void closeTheApplicationForm() {
        qajaCoursePage.closeApplicationForm();
    }

    @Then("assert that the application form is closed")
    public void assertThatTheApplicationFormIsClosed() {
        qajaCoursePage.assertThatTheApplicationFormIsClosed();
    }

    @Then("assert that the phone code is correct")
    public void assertThatThePhoneCodeIsCorrect() {
        qajaCoursePage.assertThatThePhoneCodeIsCorrect();
    }

    @Then("click the button Получить программу")
    public void click_the_button_получить_программу() {
        qajaCoursePage.clickGetProgram();
    }

    @Then("assert that user got notification")
    public void assertThatUserGotNotification() {
        qajaCoursePage.assertUserGotNotification();
    }

    @Then("assert that user got set name notification {string}")
    public void assertThatUserGotSetNameNotification(String setNameNotification) {
        qajaCoursePage.assertUserGotSetNameNotification(setNameNotification);
    }

    @Then("assert that user got incorrect email notification {string}")
    public void assertThatUserGotIncorrectEmailNotification(String incorrectEmailNotification) {
        qajaCoursePage.assertUserGotIncorrectEmailNotification(incorrectEmailNotification);
    }

    @Then("assert that user got incorrect phone number notification {string}")
    public void assertThatUserGotIncorrectPhoneNumberNotification(String incorrectPhoneNumberNotification) {
        qajaCoursePage.assertUserGotIncorrectPhoneNumberNotification(incorrectPhoneNumberNotification);
    }

    @Then("assert that user got too short phone number notification {string}")
    public void assertThatUserGotTooShortPhoneNumberNotification(String tooShortPhoneNumberNotification) {
        qajaCoursePage.assertUserGotTooShortPhoneNumberNotification(tooShortPhoneNumberNotification);
    }

    @Then("assert that length of phone number is correct")
    public void assertThatLengthOfPhoneNumberIsCorrect() {
        qajaCoursePage.assertThatLengthOfPhoneNumberIsCorrect();
    }

    @Then("enter {string} into the phone box")
    public void enterLettersIntoThePhoneBox(String letters) {
        qajaCoursePage.enterLettersIntoThePhoneBox(letters);
    }

    @Then("assert that length of the phone number is {int}")
    public void assertThatLengthOfThePhoneNumberIs(int length) {
        qajaCoursePage.assertThatLengthOfThePhoneNumberIs(length);
    }

    @When("the site is open enter {string} into phone number box")
    public void theSiteIsOpenEnterLettersIntoPhoneBox(String letters) {
        qajaCoursePage.theSiteIsOpenEnterLetters(letters);
    }

    @Then("assert that length of this phone number is {int}")
    public void assertThatLengthOfThisPhoneNumberIs(int length) {
        qajaCoursePage.assertThatLengthOfThisPhoneNumberIs(length);
    }

    @Then("untick the agreement box")
    public void untickTheAgreementBox() {
        qajaCoursePage.untickTheAgreementBox();
    }

    @Then("assert that user got error notification")
    public void assertThatUserGotErrorNotification() {
        qajaCoursePage.assertUserGotErrorNotification();
    }

    @Then("click the link Ипотека со ставкой 5%")
    public void clickTheLinkИпотекаСоСтавкой() {
        qajaCoursePage.clickTheLinkИпотекаСоСтавкой();
    }

    @Then("assert that user sees page {string}")
    public void assertThatUserSeesPage(String url) {
        preferentialMortgagePage.assertThatUserSeesPage(url);
    }

    @When("the site is open click the link Отсрочка от призыва до 27 лет")
    public void theSiteIsOpenClickTheLinkОтсрочкаОтПризываДо27Лет() {
        qajaCoursePage.clickTheLinkОтсрочкаОтПризываДо27Лет();
    }

    @Then("assert that page {string} opened")
    public void assertThatPageOpened(String url) {
        defermentOfConscriptionPage.assertThatPageOpened(url);
    }

    @When("the site is open click the link Отсрочка от частичной мобилизации")
    public void theSiteIsOpenClickTheLinkОтсрочкаОтЧастичнойМобилизации() {
        qajaCoursePage.clickTheLinkОтсрочкаОтЧастичнойМобилизации();
    }

    @Then("assert that page {string} is opened")
    public void assertThatPageIsOpened(String url) {
        defermentOfMilitaryServiceDuringMobilisationPage.assertThatPageIsOpened(url);
    }

    @Then("click the link Shopiland")
    public void clickTheLinkShopiland() {
        qajaCoursePage.clickTheLinkShopiland();
    }

    @Then("assert that user gets page {string}")
    public void assertThatUserGetsPage(String url) {
        shopinlandPage.assertThatUserGetsPage(url);
    }

    @Then("enter name {string}")
    @When("the site is open enter name {string}")
    public void enterName(String name) {
        qajaCoursePage.enterName(name);
    }

    @And("enter email {string}")
    public void enterEmail(String email) {
        qajaCoursePage.enterEmail(email);
    }

    @And("enter phone number {string}")
    public void enterPhoneNumber(String number) {
        qajaCoursePage.enterPhoneNumber(number);
    }

    @And("enter promo code {string}")
    public void enterPromoCodeTest(String promoCode) {
        qajaCoursePage.enterPromoCode(promoCode);
    }

    @When("the site is open select kyrgyz phone code")
    public void SelectKyrgyzPhoneCode() {
        qajaCoursePage.selectAnotherPhoneCode();
    }

    @Then("assert that this phone code is correct")
    public void assertThatThisPhoneCodeIsCorrect() {
        qajaCoursePage.assertThatThisPhoneCodeIsCorrect();
    }

    @When("the site is open click the button Получить программу")
    public void clickTheButtonПолучитьПрограмму() {
        qajaCoursePage.clickTheButtonПолучитьПрограмму();
    }

    @Then("assert that user sees notification")
    public void assertThatUserSeesNotification() {
        qajaCoursePage.assertThatUserSeesNotification();
    }

    @Then("assert that user sees set name notification {string}")
    public void assertThatUserSeesSetNameNotification(String notification) {
        qajaCoursePage.assertUserSeesSetNameNotification(notification);
    }

    @When("the site is open enter email {string}")
    public void theSiteIsOpenEnterEmailTestGmailCom(String email) {
        qajaCoursePage.theSiteIsOpenEnterEmail(email);
    }

    @Then("assert that user sees incorrect email notification {string}")
    public void assertThatUserSeesIncorrectEmailNotification(String incorrectEmailNotification) {
        qajaCoursePage.assertUserSeesIncorrectEmailNotification(incorrectEmailNotification);
    }

    @Then("assert that user sees incorrect phone number notification {string}")
    public void assertThatUserSeesIncorrectPhoneNumberNotification(String incorrectPhoneNumberNotification) {
        qajaCoursePage.assertUserSeesIncorrectPhoneNumberNotification(incorrectPhoneNumberNotification);
    }

    @Then("assert that user sees too short phone number notification {string}")
    public void assertThatUserSeesTooShortPhoneNumberNotification(String tooShortPhoneNumberNotification) {
        qajaCoursePage.assertUserSeesTooShortPhoneNumberNotification(tooShortPhoneNumberNotification);
    }

    @Then("assert that length of this phone number is correct")
    public void assertThatLengthOfThisPhoneNumberIsCorrect() {
        qajaCoursePage.assertThatLengthOfThisPhoneNumberIsCorrect();
    }

    @When("the site is open untick the agreement box")
    public void theSiteIsOpenUntickTheAgreementBox() {
        qajaCoursePage.theSiteIsOpenUntickTheAgreementBox();
    }

    @Then("assert that user sees error notification")
    public void assertThatUserSeesErrorNotification() {
        qajaCoursePage.assertUserSeesErrorNotification();
    }

    @When("the site is open enter phone number {string}")
    public void theSiteIsOpenEnterPhoneNumber(String number) {
        qajaCoursePage.enterPhoneNumber(number);
    }

    @Then("click button Получить программу")
    public void clickButtonПолучитьПрограмму() {
        qajaCoursePage.clickTheButtonПолучитьПрограмму();
    }

    @When("the site is open click the link {string}")
    public void theSiteIsOpenClickTheLinkПравилахАкции(String url) {
        qajaCoursePage.theSiteIsOpenClickTheLinkПравилахАкции(url);
    }

    @Then("assert that user got page {string}")
    public void assertThatUserGotPage(String url) {
        promotionRulesPage.assertThatPageOpened(url);
    }

    @When("the site is open click the button Все истории успеха в блоге")
    public void theSiteIsOpenClickTheButtonВсеИсторииУспехаВБлоге() {
        qajaCoursePage.theSiteIsOpenClickTheButtonВсеИсторииУспехаВБлоге();
    }

    @Then("assert that user sees blog page {string}")
    public void assertThatUserSeesBlogPage(String url) {
        successStoriesPage.assertThatUserSeesBlogPage(url);
    }

        /*@When("the site is open click the button Выбрать тариф Базовый")
    public void theSiteIsOpenClickTheButtonВыбратьТарифБазовый() {
        qajaCoursePage.theSiteIsOpenClickTheButtonВыбратьТарифБазовый();
    }

    @Then("assert that user sees the form 1 {string}")
    public void assertThatUserSeesTheForm1(String basic) {
        qajaCoursePage.assertThatUserSeesTheForm1(basic);
    }

    @When("the site is open click the button Выбрать тариф Оптимальный")
    public void theSiteIsOpenClickTheButtonВыбратьТарифОптимальный() {
    }

    @Then("assert that user sees the form 2 {string}")
    public void assertThatUserSeesTheForm2(String consult) {
    }

    @When("the site is open click the button Выбрать тариф VIP")
    public void theSiteIsOpenClickTheButtonВыбратьТарифVIP() {
    }

    @Then("assert that user sees the form 3 {string}")
    public void assertThatUserSeesTheForm3(String full) {
    }*/
}