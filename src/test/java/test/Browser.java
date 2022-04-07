package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://google.com");
		String getURL = driver.getCurrentUrl();
		System.out.println("getURL "+getURL);
		String title = driver.getTitle();
		System.out.println("title "+title);
		
		WebElement element =  driver.findElement(By.cssSelector(".lnXdpd"));
		
		File ElementSS =  element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ElementSS, new File("./Google.png"));
		
		String windowHandle = driver.getWindowHandle();
		System.out.println("windowHandle "+windowHandle);
		
		JavascriptExecutor jse =  (JavascriptExecutor)driver;
		WebElement feelingLucky = driver.findElement(By.name("btnI"));
		jse.executeScript("arguments[0].click();", feelingLucky);
		
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://yahoo.com");
		
		//driver.navigate().refresh();
		
		String yahooHandle = driver.getWindowHandle();
		driver.switchTo().window(yahooHandle);
		System.out.println("yahooHandle "+yahooHandle);
		driver.switchTo().newWindow(WindowType.TAB);
	
		//String thirdHandle = driver.getWindowHandle();
		//System.out.println("thirdHandle "+thirdHandle);
		driver.switchTo().window(windowHandle);
		
		//Switch to Frame 
		/*driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("Action")).click();
		*/
		//We need to Set Default content When Frame OPeration performed.
		driver.switchTo().defaultContent();
		//driver.close();
		
	
		
		//Set Size
		/*
		driver.manage().window().setSize(new Dimension(700, 800));
		Dimension size  = driver.manage().window().getSize();
		int Height= size.getHeight();
		int Width= size.getWidth();
		
		System.out.println("Height is :-"+Height);
		System.out.println("Width is :-"+Width);
		
		//We Can Move Position OF Windows By Default its 10*10
		driver.manage().window().setPosition(new Point(500,200));
		//Max MIn Full Screen 
		driver.manage().window().maximize();
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./image1.png"));
		
		driver.close();
		driver.quit(); */
	}
}
