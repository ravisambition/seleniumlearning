package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver.exe");
		//We can use WebDriverManager IF we dont know want to include path we can also specify version of chrome
		
		//WebDriverManager.chromedriver().driverVersion("98.0.4758.102").setup();
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://google.com");
	}
}
