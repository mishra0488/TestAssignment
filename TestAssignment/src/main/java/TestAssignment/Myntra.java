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

		
		/*List<WebElement> boxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		System.out.println(boxList.size());

		for (int i = 0; i < 4; i++) {
			boxList.get(i).click();
		}*/

                for (int i = 1; i <= 4; i++) {
			WebElement element = driver.findElement(By.xpath("(//input[@type='checkbox'])" + "[" + i + "]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
	
		

	}
}
