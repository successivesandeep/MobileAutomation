package mobile.pages;

import mobile.utilities.I;
import org.junit.Assert;
import org.openqa.selenium.By;


public class ChangePasswordPage extends I {
    private static String editCurrentPasswordField = "com.workorder.mobile:id/edittext_current_password";
    private static String editNewPasswordField = "com.workorder.mobile:id/edittext_profile_change_password";
    private static String confirmPasswordField = "com.workorder.mobile:id/edittext_profile_confirm_password";
    private static String submitButton = "com.workorder.mobile:id/button_profile_change_password_submit";
    private static String hintMessage = "android:id/message";
    private static String acceptButton = "android:id/button1";
    private static String invalidCredentialMessage = "android:id/message";


    public static void currentPassword(String currentPassword) {
        I.fillField(By.id(editCurrentPasswordField), currentPassword);
    }


    public static void newPassword(String newPassword) {
        I.fillField(By.id(editNewPasswordField), newPassword);
    }

    public static void confirmPassword(String confirmPassword) {
        I.fillField(By.id(confirmPasswordField), confirmPassword);

    }

    public static void submit() {
        I.clickOnElement(By.id(submitButton));
    }

    public static void seeMessage(String message) {
        I.waitTillTextIsInvisible(By.id(invalidCredentialMessage), "Loading...");
        while (I.getText(By.id(invalidCredentialMessage)).equals("Loading...")) {
            I.waitFor(2);
        }
        String hint = I.getText(By.id(hintMessage));
        Assert.assertEquals(hint.trim(), message.trim());
    }

    public static void acceptMessage() {
        I.clickOnElement(By.id(acceptButton));
    }

}


