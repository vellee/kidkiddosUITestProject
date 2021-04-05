package Pages;

import Consts.Consts;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private static final String LOGO_IMG = "//img[@itemprop='logo']";
    public static final String CONTACT_US = "//a[text()='Contact us']";
    public static final String HOME = "//a[text()='Home']";
    public static final String BOOKS_BY_LANG = "//*[@id='SiteNav']/li[2]/a";
    public static final String EBOOKS_BY_LANG = "//a[@aria-controls='SiteNavLabel-ebooks-by-language']";
    public static final String SPANISH = "//a[text()='Español']";
    public static final String FRENCH = "//a[text()='Français']";
    public static final String CHINESE = "//a[text()='中文']";
    public static final String ALL_LANG = "//*[@id='SiteNav']/li[7]/a";
    public static final String RESOURCES = "//a[text()='SiteNavLabel-resources']";
    public static final String FAQ = "//a[text()='FAQs']";
    public static final String BLOG = "//a[text()='Blog']";
    public static final String ALBANIAN = "//*[@id='SiteNavLabel-books-by-language']/ul/li[1]/a";
    public static final String eENGLISH = "//*[@id='SiteNavLabel-ebooks-by-language']/ul/li[5]/a";
    public static final String DUTCH = "//*[@id='SiteNavLabel-books-by-language']/ul/li[7]/a";
    public static final String ENGLISH = "//*[@id='SiteNavLabel-books-by-language']/ul/li[8]/a";
    public static final String HUNGARIAN = "//*[@id='SiteNavLabel-all-languages']/ul/li[15]/a";
    public static final String UKRAINIAN = "//*[@id='SiteNavLabel-all-languages']/ul/li[33]/a";
    public static final String VIETNAMESE = "//*[@id='SiteNavLabel-all-languages']/ul/li[35]/a";

    public static final String PROFILE = "//a[@class='site-header__account']";
    public static final String CART = "//a[@class='site-header__cart']";
    public static final String CART_NUMBER = "//div[@id='CartCount']";
    public static final String CURRENCY = "//span[@class='currency-converter-currency-button cbb-desktop-view skiptranslate notranslate']";
    public static final String USD = "/html/body/ul[2]/li[10]";
    public static final String EUR = "/html/body/ul[2]/li[5]";
    public static final String CAD = "/html/body/ul[2]/li[4]";
    //public int COUNTER;
    public String NUMBER_OF_BOOKS_IN_CART;

    public void navigateToMainPage() {
        webDriver.get(Consts.MAIN_URL);
    }

    public boolean isAccountButtonVisible() {
        boolean isVisible = elementExistsByXpath(PROFILE);
        return isVisible;
    }

    public boolean isCartButtonVisible() {
        boolean isVisible = elementExistsByXpath(CART);
        return isVisible;
    }

    public boolean isCurrencyButtonVisible() {
        boolean isVisible = elementExistsByXpath(CURRENCY);
        return isVisible;
    }

    public boolean isUSDVisible() {
        clickElementByXpath(CURRENCY);
        return elementExistsByXpath(USD);
    }

    public void changeTo(String currency) {
        switch (currency) {
            case "USD":
                clickElementByXpath(CURRENCY);
                clickElementByXpath(USD);
                break;
            case "CAD":
                clickElementByXpath(CURRENCY);
                clickElementByXpath(CAD);
                break;
            case "EUR":
                clickElementByXpath(CURRENCY);
                clickElementByXpath(EUR);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currency);

        }
    }

    public boolean isLogoVisible() {
        boolean isVisible = elementExistsByXpath(LOGO_IMG);
        return isVisible;
    }

    public LoginPage openLoginPage() {
        clickElementByXpath(PROFILE);
        return new LoginPage();
    }

    public ContactUsPage openContactUsPage() {
        clickElementByXpath(CONTACT_US);
        return new ContactUsPage();
    }

    public HomePage openHomePage() {
        clickElementByXpath(HOME);
        return new HomePage();
    }

    public SpanishPage openSpanishPage() {
        clickElementByXpath(SPANISH);
        return new SpanishPage();
    }

    public FrenchPage openFrenchPage() {
        clickElementByXpath(FRENCH);
        return new FrenchPage();
    }

    public EnglishPage openEnglishPage() {
        clickElementByXpath(BOOKS_BY_LANG);
        clickElementByXpath(ENGLISH);
        return new EnglishPage();
    }

    public ChinesePage openChinesePage() {
        clickElementByXpath(CHINESE);
        return new ChinesePage();
    }

    public FAQPage openFAQPage() {
        clickElementByXpath(FAQ);
        return new FAQPage();
    }

    public CartPage openCartPage() {
        clickElementByXpath(CART);
        return new CartPage();
    }

    public boolean isDDBBooksByLanguageVisible() {
        return elementExistsByXpath(BOOKS_BY_LANG);
    }

    public boolean isDDBEBooksByLanguageVisible() {
        return elementExistsByXpath(EBOOKS_BY_LANG);
    }

    public boolean isDDBAllLanguagesVisible() {
        return elementExistsByXpath(ALL_LANG);
    }

    public String inputDDBBooksByLang(String name) {
        clickElementByXpath(BOOKS_BY_LANG);
        String language;
        switch (name) {
            case "Albanian - Shqip":
                clickElementByXpath(ALBANIAN);
                language = name;
                break;
            case "Dutch - Nederlands":
                clickElementByXpath(DUTCH);
                language = name;
                break;
            case "English Only":
                clickElementByXpath(ENGLISH);
                language = name;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
        return language;
    }

    public String inputDDBEBooksByLang(String eName) {
        clickElementByXpath(EBOOKS_BY_LANG);
        String language;
        switch (eName) {
            case "English Only":
                clickElementByXpath(eENGLISH);
                language = eName;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + eName);
        }
        return language;
    }

    public String inputDDBAllLanguages(String name) {
        clickElementByXpath(ALL_LANG);
        String languageSelected;
        switch ((name)) {

            case "Hungarian - Magyar":
                clickElementByXpath(HUNGARIAN);
                languageSelected = name;
                break;
            case "Ukrainian - Українська":
                clickElementByXpath(UKRAINIAN);
                languageSelected = name;
                break;
            case "Vietnamese - Tiếng Việt":
                clickElementByXpath(VIETNAMESE);
                languageSelected = name;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + (name));
        }
        return languageSelected;
    }

    // Reads total number of books in current cart

    public String numberOfBooksInCart() {

        NUMBER_OF_BOOKS_IN_CART = readValueOfCart(CART_NUMBER);
        return NUMBER_OF_BOOKS_IN_CART;

    }

    public void clearCart() {
        CartPage cartPage = new CartPage();

        int COUNTER = Integer.parseInt(readValueOfCart(CART_NUMBER));
        while (COUNTER != 0) {
            cartPage.removeItemFromCart();
            COUNTER--;
        }
    }

}