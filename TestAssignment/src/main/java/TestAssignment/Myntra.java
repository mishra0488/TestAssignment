package TestAssignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Myntra {

	@Test
	public void checkbox() {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

		driver.get("https://www.myntra.com/ethnic-wear-dresses-menu");

		
		List<WebElement> boxList = driver.findElements(By.xpath("(//input[@type='checkbox'])[1]"));
		
		System.out.println(boxList.size());

		for (int i = 0; i < 4; i++) {
			boxList.get(i).click();
		}
	
		

	}
}
