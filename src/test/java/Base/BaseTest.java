package Base;

import Utils.GestureUtil;
import Utils.WaitUtil;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest
{
    public GestureUtil gestureUtil;
    public WaitUtil waitUtil;

    public BaseTest(AndroidDriver driver)
    {
        gestureUtil = new GestureUtil(driver);
        waitUtil = new WaitUtil(driver);
    }
}
