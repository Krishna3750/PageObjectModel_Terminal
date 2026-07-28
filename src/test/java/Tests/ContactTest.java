package Tests;

import Base.BaseClass;
import ExcelDataProvider.ContactExcelData;
import KeywordDataProvider.ContactKeywordData;
import KeywordSearchEngine.ContactSearchEngine;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactTest extends BaseClass
{
    @Test(dataProvider = "Add Contact",dataProviderClass = ContactExcelData.class,description = "AddContact")
    public void addContactTest(String firstName,String lastName,String companyName,String phoneNumber) throws IOException
    {
        ContactSearchEngine contactSearchEngine = new ContactSearchEngine(driver);
        ContactKeywordData contactKeywordData = new ContactKeywordData();

        List<String> keyword = contactKeywordData.addContact_KeywordData();
        for(String key : keyword)
        {
            contactSearchEngine.execute_AddContactKeyword(key,firstName,lastName,companyName,phoneNumber);
        }
    }

    @Test(dataProvider = "Edit Contact",dataProviderClass = ContactExcelData.class,description = "EditContact")
    public void editContactTest(String contact,String firstName,String lastName,String companyName,String phoneNumber) throws IOException
    {
        ContactKeywordData contactKeywordData = new ContactKeywordData();
        ContactSearchEngine contactSearchEngine = new ContactSearchEngine(driver);

        List<String> keyword = contactKeywordData.editContact_KeywordData();
        for(String key : keyword)
        {
            contactSearchEngine.execute_EditContactKeyword(key,contact,firstName,lastName,companyName,phoneNumber);
        }
    }

    @Test(dataProvider = "Delete Contact",dataProviderClass = ContactExcelData.class,description = "DeleteContact",dependsOnMethods="editContactTest")
    public void deleteContactTest(String contact) throws IOException
    {
        ContactKeywordData contactKeywordData = new ContactKeywordData();
        ContactSearchEngine contactSearchEngine = new ContactSearchEngine(driver);

        List<String> keyword = contactKeywordData.deleteContact_KeywordData();
        for(String key : keyword)
        {
            contactSearchEngine.execute_DeleteContactKeyword(key,contact);
        }
    }
}
