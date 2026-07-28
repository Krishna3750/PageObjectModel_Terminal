package Pages;

import Base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class PhotoPage extends BaseTest
{
   public AndroidDriver driver;

   public PhotoPage(AndroidDriver driver)
   {
       super(driver);
       PageFactory.initElements(new AppiumFieldDecorator(driver),this);
   }

   By letsGo = By.id("com.google.android.apps.photos:id/onboarding_action_button");
   By allow = By.id("com.android.permissioncontroller:id/permission_allow_button");
   By photo = By.xpath("//android.support.v7.widget.RecyclerView[@index='0']/child::android.widget.ImageView[@index='3']");

   public void clickLetsGo()
   {
      waitUtil.waitForVisible(letsGo).click();
   }

   public void clickAllow()
   {
      waitUtil.checkForAlert();
   }

   public void performLongPressPhoto()
   {
      gestureUtil.longPress(waitUtil.waitForVisible(photo));
   }

   public void performSingleTapPhoto()
   {
      gestureUtil.singleTap((waitUtil.waitForVisible(photo)));
   }

   public void performDoubleTap(int x,int y)
   {
      gestureUtil.doubleTap(x,y);
   }

   public void performSwipePhoto(int x1,int y1,int x2,int y2)
   {
      gestureUtil.swipe(x1,y1,x2,y2);
   }

   public void performZoomInPhoto(int x,int y,int x1,int y1,int x2,int y2)
   {
      gestureUtil.zoomIn(x,y,x1,y1,x2,y2);
   }

   public void performZoomOutPhoto(int x,int y,int x1,int y1,int x2,int y2)
   {
      gestureUtil.zoomOut(x,y,x1,y1,x2,y2);
   }

   public void performDragAndDrop(int x1,int y1,int x2,int y2)
   {
      gestureUtil.dragAndDrop(x1,y1,x2,y2);
   }
}
