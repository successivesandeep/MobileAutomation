package mobile.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageHandler extends MobileConfiguration {
    private static WebDriverWait wait;
    private static final int DEFAULT_TIME_OUT = 60;
    private static AppiumDriver<MobileElement> driver = getAppiumDriver();

    protected static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    private static void waitForVisible(WebElement webElement, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    private static void waitForVisible(By locator, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private static void waitForClickable(WebElement webElement, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private static void waitForClickable(By locator, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected static void textIsPresent(WebElement webElement, String text, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    protected static void textIsPresent(By locator, String text, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    protected static void clickOnElement(By locator) {
        waitForVisible(locator, DEFAULT_TIME_OUT);
        waitForClickable(locator, DEFAULT_TIME_OUT);
        getDriver().findElement(locator).click();
    }

    protected static void clickOnElement(WebElement webElement) {
        waitForVisible(webElement, DEFAULT_TIME_OUT);
        waitForClickable(webElement, DEFAULT_TIME_OUT);
        webElement.click();
    }

    protected static void fillField(By locator, String data) {
        waitForVisible(locator, DEFAULT_TIME_OUT);
        getDriver().findElement(locator).clear();
        getDriver().findElement(locator).sendKeys(data);
    }

    protected static void fillField(WebElement webElement, String data) {
        waitForVisible(webElement, DEFAULT_TIME_OUT);
        webElement.clear();
        webElement.sendKeys(data);
    }

    protected static String getText(By locator) {
        waitForVisible(locator, DEFAULT_TIME_OUT);
        return getDriver().findElement(locator).getText();
    }

    protected static String getText(WebElement webElement) {
        waitForVisible(webElement, DEFAULT_TIME_OUT);
        return webElement.getText();
    }

}
