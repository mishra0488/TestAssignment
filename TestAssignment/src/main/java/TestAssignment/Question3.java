package TestAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Question3 {

	@Test(dataProvider = "QA", dataProviderClass = DataGenerator.class)
	//@Test
	public static void Test3(String searchtext, String searchtext1) {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

		driver.get("http://atcost.in/");

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(searchtext);
		driver.findElement(By.xpath("//i[@class='icon-search button-search hover_icon']")).click();
		

		// String RowNum = "5";
		String quantity = "2";

//To change the quantity:
		driver.findElement(By.xpath("(//*[@name='quantity'])[1]")).clear();
		driver.findElement(By.xpath("(//*[@name='quantity'])[1]")).sendKeys(quantity);
		

//To click the Add to cart
		driver.findElement(By.xpath("(//*[@class='btn-primary'])[1]")).click();

//To click on My cart:
		WebElement locator = driver.findElement(By.xpath("//*[@class='cart_holder']"));
		new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();

//To check the 

		String Itemcheck = driver
				.findElement(By.xpath("(//*[contains(text(), 'Amul Garlic and Herbs Buttery Spread 100Gm')])[2]")).getText();
		System.out.println(Itemcheck);
		if (Itemcheck.equalsIgnoreCase("Amul Garlic and Herbs Buttery Spread 100Gm")) {
			System.out.println("Item selected is correct");
		}else {
			System.out.println("Item selected is wrong");
		}
	}

	
}
