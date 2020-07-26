package mobile.pages;

import mobile.utilities.I;
import org.openqa.selenium.By;

public class WorkOrderPage extends I {
    private static String workOrderText = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.widget.TextView";
    private static String menuButton = "com.workorder.mobile:id/linear_layout_navigation_menu";

    public static void verifyUserOnWorkOrderPage(String pageName) {
        I.textIsPresent(By.xpath(workOrderText), pageName);
    }

    public static void clickOnMenuButton() {
        I.clickOnElement(By.id(menuButton));
    }
}
