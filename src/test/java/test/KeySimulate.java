package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeySimulate {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		//Key Down
		driver.get("https://www.google.com");
		WebElement searchBox =driver.findElement(By.name("q"));
	//	driver.findElement(By.name("q")).sendKeys("Selenium "+Keys.ENTER);
		Actions actions = new Actions(driver);
//		Action ctrlAKey = actions.keyDown(Keys.CONTROL).sendKeys("a").build();
//		ctrlAKey.perform();
//		
		
		actions.keyDown(Keys.SHIFT).sendKeys(searchBox," Capital Letter Only").perform();
		actions.keyUp(Keys.SHIFT).perform();
		searchBox.sendKeys(" Data ");
		Thread.sleep(2000);
		driver.quit();
	}
}
