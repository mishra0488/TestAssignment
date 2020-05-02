package TestAssignment;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class base {

	public static String fetchValueFromFile(String key) throws Exception {
		FileInputStream Fin = new FileInputStream("ConfigFiles\\config.properties");
		Properties property = new Properties();
		property.load(Fin);
		return property.get(key).toString();
	}

	public static WebDriver driver;

	@BeforeMethod
	public void InitiateBrowser() throws Exception {

		if (fetchValueFromFile("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (fetchValueFromFile("browser").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}

		else if (fetchValueFromFile("browser").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}

		else {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.get(fetchValueFromFile("URL"));
	}

	@AfterMethod
	public void dropBrowser() {
		driver.quit();
	}

}
