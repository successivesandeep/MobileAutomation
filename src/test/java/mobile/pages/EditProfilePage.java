package mobile.pages;

import mobile.utilities.I;
import org.openqa.selenium.By;

public class EditProfilePage extends I {
    private static String nameField = "com.workorder.mobile:id/editText_edit_profile_name";
    private static String mobileNumberField = "com.workorder.mobile:id/editText_edit_profile_contact_number";
    private static String saveButton = "com.workorder.mobile:id/button_edit_profile_save";
    private static String backButton = "com.workorder.mobile:id/toolbar_edit_profile";
    private static String ChangePasswordButton = "com.workorder.mobile:id/button_change_password";

    public static void changeName(String name) {
        I.fillField(By.id(nameField), name);
    }

    public static void changeMobileNumber(String mobileNumber) {
        I.fillField(By.id(mobileNumberField), mobileNumber);
    }

    public static void clickSaveButton() {
        I.clickOnElement(By.id(saveButton));
    }

    public static void clickOnBackButton() {
        //I.clickOnElement(By.id(backButton));
        I.navigateBack();
    }

    public static void changePasswordButton() {
        I.clickOnElement(By.id(ChangePasswordButton));
    }
}
