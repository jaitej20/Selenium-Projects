package day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2 {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		List<WebElement> boxes=driver.findElements(By.xpath("//div[@class=\"form-group\"] //input[@type=\"checkbox\"]"));
		int noofboxes=boxes.size();
		System.out.println(noofboxes);
		
//		for(int i=0;i<noofboxes;i++) {
//			boxes.get(i).click();
//		}
		
		int lastbox=noofboxes-2;
		System.out.println(lastbox);
		for(int i=lastbox;i<noofboxes;i++) {
			boxes.get(i).click();
		}

	}

}
