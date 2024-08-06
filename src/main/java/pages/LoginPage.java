package pages;

import Locators.*;
import baseFiles.BaseActions;
import baseFiles.TestBase;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.bouncycastle.asn1.crmf.SinglePubInfo.web;

public class LoginPage extends TestBase {
        BaseActions baseActions = new BaseActions();
        LandingScreen landingScreen = new LandingScreen();
        LoginScreen loginScreen = new LoginScreen();
        PrivacyPolicyScreen privacyPolicyScreen = new PrivacyPolicyScreen();
        TermsAndConditionsScreen termsAndConditionsScreen = new TermsAndConditionsScreen();
        LicensingDetailsScreen licensingDetailsScreen = new LicensingDetailsScreen();
        SettingsAppScreen settingsAppScreen = new SettingsAppScreen();
        BlueToothDetailsScreen blueToothDetailsScreen = new BlueToothDetailsScreen();


        // Verify if the element is present and prints the text of the element accordingly
        public void login() {
            beforeLogin();
            baseActions.click(loginScreen.emailTextField);
            appiumDriver.findElement(loginScreen.emailTextField).clear();
            baseActions.enterText(loginScreen.emailTextField, properties.getProperty("email"));
            appiumDriver.findElement(loginScreen.passwordTextField).clear();
            baseActions.enterText(loginScreen.passwordTextField, properties.getProperty("password"));
            // appiumDriver.hideKeyboard();
            baseActions.click(loginScreen.signInButton);
        }

        public void beforeLogin() {
            log.info("launching application");
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            appiumDriver.findElement(loginScreen.signInSectionDisplay);
            appiumDriver.findElement(loginScreen.signInText);
            appiumDriver.findElement(loginScreen.signInView);
            String signInSectionText = baseActions.getText(loginScreen.signInWithEmailAndPwdText);
            log.info("'" + signInSectionText + "' - is the text available on the screen");
            appiumDriver.findElement(loginScreen.signInView);
        }

        public void verifyLoginFields() {
            baseActions.verifyElementIsDisplayed(loginScreen.refreshIcon);
            baseActions.verifyElementIsDisplayed(loginScreen.betBridgeConfigIcon);
            //App version is to be included
            baseActions.verifyElementIsDisplayed(loginScreen.signInWithEmailAndPwdText);
            baseActions.verifyElementIsDisplayed(loginScreen.emailText);
            baseActions.verifyElementIsDisplayed(loginScreen.passwordTextField);
            baseActions.verifyElementIsDisplayed(loginScreen.passwordText);
            baseActions.verifyElementIsDisplayed(loginScreen.forgotPasswordHyperLink);
            baseActions.verifyElementIsDisplayed(loginScreen.signInButton);
            baseActions.verifyElementIsDisplayed(loginScreen.cpiLogo);
            baseActions.verifyElementIsDisplayed(loginScreen.privaCyPolicyLinks);
            baseActions.verifyElementIsDisplayed(loginScreen.termsAndConditionsLink);
            baseActions.verifyElementIsDisplayed(loginScreen.licensingDetailsLink);
        }

        public void ToolTips() {
            baseActions.enterText(loginScreen.emailTextField, "");
            baseActions.click(loginScreen.signInButton);
            log.info("*********************************** Clicking signin button without entering email ***********************************");
            baseActions.toolTip();
            baseActions.enterText(loginScreen.emailTextField, properties.getProperty("email"));
            baseActions.click(loginScreen.signInButton);
            log.info("*********************************** Clicking signin button after entering only email ***********************************");
            baseActions.toolTip();
        }

        public void invalidUsernameOrPwdError() {
            baseActions.enterText(loginScreen.emailTextField, properties.getProperty("email"));
            baseActions.enterText(loginScreen.passwordTextField, properties.getProperty("invalidPassword"));
            baseActions.click(loginScreen.signInButton);
            baseActions.verifyElementIsDisplayed(loginScreen.invalidUsernameOrPassword);
            baseActions.compareText(loginScreen.incorrectUsernameOrPasswordError, properties.getProperty("expectedInvalidUSernamePwdText"));
        }

        public void afterClickingSignInButton() {
            login();
            baseActions.verifyInitialPopUp();
            baseActions.verifyElementIsDisplayed(landingScreen.qrcode);
        }

        public void clickLogOut() {
            afterClickingSignInButton();
            baseActions.click(landingScreen.menuDots);
            baseActions.click(landingScreen.logout);
        }

        public void login_logout() {
            login();
            baseActions.verifyInitialPopUp();
            baseActions.click(landingScreen.menuDots);
            baseActions.click(landingScreen.logout);
        }

        //Navigate to privacy policy screen
        public void verifyNavigationForPrivacyPolicy() {
            baseActions.click(loginScreen.privaCyPolicyLinks);
            log.info("Privacy policy link is being clicked");
            baseActions.verifyElementIsDisplayed(privacyPolicyScreen.betBridgeLogo);
            baseActions.verifyElementIsDisplayed(privacyPolicyScreen.privacyPolicyHeader);
            baseActions.click(privacyPolicyScreen.backArrowIcon);
            baseActions.verifyElementIsDisplayed(loginScreen.signInButton);
        }


        public void verifyNavigationForTermsAndConditions() {
            baseActions.click(loginScreen.termsAndConditionsLink);
            log.info("Terms And Conditions link is being clicked");
            baseActions.verifyElementIsDisplayed(termsAndConditionsScreen.betBridgeLogo);
            baseActions.verifyElementIsDisplayed(termsAndConditionsScreen.termsAndConditionsHeader);
            baseActions.click(termsAndConditionsScreen.backArrowIcon);
            baseActions.verifyElementIsDisplayed(loginScreen.signInButton);
        }

        public void verifyNavigationForLicensingDetailsLink() {
            baseActions.click(loginScreen.licensingDetailsLink);
            log.info("Licensing Details link is being clicked");
            baseActions.verifyElementIsDisplayed(licensingDetailsScreen.betBridgeLogo);
            baseActions.verifyElementIsDisplayed(licensingDetailsScreen.licensingDetailsHeader);
            getListOfLicensingDetailsLinks();
            baseActions.scrollUp();
            getListOfLicensingDetailsLinks();

        }

        public Object getListOfLicensingDetailsLinks() {
            {
                List<WebElement> listOfElements = appiumDriver.findElements(By.xpath("//*[contains(@class,'android.view.View')]"));
                for (WebElement element : listOfElements) {
                    log.info(element.getAttribute("content-desc"));
                    String detailsHeader = element.getAttribute("content-desc");
                    try {
                        if ((detailsHeader != null) && !(detailsHeader.equals("Licensing Details"))) {
                            log.info("Checking on the : " + detailsHeader + " link");
                            appiumDriver.findElement(By.xpath("//android.view.View[@content-desc='" + detailsHeader + "']")).isDisplayed();
                            log.info(detailsHeader + " is available");
                            appiumDriver.findElement(By.xpath("//android.view.View[@content-desc='" + detailsHeader + "']")).click();
                            log.info("Clicked on the : " + detailsHeader + " link");
                            baseActions.click(licensingDetailsScreen.backArrow);
                            log.info("Clicked on the back arrow on the licensing details screen");
                        }
                    } catch (Exception e) {
                        log.info(e.getMessage());
                    }
                }
                return listOfElements;

            }
        }

        public void turnOnBlueTooth()
        {
            log.info("Launching Bleutooth");
            //  appiumDriver.getRemoteAddress().getPath();
            // System.out.println("Launching Wifi");
            appiumDriver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.android.settings/.Settings"));
            WebElement name = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connected devices\']"));
            System.out.println(name.getText());
            name.click();
            appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Pair new device\']")).click();
            WebElement cpiBluetooth = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'CPI\']"));
            Boolean ifCPIBluetooth = cpiBluetooth.isDisplayed();
            if (ifCPIBluetooth == true) {
                System.out.println(cpiBluetooth.getText());
                appiumDriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\'Navigate up\']")).click();
                appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connection preferences\']")).click();
                appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Bluetooth\']")).click();
               // appiumDriver.findElement(By.xpath("//android.widget.Switch[@resource-id=\'android:id/switch_widget\']")).click();
                //android.widget.Switch[@resource-id="android:id/switch_widget"]
                //android.widget.Switch[@resource-id="android:id/switch_widget"]
            }
        }

        public void turnOffBluetooth()
        {
            log.info("Launching Bleutooth");
            //  appiumDriver.getRemoteAddress().getPath();
            // System.out.println("Launching Wifi");
            appiumDriver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.android.settings/.Settings"));
           // WebElement name = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connected devices\']"));

            WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, Duration.ofSeconds(30));
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.connectedDevices)));
            WebElement blueToothName = appiumDriver.findElement(settingsAppScreen.connectedDevices);
            System.out.println(blueToothName.getText());
            blueToothName.click();

            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.pairNewDevice)));
            //appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Pair new device\']")).click();
            appiumDriver.findElement(settingsAppScreen.pairNewDevice).click();

            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.cpiDevice)));
            // WebElement cpiBluetooth = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'CPI\']"));
            WebElement cpiBluetooth = appiumDriver.findElement(settingsAppScreen.cpiDevice);
            Boolean ifCPIBluetooth = cpiBluetooth.isDisplayed();
            if (ifCPIBluetooth == true) {
                System.out.println(cpiBluetooth.getText());
                //appiumDriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\'Navigate up\']")).click();
                appiumDriver.findElement(settingsAppScreen.navigateUpSettingsPage).click();
                appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.connectionPreferences)));

                //appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Connection preferences\']")).click();
                appiumDriver.findElement(settingsAppScreen.connectionPreferences).click();
                //appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Bluetooth\']")).click();

                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.blueToothToggleButtonOn)));
                appiumDriver.findElement(settingsAppScreen.blueToothToggleButtonOn).click();
                //appiumDriver.findElement(By.xpath("//android.widget.Switch[@resource-id=\'android:id/switch_widget\']")).click();

                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((settingsAppScreen.blueToothToglleButtonOff)));
                appiumDriver.findElement(settingsAppScreen.blueToothToglleButtonOff).click();
            }
        }

        //01.4 Validate Successful Login on Mobile Device with Bluetooth turned off #250

    public void verifyTurnOnBluetoothPopUp()
    {
        try {
            baseActions.verifyElementIsDisplayed(blueToothDetailsScreen.turnOnBluetoothPopUpText);
            baseActions.click(blueToothDetailsScreen.denyLink);

        }
        catch (Exception e)
        {
            e.getMessage();
        }
        try
        {
            baseActions.click(landingScreen.refreshIcon);
            baseActions.verifyElementIsDisplayed(blueToothDetailsScreen.turnOnBluetoothToContinueText);
           // baseActions.compareText(blueToothDetailsScreen.turnOnBluetoothToContinueText, properties.getProperty("turnOnBluetoothToContinueText"));
//            String textValue = baseActions.getText(blueToothDetailsScreen.turnOnBluetoothToContinueText);
//            Assert.assertEquals(textValue, properties.getProperty("turnOnBluetoothToContinueText"));
            baseActions.verifyElementIsDisplayed(blueToothDetailsScreen.turnOnLink);
            baseActions.click(blueToothDetailsScreen.turnOnLink);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}

