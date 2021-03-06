import Pages.CartPage;
import Pages.CreateAccountPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPageTest extends UseCaseBase {

    public static CartPage cartPage;
    public static final Logger logger = LogManager.getLogger(CartPageTest.class);

    // Steps performed only once before all tests run
    @BeforeAll
    public static void classSetup() {

        cartPage = new CartPage();
    }

    // Steps performed before each test runs
    @BeforeEach
    public void beforeTest() {
        cartPage.navigateToCartPage();

    }

    // Test if Cart Page is loaded
    @Test
    public void cartPageLoadTest() {
        logger.info("Cart Page load test");
        boolean success = cartPage.isPageTitleVisible();
        cartPage.takeScreenShot("CartPageTest");
        assertTrue(success);
    }

    // Test if Continue Shopping Button is visible
    @Test
    public void isContShopBTNVisible() {
        boolean success = cartPage.findContShopBTN();
        assertTrue(success);
    }



}

