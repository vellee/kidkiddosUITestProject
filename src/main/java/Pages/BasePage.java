package Pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasePage {

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;
    public static final Logger logger = LogManager.getLogger(BasePage.class);

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);

    }

    public WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    protected void clickElementByXpath(String xpath) {
        logger.info("Clicking element with xpath: " + xpath);
        findElementByXpath(xpath).click();

    }

    protected void sendTextToElementByXpath(String xpath, String text) {
        findElementByXpath(xpath).sendKeys(text);

    }

    protected boolean elementExistsByXpath(String xpath) {
        try {
            logger.info("Check element with xpath exists: " + xpath);
            //findElementByXpath(xpath);
            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    protected String getCurrentPageURL() {
        return webDriver.getCurrentUrl();
    }

    public void takeScreenShot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String readValueOfElement(String xpath) {
        WebElement webElement = webDriver.findElement(By.xpath(xpath));
        return webElement.getAttribute("value");

    }
}
