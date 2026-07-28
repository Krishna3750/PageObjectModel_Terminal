package Base;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseClass
{
    public static AndroidDriver driver;

    @BeforeClass
    @Parameters({"deviceName","platformName","platformVersion","udid","appPackage","appActivity"})
    public void setUp(String deviceName,String platformName,String platformVersion,String udid,String appPackage,String appActivity) throws MalformedURLException
    {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setPlatformName(platformName);
        options.setPlatformVersion(platformVersion);
        options.setUdid(udid);
        options.setAppPackage(appPackage);
        options.setAppActivity(appActivity);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, options);
    }

    @BeforeMethod
    @Parameters({"appName","appPackage","appActivity"})
    public void resetState(String appName,String appPackage,String appActivity) throws IOException, InterruptedException
    {
        if(appName.equals("Photos"))
        {
            Runtime.getRuntime().exec("adb shell am force-stop " + appPackage).waitFor();
            Runtime.getRuntime().exec("adb shell pm clear " + appPackage).waitFor();
            driver.activateApp(appPackage);
        }
        if(appName.equals("Contact"))
        {
            ((AndroidDriver)driver).startActivity(new Activity(appPackage,appActivity));
        }
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    public static String subFolder;
    public void getScreenshot(String ssName) throws IOException
    {
        if(subFolder==null)
        {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
            subFolder = localDateTime.format(dateTimeFormatter);
        }

        String path = System.getProperty("user.dir")+"/Extent Reports/Screenshots/"+subFolder+"/"+ssName+".jpg";
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);
        FileUtils.copyFile(source,destination);
    }
}
