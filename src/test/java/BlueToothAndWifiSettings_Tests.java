package test.java;

import main.java.baseFiles.BaseActions;

import com.google.common.collect.ImmutableMap;
import main.java.baseFiles.TestBase;
import main.java.pages.BlueToothAndWifiSettings;
import main.java.pages.LoginPage;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.time.Duration;

public class BlueToothAndWifiSettings_Tests extends TestBase {

    BlueToothAndWifiSettings blueToothAndWifiSettings = new BlueToothAndWifiSettings();
    BaseActions baseActions = new BaseActions();
    LoginPage loginPage = new LoginPage();

    @Test
    public void turnOffWifi_251() throws MalformedURLException {
//        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        appiumDriver.executeScript("mobile:startActivity", ImmutableMap.of("intent", "com.android.settings/.Settings"));
        baseActions.killSettingsApp();
        blueToothAndWifiSettings.turnOffWifi();
        baseActions.killSettingsApp();
        reuseAndroidCapabilities();
        blueToothAndWifiSettings.checkNetworkErrorMessage();
    }

    @Test
    public void launchBlueTooth_250() throws MalformedURLException {
        baseActions.killSettingsApp();
        blueToothAndWifiSettings.offBlueToothToggleOnly();
        baseActions.killSettingsApp();
        reuseAndroidCapabilities();
        loginPage.beforeLogin();
        loginPage.login();
        try
        {
            baseActions.popUpAfterBlueToothOff();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        blueToothAndWifiSettings.verifyTurnOnBluetoothPopUp();
        reuseAndroidCapabilities();
    }



    @Test
    public void turnOffWifiAndONLater_251_258() throws MalformedURLException {
        blueToothAndWifiSettings.turnWifiOffAndOn();
    }

}