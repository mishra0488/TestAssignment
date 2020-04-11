package TestAssignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Question6 {

	@Test(dataProvider = "Test", dataProviderClass = DataGenerator.class)
	public void Test6(String verifyTextfromSheet) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		List<WebElement> rows = driver.findElements(By.xpath("(//*[@class='details_wrap'])"));
		int NumberOfrows = rows.size();

		// Number of rows -1
		int row = NumberOfrows - 1;

		String RowNum = "+row+";
		String quantity = "2";

		driver.get("http://atcost.in/");
		driver.findElement(By.xpath("(//*[contains(text(),'DAL, ATTA & RICE')])[2]")).click();

		// To change the quantity:
		driver.findElement(By.xpath("(//*[@name='quantity'])[" + RowNum + "]")).clear();
		driver.findElement(By.xpath("(//*[@name='quantity'])[" + RowNum + "]")).sendKeys(quantity);

		// To click on the product
		driver.findElement(By.xpath("(//*[@class='details_wrap'])[" + RowNum + "]")).click();
		String verifyText = driver.findElement(By.xpath("//h1")).getText();
		if (verifyText.equalsIgnoreCase(verifyTextfromSheet)) {
			System.out.println("Text matched from the Excel");
		}

	}

}
