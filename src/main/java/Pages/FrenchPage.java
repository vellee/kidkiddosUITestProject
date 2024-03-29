package Pages;

public class FrenchPage extends BasePage {
    public static final String LOGO_FRENCH = "//h1[text()='French - Français']";
    public static final String BOOK_1 = "//a[@href='/collections/french/products/goodnight-my-love-french-childrens-picture-book']";
    public static final String BOOK_2 = "//a[@href='/collections/french/products/i-love-my-dad-french-language-childrens-book']";
    public static final String ADD_TO_CART_BUTTON = "//button[@id='AddToCart-product-template']";

    // Returns TRUE when page is loaded and Logo is visible
    public boolean isPageTitleVisible() {
        return elementExistsByXpath(LOGO_FRENCH);
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
