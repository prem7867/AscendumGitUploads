package main.java.Locators;

import org.openqa.selenium.By;

public class BlueToothDetailsScreen {

    public By backArrow = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[1]");
    public By turnOnBluetoothPopUpText = By.xpath("//android.widget.TextView[@resource-id='android:id/message']");
    public By denyLink = By.xpath("//android.widget.Button[@resource-id='android:id/button2']");
    public By allowLink = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");
    public By turnOnBluetoothToContinueText = By.xpath("//android.view.View[@content-desc='Please turn on Bluetooth to continue']");
    public By turnOnLink = By.xpath("//android.widget.Button[@content-desc='Turn On']");
    public By cancelLink = By.xpath("//android.widget.Button[@content-desc='Cancel']");
    public By neyworkError = By.xpath("//android.widget.TextView[@text='Webpage not available']");

    public By refreshIconWhenNoNetwork = By.xpath("//android.view.View[@content-desc='Version  1.0.31 \n" +
            "net::ERR_NAME_NOT_RESOLVED']/android.widget.ImageView[2]");
}
