package TestAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {
	
	public static void main(String...s){
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	

		WebDriver driver = new ChromeDriver();
		driver.get("url of Site");

		String DynamicText= "Contact";
		driver.findElement(By.xpath("1)	//span[contains(text(),'"+DynamicText+"')]")).click();
		
		
	}

}
