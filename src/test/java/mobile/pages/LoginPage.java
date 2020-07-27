package mobile.pages;

import mobile.utilities.I;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends I {
    private static String emailField = "com.workorder.mobile:id/edittext_email";
    private static String passwordField = "com.workorder.mobile:id/edittext_password";
    private static String signInButton = "com.workorder.mobile:id/button_login";
    private static String invalidCredentialMessage = "android:id/message";
    private static String okButton = "android:id/button1";

    public static void enterEmailAddress(String emailId) {
        I.fillField(By.id(emailField), emailId);
    }

    public static void enterPassword(String password) {
        I.fillField(By.id(passwordField), password);
    }

    public static void clickSignInButton() {
        I.clickOnElement(By.id(signInButton));
    }

    public static void closeApp() {
        I.closeApp();
    }

    public static void launchApp() {
        I.launchApp();
    }

    public static void veryMessageForInvalidCredential(String expectedMessage) {
        I.waitTillTextIsInvisible(By.id(invalidCredentialMessage), "Loading...");
        String actualMessage = I.getText(By.id(invalidCredentialMessage));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    public static void pressOkButton(String expectedButtonName) {
        String actualButtonName = I.getText(By.id(okButton));
        Assert.assertEquals(expectedButtonName, actualButtonName);
        I.clickOnElement(By.id(okButton));
    }
}
