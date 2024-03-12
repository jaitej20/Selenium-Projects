package dummyFlight;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DummyTicket {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
       
        driver.findElement(By.xpath("//*[@id=\"product_3186\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"travname\"]")).sendKeys("Jai");
        driver.findElement(By.xpath("//*[@id=\"travlastname\"]")).sendKeys("Gandam");
        driver.findElement(By.xpath("//*[@id=\"dob\"]")).click();
        WebElement Months=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]"));
        Select Month=new Select(Months);
        Month.selectByVisibleText("Oct");
        WebElement Years=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]"));
        Select Year=new Select(Years);
        Year.selectByVisibleText("2022");
        
        List<WebElement> Dates=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table//td"));
        
        for(WebElement Date:Dates) {
        	if(Date.getText().contains("20")) {
        		Date.click();
        	}
        }
        
        
    }
}
