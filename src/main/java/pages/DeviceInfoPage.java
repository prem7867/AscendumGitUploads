package main.java.pages;


import main.java.Locators.BLEDetailsScreen;
import main.java.baseFiles.BaseActions;

import main.java.baseFiles.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeviceInfoPage extends TestBase {

    main.java.Locators.SettingsAppScreen settingsAppScreen = new   main.java.Locators.SettingsAppScreen();
    BaseActions baseActions = new BaseActions();
    main.java.Locators.LandingScreen landingScreen = new   main.java.Locators.LandingScreen();
    BLEDetailsScreen blueToothDetailsScreen = new BLEDetailsScreen();
    main.java.Locators.LoginScreen loginScreen = new   main.java.Locators.LoginScreen();
    LoginPage loginPage = new LoginPage();
    LandingDetailsPage landingDetailsPage = new LandingDetailsPage();
  BLEDetailsPage bleDetailsPage = new BLEDetailsPage();
    main.java.Locators.DeviceInfoScreen deviceInfoScreen = new   main.java.Locators.DeviceInfoScreen();
    BLEDetailsScreen bleDetailsScreen = new BLEDetailsScreen();

    //Navigate to DeviceIndo Screen
    public void navigateToDeviceInfoScreen()
    {
        loginPage.userHasLoggedInSuccessfully();
        landingDetailsPage.clickAvailableBLE();
        bleDetailsPage.clickDeviceInfoTab();
    }
    public void verifyDeviceInfoPageFields_340()
    {
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.backArrow);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.bluetoothIcon);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.deviceTitleTxt);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.scnAdvanceDetails);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.ucbDetails);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.deviceInfoTitleAndCustomerData);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.bleDongleDetails_RestartButton);
        //code for verifying ble details and restart button should be included - separate the above fields
    }

    public void clickRestartButton_340()
    {
        System.out.println(baseActions.getAttribute(deviceInfoScreen.bleDongleDetails_RestartButton));
        baseActions.isElementIsDisplayed(deviceInfoScreen.bleDongleDetails_RestartButton);
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(40));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(deviceInfoScreen.bleDongleDetails_RestartButton));
        element.click();
        baseActions.click(deviceInfoScreen.bleDongleDetails_RestartButton);
        //verify the code to see if the button is clicked
    }

    public void verifyrestartDonglePopUp_340()
    {
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.restartBluetoothDonglePopUptxt);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.restartBluetoothPopUp_RestartBtn);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.restartBluetoothPopUp_CancelBtn);
    }

    public void verifyRestartPopUpTxt_340()
    {
        String actualTxt = baseActions.getAttribute(deviceInfoScreen.restartBluetoothDonglePopUptxt);
        System.out.println(actualTxt);
        baseActions.compareTextByAttribute(deviceInfoScreen.restartBluetoothDonglePopUptxt, actualTxt, properties.getProperty("restartBluetoothDonglePopUptxt"));
    }

    public void cancelBtnNavigation_340()
    {
        baseActions.click(deviceInfoScreen.restartBluetoothPopUp_CancelBtn);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.deviceTitleTxt);
    }

    public void clickReStartButtonAndNavigateBack_345()
    {
        baseActions.click(deviceInfoScreen.restartBluetoothPopUp_RestartBtn);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.restartingBLEDongleLoadingTxt);
        baseActions.click(deviceInfoScreen.backArrow);
        baseActions.click(bleDetailsScreen.backArrow);
        baseActions.verifyElementIsDisplayed(landingScreen.bluetoothDevicesList);
        landingDetailsPage.clickAvailableBLE();
        baseActions.verifyElementIsDisplayed(bleDetailsScreen.configurationTab);
    }

    public void navigateBackBLEDetailsAndDeviceInfo_340()
    {
        baseActions.click(deviceInfoScreen.backArrow);
        baseActions.verifyElementIsDisplayed(bleDetailsScreen.getSystemStatus);
        baseActions.click(bleDetailsScreen.deviceInfoTabButton);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.deviceInfoTitle);
        String actualText = baseActions.getAttribute(deviceInfoScreen.deviceInfoTitle);
        System.out.println(actualText);
        baseActions.compareTextByAttribute(deviceInfoScreen.deviceInfoTitle, actualText, properties.getProperty("deviceInfoTitle"));
    }

    public void verifyBluetoothConnectDisconnect_344()
    {
        baseActions.isElementIsDisplayed(deviceInfoScreen.deviceTitleTxt);
        baseActions.verifyElementIsDisplayed(deviceInfoScreen.deviceTitleTxt);
        baseActions.isElementIsDisplayed(deviceInfoScreen.connectedText);
        try {
            if (appiumDriver.findElement(deviceInfoScreen.bluetoothIcon).isDisplayed()) {
                baseActions.verifyElementIsDisplayed(deviceInfoScreen.connectedText);
                baseActions.click(deviceInfoScreen.bluetoothIcon);
                baseActions.verifyElementIsDisplayed(deviceInfoScreen.deviceTitleTxt);
                baseActions.verifyElementIsDisplayed(deviceInfoScreen.diconnectedText);
            } else if (appiumDriver.findElement(deviceInfoScreen.refreshIcon).isDisplayed()) {
                baseActions.click(deviceInfoScreen.refreshIcon);
                baseActions.waitForElementToVisible(deviceInfoScreen.bluetoothIcon);
                baseActions.verifyElementIsDisplayed(deviceInfoScreen.bluetoothIcon);
            }
        }
        catch (Exception e)
        {
            log.info(e.getStackTrace());
        }

        try
        {
            if(appiumDriver.findElement(deviceInfoScreen.refreshIcon).isDisplayed())
            {
                baseActions.verifyElementIsDisplayed(deviceInfoScreen.diconnectedText);
                baseActions.click(deviceInfoScreen.refreshIcon);
                baseActions.waitForElementToVisible(deviceInfoScreen.bluetoothIcon);
                baseActions.verifyElementIsDisplayed(deviceInfoScreen.connectedText);
            }
        }
        catch (Exception e)
        {
         log.info(e.getMessage());
        }
    }
}