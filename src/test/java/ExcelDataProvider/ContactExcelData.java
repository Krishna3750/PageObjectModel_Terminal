package ExcelDataProvider;

import Utils.ExcelUtil;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class ContactExcelData
{
    @DataProvider(name = "Add Contact")
    public Object[][] addContact_ExcelData() throws IOException
    {
        String path = System.getProperty("user.dir")+"/Excel Data Driven/ExcelData.xlsx";
        String sheetName = "Contact";
        String testcase = "AddContact";

        ExcelUtil excelUtil = new ExcelUtil();
        List<List<String>> list = excelUtil.getExcelData(path,sheetName,testcase);

        Object[][] data = new Object[list.size()][];

        for(int i=0;i<list.size();i++)
        {
            data[i] = list.get(i).toArray();
        }
        return data;
    }

    @DataProvider(name = "Edit Contact")
    public Object[][] editContact_ExcelData() throws IOException
    {
        String path = System.getProperty("user.dir")+"/Excel Data Driven/ExcelData.xlsx";
        String sheetName = "Contact";
        String testcase = "EditContact";

        ExcelUtil excelUtil = new ExcelUtil();
        List<List<String>> list = excelUtil.getExcelData(path,sheetName,testcase);

        Object[][] data = new Object[list.size()][];

        for(int i=0;i<list.size();i++)
        {
            data[i] = list.get(i).toArray();
        }
        return data;
    }

    @DataProvider(name = "Delete Contact")
    public Object[][] deleteContact_ExcelData() throws IOException
    {
        String path = System.getProperty("user.dir")+"/Excel Data Driven/ExcelData.xlsx";
        String sheetName = "Contact";
        String testcase = "DeleteContact";

        ExcelUtil excelUtil = new ExcelUtil();
        List<List<String>> list = excelUtil.getExcelData(path,sheetName,testcase);

        Object[][] data = new Object[list.size()][];

        for(int i=0;i<list.size();i++)
        {
            data[i] = list.get(i).toArray();
        }
        return data;
    }
}
