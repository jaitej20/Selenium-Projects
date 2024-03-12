package day4;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@class=\"wikipedia-search-button\"]")).click();
		
		List<WebElement> Search=driver.findElements(By.xpath("//div[@id=\"wikipedia-search-result-link\"]/a"));
		System.out.println(Search.size());
		
		for(int i=0;i<Search.size();i++) {
			System.out.println(Search.get(i).getText());
			Search.get(i).click();
		}
		Set<String> WebTitle=driver.getWindowHandles();
		
		for(String Web:WebTitle) {
			System.out.println(driver.switchTo().window(Web).getTitle());
			driver.close();
		}
	}
}
