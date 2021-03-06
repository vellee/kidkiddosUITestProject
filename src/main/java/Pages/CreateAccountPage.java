package Pages;

import Consts.Consts;

public class CreateAccountPage extends BasePage {
    public static final String LOGO_CREATE_ACCOUNT = "//h1[text()='Create Account']";
    public static final String FIRST_NAME_BOX = "//input[@id='FirstName']";
    public static final String LAST_NAME_BOX = "//input[@id='LastName']";
    public static final String EMAIL = "//input[@id='Email']";
    public static final String PASSWORD = "//input[@id='CreatePassword']";
    public static final String CREATE_BUTTON = "//input[@class='btn' and @value='Create']";


    public boolean isPageTitleVisible() {
        return elementExistsByXpath(LOGO_CREATE_ACCOUNT);
    }

    public void navigateToCreateAccountPage() {
        webDriver.get(Consts.CREATE_ACCOUNT_URL);
    }

    public boolean findFirstNameBox() {
        return elementExistsByXpath(FIRST_NAME_BOX);
    }

    public boolean findLastNameBox() {
        return elementExistsByXpath(LAST_NAME_BOX);
    }

    public boolean findEmailBox() {
        return elementExistsByXpath(EMAIL);
    }

    public boolean findPasswordBox() {
        return elementExistsByXpath(PASSWORD);
    }

    public boolean findCreateButton() {
        return elementExistsByXpath(CREATE_BUTTON);
    }

    public String enterFirstName(String firstName) {
        sendTextToElementByXpath(FIRST_NAME_BOX, firstName);

        return readValueOfElement(FIRST_NAME_BOX);
    }

    public String enterLastName(String lastName) {
        sendTextToElementByXpath(LAST_NAME_BOX, lastName);
        return readValueOfElement(LAST_NAME_BOX);
    }

    public String enterEmail(String email) {
        sendTextToElementByXpath(EMAIL, email);
        return readValueOfElement(EMAIL);
    }

    public String enterPassword(String pass) {
        sendTextToElementByXpath(PASSWORD, pass);
        return readValueOfElement(PASSWORD);
    }

    public String getCurPageURL() {
        return getCurrentPageURL();
    }

    public void clickCreateAccountButton() {
        clickElementByXpath(CREATE_BUTTON);
    }
}
