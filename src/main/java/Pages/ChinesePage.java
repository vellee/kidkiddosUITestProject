package Pages;

public class ChinesePage extends BasePage {
    public static final String LOGO_MANDARIN = "//h1[text() = 'Mandarin Chinese - 中文']";

    public boolean isPageTitleVisible() {
        return elementExistsByXpath(LOGO_MANDARIN);
    }

}
