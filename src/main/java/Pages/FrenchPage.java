package Pages;

public class FrenchPage extends BasePage {
    public static final String LOGO_FRENCH = "//h1[text()='French - Français']";

    public boolean isPageTitleVisible() {
        return elementExistsByXpath(LOGO_FRENCH);
    }
}
