package main.java.Locators;

import baseFiles.TestBase2;
import org.openqa.selenium.By;


public class SettingsAppScreen extends TestBase2 {

    public By connectedDevices = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connected devices\']");
    public By pairNewDevice = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Pair new device\']");
    public By cpiDevice = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'CPI\']");
    public By navigateUpSettingsPage = By.xpath("//android.widget.ImageButton[@content-desc=\'Navigate up\']");
    public By connectionPreferences = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connection preferences\']");
    public By blueToothToggleButtonOn = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Bluetooth\']");
    public By blueToothToglleButtonOff = By.xpath("//android.widget.Switch[@resource-id=\'android:id/switch_widget\']");

    public By connetedWifiNetwork = By.xpath("//android.widget.ImageView[@content-desc='Settings']");

    public By noNetworkError = By.xpath("//android.widget.TextView[@text='Webpage not available']");

    public By wifiName = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text="+properties.getProperty("wifiName")+"]");
   // public By wifiToggleButton = By.xpath("//android.widget.Button[@resource-id='com.android.settings:id/button3']");

    public By wifiToggleOnOffButton = By.xpath(" //android.widget.Switch[@resource-id='com.android.settings:id/switchWidget']");

    public By networkAndInternet = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Network & internet\']");
    public By internetLink = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Internet\']");
    public By allNetworkList = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\'com.android.settings:id/recycler_view\']");

    public By checkNetworkIsOff = By.xpath("//android.widget.TextView[@resource-id='android:id/summary' and @text='Wi‑Fi turns back on automatically']");
}