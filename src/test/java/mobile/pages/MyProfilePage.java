package mobile.pages;

import cucumber.api.DataTable;
import mobile.utilities.I;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MyProfilePage extends I {
    private static String nameLocator = "com.workorder.mobile:id/editText_my_profile_name";
    private static String emailLocator = "com.workorder.mobile:id/editText_my_profile_email_id";
    private static String contactNumberLocator = "com.workorder.mobile:id/editText_profile_contact_number";
    private static String nameAfterNotUpdateLocator = "com.workorder.mobile:id/editText_edit_profile_name";
    private static String contactNumberAfterNotUpdateLocator = "com.workorder.mobile:id/editText_edit_profile_contact_number";
    private static String changePasswordButton = "com.workorder.mobile:id/button_change_password";
    private static String editProfileButton = "com.workorder.mobile:id/button_edit_profile";
    private static String date = "com.workorder.mobile:id/textView_edit_profile_creation_date";


    public static void verifyMyProfile(DataTable dataTable) {
        String name = dataTable.asMaps(String.class, String.class).get(0).get("name");
        String email = dataTable.asMaps(String.class, String.class).get(0).get("email");
        String contactNumber = dataTable.asMaps(String.class, String.class).get(0).get("contactNumber");
        Assert.assertEquals(I.getText(By.id(nameLocator)), name);
        Assert.assertEquals(I.getText(By.id(emailLocator)), email);
        Assert.assertEquals(I.getText(By.id(contactNumberLocator)), contactNumber);
    }

    public static void profileIsNotUpdated(DataTable dataTable) {
        String name = dataTable.asMaps(String.class, String.class).get(0).get("name");
        String contactNumber = dataTable.asMaps(String.class, String.class).get(0).get("contactNumber");
        Assert.assertEquals(I.getText(By.id(nameAfterNotUpdateLocator)), name);
        Assert.assertEquals(I.getText(By.id(contactNumberAfterNotUpdateLocator)), contactNumber);
    }

    public static void clickOnEditProfileButton() {
        I.clickOnElement(By.id(editProfileButton));
    }

    public static void seeProfileCreatedDate(String expectedDate) {
        String actualDate = I.getText(By.id(date));
        Assert.assertEquals(expectedDate, actualDate);
    }
}
