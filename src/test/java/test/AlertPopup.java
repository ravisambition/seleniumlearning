package test;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopup {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Capabilities cap=((ChromiumDriver) driver).getCapabilities();
		 
		// asMap method will return all capability in MAP
		Map<String, Object> myCap=cap.asMap();
		 
		// print the map data-
		System.out.println(myCap);
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");;
		
		//Js Alert
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert alert1 = driver.switchTo().alert();
		String alertText = alert1.getText();
		System.out.println("AlertText is :-"+alertText);
		Thread.sleep(5000);
		alert1.accept();
		
		if(driver.getPageSource().contains("You successfully clicked an alert"))
		{
			System.out.println("You Clicled Alert");
		}
		
		//Js Prompt
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert alert2 = driver.switchTo().alert();
		String alertText2 = alert2.getText();
		System.out.println("AlertText is :-"+alertText2);
		alert2.sendKeys("I am Sending Data");
		Thread.sleep(5000);
		alert2.accept();
		
		driver.close();
		driver.quit();
		
	}
}
