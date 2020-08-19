package mobile.pages;

import io.appium.java_client.MobileElement;
import mobile.utilities.I;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.concurrent.atomic.AtomicInteger;


public class WorkOrderPage extends I {
    private static String workOrderText = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.widget.TextView";
    private static String menuButton = "com.workorder.mobile:id/linear_layout_navigation_menu";
    private static String addWorkOrder = "com.workorder.mobile:id/floating_action_button";
    private static String titleField = "com.workorder.mobile:id/edittext_title";
    private static String descriptionField = "com.workorder.mobile:id/edittext_description";
    private static String date = "com.workorder.mobile:id/edittext_dueDate";
    private static String okayButton = "android:id/button1";
    private static String facilityDropdown = "com.workorder.mobile:id/spinner_add_work_order_facility";
    private static String facilityActivities = "/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView";
    private static String unitDropdown = "com.workorder.mobile:id/spinner_add_work_order_unit";
    private static String priorityDropdown = "com.workorder.mobile:id/spinner_add_work_order_priority";
    private static String categoryDropdown = "com.workorder.mobile:id/spinner_add_work_order_category";
    private static String notificationDropdown = "com.workorder.mobile:id/edittext_notification";
    private static String watchersDropdown = "com.workorder.mobile:id/edittext_watchers";
    private static String unitActivity = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]";
    private static String priorityActivities = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]";
    private static String createButton = "com.workorder.mobile:id/button_add_wo_create";
    private static String message = "android:id/message";
    private static String selectedOptionFacility = "com.workorder.mobile:id/edittext_facility";
    private static String selectedOptionUnit = "com.workorder.mobile:id/edittext_unit";
    private static String selectedOptionPriority = "com.workorder.mobile:id/edittext_priority";
    private static String categoryActivity = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]";
    private static String selectedOptionCategory = "com.workorder.mobile:id/edittext_category";
    private static String notificationCheckbox = "com.workorder.mobile:id/send_notification_Checkbox";
    private static String appCheckbox = "com.workorder.mobile:id/send_app_Checkbox";
    private static String emailWatchCheckbox = "com.workorder.mobile:id/email_watch_Checkbox";
    private static String watcherCheckbox = "com.workorder.mobile:id/app_watcher_Checkbox";
    private static String crossButton = "com.workorder.mobile:id/notification_popup_image_button_cross";
    private static String AssigneeDropdown = "com.workorder.mobile:id/spinner_add_work_order_assignto";
    private static String AssigneeActivity = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]";
    private static String selectedOptionAssignee = "com.workorder.mobile:id/edittext_assignto";
    private static String watcher_checkbox = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.CheckBox";
    private static String selectedOptionWatcher = "com.workorder.mobile:id/edittext_watchers";
    private static String titleDescription = "com.workorder.mobile:id/textView_work_order_description_title";
    private static String editedDescription = "com.workorder.mobile:id/textView_work_order_description_detail";
    private static String cancelButton = "com.workorder.mobile:id/cancel_button";
    private static String crossButton2 = "com.workorder.mobile:id/watchers_popup_image_button_cross";


    public static void verifyUserOnWorkOrderPage(String pageName) {
        I.textIsPresent(By.xpath(workOrderText), pageName);
    }

    public static void clickOnMenuButton() {
        I.clickOnElement(By.id(menuButton));
    }

    public static void addWorkOrder() {
        I.clickOnElement(By.id(addWorkOrder));
    }

    public static void selectTitle(String title) {
        I.fillField(By.id(titleField), title);

    }

    public static void fillDescription(String description) {
        I.fillField(By.id(descriptionField), description);
    }

    public static void selectCurrentDate() {
        I.clickOnElement(By.id(date));
        I.clickOnElement(By.id(okayButton));
    }


    public static void selectFacility(String selectedFacility) {
        I.clickOnElement(By.id(facilityDropdown));
        System.out.println(I.findElements(By.xpath(facilityActivities)).size());
        int index = 1;
        for (MobileElement mobileElement : I.findElements(By.xpath(facilityActivities))) {
            if (I.getText(mobileElement).trim().contentEquals(selectedFacility.trim())) {
                String locator = facilityActivities + "[" + index + "]";
                System.out.println(locator);
                I.clickOnElement(By.xpath(locator));
                break;
            } else {
                index++;
            }
        }
    }

    public static void selectUnit(String selectedFacility) {
        I.clickOnElement(By.id(unitDropdown));
        System.out.println(I.findElements(By.xpath(unitActivity)).size());
        AtomicInteger index = new AtomicInteger(1);
        I.findElements(By.id(unitActivity)).forEach(mobileElement -> {
            if (I.getText(mobileElement).contentEquals(selectedFacility)) {
                I.clickOnElement(By.xpath(unitActivity + "[" + index + "]"));
            } else {
                index.getAndIncrement();
            }
        });
    }

    public static void selectPriority(String priorityMessage) {
        I.clickOnElement(By.id(priorityDropdown));
        I.clickOnElement(By.xpath(priorityActivities));
        String actualMessage = I.getText(By.id(selectedOptionPriority));
        Assert.assertEquals(actualMessage.trim(), priorityMessage.trim());
        I.scrollDown();
    }


    public static void selectCategory(String category) {
        I.clickOnElement(By.id(categoryDropdown));
        I.clickOnElement(By.xpath(categoryActivity));
    }


    public static void clickOnCreateButton() {
        I.clickOnElement(By.id(createButton));
    }

    public static void errorMessage(String expectedMessage) {
        String actualMessage = I.getText(By.id(expectedMessage));
        Assert.assertEquals(actualMessage.trim(), expectedMessage.trim());
        I.clickOnElement(By.id(okayButton));
    }

    public static void notification() {
        I.clickOnElement(By.id(notificationDropdown));
        I.seeCheckBoxIsSelected(By.id(appCheckbox));
        I.seeCheckBoxIsSelected(By.id(emailWatchCheckbox));
        I.seeCheckBoxIsSelected(By.id(notificationCheckbox));
        I.seeCheckBoxIsSelected(By.id(watcherCheckbox));
    }

    public static void closeNotification() {
        I.clickOnElement(By.id(createButton));
    }

    public static void selectAssignee(String assignee) {
        I.clickOnElement(By.id(""));
        I.clickOnElement(By.xpath(""));
    }

    public static void selectWatchers(String selectedWatcher) {
        I.clickOnElement(By.id(watchersDropdown));
        I.clickOnElement(By.xpath(watcherCheckbox));
        I.clickOnElement(By.id(crossButton2));
    }

    public static void verifyCreatedTitle(String titleDescription) {
        I.textIsPresent(By.id(titleDescription), titleDescription);
    }

    public static void cancel() {
        I.clickOnElement(By.id(cancelButton));
    }

    public static void blankFacility() {
        I.clickOnElement(By.id(facilityDropdown));
        I.clickOnElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"));
    }

    public static void ve(String finalDescription) {
        I.textIsPresent(By.id(editedDescription), finalDescription);

    }
}
