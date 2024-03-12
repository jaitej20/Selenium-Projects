package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropBy {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.get("https://demo.guru99.com/test/drag_drop.html");
	        
	       WebElement Amount= driver.findElement(By.xpath("//*[@id=\"fourth\"]"));
	       WebElement Bank=  driver.findElement(By.xpath("//*[@id=\"credit2\"]"));
	       WebElement Sales=  driver.findElement(By.xpath("//*[@id=\"credit1\"]"));
	       WebElement Amount2=  driver.findElement(By.xpath("//*[@id=\"fourth\"]"));
	       WebElement Bank_pos=driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
	       WebElement Amount_pos=driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
	       WebElement Sales_pos=driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
	       WebElement Amount2_pos=driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
	       
	       Actions act=new Actions(driver);
	       
	       
	       act.dragAndDrop(Bank,Bank_pos ).build().perform();
	       act.dragAndDrop(Amount, Amount_pos).build().perform();
	       act.dragAndDrop(Sales,Sales_pos ).build().perform();
	       act.dragAndDrop(Amount2, Amount2_pos).build().perform();
	       
	       WebElement Success=driver.findElement(By.xpath("//*[@id=\"equal\"]/a"));
	       if(Success.getText().equals("Perfect!")) {
	    	   System.out.println("Succesfull");
	       }
	       else {
	    	   System.out.println("UnSuccesfull");
	       }
	}

}
