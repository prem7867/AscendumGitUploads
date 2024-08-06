import baseFiles.BaseActions;
import baseFiles.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class LoginPage_Tests extends TestBase {

    LoginPage loginPage = new LoginPage();
    BaseActions baseActions = new BaseActions();

    public LoginPage_Tests() throws IOException {
    }

    @Test(priority = 1)
    public void verifyFields() throws IOException {
        ExtentTest test = extent.createTest("Verify login fields").assignAuthor("Rajeshwari.prem@ascendum.com");
        test.log(Status.PASS, "Launching the application - before login feature");
        test.info("Capturing fields on login screen");
        try {
            loginPage.beforeLogin();
            loginPage.verifyLoginFields();
            test.pass("Login screen fields are all correct");
        } catch (Exception e) {
            test.fail("unexpected error: " + e.getMessage());
            //test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
            // test.fail("message", MediaEntityBuilder.createScreenCaptureFromPath("." + captureScreenShot(appiumDriver)).build());

        }
    }

    @Test
    public void launchBlueTooth() throws MalformedURLException {
        baseActions.killSettingsApp();
       loginPage.turnOffBluetooth();
       baseActions.killSettingsApp();
        reuseAndroidCapabilities();
        loginPage.beforeLogin();
        loginPage.login();
        try
        {
            baseActions.popUpAfterBlueToothOff();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        loginPage.verifyTurnOnBluetoothPopUp();
    }

    @Test
    public void verifyNavigationToPrivacyPolicy () throws IOException {
        ExtentTest test = extent.createTest("01.6 Validate the 'Terms and Conditions' and 'Privacy Policy' links #253").assignAuthor("Rajeshwari.prem@ascendum.com");
        test.log(Status.PASS, "User is about to navigate to privacy policy screen");
        test.info("Capturing fields on Privacy Policy Screen");
        try {
            loginPage.verifyNavigationForPrivacyPolicy();
            test.pass("Privacy policy screen has been launched successfully");
        } catch (Exception e) {
            test.fail("unexpected error: " + e.getMessage());
//test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
            // test.fail("message", MediaEntityBuilder.createScreenCaptureFromPath("." + captureScreenShot(appiumDriver)).build());
        }
        test.log(Status.PASS, "User is about to navigate to Terms and Conditions link");
        test.info("Capturing fields on Terms And Conditions Screen");
        try {
            loginPage.verifyNavigationForTermsAndConditions();
            test.pass("Terms And Conditions screen has been launched successfully");
        } catch (Exception e) {
            test.fail("unexpected error: " + e.getMessage());
            //  test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
            // test.fail("message", MediaEntityBuilder.createScreenCaptureFromPath("." + captureScreenShot(appiumDriver)).build());
        }
    }

    @Test
    public void toolTip() throws IOException {

//        ExtentTest test = extent.createTest("test:dc4d2ac2a33d07ab169e0b722cd16488").assignAuthor("Rajeshwari.prem@ascendum.com");
//        test.log(Status.PASS, "Verification Of tool tip when user leaves the fields blank");
//        test.info("Capturing fields on Login screen Screen");
        try {
            loginPage.beforeLogin();
            loginPage.ToolTips();
//            test.pass("Tool tip has been shown successfully");
//            test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
//            String screenShot = Util.getScreenShot(Math.random() + ".jpg");
//            test.pass("message", MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());

        } catch (Exception e) {
            test.fail("unexpected error: " + e.getMessage());
//            test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
//            String screenShot = Util.getScreenShot(Math.random() + ".jpg");
            //test.fail("message", MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
        }
    }

    @Test
    public void verifyInvalidUserNameOrPasswordError()
    {
        loginPage.beforeLogin();
        loginPage.invalidUsernameOrPwdError();
    }

    @Test
    public void verifyLicensingDetails()
    {
        loginPage.beforeLogin();
        loginPage.verifyNavigationForTermsAndConditions();
        loginPage.verifyNavigationForLicensingDetailsLink();
    }
}
