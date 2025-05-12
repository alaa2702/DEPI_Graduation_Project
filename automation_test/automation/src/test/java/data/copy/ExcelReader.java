package data.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public FileInputStream stream = null;
	
	public FileInputStream connectExcelFile() {
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.xlsx";
		System.out.println(filePath);
		File srcFile = new File(filePath);
		if(srcFile.exists()) {
			try {
				stream = new FileInputStream(srcFile);
			} catch (FileNotFoundException e) {
				System.out.println("Error Occupied "+e.getMessage());
			}
		}
		else {
			System.out.println("File not exist");
		}
		
		return stream;
	}
	
	public Object[][] getExcelData() throws IOException{
		stream = connectExcelFile();
		
		XSSFWorkbook workBook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		int nRows = sheet.getLastRowNum() + 1;
		int nCols = 2;
		
		Object[][] excelData = new Object[nRows][nCols];
		
		for(int i = 0 ; i < nRows;++i) {
			for(int j = 0;j< nCols; ++j) {
				XSSFRow row = sheet.getRow(i);
				excelData[i][j] = row.getCell(j);
			}
		}
		workBook.close();
		return excelData;
	}
	
}
