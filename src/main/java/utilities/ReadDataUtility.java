package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataUtility {
	public static String[] getUserDetails(int userId) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata/userdetails.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("UserRegistrationDetails");
		XSSFRow row = sheet.getRow(userId);
		DataFormatter format = new DataFormatter();
		String[] details = new String[row.getLastCellNum()];
		for (int i = 0; i < details.length; i++) {
			details[i] = format.formatCellValue(row.getCell(i));
		}
		workbook.close();
		fis.close();
		return details;
	}
}
