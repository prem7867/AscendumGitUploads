package test.java;

import main.java.baseFiles.BaseActions;

import main.java.baseFiles.TestBase;
import main.java.pages.ForgotPasswordPage;
import main.java.pages.LoginPage;
import org.testng.annotations.Test;


import java.io.IOException;

public class ForgotPasswordPage_Test extends TestBase {

    LoginPage loginPage = new LoginPage();
    BaseActions baseActions = new BaseActions();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    public ForgotPasswordPage_Test() throws IOException {
    }

    @Test
    public void clickForgotPassword() throws IOException {

        forgotPasswordPage.clickForgoPasswordLink();
        forgotPasswordPage.enterCodeDetails();

    }
}