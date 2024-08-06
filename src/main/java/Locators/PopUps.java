package Locators;

import org.openqa.selenium.By;

public class PopUps {

    public By allowButton = By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']");
                                                   //android.widget.Button[@resource-id="com.android.permissioncontroller:id/permission_allow_button"]
    public By alloButtonID = By.id("com.android.permissioncontroller:id/permission_allow_button");
    public By whileUsingApp = By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']");
                                                     //android.widget.Button[@resource-id="com.android.permissioncontroller:id/permission_allow_foreground_only_button"]
    public By whileUsingAppID = By.xpath("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

    public By allowPopUp1 = By.id("com.android.permissioncontroller:id/grant_singleton");
    public By getAllowPopUp2 = By.id("com.android.permissioncontroller:id/grant_dialog");
    public By allowPopUpText = By.id("com.android.permissioncontroller:id/content_container");

    //Allow Betbridge Config to access this device's location pop up:
    public By whileUsingTheApp = By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']");
    public By onlyThisTime = By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_one_time_button']");
    public By dontAllow = By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']");

}