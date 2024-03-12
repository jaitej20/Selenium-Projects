package day1;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Finding {
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(3000);
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php");
		driver.manage().window().maximize();
		
		List<WebElement> str=driver.findElements(By.className("homeslider-container"));
		int slide=str.size();
		System.out.println("Number of slides "+slide);
		
		List<WebElement> images=driver.findElements(By.tagName("img"));
		int noOfImg=images.size();
		System.out.println("Number of images is  "+noOfImg);
		
	 driver.quit();
	}

}
