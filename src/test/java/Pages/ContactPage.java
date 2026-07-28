package Pages;

import Base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends BaseTest
{
    public AndroidDriver driver;
    public ContactPage(AndroidDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    By viewContacts = By.xpath("//android.view.View[@index='1']/child::android.widget.TextView[@text='View contacts']");
    By createContact = By.xpath("//android.view.View[@index='0']/child::android.widget.TextView[@text='Create contact']");
    By firstName = By.xpath("//android.view.View[@index='1']/descendant::android.widget.EditText[@index='0']");
    By lastName = By.xpath("//android.view.View[@index='2']/descendant::android.widget.EditText[@index='0']");
    By company = By.xpath("//android.view.View[@index='3']/descendant::android.widget.EditText[@index='0']");
    By phone = By.xpath("//android.view.View[@index='4']/descendant::android.widget.EditText[@index='0']");
    By save = By.xpath("//android.view.View[@index='0']/child::android.view.View[@index='3']/child::android.widget.Button[@index='1']");
    By title = By.xpath("//android.view.ViewGroup[@index='2']/descendant::android.view.View[@index='0']/child::android.widget.TextView[@index='0']");

    By searchContact = By.id("com.google.android.dialer:id/open_search_bar_text_view");
    By searchContactBox = By.id("com.google.android.dialer:id/open_search_view_edit_text");
    By searchContactPhoto = By.id("com.google.android.dialer:id/photo");
    By editIcon = By.id("com.google.android.contacts:id/menu_insert_or_edit");
    By delete = By.xpath("//android.widget.TextView[@text='Delete']");
    By moveToTrash = By.id("android:id/button1");

    public void clickViewContacts()
    {
        waitUtil.waitForVisible(viewContacts).click();
    }

    public void clickCreateContact()
    {
        waitUtil.waitForClickable(createContact).click();
    }

    public void sendFirstName(String name)
    {
        waitUtil.waitForVisible(firstName).sendKeys(name);
    }

    public void sendLastName(String name)
    {
        waitUtil.waitForClickable(lastName).sendKeys(name);
    }

    public void sendCompanyName(String name)
    {
        waitUtil.waitForClickable(company).clear();
        waitUtil.waitForClickable(company).sendKeys(name);
    }

    public void sendPhone(String phoneNumber)
    {
        waitUtil.waitForVisible(phone).clear();
        waitUtil.waitForVisible(phone).sendKeys(phoneNumber);
    }

    public void clickSave()
    {
        waitUtil.waitForClickable(save).click();
    }

    public boolean checkTitle(String name)
    {
        return waitUtil.checkForTextPresent(title,name);
    }

    public void clickSearchContact()
    {
        waitUtil.waitForClickable(searchContact).click();
    }

    public void sendSearchContactEdit(String contact)
    {
        waitUtil.waitForVisible(searchContactBox).sendKeys(contact);
    }

    public void clickSearchContactPhoto()
    {
        waitUtil.waitForVisible(searchContactPhoto).click();
    }

    public void clickEditIcon()
    {
        waitUtil.waitForClickable(editIcon).click();
    }

    public void swipeUpAction()
    {
        gestureUtil.swipe(490,2336,569,51);
    }

    public void clickDelete()
    {
        waitUtil.waitForVisible(delete).click();
    }

    public void clickMoveToTrash()
    {
        waitUtil.checkForAlert();
    }
}
