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

    /*String parentHandle = webDriver.getWindowHandle();
        for (String handle: webDriver.getWindowHandles()) {
            if (!parentHandle.equals(handle))
                webDriver.switchTo().window(handle);
                String currentUrl = webDriver.getCurrentUrl();
                System.out.println("URL of child window is " + currentUrl);
        }*/
//        webDriver.switchTo().(WindowType.TAB);
//        webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
//        System.out.println(webDriver.getTitle());
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

//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        TimeUnit.SECONDS.sleep(10);;
        /*WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("#recaptcha-anchor")));*/
        //new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        //new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
//        String.valueOf(webDriver.findElements(By.tagName("iframe")).size());
        //public void clickAt($locator, "10,20")
       /* Point loc = MouseInfo.getPointerInfo().getLocation();
        double x = loc.getX();
        double y = loc.getY();
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        String text = String.valueOf(webDriver.findElements(By.tagName("iframe")).size());
        System.out.println("Number of iframes is " + text);
        List<WebElement> iframes = webDriver.findElements(By.tagName("iframe"));
        System.out.println("List of iframes" + iframes);
    }*/
//        webDriver.findElement(By.xpath("/html/body/script[3]")).click();
        /*String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
                String text = webDriver.getCurrentUrl();
                System.out.println("Heading of child window is " + text);
            }
//        webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
    }*/
    /*@Then("assert that user sees {string}")
    public void assert_that_user_sees(String checkTheBoxHuman) {
        final String actualString = webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td/div[1]")).getText();
        assertEquals(checkTheBoxHuman, actualString);
    }*/
    @Then("assert that user got {string}")
    public void assert_that_user_got(String detailedCourseProgram) {
//        final String actualString = webDriver.findElement(By.cssSelector("#rec600706268 > div > div > div.t396__elem.tn-elem.tn-elem__6007062681677770138193 > div")).getText();
//        assertEquals(detailedCourseProgram, actualString);
        programPage.assertThatUserGotDetailedProgram(detailedCourseProgram);
        webDriver.close();
    }

    @Given("url of QAJA course page: {string}")
    public void urlOfQAJACoursePageHttpsSkillfactoryRuJavaQaEngineerTestirovshikPo(String url) {
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

    @Then("assert that user got page {string}")
    public void assertThatUserGotPage(String url) {
        qajaCoursePage.assertUrlEqualsExpected(url);
    }

    @Then("close the application form")
    public void closeTheApplicationForm() {
        qajaCoursePage.closeApplicationForm();
    }

    @Then("assert that the phone number is correct")
    public void assertThatThePhoneNumberIsCorrect() {
        qajaCoursePage.assertThatThePhoneNumberIsCorrect();
    }

    @Then("click the button Получить программу")
    public void click_the_button_получить_программу() {
        qajaCoursePage.clickGetProgram();
       /* String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
                String text = webDriver.getCurrentUrl();
                System.out.println("URL of child window is " + text);
            }
        }*/
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

    /*@And("enter promo code")
    public void enterPromoCode(String promoCode) {
        qajaCoursePage.enterPromoCode(promoCode);
    }

    @Then("assert that user sees {string}")
    public void assertThatUserSees(String arg0) {
    }*/

    @And("enter promo code {string}")
    public void enterPromoCodeTest(String promoCode) {
        qajaCoursePage.enterPromoCode(promoCode);
    }

    @When("the site is open select kyrgyz phone code")
    public void SelectKyrgyzPhoneCode() {
        qajaCoursePage.selectAnotherPhoneCode();
    }

    @Then("assert that this phone number is correct")
    public void assertThatThisPhoneNumberIsCorrect() {
        qajaCoursePage.assertThatThisPhoneNumberIsCorrect();
    }

    @When("the site is open click the button Получить программу")
    public void ClickTheButtonПолучитьПрограмму() {
        qajaCoursePage.ClickTheButtonПолучитьПрограмму();
    }

    @Then("assert that user sees notification")
    public void assertThatUserSeesNotification(String notification) {
        qajaCoursePage.assertThatUserSeesNotification(notification);
    }

    @Then("assert that user sees set name notification {string}")
    public void assertThatUserSeesSetNameNotification(String notification) {
        qajaCoursePage.assertUserSeesSetNameNotification(notification);
    }

    @When("the site is open enter email {string}")
    public void theSiteIsOpenEnterEmailTestGmailCom() {
        qajaCoursePage
    }

    @Then("assert that user sees incorrect email notification {string}")
    public void assertThatUserSeesIncorrectEmailNotification(String incorrectEmailNotification) {
        qajaCoursePage.assertUserSeesIncorrectEmailNotification(incorrectEmailNotification)
    }

    @Then("assert that user sees incorrect phone number notification {string}")
    public void assertThatUserSeesIncorrectPhoneNumberNotification(String arg0) {
    }

    @Then("assert that user sees too short phone number notification {string}")
    public void assertThatUserSeesTooShortPhoneNumberNotification(String arg0) {
    }

    @Then("assert that length of this phone number is correct")
    public void assertThatLengthOfThisPhoneNumberIsCorrect() {
    }

    @When("the site is open untick the agreement box")
    public void theSiteIsOpenUntickTheAgreementBox() {
    }

    @Then("assert that user sees error notification")
    public void assertThatUserSeesErrorNotification() {
    }

    @Then("click the button Выбрать тариф Базовый")
    public void clickTheButtonВыбратьТарифБазовый() {
    }

    @Then("assert that user sees page1 {string}")
    public void assertThatUserSeesPage1(String url) {
    }

    @When("the site is open click the button Выбрать тариф Оптимальный")
    public void theSiteIsOpenClickTheButtonВыбратьТарифОптимальный() {
    }

    @Then("assert that user sees page2 {string}")
    public void assertThatUserSeesPage2(String url) {
    }

    @When("the site is open click the button Выбрать тариф VIP")
    public void theSiteIsOpenClickTheButtonВыбратьТарифVIP() {
    }

    @Then("assert that user sees page3 {string}")
    public void assertThatUserSeesPage3(String url) {
    }

    @When("the site is open enter phone number {string}")
    public void theSiteIsOpenEnterPhoneNumber(String number) {
        qajaCoursePage.enterPhoneNumber(number);
    }














        /*String parentHandle = webDriver.getWindowHandle();
        for (String nowHandle: webDriver.getWindowHandles()) {
            if (!parentHandle.equals(nowHandle))
                webDriver.switchTo().window(nowHandle);*//*
            *//*webDriver.switchTo().frame("popupFrame")*//*
        *//*webDriver.switchTo().frame("buttonframe");
        final String actualString = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td > div:nth-child(1)")).getText();
        assertEquals (detailedCourseProgram, actualString);*//*
//            webDriver.findElement(By.id("recaptchabox"));
        *//*new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();*//*
    }*/


    /*@Given("url of Russian Railways: {string}")
    public void url_of_russian_railways(String url)  {
        homePage.go(url);
    }

    @When("the site is open enter city name {string} into the field From")
    public void the_site_is_open_enter_city_name_into_the_field_from(String cityFrom) {
        homePage.enterCityFrom(cityFrom);
    }

    @Then("enter city name {string} into the field To")
    public void enter_city_name_into_the_field_to(String cityTo) {
        homePage.enterCityTo(cityTo);
    }

    @Then("enter date {string} into the field Depart")
    public void enter_date_into_the_field_depart(String depart) {
        homePage.enterDate(depart);
    }

    @And("click the button Search")
    public void click_the_button_search() {
        homePage.search();
    }

    @Then("assert that there is a list of results")
    public void assert_that_there_is_a_list_of_results() {
        resultsPage.assertThatThereIsAListOfResults();
    }


    @When("the site is open click the button Search")
    public void the_site_is_open_click_the_button_search() {
        homePage.search();
    }

    @Then("assert that user got the message {string}")
    public void assert_that_user_got_the_message(String errorMessage) {
        homePage.assertThatUserGotTheMessage(errorMessage);
    }*/
}