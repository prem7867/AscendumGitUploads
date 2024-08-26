package test.java;

import main.java.baseFiles.BaseActions;

import main.java.baseFiles.TestBase;
import main.java.pages.LoginPage;
import org.testng.annotations.Test;


import java.io.IOException;

public class LoginPage_Tests extends TestBase {

    LoginPage loginPage = new LoginPage();
    BaseActions baseActions = new BaseActions();

    public LoginPage_Tests() throws IOException {
    }

    @Test
    public void verifyLicensingDetails_249() {
        loginPage.beforeLogin();
        loginPage.verifyNavigationForTermsAndConditions_249();
        loginPage.verifyNavigationForLicensingDetailsLink_249();

    }

    @Test
    public void verifyInvalidUserNameOrPasswordError() {
        loginPage.beforeLogin();
        loginPage.invalidUsernameOrPwdError_247();

    }

    @Test
    public void verifyFields_247() throws IOException {
//        ExtentTest test = extent.createTest("Verify login fields").assignAuthor("Rajeshwari.prem@ascendum.com");
//        test.log(Status.PASS, "Launching the application - before login feature");
//        test.info("Capturing fields on login screen");
//        try {
        loginPage.beforeLogin();
        loginPage.verifyLoginFields_247();
//            test.pass("Login screen fields are all correct");
//        } catch (Exception e) {
//            test.fail("unexpected error: " + e.getMessage());
        //test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
        // test.fail("message", MediaEntityBuilder.createScreenCaptureFromPath("." + captureScreenShot(appiumDriver)).build());

    }


    // @Test(priority = 2)
    @Test
    public void verifyNavigationToPrivacyPolicyAndTermsAndConditions_249() {

//        ExtentTest test = extent.createTest("01.6 Validate the 'Terms and Conditions' and 'Privacy Policy' links #253").assignAuthor("Rajeshwari.prem@ascendum.com");
//        test.log(Status.PASS, "User is about to navigate to privacy policy screen");
//        test.info("Capturing fields on Privacy Policy Screen");
//        try {
        loginPage.beforeLogin();
        loginPage.verifyNavigationForPrivacyPolicy_249();
        //test.pass("Privacy policy screen has been launched successfully");
//        } catch (Exception e) {
//            test.fail("unexpected error: " + e.getMessage());
//test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
        // test.fail("message", MediaEntityBuilder.createScreenCaptureFromPath("." + captureScreenShot(appiumDriver)).build());
//        }
//        test.log(Status.PASS, "User is about to navigate to Terms and Conditions link");
//        test.info("Capturing fields on Terms And Conditions Screen");
//        try {
        loginPage.beforeLogin();
        loginPage.verifyNavigationForTermsAndConditions_249();
        //  test.pass("Terms And Conditions screen has been launched successfully");
//        } catch (Exception e) {
//            test.fail("unexpected error: " + e.getMessage());
        //  test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
        // test.fail("message", MediaEntityBuilder.createScreenCaptureFromPath("." + captureScreenShot(appiumDriver)).build());
        //   }
    }

    //@Test(priority = 3)
    @Test
    public void toolTip_247() throws IOException {

//        ExtentTest test = extent.createTest("test:dc4d2ac2a33d07ab169e0b722cd16488").assignAuthor("Rajeshwari.prem@ascendum.com");
//        test.log(Status.PASS, "Verification Of tool tip when user leaves the fields blank");
//        test.info("Capturing fields on Login screen Screen");
//        try {
        loginPage.beforeLogin();
        loginPage.ToolTips_247();
//            test.pass("Tool tip has been shown successfully");
//            test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
//            String screenShot = Util.getScreenShot(Math.random() + ".jpg");
//            test.pass("message", MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());

//        } catch (Exception e) {
//            test.fail("unexpected error: " + e.getMessage());
//            test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
//            String screenShot = Util.getScreenShot(Math.random() + ".jpg");
        //test.fail("message", MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
        //}
    }


//    @Test
//    public void verifyLicensingDetails()
//    {
//        loginPage.beforeLogin();
//        //loginPage.verifyNavigationForTermsAndConditions();
//        loginPage.verifyNavigationForLicensingDetailsLink();
//    }
}