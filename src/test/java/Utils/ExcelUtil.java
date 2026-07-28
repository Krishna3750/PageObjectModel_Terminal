package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil
{
    public List<List<String>> getExcelData(String path,String sheetName,String testcase) throws IOException
    {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        List<List<String>> data = new ArrayList<>();

        for(int i=1;i<=rows;i++)
        {
            Row row = sheet.getRow(i);
            if(row==null)
            {
                continue;
            }

            Cell testCaseCell = row.getCell(0);
            if(testCaseCell==null || testCaseCell.toString().trim().isEmpty())
            {
                continue;
            }

            if(testcase.equals(testCaseCell.toString()))
            {
                List<String> rowData = new ArrayList<>();
                for(int j=1;j<cols;j++)
                {
                    Cell cell = row.getCell(j);
                    if(cell!=null && !cell.toString().trim().isEmpty())
                    {
                        rowData.add(cell.toString());
                    }
                }
                data.add(rowData);
                System.out.println(rowData);
            }
        }


        workbook.close();
        fis.close();
        return data;
    }
}
