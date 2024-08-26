package main.java.pages;


import main.java.Locators.BLEDetailsScreen;
import main.java.baseFiles.BaseActions;

import baseFiles.TestBase2;
import main.java.baseFiles.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BLEDetailsPage extends TestBase {
        BaseActions baseActions = new BaseActions();
        main.java.Locators.LandingScreen landingScreen = new   main.java.Locators.LandingScreen();
        main.java.Locators.LoginScreen loginScreen = new   main.java.Locators.LoginScreen();
        main.java.Locators.PrivacyPolicyScreen privacyPolicyScreen = new   main.java.Locators.PrivacyPolicyScreen();
        main.java.Locators.TermsAndConditionsScreen termsAndConditionsScreen = new   main.java.Locators.TermsAndConditionsScreen();
        main.java.Locators.LicensingDetailsScreen licensingDetailsScreen = new   main.java.Locators.LicensingDetailsScreen();
        main.java.Locators.SettingsAppScreen settingsAppScreen = new   main.java.Locators.SettingsAppScreen();
        BLEDetailsScreen bleDetailsDetailsScreen = new BLEDetailsScreen();


        // Verify if the element is present and prints the text of the element accordingly
        public void clickDeviceInfoTab() {
                WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(5000));
                wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(bleDetailsDetailsScreen.deviceInfoTabButton)));
                baseActions.click(bleDetailsDetailsScreen.deviceInfoTabButton);
        }
}