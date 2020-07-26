package mobile.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class I extends MobileConfiguration {
    private static AppiumDriver<MobileElement> driver = getAppiumDriver();
    private static final int DEFAULT_TIME_OUT = 60;
    private static WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME_OUT);

    protected static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    private static void waitForVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    private static void waitForVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private static void waitForClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private static void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected static void textIsPresent(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    protected static void textIsPresent(By locator, String text) {
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    protected static void waitTillTextIsInvisible(By locator, String text) {
        wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }

    public static void waitFor(int minute) {
        try {
            Thread.sleep(minute * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static void clickOnElement(By locator) {
        waitForVisible(locator);
        waitForClickable(locator);
        getDriver().findElement(locator).click();
    }

    protected static void clickOnElement(WebElement webElement) {
        waitForVisible(webElement);
        waitForClickable(webElement);
        webElement.click();
    }

    protected static void fillField(By locator, String data) {
        waitForVisible(locator);
        getDriver().findElement(locator).sendKeys(Keys.CONTROL + "a");
        driver.findElement(locator).sendKeys(Keys.ENTER);
        //getDriver().findElement(locator).clear();
        getDriver().findElement(locator).sendKeys(data);
        getDriver().hideKeyboard();
    }

    protected static void fillField(WebElement webElement, String data) {
        waitForVisible(webElement);
        webElement.clear();
        webElement.sendKeys(data);
        getDriver().hideKeyboard();
    }

    protected static String getText(By locator) {
        waitForVisible(locator);
        return getDriver().findElement(locator).getText();
    }

    protected static String getText(WebElement webElement) {
        waitForVisible(webElement);
        return webElement.getText();
    }

    protected static void closeApp() {
        getDriver().closeApp();
    }

    protected static void launchApp() {
        getDriver().launchApp();
    }

    protected static void navigateBack() {
        getDriver().navigate().back();
    }

}
