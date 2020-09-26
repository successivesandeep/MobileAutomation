package mobile.pages;

import mobile.utilities.I;
import org.openqa.selenium.By;

public class NotificationPage extends I {
    private static String notificationButtonLocator = "com.workorder.mobile:id/imageview_navigation_notification";
    private static String notificationPageTextLocator = "com.workorder.mobile:id/notification_heading";
    private static String readAllConfirmationMessageLocator = "android:id/message";
    private static String firstNotificationActionButtonLocator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView";
    private static String firstNotificationTextLocatorLocator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView";
    private static String markAsAllReadButtonLocator = "com.workorder.mobile:id/notification_mark_all_read_btn";
    private static String deleteSingleNotificationButtonLocator = "com.workorder.mobile:id/textview_delete_notification_menu";
    private static String beforeConfirmDeleteSingleNotificationButtonLocator = "com.workorder.mobile:id/textview_delete_notification_menu";
    private static String confirmDeleteSingleNotificationButtonLocator = "android:id/button1";
    private static String markReadSingleNotificationButtonLocator = "com.workorder.mobile:id/textview_markasread_notification_menu";
    private static String cancelButtonLocator = "android:id/button2";
    private static String okButtonLocator = "android:id/button1";
    private static String firstNotificationText = "";

    public static void clickOnNotificationButton(String pageName) {
        I.clickOnElement(By.id(notificationButtonLocator));
        I.canSeeText(By.id(notificationPageTextLocator), pageName);
    }

    public static void clickOnActionButtonForFirstNotification() {
        firstNotificationText = I.getText(By.xpath(firstNotificationTextLocatorLocator));
        I.clickOnElement(By.xpath(firstNotificationActionButtonLocator));
    }

    public static void deleteANotification() {
        I.clickOnElement(By.id(beforeConfirmDeleteSingleNotificationButtonLocator));
        I.clickOnElement(By.id(confirmDeleteSingleNotificationButtonLocator));
    }

    public static void readANotification() {
        I.clickOnElement(By.id(markReadSingleNotificationButtonLocator));
    }

    public static void readAllNotifications(String buttonName) {
        if (buttonName.equalsIgnoreCase("Mark All as Read")) {
            I.canSeeText(By.id(markAsAllReadButtonLocator), buttonName);
            I.clickOnElement(By.id(markAsAllReadButtonLocator));
        } else if (buttonName.equalsIgnoreCase("ok")) {
            I.canSeeText(By.id(okButtonLocator), buttonName);
            I.clickOnElement(By.id(okButtonLocator));
        } else if (buttonName.equalsIgnoreCase("Cancel")) {
            I.canSeeText(By.id(cancelButtonLocator), buttonName);
            I.clickOnElement(By.id(cancelButtonLocator));
        }
    }

    public static void verifyConfirmationMessageForReadAllMessage(String message) {
        I.canSeeText(By.id(readAllConfirmationMessageLocator), message);
    }

    public static void deletedNotificationIsNotDisplaying() {
        I.canNotSeeText(By.xpath(firstNotificationTextLocatorLocator), firstNotificationText);
    }

    public static void cancelSingleDeleteNotification() {
        I.clickOnElement(By.id(cancelButtonLocator));
    }

}
