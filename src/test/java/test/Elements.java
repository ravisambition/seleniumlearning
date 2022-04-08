package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://google.com");
		
		WebElement searchInput = driver.findElement(By.name("q"));
		
		searchInput.sendKeys("Ravi Vyas",Keys.ENTER);
		Thread.sleep(2000);
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		//Here Login Button is Below the Inputbox
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		WebElement passwordTextBox = driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginButton));
		
		
		passwordTextBox.sendKeys("password");
		
		
		driver.close();
		driver.quit();
	}
}
