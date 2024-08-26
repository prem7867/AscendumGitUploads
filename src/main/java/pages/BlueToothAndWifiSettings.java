package main.java.pages;

import main.java.Locators.BLEDetailsScreen;
import main.java.baseFiles.BaseActions;

import com.google.common.collect.ImmutableMap;
import main.java.baseFiles.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static main.java.baseFiles.TestBase.appiumDriver;

public class BlueToothAndWifiSettings extends TestBase {

    main.java.Locators.SettingsAppScreen settingsAppScreen = new   main.java.Locators.SettingsAppScreen();
    BaseActions baseActions = new BaseActions();
    main.java.Locators.LandingScreen landingScreen = new   main.java.Locators.LandingScreen();
    BLEDetailsScreen blueToothDetailsScreen = new BLEDetailsScreen();
    main.java.Locators.LoginScreen loginScreen = new   main.java.Locators.LoginScreen();
    LoginPage loginPage = new LoginPage();

//    public void turnBlueToothOn() {
//        navigateToBlueTooth();
//        appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Bluetooth\']")).click();
//    }

//    public void turnBluetoothOFF() {
//        navigateToBlueTooth();
//        appiumDriver.findElement(By.xpath("//android.widget.Switch[@resource-id=\'android:id/switch_widget\']")).click();
//    }

    public void navigateToBlueTooth() {
        System.out.println("Launching Bleutooth");
        appiumDriver.getRemoteAddress().getPath();
        System.out.println("Launching Wifi");
        WebElement name = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connected devices\']"));
        System.out.println(name.getText());
        name.click();
        appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Pair new device\']")).click();
        WebElement cpiBluetooth = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'CPI\']"));
        boolean ifCPIBluetooth = cpiBluetooth.isDisplayed();
        if (ifCPIBluetooth) {
            System.out.println(cpiBluetooth.getText());
            appiumDriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\'Navigate up\']")).click();
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connection preferences\']")).click();
        }
    }

    public void turnOffWifi() {
        log.info("Wifi connection test case has started");
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(settingsAppScreen.networkAndInternet))); // wait for loader to ap
        baseActions.click(settingsAppScreen.networkAndInternet);
        log.info("Clicked on the Network & Internet label under settings tab");
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(settingsAppScreen.internetLink)));
        baseActions.click(settingsAppScreen.internetLink);
        log.info("Clicked on the Internet label under Network & Internet menu");
        boolean state = baseActions.isElementIsDisplayed(settingsAppScreen.connetedWifiNetwork);
        try
        {
            if(state==true)
            {
                baseActions.click(settingsAppScreen.wifiToggleOnOffButton);
            }
            else
            {
                baseActions.click(settingsAppScreen.navigateUpSettingsPage);
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }


    public void turnOnWifi() {
        log.info("Wifi connection test case has started");
        log.info("Launched the settings app");
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(settingsAppScreen.networkAndInternet))); // wait for loader to ap
        baseActions.click(settingsAppScreen.networkAndInternet);
        log.info("Clicked on the Network & Internet label under settings tab");
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(settingsAppScreen.internetLink)));
        baseActions.click(settingsAppScreen.internetLink);
        log.info("Clicked on the Internet label under Network & Internet menu");
        try {
            if (baseActions.isElementIsDisplayed(settingsAppScreen.connetedWifiNetwork)) {
                baseActions.click(settingsAppScreen.navigateUpSettingsPage);
            } else {
                baseActions.click(settingsAppScreen.wifiToggleOnOffButton);
            }
        } catch(Exception e)
        {
            log.info(e.getStackTrace());
        }
    }

    public void turnOnBlueTooth() {
        log.info("Launching Bleutooth");
        appiumDriver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.android.settings/.Settings"));
        WebElement name = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connected devices\']"));
        System.out.println(name.getText());
        name.click();
        appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Pair new device\']")).click();
        WebElement cpiBluetooth = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'CPI\']"));
        boolean ifCPIBluetooth = cpiBluetooth.isDisplayed();
        if (ifCPIBluetooth) {
            System.out.println(cpiBluetooth.getText());
            appiumDriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\'Navigate up\']")).click();
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connection preferences\']")).click();
            appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Bluetooth\']")).click();
        }
    }


    public void turnOffBluetooth() {
        log.info("Launching Bleutooth");
        appiumDriver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.android.settings/.Settings"));
        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.connectedDevices)));
        WebElement blueToothName = appiumDriver.findElement(settingsAppScreen.connectedDevices);
        System.out.println(blueToothName.getText());
        blueToothName.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.pairNewDevice)));
        appiumDriver.findElement(settingsAppScreen.pairNewDevice).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.cpiDevice)));
        WebElement cpiBluetooth = appiumDriver.findElement(settingsAppScreen.cpiDevice);
        boolean ifCPIBluetooth = cpiBluetooth.isDisplayed();
        if (ifCPIBluetooth) {
            System.out.println(cpiBluetooth.getText());
            appiumDriver.findElement(settingsAppScreen.navigateUpSettingsPage).click();
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.connectionPreferences)));
            appiumDriver.findElement(settingsAppScreen.connectionPreferences).click();
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.blueToothToggleButtonOn)));
            appiumDriver.findElement(settingsAppScreen.blueToothToggleButtonOn).click();
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.blueToothToglleButtonOff)));
            appiumDriver.findElement(settingsAppScreen.blueToothToglleButtonOff).click();
        }
    }

    //01.4 Validate Successful Login on Mobile Device with Bluetooth turned off #250

    public void verifyTurnOnBluetoothPopUp() {
        try {
            baseActions.verifyElementIsDisplayed(blueToothDetailsScreen.turnOnBluetoothPopUpText);
            log.info("verifying if bluetooth pop up has the appropriate text");
            baseActions.click(blueToothDetailsScreen.denyLink);
            log.info("Clicking on the deny link on the bluetooth pop up");

        } catch (Exception e) {
            log.info(e.getStackTrace());
        }
        try {
            baseActions.click(landingScreen.refreshIcon);
            baseActions.verifyElementIsDisplayed(blueToothDetailsScreen.turnOnBluetoothToContinueText);
            baseActions.verifyElementIsDisplayed(blueToothDetailsScreen.turnOnLink);
            baseActions.click(blueToothDetailsScreen.turnOnLink);
        } catch (Exception e) {
            log.info(e.getStackTrace());
        }
    }


    public void checkNetworkErrorMessage() {
        baseActions.click(blueToothDetailsScreen.refreshIconWhenNoNetwork);
        log.info("clicking on refresh icon when there is no network connection available");
        baseActions.compareText(blueToothDetailsScreen.networkError, properties.getProperty("networkError"));
        log.info("Comparing the text when there is no network");
    }


    public void offBlueToothToggleOnly() {
        log.info("Connecting Bleutooth from Settings application");
        appiumDriver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.android.settings/.Settings"));
        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.connectedDevices)));
        log.info("Waiting for connected devices to be listed in the Settings Application");
        WebElement blueToothName = appiumDriver.findElement(settingsAppScreen.connectedDevices);
        log.info(blueToothName.getText());
        blueToothName.click();
        log.info("Clicking on the connected bluetooth");
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.connectionPreferences)));
        appiumDriver.findElement(settingsAppScreen.connectionPreferences).click();
        log.info("Clicking on the connected preferences link under settings application");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.blueToothToggleButtonOn)));
        appiumDriver.findElement(settingsAppScreen.blueToothToggleButtonOn).click();
        log.info("Clicking on the bluetooth toggle button to - ON");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.blueToothToglleButtonOff)));
        appiumDriver.findElement(settingsAppScreen.blueToothToglleButtonOff).click();
        log.info("Clicking on the bluetooth toggle button to - Off");
    }

    public void turnWifiOffAndOn() throws MalformedURLException {
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        appiumDriver.executeScript("mobile:startActivity", ImmutableMap.of("intent", "com.android.settings/.Settings"));
        baseActions.killSettingsApp();
        log.info("Killing settings application");
        turnOffWifi();
        log.info("Tutning off the wifi connection");
        baseActions.killSettingsApp();
        log.info("Killing the setting application again");
        reuseAndroidCapabilities();
        log.info("Launching the gaming cashless application");
        baseActions.checkNetworkAndclickRefreshIcon();
        checkNetworkErrorMessage();
        appiumDriver.executeScript("mobile:startActivity", ImmutableMap.of("intent", "com.android.settings/.Settings"));
        turnOnWifi();
        reuseAndroidCapabilities();
       baseActions.checkNetworkAndclickRefreshIcon();
        loginPage.beforeLogin();
        loginPage.login();
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        baseActions.verifySuccessfullLogin();
    }

}