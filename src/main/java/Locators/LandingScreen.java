package main.java.Locators;

import baseFiles.TestBase2;
import org.openqa.selenium.By;

public class LandingScreen extends TestBase2 {

    //String signalStrength = "86 dbm";

    public By bluetoothDevicesList = By.xpath("//android.widget.ImageView[contains(@content-desc, '" + properties.getProperty("bleName") + "')]");
    //android.widget.ImageView[@content-desc="CPI

    public By refreshIcon = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]");
                                                    //android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]

    public By qrcode = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]");

    public By menuDots = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]");
   //public By menuDots = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]");

   public By logout = By.xpath("//android.view.View[@content-desc='Logout']");
    public By bluetoothIconName = By.xpath("//android.view.View[@content-desc='"+properties.getProperty("bleName")+"']");
    public By bluetoothConnected = By.xpath("//android.view.View[@content-desc='Connected']");
    public By bluetoothIcon = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[1]");
    public By infoIcon = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]");
   // public By signalStrengthNumber = By.xpath("//android.view.View[@content-desc='"+signalStrength+"']");

//    //Customer Data Section
//    public By customerDataText = By.xpath("//android.view.View[@content-desc='Customer Data:']");
//    public By userAssetID = By.xpath("//android.view.View[@content-desc='UCB Asset ID:']");
//    public By userAssetIDNumber = By.xpath("//android.view.View[@content-desc='3052533932']");
//    public By bluetoothStrength = By.xpath("//android.view.View[@content-desc='Bluetooth Strength:']");
//   // public By signalStrengthNumberCust = By.xpath("//android.view.View[@content-desc='"+signalStrength+"']");
//    public By ucbModel = By.xpath("//android.view.View[@content-desc='UCB Model:']");
//    public By ucbModelNumber = By.xpath("//android.view.View[@content-desc='UB01']");
//    public By ucbFWREvText = By.xpath("//android.view.View[@content-desc='UCB FW Rev:']");
//    public By ucbSerialNumber = By.xpath("//android.view.View[@content-desc='UCB Serial Number:']");
//    public By apiVersionText = By.xpath("//android.view.View[@content-desc='Api Version:']");
//    public By apiVersionNumber = By.xpath("//android.view.View[@content-desc='2']");
//    public By getSystemStatus = By.xpath("//android.widget.Button[@content-desc='Get System Status']");
//    public By resetStatus = By.xpath("//android.widget.Button[@content-desc='Reset Status']");
//    public By configurationTab = By.xpath("//android.widget.Button[@content-desc='Configuration']");
//    public By deviceInfo = By.xpath("//android.widget.Button[@content-desc='Device Info']");
//    public By testETITO = By.xpath("//android.widget.Button[@content-desc='Test eTITO']");
    public By userProfileIcon = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView");
}