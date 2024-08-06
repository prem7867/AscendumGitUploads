import baseFiles.BaseActions;
import baseFiles.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BlueToothAndWifiSettings;
import pages.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BlueToothAndWifiSettings_Tests extends TestBase {

    BlueToothAndWifiSettings blueToothAndWifiSettings = new BlueToothAndWifiSettings();
    BaseActions baseActions = new BaseActions();

    @Test
    public void turnOffWifi()
    {


      //  appiumDriver.executeScript("mobile:startActivity", ImmutableMap.of("intent", "com.android.settings/.Settings"));
        appiumDriver.executeScript("mobile:startActivity", ImmutableMap.of("intent", "com.cranepi.mobileapp.gconnect/.Gconnect"));
        blueToothAndWifiSettings.wifiSettings();
    }
}
