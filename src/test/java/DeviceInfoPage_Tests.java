package test.java;

import main.java.baseFiles.BaseActions;

import main.java.baseFiles.TestBase;
import main.java.pages.BlueToothAndWifiSettings;
import main.java.pages.DeviceInfoPage;
import main.java.pages.LoginPage;
import org.testng.annotations.Test;


import java.net.MalformedURLException;

public class DeviceInfoPage_Tests extends TestBase {

    BlueToothAndWifiSettings blueToothAndWifiSettings = new BlueToothAndWifiSettings();
    BaseActions baseActions = new BaseActions();
    LoginPage loginPage = new LoginPage();
    DeviceInfoPage deviceInfoPage = new DeviceInfoPage();

    @Test
    public void verifyDeviceInfoPage_340() throws MalformedURLException {
        deviceInfoPage.navigateToDeviceInfoScreen();
        deviceInfoPage.verifyDeviceInfoPageFields_340();
        deviceInfoPage.clickRestartButton_340();
        deviceInfoPage.verifyrestartDonglePopUp_340();
        deviceInfoPage.verifyRestartPopUpTxt_340();
        deviceInfoPage.cancelBtnNavigation_340();
        deviceInfoPage.navigateBackBLEDetailsAndDeviceInfo_340();
    }
    @Test
    public void rebootBLEDongle_345() throws MalformedURLException {
        deviceInfoPage.navigateToDeviceInfoScreen();
        deviceInfoPage.verifyDeviceInfoPageFields_340();
        deviceInfoPage.clickRestartButton_340();
        deviceInfoPage.verifyrestartDonglePopUp_340();
        deviceInfoPage.verifyRestartPopUpTxt_340();
        deviceInfoPage.clickReStartButtonAndNavigateBack_345();
    }

    @Test
    public void connectDisconnect_344()
    {
//        loginPage.beforeLogin();
//        loginPage.login();
        baseActions.verifyInitialPopUp();
        deviceInfoPage.navigateToDeviceInfoScreen();
        deviceInfoPage.verifyBluetoothConnectDisconnect_344();

    }
}