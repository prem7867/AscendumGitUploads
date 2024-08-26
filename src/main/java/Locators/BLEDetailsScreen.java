package main.java.Locators;

import org.openqa.selenium.By;

public class BLEDetailsScreen {

    public By backArrow = By.xpath("//android.widget.Button");
    public By turnOnBluetoothPopUpText = By.xpath("//android.widget.TextView[@resource-id='android:id/message']");
    public By denyLink = By.xpath("//android.widget.Button[@resource-id='android:id/button2']");
    public By allowLink = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");
    public By turnOnBluetoothToContinueText = By.xpath("//android.view.View[@content-desc='Please turn on Bluetooth to continue']");
    public By turnOnLink = By.xpath("//android.widget.Button[@content-desc='Turn On']");
    public By cancelLink = By.xpath("//android.widget.Button[@content-desc='Cancel']");
    public By networkError = By.xpath("//android.widget.TextView[@text='Webpage not available']");
    public By refreshIconWhenNoNetwork = By.xpath("//android.view.View[contains(@content-desc, 'Version')]");
    public By deviceInfoTabButton = By.xpath("//android.widget.Button[@content-desc='Device Info']");

    public By logout = By.xpath("//android.view.View[@content-desc='Logout']");
    //public By bluetoothIconName = By.xpath("//android.view.View[@content-desc='"+properties.getProperty("bleName")+"']");
    public By bluetoothConnected = By.xpath("//android.view.View[@content-desc='Connected']");
    public By bluetoothIcon = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[1]");
    public By infoIcon = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]");
    // public By signalStrengthNumber = By.xpath("//android.view.View[@content-desc='"+signalStrength+"']");

    //Customer Data Section
    public By customerDataText = By.xpath("//android.view.View[@content-desc='Customer Data:']");
    public By userAssetID = By.xpath("//android.view.View[@content-desc='UCB Asset ID:']");
    public By userAssetIDNumber = By.xpath("//android.view.View[@content-desc='3052533932']");
    public By bluetoothStrength = By.xpath("//android.view.View[@content-desc='Bluetooth Strength:']");
    // public By signalStrengthNumberCust = By.xpath("//android.view.View[@content-desc='"+signalStrength+"']");
    public By ucbModel = By.xpath("//android.view.View[@content-desc='UCB Model:']");
    public By ucbModelNumber = By.xpath("//android.view.View[@content-desc='UB01']");
    public By ucbFWREvText = By.xpath("//android.view.View[@content-desc='UCB FW Rev:']");
    public By ucbSerialNumber = By.xpath("//android.view.View[@content-desc='UCB Serial Number:']");
    public By apiVersionText = By.xpath("//android.view.View[@content-desc='Api Version:']");
    public By apiVersionNumber = By.xpath("//android.view.View[@content-desc='2']");
    public By getSystemStatus = By.xpath("//android.widget.Button[@content-desc='Get System Status']");
    public By resetStatus = By.xpath("//android.widget.Button[@content-desc='Reset Status']");
    public By configurationTab = By.xpath("//android.widget.Button[@content-desc='Configuration']");
    public By deviceInfo = By.xpath("//android.widget.Button[@content-desc='Device Info']");
    public By testETITO = By.xpath("//android.widget.Button[@content-desc='Test eTITO']");
   // public By userProfileIcon = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView");
}