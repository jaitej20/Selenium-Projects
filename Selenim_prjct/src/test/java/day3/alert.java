package day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alert {
	public static void main(String[] args) throws InterruptedException {

	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.bing.com");
	WebElement auto=driver.findElement(By.id("sb_form_q"));
	Thread.sleep(3000);
	auto.click();	
	auto.sendKeys("Selenium");
	
	List<WebElement> Suggestions=driver.findElements(By.xpath("//span[@class=\"sa_tm_text\"]"));
	
	
	System.out.println(Suggestions.size());
	
	for(int i=0;i<Suggestions.size();i++) {
		System.out.println(Suggestions.get(i).getText());
		if(Suggestions.get(i).getText().equals("selenium ide")) {
			Suggestions.get(i).click();
		}
	}
	
	}	
	
	
	
}

