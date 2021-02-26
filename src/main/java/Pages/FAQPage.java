package Pages;

public class FAQPage extends BasePage {
    public static final String LOGO_FAQ = "//h1[text()='FAQ/addition info']";

    public boolean isPageTitleVisible() {
        return elementExistsByXpath(LOGO_FAQ);
    }
}
