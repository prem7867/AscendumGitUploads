package main.java.Locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class eTiToScreen {

    String ticketNumber = "190304093927000112";
    String amount = "1.00";
    String assetNumberData = "3052533932";

    public By timeoutError = new AppiumBy.ByAccessibilityId("Sending..." + "eTITO Transferred [02]" + "eTITO Loaded [03]" + "Timeout");
    public By successMessage = By.xpath("//android.view.View[@content-desc='Sending...\n" +
            "eTITO Transferred [02]\n" +
            "eTITO Loaded [03]\n" +
            "Success [00]']");

    public By timeOutMessage = By.xpath("//android.view.View[@content-desc='eTITO Transferred [02]\n" +
            "eTITO Loaded [03]\n" +
            "Timeout']");
    public By successTimeOutRejectCrossMark = By.xpath("//android.widget.FrameLayout[@resource-id=android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[1]");
    public By enterPasswordToContinuePopUp = By.xpath("//android.view.View[@content-desc='Enter Password to Continue\n" +
            "Password']");
    public By passwordTextFieldOnPopUp = By.xpath("//android.widget.EditText");
    public By crossMarkPasswordField = By.xpath("//android.view.View[@content-desc='Enter Password to Continue\n" +
            "Password']/android.widget.Button[1]");
    public By showPasswordIcon = By.xpath("//android.view.View[@content-desc='Enter Password to Continue\n" +
            "Password']/android.widget.Button[2]");
    public By continueButton = By.xpath("//android.view.View[@content-desc='Continue']");
    public By cancelButton = By.xpath("//android.view.View[@content-desc='Cancel']");
    public By testETitoHeader = By.xpath("//android.view.View[@content-desc='Test eTITO']");
    public By etitoTicketText = By.xpath("//android.view.View[@content-desc='eTITO Ticket*']");
    public By etitoTicketTextFieldData = By.xpath("//android.widget.EditText[@text='"+ticketNumber+"']");
    public By barcode = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[2]");
    public By amountText = By.xpath("//android.view.View[@content-desc='Amount']");
    public By amountTextFieldData = By.xpath("//android.widget.EditText[@text='"+amount+"']");
    public By crossMArkAmountField = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[3]");
    public By currencyText = By.xpath("//android.view.View[@content-desc='Currency']");
    public By currencyDropdown = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View");
    public By selectUsdValue = By.xpath("//android.view.View[@content-desc='USD']");
    public By selectCADValue = By.xpath("//android.view.View[@content-desc='CAD']");
    public By assetNumberText = By.xpath("//android.view.View[@content-desc='Asset Number']");
    public By assetNumberTextFieldsData = By.xpath("//android.widget.EditText[@text='"+assetNumberData+"']");
    public By crossMarkAssetNumber = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[4]");
    public By assetNumberQRCode = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[5]");
    public By sendEtitoToDEviceButton = By.xpath("//android.widget.Button[@content-desc='Send eTITO to Device']");
}