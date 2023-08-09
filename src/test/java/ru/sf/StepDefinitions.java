package ru.sf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class StepDefinitions {
    static final WebDriver webDriver;

    public static final HomePage homePage;
    public static final TestingCoursesPage testingCoursesPage;
    public static final QajaCoursePage qajaCoursePage;
    public static final ProgramPage programPage;
    public static final PreferentialMortgagePage preferentialMortgagePage;
    public static final DefermentOfConscriptionPage defermentOfConscriptionPage;
    public static final DefermentOfMilitaryServiceDuringMobilisationPage defermentOfMilitaryServiceDuringMobilisationPage;
    public static final PersonalDataProtectionRegulationPage personalDataProtectionRegulationPage;
    public static final ShopilandPage shopilandPage;
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
        personalDataProtectionRegulationPage = new PersonalDataProtectionRegulationPage(webDriver);
        shopilandPage = new ShopilandPage(webDriver);
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
    @Then("assert that user got QAJA course page")
    public void assertThatUserGotQAJACoursePage() {
        qajaCoursePage.assertThatUserGotQAJACoursePage();
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
        final String actualURL = webDriver.getCurrentUrl();
        if (url.equals(actualURL)) {
            programPage.assertUrlEqualsExpected(url);
        }
//        Если выскакивает капча "Please check the box to let us know you're human"
        else {
            qajaCoursePage.assertUrlEqualsExpected(url);
        }
    }

    @Then("click the personal data protection regulation link")
    public void clickThePersonalDataProtectionRegulationLink() {
        qajaCoursePage.clickTheRegulationLink();
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

    @When("the site is open click the link Ипотека со ставкой 5%")
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

    @When("the site is open click the link Shopiland")
    public void clickTheLinkShopiland() {
        qajaCoursePage.clickTheLinkShopiland();
    }

    @Then("assert that user gets page {string}")
    public void assertThatUserGetsPage(String url) {
        shopilandPage.assertThatUserGetsPage(url);
    }

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

    @When("the site is open click the personal data protection regulation link")
    public void theSiteIsOpenClickThePersonalDataProtectionRegulationLink() {
        qajaCoursePage.clickTheLinkОбработкуПерсональныхДанных();
    }

    @Then("assert that user goes to the regulation page {string}")
    public void assertThatUserGoesToTheRegulationPage(String url) {
        personalDataProtectionRegulationPage.assertUrlEqualsExpected(url);
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
}