package pages;

import baseFiles.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BlueToothAndWifiSettings extends TestBase {

    public void turnBlueToothOn()
    {
        navigateToBlueTooth();
        appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Bluetooth\']")).click();
    }

    public void turnBluetoothOFF()
    {
            navigateToBlueTooth();
            appiumDriver.findElement(By.xpath("//android.widget.Switch[@resource-id=\'android:id/switch_widget\']")).click();
    }
        public void navigateToBlueTooth() {
            System.out.println("Launching Bleutooth");
            appiumDriver.getRemoteAddress().getPath();
            System.out.println("Launching Wifi");
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
            }
        }

        public void wifiSettings()
        {
            log.info("Wifi connection test case has started");
            log.info("Launched the settings app");
            appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Network & internet\']")).click();
            log.info("Clicked on the Network & Internet label under settings tab");
            appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Internet\']")).click();
            log.info("Clicked on the Internet label under Network & Internet menu");
            WebElement serachSRWIFIUnderALLNetwork = appiumDriver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\'com.android.settings:id/recycler_view\']"));
            //serachSRWIFIUnderALLNetwork.click();

           List names =  getElementWithByLocator("//androidx.recyclerview.widget.RecyclerView[@resource-id=\'com.android.settings:id/recycler_view\']");
            //WebElement serachForSRWIFI = appiumDriver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\'com.android.settings:id/recycler_view\']"));
//            String printAllWifiNames = serachForSRWIFI.getText();
            System.out.println(names.get(0));
            if(names.contains("SRWIFI")) {
                WebElement SRWifiName = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'SRWIFI\']"));
                SRWifiName.click();
                appiumDriver.findElement(By.xpath("//android.widget.Button[@resource-id=\'com.android.settings:id/button3\']")).click();
                log.info("Disconnecting the wifi connection");
                WebElement checkConnectText = appiumDriver.findElement(By.xpath("//android.widget.Button[@resource-id=\'com.android.settings:id/button3\']"));
                if((checkConnectText.getText()).equalsIgnoreCase("Connect"))
                {
                    log.info("Wifi has been successfully turned off");
                }

            }



        }

    public List<WebElement> getElementWithByLocator(String elementName) {
        return appiumDriver.findElements(By.xpath(elementName));
    }
}
