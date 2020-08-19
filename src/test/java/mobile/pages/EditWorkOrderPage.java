package mobile.pages;

import mobile.utilities.I;
import org.openqa.selenium.By;

public class EditWorkOrderPage extends I {
    private static String edit = "com.workorder.mobile:id/toolbar_menu_work_order_description_edit";
    private static String saveButton = "com.workorder.mobile:id/button_add_wo_save";

    public static void editWorkorder() {
        I.clickOnElement(By.id(edit));
    }

    public static void save() {
        I.scrollDown();
        I.clickOnElement(By.id(saveButton));
    }
}
