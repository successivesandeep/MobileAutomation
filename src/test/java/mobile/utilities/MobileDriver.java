package mobile.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileDriver extends MobileConfiguration{
    private static AppiumDriver<MobileElement> driver = getAppiumDriver();

    protected static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }
}
