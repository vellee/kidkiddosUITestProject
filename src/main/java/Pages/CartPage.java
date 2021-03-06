package Pages;

import Consts.Consts;

public class CartPage extends BasePage {
    public static final String LOGO_CART = "//h1[text()='Your cart']";
    public static final String CONTINUE_SHOPPING_BUTTON = "//a[@class='btn btn--has-icon-after cart__continue-btn']";

    public boolean isPageTitleVisible() {
        return elementExistsByXpath(LOGO_CART);
    }

    public void navigateToCartPage() {
        webDriver.get(Consts.CART_URL);
    }

    public boolean findContShopBTN() {
        return elementExistsByXpath(CONTINUE_SHOPPING_BUTTON);

    }

}
