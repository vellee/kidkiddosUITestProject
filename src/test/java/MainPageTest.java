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
//import org.openqa.selenium.WebElement;

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

    // Test if button Account in upper right menu is visible
    @Test
    public void isAccountBTNVisible() {
        boolean success = mainPage.isAccountButtonVisible();
        assertTrue(success);
    }

    // Test if button Cart in upper right menu is visible
    @Test
    public void isCartBTNVisible() {
        boolean success = mainPage.isCartButtonVisible();
        assertTrue(success);
    }

    // Test if button Currency in upper right menu is visible
    @Test
    public void isCurrencyBTNVisible() {
        boolean success = mainPage.isCurrencyButtonVisible();
        assertTrue(success);
    }

    // Test if "Login Page" is loaded from upper right menu
    @Test
    public void openLoginPage() {
        logger.info("Login Page load Test");
        LoginPage loginPage = mainPage.openLoginPage();
        boolean isLoaded = loginPage.isPageTitleVisible();
        assertTrue(isLoaded);
        mainPage.takeScreenShot("LoginPageTest");
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

    // Test if "English" page is loaded from upper menu
    @Test
    public void openEnglishPageTest() {
        logger.info("English books page load test");
        EnglishPage englishPage = mainPage.openEnglishPage();
        boolean isLoaded = englishPage.isPageTitleVisible();
        assertTrue(isLoaded);
        mainPage.takeScreenShot("EnglishBooksPage");
    }

    // Test if 1 book in English language can be added to cart
    @Test
    public void addingEnglishBookTest() {
        logger.info("Add 1 English book to cart test");
        EnglishPage englishPage = mainPage.openEnglishPage();
        boolean isLoaded = englishPage.isPageTitleVisible();
        assertTrue(isLoaded);
        mainPage.takeScreenShot("EnglishBooksPage");
        englishPage.findAndAddFirstBookFound();
        assertEquals("1", mainPage.numberOfBooksInCart());
        logger.info("One English book added successfully");
    }

    // Test if 2 books in English language can be added to cart
    @Test
    public void addingTwoEnglishBooksTest() {
        logger.info("Add 2 English books to cart test");
        EnglishPage englishPage = mainPage.openEnglishPage();
        boolean isLoaded = englishPage.isPageTitleVisible();
        assertTrue(isLoaded);
        mainPage.takeScreenShot("EnglishBooksPage");
        englishPage.findAndAddFirstBookFound();
        mainPage.openEnglishPage();
        englishPage.findAndAddSecondBookFound();
        assertEquals("2", mainPage.numberOfBooksInCart());
        logger.info("Two English books added successfully");
    }

    // Test if 1 book in French language can be added to cart
    @Test
    public void addingOneFrenchBookTest() {
        logger.info("Add 1 French book to cart test");
        FrenchPage frenchPage = mainPage.openFrenchPage();
        assertTrue(frenchPage.isPageTitleVisible());
        frenchPage.findAndAddFirstBookFound();
        assertEquals("1", mainPage.numberOfBooksInCart());
        logger.info("One French book added successfully");
    }

    // Test if 2 books in French language can be added to cart
    @Test
    public void addingTwoFrenchBooksTest() {
        logger.info("Add 2 French book to cart test");
        FrenchPage frenchPage = mainPage.openFrenchPage();
        assertTrue(frenchPage.isPageTitleVisible());
        frenchPage.findAndAddFirstBookFound();
        mainPage.openFrenchPage();
        frenchPage.findAndAddSecondBookFound();
        assertEquals("2", mainPage.numberOfBooksInCart());
        logger.info("Two French books added successfully");
    }

    // Test if 4 books in different languages can be added to cart
    @Test
    public void addingFourDiffBooksTest() {
        logger.info("Adding 4 different books to cart test");
        FrenchPage frenchPage = mainPage.openFrenchPage();
        assertTrue(frenchPage.isPageTitleVisible());
        frenchPage.findAndAddFirstBookFound();
        mainPage.openFrenchPage();
        frenchPage.findAndAddSecondBookFound();

        EnglishPage englishPage = mainPage.openEnglishPage();
        assertTrue(englishPage.isPageTitleVisible());
        englishPage.findAndAddFirstBookFound();
        mainPage.openEnglishPage();
        englishPage.findAndAddSecondBookFound();

        assertEquals("4", mainPage.numberOfBooksInCart());
        logger.info("Four different books added successfully");
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

    @Test
    public void isCurrencyVisible() {
        boolean success = mainPage.isCurrencyButtonVisible();
        assertTrue(success);
    }

    @Test
    public void isUSDVisible() {
        boolean success = mainPage.isUSDVisible();
        assertTrue(success);
    }

    @ParameterizedTest
    @ValueSource(strings = {"EUR", "USD", "CAD", "EUR"})
    public void changeCurTo(String cur) {
        mainPage.changeTo(cur);
    }

}
