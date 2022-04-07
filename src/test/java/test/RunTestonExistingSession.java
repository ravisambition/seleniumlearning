package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunTestonExistingSession {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options =  new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:5678");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://facebook.com");
		driver.findElement(By.id("pass")).sendKeys("pass");
	}
}
