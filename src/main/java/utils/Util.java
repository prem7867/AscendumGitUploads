package utils;

import baseFiles.TestBase;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Util extends TestBase {

    public static String getScreenShot(String imageName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) appiumDriver;
        File f = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "./screenShot/"+imageName;
        FileUtils.copyFile(f, new File(filePath));
        return filePath;
    }
}
