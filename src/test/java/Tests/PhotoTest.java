package Tests;

import Base.BaseClass;
import KeywordDataProvider.PhotoKeywordData;
import KeywordSearchEngine.PhotoSearchEngine;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class PhotoTest extends BaseClass
{
    @Test(description = "PressActions")
    public void test_PressActions() throws IOException, InterruptedException
    {
        PhotoSearchEngine photoSearchEngine = new PhotoSearchEngine(driver);
        PhotoKeywordData photoKeywordData = new PhotoKeywordData();

        List<String> keyword = photoKeywordData.pressActions_KeywordData();
        for(String key : keyword)
        {
            photoSearchEngine.execute_Actions(key);
        }
    }

    @Test(description = "MoveActions")
    public void test_MoveActions() throws IOException, InterruptedException
    {
        PhotoSearchEngine photoSearchEngine = new PhotoSearchEngine(driver);
        PhotoKeywordData photoKeywordData = new PhotoKeywordData();

        List<String> keyword = photoKeywordData.moveActions_KeywordData();
        for(String key : keyword)
        {
            photoSearchEngine.execute_Actions(key);
        }
    }
}
