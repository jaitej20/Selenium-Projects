package day1;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
   
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		
//		String act=driver.getTitle();
//		String exp="OrangeHRM";
//		
//		if(act.equals(exp)) {
//			System.out.println("Test is Passed");
//		}
//		else {
//			System.out.println("Test is Failed");
//		}
//		
//		driver.close();
		Thread.sleep(5000);
		String act="";
		try {
			act=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		}
		catch(Exception e) {

	}
		String exp="Dashboard";
		if(act.equals(exp)) {
			System.out.println("Test is Passed");
		}
		else {
			System.out.println("Test is Failed");
		}
		
		driver.quit();
		}
}
