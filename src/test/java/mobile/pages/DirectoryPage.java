package mobile.pages;

import mobile.utilities.I;
import org.openqa.selenium.By;

public class DirectoryPage extends I {
    private static String directoryTabLocator = "com.workorder.mobile:id/textview_navigation_directory";
    private static String searchDirectoryButton = "com.workorder.mobile:id/search_button";
    private static String directorySearchField = "com.workorder.mobile:id/search_src_text";
    private static String totalVendorsLocator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout";
    private static String vendorNameTextLocator1 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[";
    private static String vendorNameTextLocator2 = "]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]";
    private static String vendorTypeDropdownButtonLocator = "com.workorder.mobile:id/menu_btn_directory_filter";
    private static String vendorsLocator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout";
    private static String vendorTypeTextLocator1 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[";
    private static String vendorTypeTextLocator2 = "]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]";
    private static String applyFilterButtonLocator = "com.workorder.mobile:id/button_directory_apply_filter";


    public static void clickOnDirectoryTab() {
        I.clickOnElement(By.id(directoryTabLocator));
    }

    public static void clickOnSearchButton() {
        I.clickOnElement(By.id(searchDirectoryButton));
    }

    public static void enterKeyToSearchVendors(String value) {
        I.searchValue(By.id(directorySearchField), value);
    }

    public static void verifySearchedVendorsWithFullText(String searchValue) {
        int vendorsCount = I.findElements(By.xpath(totalVendorsLocator)).size();
        for (int index = 0; index < vendorsCount; index++) {
            I.canSeeText(By.xpath(vendorNameTextLocator1 + (index + 1) + vendorNameTextLocator2), searchValue);
        }
    }

    public static void verifySearchedVendorsWithPartialText(String searchValue) {
        int vendorsCount = I.findElements(By.xpath(totalVendorsLocator)).size();
        for (int index = 0; index < vendorsCount; index++) {
            I.canSeeSubText(By.xpath(vendorNameTextLocator1 + (index + 1) + vendorNameTextLocator2), searchValue);
        }
    }

    public static void verifySearchedVendorsWithFullVendorTypeText(String searchValue) {
        int vendorsCount = I.findElements(By.xpath(totalVendorsLocator)).size();
        for (int index = 0; index < vendorsCount; index++) {
            I.canSeeText(By.xpath(vendorTypeTextLocator1 + (index + 1) + vendorTypeTextLocator2), searchValue);
        }
    }

    public static void verifySearchedVendorsWithPartialVendorTypeText(String searchValue) {
        int vendorsCount = I.findElements(By.xpath(totalVendorsLocator)).size();
        for (int index = 0; index < vendorsCount; index++) {
            I.canSeeSubText(By.xpath(vendorTypeTextLocator1 + (index + 1) + vendorTypeTextLocator2), searchValue);
        }
    }

    public static void filterVendorsBasedOnVendorTypeBySelectingThroughDropdown(String vendorType) {
        I.clickOnElement(By.id(vendorTypeDropdownButtonLocator));
        int vendorsCount = I.findElements(By.xpath(vendorsLocator)).size();
        for (int index = 0; index < vendorsCount; index++) {
            if (I.getText(By.xpath(vendorTypeTextLocator1 + (index + 1) + vendorTypeTextLocator2)).equalsIgnoreCase(vendorType)) {
                I.clickOnElement(By.id(vendorTypeTextLocator1 + (index + 1) + vendorTypeTextLocator2));
                break;
            }
        }
        I.clickOnElement(By.id(applyFilterButtonLocator));
    }
}
