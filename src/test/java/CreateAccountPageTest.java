import Pages.CreateAccountPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAccountPageTest extends UseCaseBase {

    private static CreateAccountPage createAccountPage;
    public static final Logger logger = LogManager.getLogger(CreateAccountPageTest.class);

    // Steps performed only once before all tests run
    @BeforeAll
    public static void classSetup() {

        createAccountPage = new CreateAccountPage();
    }

    // Steps performed before each test runs
    @BeforeEach
    public void beforeTest() {
        createAccountPage.navigateToCreateAccountPage();

    }

    // Test if Create Account Page is loaded
    @Test
    public void createAccountPageLoadTest() {
        logger.info("Create Account Page load test");
        boolean success = createAccountPage.isPageTitleVisible();
        createAccountPage.takeScreenShot("CreateAccountPageTest");
        assertTrue(success);
    }

    // Tests visibility of First Name Box
    @Test
    public void isFirstNameBoxVisible() {
        boolean success = createAccountPage.findFirstNameBox();
        assertTrue(success);
    }

    // Tests visibility of Last Name Box
    @Test
    public void isLastNameBoxVisible() {
        boolean success = createAccountPage.findLastNameBox();
        assertTrue(success);
    }

    // Tests visibility of Email Box
    @Test
    public void isEmailBoxVisible() {
        boolean success = createAccountPage.findEmailBox();
        assertTrue(success);
    }

    // Tests visibility of Password Box
    @Test
    public void isPasswordBoxVisible() {
        boolean success = createAccountPage.findPasswordBox();
        assertTrue(success);
    }

    // Tests visibility of Create Account Button
    @Test
    public void isCreateButtonAccessible() {
        boolean success = createAccountPage.findCreateButton();
        assertTrue(success);
    }

    // Test for input to First Name Box, can accept any letter,number,symbol
    @ParameterizedTest
    @ValueSource(strings = {"Mike", "Boris78", "Ben!_0"})
    public void firstNameInputTest(String name) {
        String readName = createAccountPage.enterFirstName(name);
        assertEquals(name, readName);
    }

    // Test for input to Last Name Box, can accept any letter,number,symbol
    @ParameterizedTest
    @ValueSource(strings = {"Philips", "00Jacobson", "Gur_rQ8"})
    public void lastNameInputTest(String name) {
        String readName = createAccountPage.enterLastName(name);
        assertEquals(name, readName);
    }

    // Test for valid input of email address to Email Box
    @ParameterizedTest
    @ValueSource(strings = {"john@doe.net", "sara.connor@terminator.net"})
    public void emailInputTest(String email) {
        String readEmail = createAccountPage.enterEmail(email);
        assertEquals(email, readEmail);
    }

    // Test for input to Password Box, can accept any letter, number, symbol
    @ParameterizedTest
    @ValueSource(strings = {"qwerty", "12345"})
    public void passwordInputTest(String pass) {
        String readPass = createAccountPage.enterPassword(pass);
        assertEquals(pass, readPass);
    }

    // Test for invalid input to Email input box
    @ParameterizedTest
    @ValueSource(strings = {"X", "test@","net@net","load.net"})
    public void invalidEmailInputTest(String invalidEmail) {
        String readEmail = createAccountPage.enterEmail(invalidEmail);
        assertEquals(invalidEmail, readEmail);
        String curURL_before = createAccountPage.getCurPageURL();
        String curURL_after;
        createAccountPage.clickCreateAccountButton();
        curURL_after = createAccountPage.getCurPageURL();
        assertEquals(curURL_before, curURL_after);
    }


}
