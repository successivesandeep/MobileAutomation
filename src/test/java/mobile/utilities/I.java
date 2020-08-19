package mobile.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class I extends MobileConfiguration {
    private static final AppiumDriver<MobileElement> driver = getAppiumDriver();
    private static final int DEFAULT_TIME_OUT = 60;
    private static final WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME_OUT);

    protected static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    private static void waitForVisible(MobileElement mobileElement) {
        wait.until(ExpectedConditions.visibilityOf(mobileElement));
    }

    private static void waitForVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private static void waitForClickable(MobileElement mobileElement) {
        wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
    }

    private static void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected static void textIsPresent(MobileElement mobileElement, String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElement(mobileElement, expectedText));
        Assert.assertEquals(expectedText, mobileElement.getText());
    }

    protected static void textIsPresent(By locator, String expectedText) {
        wait.until(ExpectedConditions.textToBe(locator, expectedText));
        Assert.assertEquals(expectedText, getDriver().findElement(locator).getText());
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

    private static void waitForVisibilityOfAllElements(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected static void clickOnElement(By locator) {
        waitForVisible(locator);
        waitForClickable(locator);
        getDriver().findElement(locator).click();
    }

    protected static void clickOnElement(MobileElement mobileElement) {
        waitForVisible(mobileElement);
        waitForClickable(mobileElement);
        mobileElement.click();
    }

    protected static void fillField(By locator, String data) {
        waitForVisible(locator);
        getDriver().findElement(locator).sendKeys(Keys.CONTROL + "a");
        getDriver().findElement(locator).sendKeys(Keys.ENTER);
        getDriver().findElement(locator).clear();
        getDriver().findElement(locator).sendKeys(data);
        getDriver().hideKeyboard();
    }

    protected static void fillField(MobileElement mobileElement, String data) {
        waitForVisible(mobileElement);
        mobileElement.sendKeys(Keys.CONTROL + "a");
        mobileElement.sendKeys(Keys.ENTER);
        mobileElement.clear();
        mobileElement.sendKeys(data);
        getDriver().hideKeyboard();
    }

    protected static String getText(By locator) {
        waitForVisible(locator);
        return getDriver().findElement(locator).getText();
    }

    protected static String getText(MobileElement mobileElement) {
        waitForVisible(mobileElement);
        return mobileElement.getText();
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

    protected static List<MobileElement> findElements(By locator) {
        //waitForVisibilityOfAllElements(locator);
        return driver.findElements(locator);
    }

    protected static void seeCheckBoxIsSelected(By locator) {
        waitForVisible(locator);
        waitForClickable(locator);
        Assert.assertTrue(getDriver().findElement(locator).isSelected());
    }

    protected static void seeCheckBoxIsSelected(MobileElement mobileElement) {
        waitForVisible(mobileElement);
        waitForClickable(mobileElement);
        Assert.assertTrue(mobileElement.isSelected());
    }


    public static void scrollDown() {
        Dimension dimension = getDriver().manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.2);

        new TouchAction((PerformsTouchActions) getDriver())
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }
}
