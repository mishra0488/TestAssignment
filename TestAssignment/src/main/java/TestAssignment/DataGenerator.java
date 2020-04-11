package TestAssignment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {

	@DataProvider(name = "QA")
	public static Object[][] dataGenerator() throws IOException {
		System.out.println("Start");
		FileInputStream fin = new FileInputStream("C:\\Users\\dell\\Desktop\\TestAssignment\\testdata\\TestData2.xlsx");
		System.out.println("Stop");
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet sheet = wb.getSheet("Login");
		int numberofData = sheet.getPhysicalNumberOfRows();

		Object data[][] = new Object[numberofData][2];

		for (int i = 0; i < numberofData; i++) {

			XSSFRow row = sheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);

			if (username.getCellType() == username.CELL_TYPE_NUMERIC) {
				// data[i][0]=String.valueOf(username.getNumericCellValue());
				data[i][0] = username.getNumericCellValue();
				System.out.println(data[i][0]);
			} else {
				data[i][0] = username.getStringCellValue();
			}

			if (password.getCellType() == password.CELL_TYPE_NUMERIC) {

				// int data=sheet.getRow(i).getCell(1).getNumericCellValue();
				data[i][0] = password.getNumericCellValue();
				System.out.println(data[i][0]);
			} else {
				data[i][1] = password.getStringCellValue();
			}
			System.out.println(data[i][0].toString());
			System.out.println(data[i][1].toString());
		}
		return data;
	}

	@DataProvider(name = "Test")
	public static Object[][] dataGenerator2() throws IOException {
		System.out.println("Start");
		FileInputStream fin = new FileInputStream(
				"C:\\\\Users\\\\dell\\\\Desktop\\\\TestAssignment\\\\testdata\\\\TestData2.xlsx");
		System.out.println("Stop");
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet sheet = wb.getSheet("Product");
		int numberofData = sheet.getPhysicalNumberOfRows();

		Object data[][] = new Object[numberofData][2];

		for (int i = 0; i < numberofData; i++) {

			XSSFRow row = sheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);

			if (username.getCellType() == username.CELL_TYPE_NUMERIC) {
				data[i][0] = username.getNumericCellValue();
			} else {
				data[i][0] = username.getStringCellValue();
			}

			if (password.getCellType() == password.CELL_TYPE_NUMERIC) {
				data[i][1] = password.getNumericCellValue();
			} else {
				data[i][1] = password.getStringCellValue();
			}
			System.out.println(data);
		}
		return data;
	}

	public static void main(String... s) throws IOException {
		dataGenerator();

	}

}
