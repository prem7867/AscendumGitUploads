package baseFiles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentManager;
import utils.ExtentReport;
import utils.Util;

import java.io.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Year;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static Properties properties;
    public static BufferedReader reader;
    public static WebDriver driver;

    public static ExtentReports extent = new ExtentReports();
    public static ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport1.html");
    public static   ExtentTest extentTest;
    public static AppiumDriver appiumDriver;


    public static final Logger log = (Logger) LogManager.getLogger(TestBase.class.getName());
    public static final String propertyFilePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
    public static final String log4jpropertyFilepPath = System.getProperty("user.dir") + "/src/main/resources/log4j2.xml";

    public static DateFormat dateformat = new SimpleDateFormat("dd-MMM-YYYY");
   public static  Calendar cal = Calendar.getInstance();
   public static String timestamp = dateformat.format(cal.getTime());
   public static ExtentTest test;


    public TestBase() {

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
                PropertyConfigurator.configure(log4jpropertyFilepPath);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    @BeforeClass
    public void initializeApp() throws MalformedURLException {
        if (properties.getProperty("platformName").equalsIgnoreCase("iOS")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", "iPhone 13 mini");
            caps.setCapability("platformVersion", "17.1.0");
            caps.setCapability("automationName", "XCUITest");
            try {
                URL url = new URL("http://0.0.0.0:4727/wd/hub");
                appiumDriver = new IOSDriver(url, caps);
                appiumDriver.get("https://qa.cantaloupepayments.com");
                appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
           // ExtentTest test = ExtentManager.getInstanceOf().createTest(result.getMethod().getMethodName())
        } else if (properties.getProperty("platformName").equalsIgnoreCase("Android")) {
            {
                reuseAndroidCapabilities();
//                DesiredCapabilities cap = new DesiredCapabilities();
//                cap.setCapability("automationName", "appium");
//                cap.setCapability("deviceName", "android");
//                cap.setCapability("platformName", "Android");
//                cap.setCapability("deviceOrientation", "Portrait");
//                cap.setCapability("platformVersion", "14.0");
//                cap.setCapability("app", "C:\\Users\\Rajeshwari.Prem\\Downloads\\app-release-1.0.31.apk");
//               // cap.setCapability("appPackage", "com.android.settings");
//                //cap.setCapability("appActivity", "com.android.settings.Settings");
//                cap.setCapability("noReset", "true");
//                URL url = new URL("http://127.0.0.1:4727/wd/hub");
//                appiumDriver = new AndroidDriver(url, cap);
            }
        }
    }

//    @BeforeMethod
//    public void setUpSparkTest(ITestResult result) throws IOException {
//        ExtentTest test = ExtentManager.getInstanceOf().createTest(result.getMethod().getMethodName()).assignAuthor("Rajeshwari.prem@ascendum.com");
//        ExtentReport.setTest(test);
//        test.log(Status.PASS, "Verification Of tool tip when user leaves the fields blank");
//        test.info("Capturing fields on Login screen Screen");
//                    test.pass("Tool tip has been shown successfully");
//            test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
//            String screenShot = Util.getScreenShot(Math.random() + ".jpg");
//            test.pass("message", MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());

  //  }

    @AfterMethod
    public static void tearDown(ITestResult result) throws IOException {
        ExtentTest test = ExtentManager.getInstanceOf().createTest(result.getMethod().getMethodName()).assignAuthor("Rajeshwari.prem@ascendum.com");
        ExtentReport.setTest(test);
        String path = null;
//        File source = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
//        File screenShotLocation = null;
       try {
            if (ITestResult.FAILURE == result.getStatus()) {

//                log.info("The testcase " + result.getName() + " has been completed the execution with the status as " + result.getStatus());
//                path = System.getProperty("user.dir") + "\\src\\main\\resources\\FailedScreenShots\\" + Math.random() + timestamp + ".png";
//                screenShotLocation = new File(path);
//                   FileUtils.copyFile(source, new File(path));
//                log.info("Screenshot captured for the Failed testcase - i.e. "+ result.getName());
//                String failedScreenShot = Util.getScreenShot(result.getMethod().getMethodName()+".jpg");
//
//                ExtentReport.getTest().addScreenCaptureFromPath(Util.getScreenShot(result.getMethod().getMethodName()))
//                        .fail(MediaEntityBuilder.createScreenCaptureFromPath(failedScreenShot).build());
                test.log(Status.FAIL, "Verification Of tool tip when user leaves the fields blank");
                test.info("Capturing fields on Login screen Screen");
                test.pass("Tool tip has been shown successfully");
               // test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
                String screenShot = Util.getScreenShot(Math.random() + ".jpg");
                test.pass("message", MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());




            } else if (ITestResult.SUCCESS == result.getStatus()) {
                log.info("The testcase " + result.getName() + " has been completed the execution with the status as " + result.getStatus());
//                path = System.getProperty("user.dir") + "\\src\\main\\resources\\PassedScreenShots\\" + Math.random() + timestamp + ".png";
//                screenShotLocation = new File(path);
//                   FileUtils.copyFile(source, new File(path));
//                log.info("Screenshot captured for the Passed testcase - i.e  " + result.getName());
//               // test.addScreenCaptureFromPath(captureScreenShot(appiumDriver));
//                String screenShot = Util.getScreenShot(Math.random() + ".jpg");
                test.log(Status.PASS, "Verification has failed");
//                test.info("Capturing fields on Login screen Screen");
//                test.fail("message", MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
//
                String passedScreenShot = Util.getScreenShot(result.getMethod().getMethodName()+".jpg");

                ExtentReport.getTest().addScreenCaptureFromPath(Util.getScreenShot(result.getMethod().getMethodName()))
                        .fail(MediaEntityBuilder.createScreenCaptureFromPath(passedScreenShot).build());


            }
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        appiumDriver.quit();
       // return screenShotLocation.toString();
    }

//    @BeforeTest
//    public void setReport()
//    {
//        spark.config().setTheme(Theme.DARK);
//        spark.config().setDocumentTitle("Gaming Cashless Automation Report");
//        extent.attachReporter(spark);
//    }

    @AfterSuite
    public void afterTest()
    {
        ExtentManager.getInstanceOf().flush();
       // extent.flush();
    }


    public static String captureScreenShot(AppiumDriver appiumDriver) throws IOException {
        File source = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        File screenShotLocation = null;
        try {
            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\PassedScreenShots\\" + Math.random() + ".png";
            screenShotLocation = new File(path);
            String absolutePathLocation = screenShotLocation.getAbsolutePath();
            FileUtils.copyFile(source, new File(path));
            log.info("Screenshot captured for the " + ITestResult.SUCCESS + " testcase");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return screenShotLocation.toString();
    }

    public void reuseAndroidCapabilities() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "appium");
        cap.setCapability("deviceName", "android");
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceOrientation", "Portrait");
        cap.setCapability("platformVersion", "14.0");
        cap.setCapability("app", "C:\\Users\\Rajeshwari.Prem\\Downloads\\app-release-1.0.31.apk");
        // cap.setCapability("appPackage", "com.android.settings");
        //cap.setCapability("appActivity", "com.android.settings.Settings");
        cap.setCapability("noReset", "false");
        URL url = new URL("http://127.0.0.1:4727/wd/hub");
        appiumDriver = new AndroidDriver(url, cap);
    }
}