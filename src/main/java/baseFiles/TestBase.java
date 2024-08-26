package main.java.baseFiles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.ExtentManager;
import utils.ExtentReport;
import utils.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

import static utils.Util.getScreenShot;
import static utils.Util.takeScreenShot;

public class TestBase {

    public static Properties properties;
    public static BufferedReader reader;

    public static ExtentReports extent = new ExtentReports();
    public static ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport1.html");
    public static   ExtentTest extentTest;
    public static AppiumDriver appiumDriver;
    static String getError;


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

    @BeforeMethod
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
               // appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (properties.getProperty("platformName").equalsIgnoreCase("Android")) {
            {
                reuseAndroidCapabilities();
            }
        }
    }
//
//    @BeforeMethod
//    public void setUpSparkTest(ITestResult result)
//    {
//        ExtentTest test = ExtentManager.getInstanceOf().createTest(result.getMethod().getMethodName()).assignAuthor("Rajeshwari.prem@ascendum.com");
//        ExtentReport.setTest(test);
//    }

    @AfterMethod
    public static void tearDown(ITestResult result) throws IOException {
        ExtentTest test = ExtentManager.getInstanceOf().createTest(result.getMethod().getMethodName()).assignAuthor("Rajeshwari.prem@ascendum.com");
        ExtentReport.setTest(test);
        String path = null;
       try {

           if (ITestResult.FAILURE == result.getStatus()) {
               //test.log(Status.FAIL, "Verification Of tool tip when user leaves the fields blank");
//               test.info("Capturing fields on Login screen Screen");
//               test.fail("Tool tip has been shown successfully");
               String screenShot = Util.getScreenShot(Math.random() + ".jpg");
               test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShot()).build());
               test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
               test.log(Status.FAIL, "test failed as : " + result.getThrowable());
               test.log(Status.FAIL, "test failed as : " + result.getThrowable());
               getError = String.valueOf(result.getThrowable());
               log.info( "test failed as : " + getError);
               writeErrorToFile();
           } else if (ITestResult.SUCCESS == result.getStatus()) {
               log.info("The testcase " + result.getName() + " has been completed the execution with the status as " + result.getStatus());
               test.log(Status.PASS, "Verification has failed");
               String passedScreenShot = Util.getScreenShot(result.getMethod().getMethodName() + ".jpg");
               ExtentReport.getTest().addScreenCaptureFromPath(Util.getScreenShot(result.getMethod().getMethodName()))
                       .pass(MediaEntityBuilder.createScreenCaptureFromPath(passedScreenShot).build());
               test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShot()).build());
               test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(passedScreenShot).build());
           }
       }

           catch (Exception e) {
                   System.out.println("Exception while taking screenshot " + e.getMessage());
                   test.fail("message", MediaEntityBuilder.createScreenCaptureFromPath("." + getScreenShot(result.getMethod().getMethodName())).build());
               }
       appiumDriver.quit();
    }

    @AfterSuite
    public void sparkFlush()
    {
        ExtentManager.getInstanceOf().flush();
    }


    public void reuseAndroidCapabilities() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "appium");
        cap.setCapability("deviceName", "android");
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceOrientation", "Portrait");
        cap.setCapability("platformVersion", "14.0");
        cap.setCapability("app", "C:\\Users\\Rajeshwari.Prem\\Downloads\\app-release-1.0.34.apk");
        // cap.setCapability("appPackage", "com.android.settings");
        //cap.setCapability("appActivity", "com.android.settings.Settings");
        cap.setCapability("noReset", "false");
        URL url = new URL("http://127.0.0.1:4728/wd/hub");
        appiumDriver = new AndroidDriver(url, cap);
    }

    @AfterTest
    public void tearDown()
    {
        //appiumDriver.quit();
    }


    public static void writeErrorToFile()
    {// Creating an instance of file
        Path path
                = Paths.get(System.getProperty("user.dir") + "/src/main/resources/ErrorLogs.txt");

        // Custom string as an input
        String str
                = getError;

        // Try block to check for exceptions
        try {
            // Now calling Files.writeString() method
            // with path , content & standard charsets
            Files.writeString(path, str,
                    StandardCharsets.UTF_8);
        }

        // Catch block to handle the exception
        catch (IOException ex) {
            // Print messqage exception occurred as
            // invalid. directory local path is passed
            System.out.print("Invalid Path");
        }
    }
}