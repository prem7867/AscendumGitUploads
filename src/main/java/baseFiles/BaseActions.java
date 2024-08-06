package baseFiles;

import Locators.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class
BaseActions extends TestBase {

    LandingScreen landingScreen = new LandingScreen();
    BlueToothDetailsScreen blueToothDetailsScreen = new BlueToothDetailsScreen();
    LoginScreen loginScreen = new LoginScreen();


    PopUps popUps = new PopUps();

    public void waitForLoadingSymbolToDisappear(WebElement loader) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOf(loader)); // wait for loader to appear
        wait.until(ExpectedConditions.invisibilityOf(loader)); // wait for loader to disappear
    }

    public void click(By locator)
    {
        appiumDriver.findElement(locator).click();
        log.info("The '"+locator+"' has been clicked");

    }

    public String enterText(By locator, String enterRequiredData)
    {
        appiumDriver.findElement(locator).sendKeys(enterRequiredData);
        log.info("'"+enterRequiredData+ "' has been entered in the field - '"+locator+"'");
        return enterRequiredData;
    }

    public Boolean verifyElementIsDisplayed(By locator)
    {
        Boolean isElementDisplayed = appiumDriver.findElement(locator).isDisplayed();
        Assert.assertTrue((boolean) isElementDisplayed);
        log.info("'"+locator + "' is displayed");
        return isElementDisplayed;
    }


    // Method to fetch the retrieved text
    public String getText(By locator) {
        final String elementText = appiumDriver.findElement(locator).getText();
        log.info("'"+ elementText +"' - Is the text available for the locator = '" +locator +"'");
        return elementText;
    }

    // Method to fetch the retrieved text
    public String getInnerHTMLValue(By locator) {
        final String elementText = appiumDriver.findElement(locator).getAttribute("text");
        log.info("'"+ elementText +"' - Is the text available for the locator = '" +locator +"'");
        return elementText;
    }

    //Gets the validation message - i.e tool tips on the page
    public String getValidationMessage(By locator) {
        final String elementText = appiumDriver.findElement(locator).getAttribute("validationMessage");
        log.info("'"+ elementText +"' - Is the text available for the locator = '" +locator +"'");
        return elementText;
    }


    public void clickRefreshIcon()
    {
        verifyElementIsDisplayed(landingScreen.refreshIcon);
        click(landingScreen.refreshIcon);

        log.info( verifyElementIsDisplayed(landingScreen.refreshIcon) + "refresh icon is present?");
    }

    public String compareText(By locator, String expectedText)
    {
        String actualError = getText(locator);
        Assert.assertEquals(actualError, expectedText);
        return actualError;

    }


    protected void javaScriptScrollIntoElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToTheElementAndClick( By element) {
        javaScriptScrollIntoElement(appiumDriver.findElement(element));
        appiumDriver.findElement(element).click();
    }

    //Flow Methods
    public void verifyInitialPopUp()
    {
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(5000));
        try
        {
            appiumDriver.findElement(By.id("android:id/content"));
            appiumDriver.findElement(By.xpath("//android.widget.ScrollView"));
            appiumDriver.findElement(By.id("com.android.permissioncontroller:id/grant_singleton"));
            try {
                appiumDriver.findElement(By.id("com.android.permissioncontroller:id/grant_dialog"));
                appiumDriver.findElement(popUps.allowButton).click();
                log.info("Clicked on allow button");
            }
            catch (Exception e)
            {
                log.info(e.getMessage());
            }
            try{
                appiumDriver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.android.permissioncontroller:id/grant_dialog']")).isDisplayed();
                appiumDriver.findElement(popUps.whileUsingApp).click();
                log.info("Clicked on While Using App button");
            }
            catch(Exception e)
            {
                log.info(e.getMessage());
            }
        }
        catch (Exception e)
        {
            e.getCause();
            log.error(e.getMessage());
        }
        try
        {
            appiumDriver.findElement(popUps.allowButton).isDisplayed();
            log.info("Allow button is displayed");
            appiumDriver.findElement(popUps.allowButton).click();
            log.info("Allow button is clicked");
        }
        catch(Exception e) {
            System.out.println(e.getMessage() + "Pop up is not displaying second time");
            log.error(e.getMessage() + "Pop up is not displaying second time");
        }
    }



    // Verify if the element is present and prints the text of the element accordingly
    public void login() {

        click(loginScreen.emailTextField);
        //appiumDriver.hideKeyboard();
        enterText(loginScreen.emailTextField, "demo@cranepi.com");
        click(loginScreen.passwordTextField);
        enterText(loginScreen.passwordTextField, "demo2024@CPI");
        appiumDriver.findElement(loginScreen.signInButton).isEnabled();
        click(loginScreen.signInButton);
    }

    public void getBlueToothAvailableOnLandingScreen(String bluetoothName)
    {
        getText(landingScreen.bluetoothDevicesList);
    }

    public void scrollUp()
    {
        TouchAction action = new TouchAction((PerformsTouchActions) appiumDriver);
        //Using PointOption class to specify the co-ordinates for touch action
        PointOption pointStart = PointOption.point(0,700);
        PointOption pointEnd = PointOption.point(0,100);
        action.press(pointStart).moveTo(pointEnd).release().perform();
        PointOption pointStart1 = PointOption.point(0,800);
        PointOption pointEnd1 = PointOption.point(0,100);
        action.press(pointStart1).moveTo(pointEnd1).release().perform();
    }




    public void signIn()
    {
        //Login section
        WebElement emailTextField = appiumDriver.findElement(By.xpath("//android.webkit.WebView[@text='Signin']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        emailTextField.click();
        emailTextField.sendKeys("demo@cranepi.com");
        //appiumDriver.hideKeyboard();

        //Password
        WebElement passwordTextField = appiumDriver.findElement(By.xpath("//android.webkit.WebView[@text='Signin']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        passwordTextField.click();
        passwordTextField.sendKeys("demo2024@CPI");
        // appiumDriver.hideKeyboard();

        //Sign In button
        WebElement signInButton = appiumDriver.findElement(By.xpath("//android.widget.Button[@text='submit']"));
        System.out.println(signInButton.isEnabled() + "clicked sign in button");
        signInButton.click();
        // appiumDriver.hideKeyboard();
    }

    public String toolTip()
    {
        String toolTipError = getText(loginScreen.toolTipError);
        log.info("**** The following error "+toolTipError+" is displayed for username field ****");
        log.info(appiumDriver.getPageSource());
        if((appiumDriver.getPageSource()).contains("Please fill out this field."))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertFalse(false);
        }
        return toolTipError;
    }


    public void killSettingsApp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "appium");
        cap.setCapability("deviceName", "android");
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceOrientation", "Portrait");
        cap.setCapability("platformVersion", "14.0");
        //cap.setCapability("app", "C:\\Users\\Rajeshwari.Prem\\Downloads\\app-release-1.0.31.apk");
         cap.setCapability("appPackage", "com.android.settings");
        cap.setCapability("appActivity", "com.android.settings.Settings");
        cap.setCapability("noReset", "false");
        URL url = new URL("http://127.0.0.1:4727/wd/hub");
        appiumDriver = new AndroidDriver(url, cap);
    }




    public void popUpAfterBlueToothOff() {
        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, Duration.ofSeconds(30));
        try {
            appiumDriver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.android.permissioncontroller:id/grant_dialog']")).isDisplayed();
            appiumDriver.findElement(popUps.whileUsingApp).click();
            log.info("Clicked on While Using App button");
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        try {
            appiumDriver.findElement(popUps.allowButton).isDisplayed();
            log.info("Allow button is displayed");
            appiumDriver.findElement(popUps.allowButton).click();
            log.info("Allow button is clicked");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Pop up is not displaying second time");
            log.error(e.getMessage() + "Pop up is not displaying second time");
        }


    }


}
