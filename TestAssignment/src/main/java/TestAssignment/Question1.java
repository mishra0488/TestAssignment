package TestAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {
	
	public static void main(String...s){
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");	

		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.sparkeighteen.com/");

		
		String w = driver.findElement(By.xpath("//p[contains(text(),'Founded in 2012')]")).getText();
		System.out.println(w);
		String[] arrSplit = w.split(" ");
		
		for(int i = 0; i<arrSplit.length; i++) {
			if(arrSplit[i].equals("discover")) {
				System.out.println(arrSplit[i]);
			}
		}
		
	}

}
