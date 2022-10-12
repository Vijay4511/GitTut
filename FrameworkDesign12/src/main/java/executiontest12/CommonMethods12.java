package executiontest12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonMethods12 {
	
	
public static ArrayList<String> GetExcelData(String TcName) throws IOException{
		
		ArrayList<String> al = new ArrayList();
			
		String testdatpath = System.getProperty("user.dir")+"\\resources\\SignupData.xlsx";
		
		FileInputStream fis = new FileInputStream(testdatpath);
		
		XSSFWorkbook wbook = new XSSFWorkbook(fis);
		
		XSSFSheet wsheet = wbook.getSheet("Regestration");
		
		Iterator<Row> rows= wsheet.iterator();

		while(rows.hasNext())
		{
			Row specificrow = rows.next();
	
			if(specificrow.getCell(0).getStringCellValue().equalsIgnoreCase(TcName))
			{
				Iterator<Cell> cells = specificrow.iterator();
				
				while(cells.hasNext())
				{
					Cell specificcell =  cells.next();
					
					String str = specificcell.getStringCellValue();
					al.add(str);
				}
			}

		}
		
		wbook.close();
		return al;

	}

	

}
