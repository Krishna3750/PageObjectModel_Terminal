package KeywordDataProvider;

import Utils.KeywordUtil;
import java.io.IOException;
import java.util.List;

public class ContactKeywordData
{
    public List<String> addContact_KeywordData() throws IOException
    {
        String path = System.getProperty("user.dir")+"/Keyword Data Driven/KeywordData.xlsx";
        String sheetName = "Contact";
        String columnName = "Add Contact";
        KeywordUtil keywordUtil = new KeywordUtil();
        return keywordUtil.getKeywordData(path,sheetName,columnName);
    }

    public List<String> editContact_KeywordData() throws IOException {
        String path = System.getProperty("user.dir")+"/Keyword Data Driven/KeywordData.xlsx";
        String sheetName = "Contact";
        String columnName = "Edit Contact";
        KeywordUtil keywordUtil = new KeywordUtil();
        return keywordUtil.getKeywordData(path,sheetName,columnName);
    }

    public List<String> deleteContact_KeywordData() throws IOException
    {
        String path = System.getProperty("user.dir")+"/Keyword Data Driven/KeywordData.xlsx";
        String sheetName = "Contact";
        String columnName = "Delete Contact";
        KeywordUtil keywordUtil = new KeywordUtil();
        return keywordUtil.getKeywordData(path,sheetName,columnName);
    }
}
