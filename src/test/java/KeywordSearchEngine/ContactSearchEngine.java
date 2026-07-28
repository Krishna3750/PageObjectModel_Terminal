package KeywordSearchEngine;

import Pages.ContactPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class ContactSearchEngine
{
    public AndroidDriver driver;
    ContactPage contactPage;
    public ContactSearchEngine(AndroidDriver driver)
    {
        this.driver = driver;
        contactPage = new ContactPage(driver);
    }

    public void execute_AddContactKeyword(String keyword,String firstName,String lastName,String companyName,String phoneNumber)
    {
        switch(keyword)
        {
            case "ViewContacts" : contactPage.clickViewContacts();
            break;

            case "CreateContact" : contactPage.clickCreateContact();
            break;

            case "FirstName" : contactPage.sendFirstName(firstName);
            break;

            case "LastName" : contactPage.sendLastName(lastName);
            break;

            case "CompanyName" : contactPage.sendCompanyName(companyName);
            break;

            case "PhoneNumber" : contactPage.sendPhone(phoneNumber);
            break;

            case "Save" : contactPage.clickSave();
            break;

            case "VerifyTitle" : String title = firstName+" "+lastName;
            Assert.assertTrue(contactPage.checkTitle(title));
            break;
        }
    }

    public void execute_EditContactKeyword(String keyword,String contact,String firstName,String lastName,String companyName,String phoneNumber)
    {
        switch(keyword)
        {
            case "SearchBar" : contactPage.clickSearchContact();
            break;

            case "SearchContact" : contactPage.sendSearchContactEdit(contact);
            break;

            case "SearchResult" : contactPage.clickSearchContactPhoto();
            break;

            case "EditIcon" : contactPage.clickEditIcon();
            break;

            case "FirstName" : contactPage.sendFirstName(firstName);
            break;

            case "LastName" : contactPage.sendLastName(lastName);
            break;

            case "CompanyName" : contactPage.sendCompanyName(companyName);
            break;

            case "PhoneNumber" : contactPage.sendPhone(phoneNumber);
            break;

            case "Save" : contactPage.clickSave();
            break;

            case "VerifyTitle" : String title = firstName+" "+lastName;
            Assert.assertTrue(contactPage.checkTitle(title));
            break;
        }
    }

    public void execute_DeleteContactKeyword(String keyword,String contact)
    {
        switch(keyword)
        {
            case "SearchBar" : contactPage.clickSearchContact();
            break;

            case "SearchContact" : contactPage.sendSearchContactEdit(contact);
            break;

            case "SearchResult" : contactPage.clickSearchContactPhoto();
            break;

            case "SwipeUp" : contactPage.swipeUpAction();
            break;

            case "DeleteBar" : contactPage.clickDelete();
            break;

            case "MoveToTrash" : contactPage.clickMoveToTrash();
            break;
        }
    }
}
