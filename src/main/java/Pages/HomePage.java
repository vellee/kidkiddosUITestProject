package Pages;

public class HomePage extends BasePage {
    public static final String HOME = "//a[text()='Home']";
    public static final String BTN_CHOOSE_LANG = "//*[@id='shopify-section-hero']/div/div/div/a";

    public boolean isBTNVisible() {
        return elementExistsByXpath(BTN_CHOOSE_LANG);
    }


}
