package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframesDemo {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/tinymce");
	    driver.switchTo().frame("mce_0_ifr");
		WebElement Text=driver.findElement(By.xpath("//body[@id=\"tinymce\"]/p"));
		Text.clear();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/button[1]/span")).click();
		driver.switchTo().frame("mce_0_ifr");
		Text.sendKeys("Welcome to IFrames.");

		

	}

}
