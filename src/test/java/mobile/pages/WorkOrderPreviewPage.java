package mobile.pages;

import mobile.utilities.I;
import org.openqa.selenium.By;

public class WorkOrderPreviewPage extends I {
    private static String PreviewButton = "com.workorder.mobile:id/button_add_wo_preview";
    private static String toolbarHeading = "com.workorder.mobile:id/toolbar_work_order_description_title";
    private static String createButton = "com.workorder.mobile:id/button_work_order_create";


    public static void preview() {
        I.clickOnElement(By.id(PreviewButton));
    }

    public static void headingPreview(String preview) {
        I.textIsPresent(By.id(toolbarHeading), "Preview");
    }

    public static void previewCreate() {
        I.clickOnElement(By.id(createButton));
    }
}
