package TestAssignment;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {
	
	public static Map<Integer, String> Add_data = new HashMap();
	public static void main(String...s){

	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");	

	WebDriver driver= new ChromeDriver();
	driver.get("url of Site");


	String SearchText = driver.findElement(By.xpath("//span[contains(text(),'1009')]")).getText();
	WebElement NextPageButton = driver.findElement(By.xpath("xpath to navigate to the next page"));

			
	for(int i=1;i<=5;i++){			
	for(int j=1;j<=5;j++){
	String AllValues = driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
	if(AllValues.equalsIgnoreCase(SearchText)){
	System.out.println("Found the expected data");
	Add_data.put(1, AllValues);
	}
	else {
	NextPageButton.click();
	}}}
	}}
