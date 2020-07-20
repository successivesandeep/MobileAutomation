package mobile.utilities;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.net.URL;
import java.util.Properties;

class MobileConfiguration {
    private static String mobilePlatform;
    private static String deviceName;
    private static AppiumDriver<MobileElement> appiumDriver;

    private static void selectMobileToRunTest() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("./src/test/resources/mobile.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Properties properties = new Properties();
            properties.load(fileReader);
            mobilePlatform = properties.get("mobilePlatform").toString();
            deviceName = properties.get("deviceName").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static AppiumDriver<MobileElement> getAppiumDriver() {
        selectMobileToRunTest();
        Config config = ConfigFactory.load("mobile");
        String mobilePlatform = System.getProperty("mobilePlatform") == null ? MobileConfiguration.mobilePlatform : System.getProperty("mobilePlatform");
        String deviceName = System.getProperty("deviceName") == null ? MobileConfiguration.deviceName : System.getProperty("deviceName");
        if (config.hasPath(mobilePlatform)) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", mobilePlatform);
            desiredCapabilities.setCapability("deviceName", deviceName);
            desiredCapabilities.setCapability("udid", config.getConfig(mobilePlatform).withFallback(config).getConfig(mobilePlatform).getConfig(deviceName).getString("udid"));
            desiredCapabilities.setCapability("platformVersion", config.getConfig(mobilePlatform).withFallback(config).getConfig(mobilePlatform).getConfig(deviceName).getString("platformVersion"));
            desiredCapabilities.setCapability("appPackage", config.getConfig(mobilePlatform).withFallback(config).getConfig(mobilePlatform).getConfig(deviceName).getString("appPackage"));
            desiredCapabilities.setCapability("appActivity", config.getConfig(mobilePlatform).withFallback(config).getConfig(mobilePlatform).getConfig(deviceName).getString("appActivity"));
            //desiredCapabilities.setCapability("automationName", config.getConfig(mobilePlatform).withFallback(config).getConfig(mobilePlatform).getConfig(deviceName).getString("automationName"));
            desiredCapabilities.setCapability("noSign", "true");
            try {
                URL url = new URL("http://0.0.0.0:4723/wd/hub");
                appiumDriver = new AppiumDriver<>(url, desiredCapabilities);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return appiumDriver;
    }
}