package mobile.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    protected static void canSeeText(MobileElement mobileElement, String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElement(mobileElement, expectedText));
        Assert.assertEquals(expectedText, mobileElement.getText());
    }

    protected static void canSeeText(By locator, String expectedText) {
        wait.until(ExpectedConditions.textToBe(locator, expectedText));
        Assert.assertEquals(expectedText, getDriver().findElement(locator).getText());
    }

    protected static void canNotSeeText(MobileElement mobileElement, String expectedText) {
        waitForVisible(mobileElement);
        Assert.assertNotEquals(expectedText, mobileElement.getText());
    }

    protected static void canNotSeeText(By locator, String expectedText) {
        waitForVisible(locator);
        Assert.assertNotEquals(expectedText, getDriver().findElement(locator).getText());
    }

    protected static void canSeeSubText(MobileElement mobileElement, String expectedText) {
        waitForVisible(mobileElement);
        Assert.assertTrue(mobileElement.getText().toLowerCase().contains(expectedText.toLowerCase()));
    }

    protected static void canSeeSubText(By locator, String expectedText) {
        waitForVisible(locator);
        Assert.assertTrue(getDriver().findElement(locator).getText().toLowerCase().contains(expectedText.toLowerCase()));
    }


    protected static void waitTillTextIsInvisible(By locator, String text) {
        wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
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
        getDriver().findElement(locator).clear();
        getDriver().findElement(locator).sendKeys(data);
        getDriver().hideKeyboard();
    }

    protected static void fillField(MobileElement mobileElement, String data) {
        waitForVisible(mobileElement);
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

    protected static void searchValue(By locator, String data) {
        waitForVisible(locator);
        getDriver().findElement(locator).clear();
        Actions actions = new Actions(getDriver());
        actions.sendKeys(getDriver().findElement(locator), data).sendKeys(Keys.ENTER).build().perform();
    }

    protected static void searchValue(MobileElement mobileElement, String data) {
        waitForVisible(mobileElement);
        mobileElement.clear();
        Actions actions = new Actions(getDriver());
        actions.sendKeys(mobileElement, data).sendKeys(Keys.ENTER).build().perform();
    }

}
