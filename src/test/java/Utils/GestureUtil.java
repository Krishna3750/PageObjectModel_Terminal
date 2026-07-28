package Utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class GestureUtil
{
    public AndroidDriver driver;
    public GestureUtil(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public int element_Center_CoordinateX(WebElement element)
    {
        int width = element.getRect().getWidth();
        int x = element.getRect().getX();
        return (int)(x+(width/2));
    }

    public int element_Center_CoordinateY(WebElement element)
    {
        int height = element.getRect().getHeight();
        int y = element.getRect().getY();
        return (int)(y+(height/2));
    }

    public void singleTap(WebElement element)
    {
        int centerX = element_Center_CoordinateX(element);
        int centerY = element_Center_CoordinateY(element);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence seq = new Sequence(finger,0);

        seq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),centerX,centerY));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(new Pause(finger, Duration.ofMillis(300)));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(seq));
    }

    public void doubleTap(int x,int y)
    {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence seq = new Sequence(finger,0);

        seq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),x,y));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        seq.addAction(new Pause(finger,Duration.ofMillis(300)));

        seq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),x,y));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singleton(seq));
    }

    public void longPress(WebElement element)
    {
        int centerX = element_Center_CoordinateX(element);
        int centerY = element_Center_CoordinateY(element);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence seq = new Sequence(finger,0);

        seq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),centerX,centerY));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(new Pause(finger,Duration.ofSeconds(10)));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(seq));
    }

    public void swipe(int x1,int y1,int x2,int y2)
    {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence seq = new Sequence(finger,0);

        seq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),x1,y1));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(new Pause(finger,Duration.ofMillis(300)));
        seq.addAction(finger.createPointerMove(Duration.ofMillis(2000),PointerInput.Origin.viewport(),x2,y2));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singleton(seq));
    }

    public void zoomIn(int x,int y,int x1,int y1,int x2,int y2)
    {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence seq1 = new Sequence(finger1,0);

        seq1.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),x,y));
        seq1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq1.addAction(new Pause(finger1,Duration.ofMillis(300)));
        seq1.addAction(finger1.createPointerMove(Duration.ofMillis(2000),PointerInput.Origin.viewport(),x1,y1));
        seq1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH,"finger2");
        Sequence seq2 = new Sequence(finger2,0);

        seq2.addAction(finger2.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),x,y));
        seq2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq2.addAction(new Pause(finger2,Duration.ofMillis(300)));
        seq2.addAction(finger2.createPointerMove(Duration.ofMillis(2000),PointerInput.Origin.viewport(),x2,y2));
        seq2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(seq1,seq2));
    }

    public void zoomOut(int x,int y,int x1,int y1,int x2,int y2)
    {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence seq1 = new Sequence(finger1,0);

        seq1.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),x1,y1));
        seq1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq1.addAction(new Pause(finger1,Duration.ofMillis(300)));
        seq1.addAction(finger1.createPointerMove(Duration.ofMillis(2000),PointerInput.Origin.viewport(),x,y));
        seq1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH,"finger2");
        Sequence seq2 = new Sequence(finger2,0);

        seq2.addAction(finger2.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),x2,y2));
        seq2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq2.addAction(new Pause(finger2,Duration.ofMillis(300)));
        seq2.addAction(finger2.createPointerMove(Duration.ofMillis(2000),PointerInput.Origin.viewport(),x,y));
        seq2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(seq1,seq2));
    }

    public void dragAndDrop(int x1,int y1,int x2,int y2)
    {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence seq = new Sequence(finger,0);

        seq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),x1,y1));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(new Pause(finger,Duration.ofSeconds(10)));
        seq.addAction(finger.createPointerMove(Duration.ofMillis(1500),PointerInput.Origin.viewport(),x2,y2));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singleton(seq));
    }
}
