package main.java.baseFiles;

import main.java.Locators.BLEDetailsScreen;
import main.java.Locators.LandingScreen;
import main.java.Locators.LoginScreen;
import main.java.Locators.PopUps;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import main.java.baseFiles.TestBase;
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

public class BaseActions extends TestBase {

    LandingScreen landingScreen = new LandingScreen();
    BLEDetailsScreen blueToothDetailsScreen = new BLEDetailsScreen();
    LoginScreen loginScreen = new LoginScreen();




    PopUps popUps = new PopUps();

    public void waitForLoadingSymbolToDisappear(WebElement loader) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOf(loader));
        log.info("Waiting for the " + loader + " to appear");
        wait.until(ExpectedConditions.invisibilityOf(loader));
        log.info("Waiting for the " + loader + " to disapper");
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

    public Boolean isElementIsDisplayed(By locator)
    {
        Boolean isElementDisplayed = appiumDriver.findElements(locator).size()>0;
        log.info("'"+locator + "' is displayed");
        return isElementDisplayed;
    }

    public void waitForElementToBeClickable(By Locator)
    {
        new WebDriverWait(appiumDriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Locator));
        log.info("Waiting for the " + Locator + " to be clickable");
    }

    public void waitForElementToVisible(By Locator)
    {
        new WebDriverWait(appiumDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(appiumDriver.findElement(Locator)));
        log.info("Waiting for the " + Locator + " to be visible");
    }


    // Method to fetch the retrieved text
    public String getText(By locator) {
        final String elementText = appiumDriver.findElement(locator).getText();
        log.info("'"+ elementText +"' - Is the text available for the locator = '" +locator +"'");
        return elementText;
    }

    // Method to fetch the retrieved text
    public String getAttribute(By locator) {
        final String elementText = appiumDriver.findElement(locator).getAttribute("content-desc");
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
        String actualText = getText(locator);
        log.info("'"+ actualText +"' - Is the text available for the locator = '" +locator +"'");
        Assert.assertEquals(actualText, expectedText);
        log.info(actualText + " and " + expectedText + " both are equal.");
        return actualText;
    }

    public String compareTextByAttribute(By locator, String actualText, String expectedText)
    {
        actualText = appiumDriver.findElement(locator).getAttribute("content-desc");
        log.info("'"+ actualText +"' - Is the text available for the locator = '" +locator +"'");
        Assert.assertEquals(actualText, expectedText);
        return actualText;
    }


    protected void javaScriptScrollIntoElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        log.info("Scrolls to the element i.e: " + element);
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
            isElementIsDisplayed(popUps.content);
            isElementIsDisplayed(popUps.scrollView);
            isElementIsDisplayed(popUps.grantSingleton);
            tryAllowButtonFirst();
            tryAllowWhileUsingApp();
       }
        catch (Exception e)
        {
            e.getCause();
            log.error(e.getMessage());
        }
        tryAllowButtonSecondTime();
    }

    public void tryAllowButtonFirst()
    {
        isElementIsDisplayed(popUps.content);
        isElementIsDisplayed(popUps.scrollView);
        isElementIsDisplayed(popUps.grantSingleton);
        try
        {
            isElementIsDisplayed(popUps.grantDialog);
            appiumDriver.findElement(popUps.allowButton).click();
            log.info("Clicked on allow button");
        }
        catch (Exception e)
        {
            log.info(e.getMessage());
        }
    }

        public void tryAllowWhileUsingApp()
        {
            try{
                isElementIsDisplayed(popUps.grantDialog);
                appiumDriver.findElement(popUps.whileUsingApp).click();
                log.info("Clicked on While Using App button");
            }
            catch(Exception e)
            {
                log.info(e.getMessage());
            }
        }

        public void tryAllowButtonSecondTime()
        {
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
        URL url = new URL("http://127.0.0.1:4728/wd/hub");
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

    public List<WebElement> getElementWithByLocator(By elementName) {

        return appiumDriver.findElements(elementName);
    }

    public void clearData(By targetWebelement) {
        JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
        js.executeScript("arguments[0].value= ''", appiumDriver.findElement(targetWebelement));
    }

    public void verifySuccessfullLogin()
    {
        try
        {
            verifyInitialPopUp();
        }
        catch (Exception e)
        {
            log.info(e.getMessage());
        }
        click(landingScreen.userProfileIcon);
        Assert.assertTrue(appiumDriver.findElement(landingScreen.logout).isDisplayed());
    }

    //Check for refresh icon and click
    public void checkNetworkAndclickRefreshIcon()
    {
        try
        {
            if(isElementIsDisplayed(loginScreen.refreshIcon)) {
                click(loginScreen.refreshIcon);
            }
            else if(isElementIsDisplayed(loginScreen.noNetworkRefreshIcon))
            {
                click(loginScreen.noNetworkRefreshIcon);
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}