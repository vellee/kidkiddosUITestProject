import Pages.LoginPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest extends UseCaseBase {

    private static LoginPage loginPage;
    public static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    // Steps performed only once before all tests run
    @BeforeAll
    public static void classSetup() {

        loginPage = new LoginPage();
    }

    // Steps performed before each test runs
    @BeforeEach
    public void beforeTest() {
        loginPage.navigateToLoginPage();
    }

    @Test
    public void isEmailBoxLoaded() {
        assertTrue(loginPage.findEmailInput());
    }

    @Test
    public void isPasswordBoxLoaded() {
        assertTrue(loginPage.findPasswordInput());
    }

    @Test
    public void isSignInBTNLoaded() {
        assertTrue(loginPage.findSignInButton());
    }

    @Test
    public void isCreateAccountLinkLoaded() {
        assertTrue(loginPage.findCreateAccountLink());
    }

    @Test
    public void checkEmptyInputErrorMSG() {
        loginPage.sendEmptyInput();
        assertTrue(loginPage.findEmptyInputErrorMSG());
    }
}
