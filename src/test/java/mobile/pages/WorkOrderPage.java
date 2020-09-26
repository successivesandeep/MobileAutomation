package mobile.pages;

import mobile.utilities.I;
import org.openqa.selenium.By;

public class WorkOrderPage extends I {
    private static String workOrderText = "com.workorder.mobile:id/work_order";
    private static String menuButton = "com.workorder.mobile:id/linear_layout_navigation_menu";

    public static void verifyUserOnWorkOrderPage(String pageName) {
        I.canSeeText(By.id(workOrderText), pageName);
    }

    public static void clickOnMenuButton() {
        I.clickOnElement(By.id(menuButton));
    }
}