package day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		
		WebElement str=driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));

		Select ing=new Select(str);
//		ing.selectByVisibleText("Belgium");
		ing.selectByValue("CHL");
		
		List<WebElement> op=ing.getOptions();
		
		System.out.println("Size of: " +op.size());
		
		for(int i=0;i<op.size();i++) {
			
			System.out.println(op.get(i).getText());
		}
	}
}
