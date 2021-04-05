package Pages;

public class EnglishPage extends BasePage {
    public static final String LOGO_ENGLISH = "//h1[text()='English Only']";
    public static final String BOOK_1 = "//a[@href='/collections/english-only/products/i-love-to-eat-fruits-and-vegetables-childrens-book-english-only']";
    public static final String BOOK_2 = "//a[@href='/collections/english-only/products/amandas-dream-childrens-picture-book-english-only']";
    public static final String ADD_TO_CART_BUTTON = "//button[@id='AddToCart-product-template']";

    // Returns TRUE when page is loaded and Logo is visible
    public boolean isPageTitleVisible() {
        return elementExistsByXpath(LOGO_ENGLISH);
    }

    // Finds and adds to CART one book
    public void findAndAddFirstBookFound() {
        clickElementByXpath(BOOK_1);
        clickElementByXpath(ADD_TO_CART_BUTTON);
    }

    // Finds and adds to CART second book
    public void findAndAddSecondBookFound() {
        clickElementByXpath(BOOK_2);
        clickElementByXpath(ADD_TO_CART_BUTTON);
    }
}
