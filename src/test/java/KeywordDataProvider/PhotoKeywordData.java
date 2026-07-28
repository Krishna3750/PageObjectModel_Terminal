package KeywordDataProvider;

import Utils.KeywordUtil;
import java.io.IOException;
import java.util.List;

public class PhotoKeywordData
{
    public List<String> pressActions_KeywordData() throws IOException
    {
        KeywordUtil keywordUtil = new KeywordUtil();
        String path = System.getProperty("user.dir")+"/Keyword Data Driven/KeywordData.xlsx";
        String sheetName = "Photos";
        String columnName = "Press Actions";
        return keywordUtil.getKeywordData(path,sheetName,columnName);
    }

    public List<String> moveActions_KeywordData() throws IOException
    {
        KeywordUtil keywordUtil = new KeywordUtil();
        String path = System.getProperty("user.dir")+"/Keyword Data Driven/KeywordData.xlsx";
        String sheetName = "Photos";
        String columnName = "Move Actions";
        return keywordUtil.getKeywordData(path,sheetName,columnName);
    }
}
