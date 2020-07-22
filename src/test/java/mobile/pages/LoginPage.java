package mobile.pages;

import mobile.utilities.PageHandler;
import org.openqa.selenium.By;

public class LoginPage extends PageHandler {
    private static String emailField = "com.workorder.mobile:id/edittext_email";
    private static String passwordField = "com.workorder.mobile:id/edittext_password";
    private static String signInButton = "com.workorder.mobile:id/button_login";

    public static void enterEmailAddress(String emailId) {
        fillField(By.id(emailField), emailId);
    }

    public static void enterPassword(String password) {
        fillField(By.id(passwordField), password);
    }

    public static void clickSignInButton() {
        clickOnElement(By.id(signInButton));
    }
}
