package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class ForgotPasswordOutlookLogin {
    public static void main(String[] args) throws Exception {
        DriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\Users\\Rajeshwari.Prem\\Downloads\\chromedriver\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
        WebDriver driver = new ChromeDriver((ChromeDriverService) service);
        System.out.println("Successfully opened the website www.outlook.com");


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajeshwari.Prem\\Downloads\\chromedriver\\chromedriver.exe");
        driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=158&ct=1724027287&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26deeplink%3dowa%252f%26RpsCsrfState%3d6c8356fc-ac46-ae77-2cab-3e3c7e3db6ea&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.name("loginfmt"))).sendKeys("rajeshwari.prem@ascendum.com");
        driver.findElement(By.xpath("//button[@id='idSIButton9']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.name("passwd"))).sendKeys("HareKrishna*786");
        driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='row text-title']"))));
            if (driver.findElement(By.xpath("//div[@class='row text-title']")).isDisplayed()) {
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.name("DontShowAgain")))).click();
                new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("idBtn_Back")))).click();
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        // }

        //************************************************************/

        // public void enterText_SerachBox()
        // {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='topSearchInput']")));
        driver.findElement(By.xpath("//input[@id='topSearchInput']")).sendKeys("support@devcpisimplifi.com");
        driver.findElement(By.xpath("//input[@id='topSearchInput']")).sendKeys(Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='groupHeaderAll results']/following-sibling::div")));
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='groupHeaderAll results']/following-sibling::div")));
        driver.findElement(By.xpath("//*[@id='groupHeaderTop results']/following-sibling::div")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Your password reset code is')]")));
        String code = driver.findElement(By.xpath("//div[contains(text(), 'Your password reset code is')]")).getText();
        String str = code;
        String subStr = str.substring(27, 34);
        System.out.println(subStr);

            // Creating an instance of file
            Path path
                    = Paths.get("C:\\Users\\Rajeshwari.Prem\\substring.txt");

            // Custom string as an input
            // Try block to check for exceptions
            try {
                // Now calling Files.writeString() method
                // with path , content & standard charsets
                Files.writeString(path, subStr,
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