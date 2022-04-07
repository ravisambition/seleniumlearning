package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		WebElement aBox = driver.findElement(By.xpath("//li[text()='A']"));
		WebElement DBox = driver.findElement(By.xpath("//li[text()='D']"));
		WebElement eBox = driver.findElement(By.xpath("//li[text()='E']"));

		/* Drag and Drop */
		Actions actions = new Actions(driver);

		
		  actions.moveToElement(DBox); actions.clickAndHold();
		  actions.moveToElement(aBox); actions.build().perform(); Thread.sleep(2000);
		  actions.release().perform(); System.out.println("Complete 1");
		  
		  actions.moveToElement(aBox); actions.clickAndHold();
		  actions.moveToElement(DBox); Thread.sleep(2000); actions.build().perform();
		  Thread.sleep(2000); actions.release().perform(); 
		  //Right Click on Element
		  actions.contextClick(DBox);
		  
		  Thread.sleep(2000); System.out.println("Complete 2");
		 
		  driver.get("https://trytestingthis.netlify.app/");
		  
		  WebElement dropDown = driver.findElement(By.id("option"));
		  Select selectObject =  new Select(dropDown);
		  List<WebElement> options = selectObject.getOptions();
		  for(WebElement singleElement : options)
		  {
			  System.out.println("Single Options "+singleElement.getText());
		  }
		  selectObject.selectByIndex(2);
		  Thread.sleep(2000);
		//driver.quit();
	}
}
