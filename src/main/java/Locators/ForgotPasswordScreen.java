package Locators;

import org.openqa.selenium.By;

public class ForgotPasswordScreen {

    public By forgotYourPasswordText = By.xpath("//android.widget.TextView[@text='Forgot your password?']");
    public By enterYourEmailBelowText = By.xpath("//android.widget.TextView[@text='Enter your Email below and we will send a message to reset your password'");
    public By forgotPasswordTextField = By.xpath("//android.widget.EditText");
    public By resetPasswordButON = By.xpath("//android.widget.Button[@text='Reset my password']");
    public By wehaveSentEmailText = By.xpath("//android.widget.TextView[@text='We have sent a password reset code by email to R***@a***. Enter it below to reset your password.']");
    public By codeText = By.xpath("//android.view.View[@text='Code']");

   //*****************************This is wrong - inform developer - it has sign in in it
    public By codeTextField = By.xpath("//android.webkit.WebView[@text='Signin']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
    public By newPasswordText = By.xpath("//android.view.View[@text='New Password']");
   //******************************************Inform developer
    public By newPasswordTextField = By.xpath("//android.webkit.WebView[@text='Signin']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
    public By changePasswordButoon = By.xpath("//android.widget.Button[@text='Change Password']");

}
