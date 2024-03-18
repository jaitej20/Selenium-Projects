package dummyFlight;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DummyTicket {
	
	static void slectdate(WebDriver driver,WebElement dateselector, String date,String Month,String Year) {
		dateselector.click();
		
		WebElement Months=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]"));
        Select monthPicker=new Select(Months);
        monthPicker.selectByVisibleText(Month);
        
        
        WebElement Years=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]"));
        Select yearPicker=new Select(Years);
        yearPicker.selectByVisibleText(Year);
        
        List<WebElement> Dates=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table//td"));
        
        for(WebElement DatePicker:Dates) {
        	if(DatePicker.getText().contains(date)) {
        		DatePicker.click();
        	}
        }
		
	}

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
       
        driver.findElement(By.xpath("//*[@id=\"product_3186\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"travname\"]")).sendKeys("Jai");
        driver.findElement(By.xpath("//*[@id=\"travlastname\"]")).sendKeys("Gandam");
        
        
       WebElement dob= driver.findElement(By.xpath("//*[@id=\"dob\"]"));
        slectdate(driver,dob,"20","Oct","2022");
        
        List<WebElement> rad_btn=driver.findElements(By.xpath("//*[@id=\"sex_field\"]/span/label"));
           
        
        for(WebElement rad:rad_btn) {
        	if(rad.getText().equals("Male")) {
        		rad.click();	
        	}
    }
        
        driver.findElement(By.xpath("//*[@id=\"fromcity\"]")).sendKeys("Hyderabad");
        driver.findElement(By.xpath("//*[@id=\"tocity\"]")).sendKeys("Mumbai");
        
        WebElement dept=driver.findElement(By.xpath("//*[@id=\"departon\"]"));
        slectdate(driver,dept,"21","Mar","2024");
        
        driver.findElement(By.xpath("//*[@id=\"select2-reasondummy-container\"]")).click();
        driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Visa extension"+Keys.ENTER);
        
        driver.findElement(By.xpath("//*[@id=\"deliverymethod_3\"]")).click();
        
    	driver.findElement(By.xpath("//*[@id=\"billname\"]")).sendKeys("Jai");
		driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys("89567890");
		driver.findElement(By.xpath("//*[@id=\"billing_email\"]")).sendKeys("jai@gmail.com");
		
		driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("India"+Keys.ENTER);
        
		
		driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).sendKeys("221107");
		driver.findElement(By.xpath("//*[@id=\"billing_address_2\"]")).sendKeys("Kachiguda");
		driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys("HYD");
		
		driver.findElement(By.xpath("//span[@id='select2-billing_state-container']")).click();
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Telangana"+Keys.ENTER); 
		
		driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys("500044");
		
		driver.findElement(By.xpath("//button[@id='place_order']")).click();
		
       driver.getTitle();
       Thread.sleep(3000);
		
		if(driver.getTitle().equals("Payment Page"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
	Thread.sleep(3000);
		
	driver.quit();
  }
}
