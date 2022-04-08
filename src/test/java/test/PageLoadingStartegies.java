package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadingStartegies {

	public static void main(String[] args) {
		
		//Normal : Wait for the entire page to be loaded.(Normal is Default)
		//Eager Wait until initial HTML document has been completely loaded and parsed.
		//Discard loading of images,subframes,stylesheets.
		//None wait until initial page is loaded.
		
		ChromeOptions option = new ChromeOptions();
		
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://www.google.com");
		
		/*Find Multiple Elements*/
		List<WebElement> elements  =  driver.findElements(By.tagName("input"));
		System.out.println("elements "+elements.size());
		for(WebElement element : elements)
		{
			System.out.println("Text is "+element.getAttribute("value"));
		}
		
		driver.close();
		driver.quit();
	}
}
