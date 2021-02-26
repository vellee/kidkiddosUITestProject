import Consts.Consts;
import Pages.*;
import Utils.UseCaseBase;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends UseCaseBase {
    private static MainPage mainPage;
    public static final Logger logger = LogManager.getLogger(MainPageTest.class);

    // Steps performed only once before all tests run
    @BeforeAll
    public static void classSetup() {

        mainPage = new MainPage();
    }

    // Steps performed before each test runs
    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
    }

    // Test if main page is opened
    @Test
    public void mainPageLoadTest() {
        logger.info("Main page load test");
        boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenShot("MainPageTest");
        assertTrue(success);
    }

    // Test if "Contact Us" page is loaded from upper menu
    @Test
    public void openContactUsPageTest() {
        logger.info("Contact Us Page load test");
        ContactUsPage contactUsPage = mainPage.openContactUsPage();
        boolean isLoaded = contactUsPage.isPageTitleVisible();
        assertTrue(isLoaded);
        mainPage.takeScreenShot("ContactUsPageTest");
    }

    // Test if "Spanish" page is loaded from upper menu
    @Test
    public void openSpanishPageTest() {
        logger.info("Spanish books page load test");
        SpanishPage spanishPage = mainPage.openSpanishPage();
        boolean isLoaded = spanishPage.isPageTitleVisible();
        assertTrue(isLoaded);
        mainPage.takeScreenShot("SpanishBooksPage");
    }

    // Test if "French" page is loaded from upper menu
    @Test
    public void openFrenchPageTest() {
        logger.info("French books page load test");
        FrenchPage frenchPage = mainPage.openFrenchPage();
        boolean isLoaded = frenchPage.isPageTitleVisible();
        assertTrue(isLoaded);
        mainPage.takeScreenShot("FrenchBooksPage");
    }

    // Test if "Chinese" page is loaded from upper menu
    @Test
    public void openChinesePageTest() {
        logger.info("Chinese books page load test");
        ChinesePage chinesePage = mainPage.openChinesePage();
        boolean isLoaded = chinesePage.isPageTitleVisible();
        assertTrue(isLoaded);
        mainPage.takeScreenShot("ChineseBooksPage");
    }

    // Test if "Home" page is loaded from upper menu, actually "Home" page is same as "Main"
    @Test
    public void openHomePageTest() {
        logger.info("Home page load test");
        boolean success = mainPage.isLogoVisible();
        assertTrue(success);
        HomePage homePage = mainPage.openHomePage();
        boolean isLoaded = homePage.isBTNVisible();
        assertTrue(isLoaded);
        mainPage.takeScreenShot("HomePage");
    }

    // Test if DropDownBox "Books by Language is visible in upper menu
    @Test
    public void isVisibleDDBBooksByLanguage() {
        boolean success = mainPage.isDDBBooksByLanguageVisible();
        assertTrue(success);
    }

    // Tests some correct values that can be chosen from drop-down list "Books by Language" in upper menu
    @ParameterizedTest
    @EnumSource(Consts.LANGUAGES.class)
    public void inputTestDDBBooksByLang(Consts.LANGUAGES lang) {
        boolean success = mainPage.isDDBBooksByLanguageVisible();
        assertTrue(success);
        String selectedLang = mainPage.inputDDBBooksByLang(lang.getName());
        assertEquals(lang.getName(), selectedLang);
        logger.info(lang + " language selected from drop-down menu \"Books by languages\"");
    }

    // Tests some correct values that can be chosen from drop-down list "eBooks by Language" in upper menu
    @ParameterizedTest
    @ValueSource(strings = {"English Only"})
    public void inputTestDDBEBooksByLang(String lang) {
        boolean success = mainPage.isDDBEBooksByLanguageVisible();
        assertTrue(success);
        String selectedLang = mainPage.inputDDBEBooksByLang(lang);
        assertEquals(lang, selectedLang);
        logger.info(lang + " language selected from drop-down menu \"eBooks by languages\"");
    }

    @Test
    public void isVisibleDDBAllLanguages() {
        boolean success = mainPage.isDDBAllLanguagesVisible();
        assertTrue(success);
    }

    @ParameterizedTest
    @EnumSource(Consts.ALL_LANGUAGES.class)
    public void inputTestDDBAllLanguages(Consts.ALL_LANGUAGES lang) {
        boolean success = mainPage.isDDBAllLanguagesVisible();
        assertTrue(success);
        String selectedLanguage = mainPage.inputDDBAllLanguages((lang.getName()));
        assertEquals(lang.getName(), selectedLanguage);
        logger.info(lang + " language selected from drop-down menu \"All languages\"");
    }

    @Test
    public void openFAQPageTest() {
        logger.info("FAQ page load test");
        FAQPage faqPage = mainPage.openFAQPage();
        boolean isLoaded = faqPage.isPageTitleVisible();
        assertTrue(isLoaded);
        mainPage.takeScreenShot("FAQPage");
    }

}
