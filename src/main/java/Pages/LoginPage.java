package Pages;

import Consts.Consts;

public class LoginPage extends BasePage {
    public static final String LOGO_LOGIN = "//h1[text()='Login']";
    public static final String EMAIL = "//input[@id='CustomerEmail']";
    public static final String PASSWORD = "//input[@id='CustomerPassword']";
    public static final String SIGN_IN_BTN = "//input[@class='btn' and @value ='Sign In']";
    public static final String CREATE_ACCOUNT = "//a[@id='customer_register_link']";
    public static final String ERROR = "//li[text()='Incorrect email or password.']";

    public boolean isPageTitleVisible() {
        return elementExistsByXpath(LOGO_LOGIN);
    }

    public void navigateToLoginPage() {
        webDriver.get(Consts.LOGIN_URL);

    }

    public boolean findEmailInput() {
        return elementExistsByXpath(EMAIL);
    }

    public boolean findPasswordInput() {
        return elementExistsByXpath(PASSWORD);
    }

    public boolean findSignInButton() {
        return elementExistsByXpath(SIGN_IN_BTN);
    }

    public boolean findCreateAccountLink() {
        return elementExistsByXpath(CREATE_ACCOUNT);
    }

    public void sendEmptyInput() {
        clickElementByXpath(SIGN_IN_BTN);
    }

    public boolean findEmptyInputErrorMSG() {
        return elementExistsByXpath(ERROR);
    }

    public CreateAccountPage openCreateAccountPage() {
        clickElementByXpath(CREATE_ACCOUNT);
        return new CreateAccountPage();
    }


}

