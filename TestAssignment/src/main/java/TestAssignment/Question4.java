package TestAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Question4 {
	
	@Test(dataProvider="QA",dataProviderClass = DataGenerator.class)	
	public void Test4(String searchText, String quantity2) {
		
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");	
	WebDriver driver= new ChromeDriver();
	
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	
	
	String RowNum="5";
	String quantity="2";
	

	driver.get("http://atcost.in/");
	
	driver.findElement(By.xpath("(//*[contains(text(),'DAL, ATTA & RICE')])[2]")).click();
	//driver.findElement(By.xpath("//i[@class='icon-search button-search hover_icon']")).click();

	//To change the quantity:
	driver.findElement(By.xpath("(//*[@name='quantity'])["+RowNum+"]")).clear();
	driver.findElement(By.xpath("(//*[@name='quantity'])["+RowNum+"]")).sendKeys(quantity);

	//To click the Add to cart
	driver.findElement(By.xpath("(//*[@class='btn-primary'])["+RowNum+"]")).click();

	//To click on My cart:
	driver.findElement(By.xpath("//*[@class='cart_holder']")).click();
	
	}
	
	

}
