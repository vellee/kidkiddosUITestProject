import Pages.ContactUsPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsPageTest extends UseCaseBase {
    private static ContactUsPage contactUsPage;
    public static final Logger logger = LogManager.getLogger(ContactUsPageTest.class);

    // Steps performed only once before all tests run
    @BeforeAll
    public static void classSetup() {

        contactUsPage = new ContactUsPage();
    }

    // Steps performed before each test runs
    @BeforeEach
    public void beforeTest() {
        contactUsPage.navigateToContactUsPage();
    }

    // Test if Contact Us page is opened
    @Test
    public void contactPageLoadTest() {
        logger.info("Contact Us page load test");
        boolean success = contactUsPage.isPageTitleVisible();
        contactUsPage.takeScreenShot("ContactUsPageTest");
        assertTrue(success);
    }

    // Test that button "Send Message" is loaded
    @Test
    public void isButtonSendMsgLoaded() {
        assertTrue(contactUsPage.isBtnSendVisible());
    }

    // Test that input box for Name is loaded
    @Test
    public void isInputNameBoxLoaded() {
        assertTrue(contactUsPage.findInputNameBox());
    }

    // Test that input box for Email address is loaded
    @Test
    public void isEmailBoxLoaded() {
        assertTrue(contactUsPage.findEmailBox());
    }

    //Test that input box for Text Message is loaded
    @Test
    public void isTextMsgBoxLoaded() {
        assertTrue(contactUsPage.findTextMsgBox());
    }

    // Test for error messages, if button clicked with empty input
    @Test
    public void isErrorMsgVisible() {
        contactUsPage.clickButtonSendMessage();
        assertTrue(contactUsPage.findErrorMsg());
        contactUsPage.takeScreenShot("ErrorMsg");
    }

    // Test for valid email inputs
    @ParameterizedTest
    @ValueSource(strings = {"mike@yahoo.com", "hello@world.net", "serge@ukr.net"})
    public void isEmailValid(String email) {
        contactUsPage.sendEmptyBoxes();
        assertTrue(contactUsPage.checkEmail(email));
        contactUsPage.takeScreenShot("ValidEmail");

    }

    // Test for invalid email inputs
    @ParameterizedTest
    @ValueSource(strings = {"mike", "halo289@", "barking.gel_"})
    public void isEmailInvalid(String email) {
        contactUsPage.sendEmptyBoxes();
        assertFalse(contactUsPage.checkEmail(email));
        contactUsPage.takeScreenShot("InvalidEmail");
    }

}
