package Locators;

import org.openqa.selenium.By;

public class LoginScreen {

    public By emailTextField = By.xpath("//android.widget.EditText[@resource-id=\'signInFormUsername\']");
    public By passwordTextField = By.xpath("//android.widget.EditText[@resource-id=\'signInFormPassword\']");
    public By signInButton = By.xpath("//android.widget.Button[@text=\'submit\']");
    public By signInSectionDisplay = By.id("android:id/content");
    public By signInText = By.xpath("//android.widget.Button[@text=\'submit\']");
    public By signInView = By.xpath("//android.webkit.WebView[@text='Signin']//android.view.View/android.view.View/android.view.View");
    public By signInWithEmailAndPwdText = By.xpath("//android.widget.TextView[@text=\'Sign in with your email and password\']");
    public By emailText = By.xpath("//android.view.View[@text=\'Email\']");
    public By passwordText = By.xpath("//android.view.View[@text=\'Password\']");
    public By forgotPasswordHyperLink = By.xpath("//android.widget.TextView[@text=\'Forgot your password?\']");
    public By invalidUsernameOrPassword = By.xpath("//android.widget.TextView[@text='Incorrect username or password.']");
    public By forgotPasswordLink = By.xpath("//android.widget.TextView[@text='Forgot your password?']");
    public By betBridgeConfigIcon = By.xpath("//android.view.View[@content-desc=\'Version  1.0.31 \']/android.widget.ImageView[1]");
    public By cpiLogo = By.xpath("//android.view.View[@content-desc=\'Version  1.0.31 \']/android.widget.ImageView[3]");
    public By privaCyPolicyLinks = By.xpath("//android.view.View[@content-desc=\'Privacy Policy\']");
    public By termsAndConditionsLink = By.xpath("//android.view.View[@content-desc=\'Terms & Conditions\']");
    public By licensingDetailsLink = By.xpath("//android.view.View[@content-desc=\'Licensing Details\']");
    public By refreshIcon = By.xpath("//android.view.View[@content-desc=\'Version  1.0.31 \']/android.widget.ImageView[2]");
    public By toolTipError = By.xpath("//android.view.View[@text=\'Please fill out this field. \']");

    public By incorrectUsernameOrPasswordError = By.xpath("//android.widget.TextView[@resource-id=\'loginErrorMessage\']");


}



