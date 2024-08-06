package Locators;

import org.openqa.selenium.By;

public class BlueToothDetailsScreen {

    public By backArrow = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[1]");
    public By turnOnBluetoothPopUpText = By.xpath("//android.widget.TextView[@resource-id='android:id/message']");
    public By denyLink = By.xpath("//android.widget.Button[@resource-id='android:id/button2']");
    public By allowLink = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");
    public By turnOnBluetoothToContinueText = By.xpath("//android.view.View[@content-desc='Please turn on Bluetooth to continue']");
    public By turnOnLink = By.xpath("//android.widget.Button[@content-desc='Turn On']");
    public By cancelLink = By.xpath("//android.widget.Button[@content-desc='Cancel']");
}
