package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class KeywordUtil
{
    public List<String> getKeywordData(String path,String sheetName,String columnName) throws IOException
    {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        List<String> data = new ArrayList<>();
        int column=0;

        for(int i=0;i<=rows;i++)
        {
            Row row = sheet.getRow(i);
            if(row==null)
            {
                continue;
            }

            for(int j=0;j<cols;j++)
            {
                Cell cell = row.getCell(j);
                if(cell==null || cell.toString().trim().isEmpty())
                {
                    continue;
                }
                if(columnName.equals(cell.toString()))
                {
                    column = j;
                    break;
                }
            }
        }

        for(int i=1;i<=rows;i++)
        {
            Row row = sheet.getRow(i);
            if(row==null)
            {
                continue;
            }

            Cell cell = row.getCell(column);
            if(cell!=null && !cell.toString().trim().isEmpty())
            {
                data.add(cell.toString());
            }
        }

        System.out.println(data);
        workbook.close();
        fis.close();
        return data;
    }
}
