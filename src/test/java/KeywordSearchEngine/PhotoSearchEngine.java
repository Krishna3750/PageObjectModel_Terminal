package KeywordSearchEngine;

import Pages.PhotoPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class PhotoSearchEngine
{
    public AndroidDriver driver;
    public PhotoSearchEngine(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public void execute_Actions(String keyword) throws InterruptedException
    {
        PhotoPage photoPage = new PhotoPage(driver);
        switch(keyword)
        {
            case "Lets go" : photoPage.clickLetsGo();
            break;

            case "Allow" : photoPage.clickAllow();
            break;

            case "Long press photo" : photoPage.performLongPressPhoto();
            System.out.println("Long Press executed");
            break;

            case "Single tap photo" : photoPage.performSingleTapPhoto();
            System.out.println("Single Tap executed");
            break;

            case "Double tap photo" : photoPage.performDoubleTap(518,1180);
            Thread.sleep(2000);
            System.out.println("Double Tap executed");
            break;

            case "Swipe left photo" : photoPage.performSwipePhoto(120,1226,995,1120);
            Thread.sleep(2000);
            System.out.println("Swipe Left executed");
            break;

            case "Swipe right photo" : photoPage.performSwipePhoto(1041,1189,65,1184);
            Thread.sleep(2000);
            System.out.println("Swipe Right executed");
            break;

            case "Swipe up photo" : photoPage.performSwipePhoto(495,2096,458,389);
            Thread.sleep(2000);
            System.out.println("Swipe Up executed");
            break;

            case "Swipe down photo" : photoPage.performSwipePhoto(458,389,495,2096);
            Thread.sleep(2000);
            System.out.println("Swipe Down executed");
            break;

            case "Zoom in photo" : photoPage.performZoomInPhoto(527,1221,500,352,495,2125);
            Thread.sleep(2000);
            System.out.println("Zoom In executed");
            break;

            case "Zoom out photo" : photoPage.performZoomOutPhoto(527,1221,500,352,495,2125);
            Assert.assertTrue(false);
            Thread.sleep(2000);
            System.out.println("Zoom Out executed");
            break;
        }
    }
}
