package main.java.Locators;

import org.openqa.selenium.By;

public class ChangePasswordScreen {

    public By wehaveSentEmailText = By.id("text-code");
    public By codeText = By.xpath("//android.view.View[@text='Code']");

   //*****************************This is wrong - inform developer - it has sign in in it
    public By codeTextField = By.xpath("//android.widget.EditText[@resource-id=\'forgot_password_code\']");
    public By newPasswordText = By.xpath("//android.view.View[@text='New Password']");
   //******************************************Inform developer
    public By newPasswordTextField = By.xpath("//android.widget.EditText[@resource-id=\'new_password\']");
    public By enterNewPasswordText = By.xpath("//android.view.View[@text=\'Enter New Password Again\']");
    public By enterNewPasswordTextField = By.xpath("//android.widget.EditText[@resource-id=\'confirm_password\']");

    public By changePasswordButoon = By.xpath("//android.widget.Button[@text='Change Password']");


}