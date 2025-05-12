package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadLoginExcel {
	FileInputStream stream = null;
	
	public FileInputStream connectExcelFile() {
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\Excel\\LoginData.xlsx";
		File excelLoginFile = new File(filePath);
		try {
			if(excelLoginFile.exists()) {
				stream = new FileInputStream(excelLoginFile);
			}
			else {
				System.out.println("File Not Exist");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error occupied "+e.getMessage());
		}
		
		return stream;
	}
	
	public Object[][] getExcelLoginData() throws IOException {
		stream = connectExcelFile();
		
		XSSFWorkbook workBook = new XSSFWorkbook(stream);
		XSSFSheet loginSheet = workBook.getSheetAt(0);
		
		int nRows = loginSheet.getLastRowNum() + 1;
		int nCols = 3;
		
		Object[][] excelData = new Object[nRows][nCols];
		for(int i = 0 ; i < nRows ; ++i) {
			XSSFRow row = loginSheet.getRow(i);
			for(int j = 0 ; j < nCols;++j) {
				excelData[i][j] = row.getCell(j).toString();
			}
		}
	

		workBook.close();
		
		return excelData;
	}
	
}
