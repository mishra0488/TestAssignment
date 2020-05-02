package TestAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Question7 {
	
	@Test
	public void concatenate() {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

		driver.get("https://www.getharvest.com/signup");

		Xls_Reader reader = new Xls_Reader("testdata\\TestData2.xlsx");

		int rowCnt = reader.getRowCount("Sheet3");
		System.out.println("Total rows are--"+ rowCnt);
		
		reader.addColumn("Sheet3", "Status"); // to add a column

		for (int rowNum = 2; rowNum <= rowCnt; rowNum++) {
			String name = reader.getCellData("Sheet3", "FirstName", rowNum) +" "+ reader.getCellData("Sheet3", "LastName", rowNum);
		
			System.out.println(name);

			driver.findElement(By.xpath("//*[@id = 'signup_first_name']")).clear();
			driver.findElement(By.xpath("//*[@id = 'signup_first_name']")).sendKeys(name);

			
			reader.setCellData("Sheet3", "Status", rowNum, name); // to write in added column
		}
	}

}
