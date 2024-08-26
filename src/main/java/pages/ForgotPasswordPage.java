package main.java.pages;

import main.java.baseFiles.BaseActions;

import baseFiles.TestBase2;
import main.java.Locators.ChangePasswordScreen;
import main.java.baseFiles.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class ForgotPasswordPage extends TestBase {
        BaseActions baseActions = new BaseActions();
    main.java.Locators.LandingScreen landingScreen = new   main.java.Locators.LandingScreen();
    main.java.Locators.LoginScreen loginScreen = new   main.java.Locators.LoginScreen();
    main.java.Locators.PrivacyPolicyScreen privacyPolicyScreen = new   main.java.Locators.PrivacyPolicyScreen();
    main.java.Locators.TermsAndConditionsScreen termsAndConditionsScreen = new   main.java.Locators.TermsAndConditionsScreen();
    main.java.Locators.LicensingDetailsScreen licensingDetailsScreen = new   main.java.Locators.LicensingDetailsScreen();
    main.java.Locators.SettingsAppScreen settingsAppScreen = new   main.java.Locators.SettingsAppScreen();
    main.java.Locators.BLEDetailsScreen blueToothDetailsScreen = new   main.java.Locators.BLEDetailsScreen();
    main.java.Locators.ForgotPasswordScreen forgotPasswordScreen = new   main.java.Locators.ForgotPasswordScreen();
        ChangePasswordScreen changePasswordScreen = new ChangePasswordScreen();


        // click on forgot password link and navigate to forgot password screen
       public void clickForgoPasswordLink()
       {
           appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
           baseActions.click(loginScreen.forgotPasswordHyperLink);
           baseActions.waitForElementToVisible(forgotPasswordScreen.enterYourEmailBelowText);
           baseActions.verifyElementIsDisplayed(forgotPasswordScreen.enterYourEmailBelowText);
           baseActions.enterText(forgotPasswordScreen.forgotPasswordTextField, properties.getProperty("forgotPasswordEmail"));
           baseActions.click(forgotPasswordScreen.resetPasswordButON);
       }

       //Enter the code details in forgot password page
    public void enterCodeDetails() throws IOException {
        //baseActions.isElementIsDisplayed(changePasswordScreen.wehaveSentEmailText);
        String retrievedCode = readCodeFromTextFile();
        baseActions.waitForElementToBeClickable(changePasswordScreen.codeTextField);
        baseActions.enterText(changePasswordScreen.codeTextField, retrievedCode);
        baseActions.waitForElementToBeClickable(changePasswordScreen.newPasswordTextField);
        baseActions.enterText(changePasswordScreen.newPasswordTextField, properties.getProperty("newPassword"));
        baseActions.waitForElementToBeClickable(changePasswordScreen.enterNewPasswordText);
        baseActions.enterText(changePasswordScreen.enterNewPasswordTextField, properties.getProperty("enterNewPassword"));
        baseActions.click(changePasswordScreen.changePasswordButoon);
    }

    public String readCodeFromTextFile() throws IOException {
        Path fileName = Path.of("C:\\Users\\Rajeshwari.Prem\\substring.txt");
        // Now calling Files.readString() method to
        // read the file
        String retrievedCode = Files.readString(fileName);
        // logging the string
        log.info(retrievedCode);
        return retrievedCode;
    }

}