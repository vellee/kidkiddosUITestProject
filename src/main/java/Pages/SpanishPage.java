package Pages;

public class SpanishPage extends BasePage {
    public static final String LOGO_SPANISH = "//h1[text()='Spanish - Español']";

    public boolean isPageTitleVisible() {
        return elementExistsByXpath(LOGO_SPANISH);
    }
}
