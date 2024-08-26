package main.java.Locators;

import org.openqa.selenium.By;

public class DeviceInfoScreen {
    public By backArrow = By.xpath("//android.widget.ImageView[@content-desc='Device Info']/android.view.View[1]/android.view.View[2]/android.widget.Button");
    public By deviceTitleTxt = By.xpath("//android.widget.ImageView[@content-desc='Device Info']/android.view.View[1]/android.view.View[2]/android.widget.Button");
    public By diconnectedText = By.xpath("//android.view.View[@content-desc='Disconnected']");
    public By connectingText = By.xpath("//android.view.View[@content-desc='Connecting...']");
    public By connectedText = By.xpath("//android.view.View[@content-desc='Connected']");
    public By bluetoothIcon = By.xpath("//android.widget.ImageView[@content-desc='Device Info']/android.view.View[1]/android.view.View[1]/android.view.View[1]");
    public By refreshIcon = By.xpath("//android.widget.ImageView[@content-desc='Device Info']/android.view.View[1]/android.view.View[1]/android.view.View[1]");
    public By ucbLogIcon = By.xpath("//android.widget.ImageView[@content-desc='Device Info']/android.view.View[1]/android.view.View[1]/android.view.View[2]");
    public By deviceInfoTitleAndCustomerData = By.xpath("//android.view.View[@content-desc=\"Device Info:\n" +
            "Customer Data:\n" +
            "3331313834\n" +
            "888369105\"]");
    public By scnAdvanceDetails = By.xpath("//android.widget.ImageView[@content-desc=\"SCN Advance Details\n" +
            "FW Version:\n" +
            "286108560\n" +
            "Serial Number:\n" +
            "16401302754\"]");
    public By ucbDetails = By.xpath("//android.widget.ImageView[@content-desc=\"UCB Details\n" +
            "FW Version:\n" +
            "888369109\n" +
            "BL Version:\n" +
            "286396107\n" +
            "Serial Number:\n" +
            "01234567890\"]");


    public By bleDongleDetails_RestartButton = By.xpath("//android.widget.ImageView[contains(@content-desc, 'Bluetooth Dongle Details')]");
    public By restartBluetoothPopUp_RestartBtn = By.xpath("//android.view.View[@content-desc='RESTART']");
    public By restartBluetoothPopUp_CancelBtn = By.xpath("//android.view.View[@content-desc='CANCEL']");
    public By restartBluetoothDonglePopUptxt = By.xpath("//android.view.View[@content-desc='Restart Bluetooth Dongle?\n" +
            "Restarting will disconnect Bluetooth Dongle from Device']");

    public By deviceInfoTitle = By.xpath("//android.widget.ImageView[@content-desc='Device Info']");
    public By restartingBLEDongleLoadingTxt = By.xpath("//android.view.View[@content-desc='Restarting Bluetooth Dongle']");


}