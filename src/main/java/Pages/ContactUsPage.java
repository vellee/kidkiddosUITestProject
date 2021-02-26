package Pages;

import Consts.Consts;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends BasePage {
    public static final String LOGO_CONTACT_US = "//h1[text() = 'Contact us']";
    public static final String BTN_SEND_MSG = "//button[@id='_form_44_submit' and text() = ' Send your message ']";
    public static final String NAME_INPUT_BOX = "//input[@type='text' and @name='field[3]']";
    public static final String EMAIL_INPUT_BOX = "//input[@type='text' and @name='email']";
    public static final String TEXT_MSG_BOX = "//textarea[@name = 'field[7]']";
    public static final String ERROR_MSG = "//div[text()='This field is required.']";
    public static final String INVALID_EMAIL_MSG = "//div[text()='Enter a valid email address.']";


    public boolean isPageTitleVisible() {
        return elementExistsByXpath(LOGO_CONTACT_US);

    }

    public boolean isBtnSendVisible() {
        return elementExistsByXpath(BTN_SEND_MSG);
    }

    // Browser opens "Contact Us" page
    public void navigateToContactUsPage() {
        webDriver.get(Consts.CONTACT_US_URL);

    }

    public void clickButtonSendMessage() {
        clickElementByXpath(BTN_SEND_MSG);
    }

    public boolean findInputNameBox() {
        return elementExistsByXpath(NAME_INPUT_BOX);
    }

    public boolean findEmailBox() {
        return elementExistsByXpath(EMAIL_INPUT_BOX);
    }

    public boolean findTextMsgBox() {
        return elementExistsByXpath((TEXT_MSG_BOX));
    }

    public void sendEmptyBoxes() {
        clickElementByXpath(BTN_SEND_MSG);
    }

    public boolean findErrorMsg() {
        return elementExistsByXpath(ERROR_MSG);
    }

    public boolean checkEmail(String email) {
        sendTextToElementByXpath(EMAIL_INPUT_BOX, email);
        boolean result;
        if (elementExistsByXpath(INVALID_EMAIL_MSG)) {
            return false;
        } else {
            return true;
        }

    }
}
