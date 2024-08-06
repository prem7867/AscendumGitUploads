package Locators;

import org.openqa.selenium.By;


public class SettingsAppScreen {

    public By connectedDevices = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connected devices\']");
    public By pairNewDevice = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Pair new device\']");
    public By cpiDevice = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'CPI\']");
    public By navigateUpSettingsPage = By.xpath("//android.widget.ImageButton[@content-desc=\'Navigate up\']");
    public By connectionPreferences = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connection preferences\']");
    public By blueToothToggleButtonOn = By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Bluetooth\']");
    public By blueToothToglleButtonOff = By.xpath("//android.widget.Switch[@resource-id=\'android:id/switch_widget\']");
}