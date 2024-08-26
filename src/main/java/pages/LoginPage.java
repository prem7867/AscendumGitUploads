package main.java.pages;


import main.java.baseFiles.BaseActions;

import baseFiles.TestBase2;
import main.java.baseFiles.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends TestBase {
        BaseActions baseActions = new BaseActions();
    main.java.Locators.LandingScreen landingScreen = new   main.java.Locators.LandingScreen();
    main.java.Locators.LoginScreen loginScreen = new   main.java.Locators.LoginScreen();
    main.java.Locators.PrivacyPolicyScreen privacyPolicyScreen = new   main.java.Locators.PrivacyPolicyScreen();
    main.java.Locators.TermsAndConditionsScreen termsAndConditionsScreen = new   main.java.Locators.TermsAndConditionsScreen();
    main.java.Locators.LicensingDetailsScreen licensingDetailsScreen = new   main.java.Locators.LicensingDetailsScreen();
    main.java.Locators.SettingsAppScreen settingsAppScreen = new   main.java.Locators.SettingsAppScreen();
    main.java.Locators.BLEDetailsScreen blueToothDetailsScreen = new   main.java.Locators.BLEDetailsScreen();


        // Verify if the element is present and prints the text of the element accordingly
        public void login() {
            beforeLogin();
           // baseActions.click(loginScreen.refreshIcon);
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
            baseActions.isElementIsDisplayed(loginScreen.signInButton);
            appiumDriver.findElement(loginScreen.signInButton);
            appiumDriver.findElement(loginScreen.signInView);
            String signInSectionText = baseActions.getText(loginScreen.signInWithEmailAndPwdText);
            log.info("'" + signInSectionText + "' - is the text available on the screen");
            appiumDriver.findElement(loginScreen.signInView);
        }

        public void verifyLoginFields_247() {
            baseActions.click(loginScreen.refreshIcon);
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

        public void ToolTips_247() {
            baseActions.click(loginScreen.refreshIcon);
            baseActions.enterText(loginScreen.emailTextField, "");
            baseActions.click(loginScreen.signInButton);
            log.info("*********************************** Clicking signin button without entering email ***********************************");
            baseActions.toolTip();
            baseActions.enterText(loginScreen.emailTextField, properties.getProperty("email"));
            baseActions.click(loginScreen.signInButton);
            log.info("*********************************** Clicking signin button after entering only email ***********************************");
            baseActions.toolTip();
        }

        public void invalidUsernameOrPwdError_247() {
            baseActions.click(loginScreen.refreshIcon);
            baseActions.enterText(loginScreen.emailTextField, properties.getProperty("email"));
            baseActions.enterText(loginScreen.passwordTextField, properties.getProperty("invalidPassword."));
            baseActions.click(loginScreen.signInButton);
            baseActions.verifyElementIsDisplayed(loginScreen.invalidUsernameOrPassword);
            baseActions.compareText(loginScreen.incorrectUsernameOrPasswordError, properties.getProperty("expectedInvalidUSernamePwdText"));
            baseActions.click(loginScreen.refreshIcon);
//            baseActions.enterText(loginScreen.emailTextField, properties.getProperty("email"));
//            //baseActions.clearData(loginScreen.passwordTextField);
//            baseActions.enterText(loginScreen.passwordTextField, properties.getProperty("invalidPasswordTrue"));
//            baseActions.click(loginScreen.signInButton);
//            baseActions.verifyElementIsDisplayed(loginScreen.invalidUsernameOrPassword);
//            baseActions.compareText(loginScreen.incorrectUsernameOrPasswordError, properties.getProperty("expectedInvalidUSernamePwdText"));
//            baseActions.click(loginScreen.refreshIcon);
//            baseActions.enterText(loginScreen.emailTextField, properties.getProperty("email"));
//           // baseActions.clearData(loginScreen.passwordTextField);
//            baseActions.enterText(loginScreen.passwordTextField, properties.getProperty("invalidPassword1"));
//            baseActions.click(loginScreen.signInButton);
//            baseActions.verifyElementIsDisplayed(loginScreen.invalidUsernameOrPassword);
//            baseActions.compareText(loginScreen.incorrectUsernameOrPasswordError, properties.getProperty("expectedInvalidUSernamePwdText"));

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
        public void verifyNavigationForPrivacyPolicy_249() {
         //   baseActions.click(loginScreen.refreshIcon);
            baseActions.click(loginScreen.privaCyPolicyLinks);
            log.info("Privacy policy link is being clicked");
            baseActions.verifyElementIsDisplayed(privacyPolicyScreen.betBridgeLogo);
            baseActions.verifyElementIsDisplayed(privacyPolicyScreen.privacyPolicyHeader);
            baseActions.click(privacyPolicyScreen.backArrowIcon);
            baseActions.verifyElementIsDisplayed(loginScreen.signInButton);
        }


        public void verifyNavigationForTermsAndConditions_249() {
           // baseActions.click(loginScreen.refreshIcon);
            baseActions.click(loginScreen.termsAndConditionsLink);
            log.info("Terms And Conditions link is being clicked");
            baseActions.verifyElementIsDisplayed(termsAndConditionsScreen.betBridgeLogo);
            baseActions.verifyElementIsDisplayed(termsAndConditionsScreen.termsAndConditionsHeader);
            baseActions.click(termsAndConditionsScreen.backArrowIcon);
            baseActions.verifyElementIsDisplayed(loginScreen.signInButton);
        }

        public void verifyNavigationForLicensingDetailsLink_249() {
            baseActions.click(loginScreen.licensingDetailsLink);
            log.info("Licensing Details link is being clicked");
            baseActions.verifyElementIsDisplayed(licensingDetailsScreen.betBridgeLogo);
            baseActions.verifyElementIsDisplayed(licensingDetailsScreen.licensingDetailsHeader);
            getListOfLicensingDetailsLinks();
            baseActions.scrollUp();
            getListOfLicensingDetailsLinks();
            baseActions.click(licensingDetailsScreen.backArrow);
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
                    //baseActions.click(licensingDetailsScreen.backArrow);
                }
                return listOfElements;
            }
        }

    public void userHasLoggedInSuccessfully()
    {
        beforeLogin();
        login();
        log.info("User has logged in successfully");
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        baseActions.verifySuccessfullLogin();
    }
}