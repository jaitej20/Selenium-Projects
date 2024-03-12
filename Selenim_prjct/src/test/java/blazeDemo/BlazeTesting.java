package blazeDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeTesting {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		
		WebElement Departure=driver.findElement(By.name("fromPort"));
		Select DepCity=new Select(Departure);
		DepCity.selectByValue("Boston");
		
		WebElement Arrival=driver.findElement(By.name("toPort"));
		Select ArrCity=new Select(Arrival);
		ArrCity.selectByValue("London");
		
		driver.findElement(By.xpath("//div[@class=\"container\"]/input")).click();
		
		
		try {
			double smallestPrice = Double.MAX_VALUE;
			List<WebElement> priceElements = driver.findElements(By.xpath("//table[@class='table']//td[6]"));
			for (WebElement priceElement : priceElements) {
			    String priceString = priceElement.getText().replace("$", "");
			    double price = Double.parseDouble(priceString);
			    if (price < smallestPrice) {
			        smallestPrice = price;
			    }
			}
		
		Thread.sleep(1000);
		List<WebElement> Rows=driver.findElements(By.xpath("//table[@class=\"table\"]//tr"));

		for(WebElement Row:Rows) {
			List<WebElement> Columns=Row.findElements(By.tagName("td"));
			for(WebElement Col:Columns) {
				if(Col.getText().contains(String.valueOf(smallestPrice))) {
					Row.findElement(By.tagName("input")).click();
					break;
				}
			}
		}
		}
		catch(StaleElementReferenceException e) {
			double smallestPrice = Double.MAX_VALUE;
			List<WebElement> priceElements = driver.findElements(By.xpath("//table[@class='table']//td[6]"));
			for (WebElement priceElement : priceElements) {
			    String priceString = priceElement.getText().replace("$", "");
			    double price = Double.parseDouble(priceString);
			    if (price < smallestPrice) {
			        smallestPrice = price;
			    }
			}
			
			Thread.sleep(1000);
			List<WebElement> Rows=driver.findElements(By.xpath("//table[@class=\"table\"]//tr"));

			for(WebElement Row:Rows) {
				List<WebElement> Columns=Row.findElements(By.tagName("td"));
				for(WebElement Col:Columns) {
					if(Col.getText().contains(String.valueOf(smallestPrice))) {
						Row.findElement(By.tagName("input")).click();
						break;
					}
				}
			}
		}
		
//		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[1]/input")).click();
		driver.findElement(By.id("inputName")).sendKeys("Jai");
		driver.findElement(By.id("address")).sendKeys("2-2-1107, Tilaknagar");
		driver.findElement(By.id("city")).sendKeys("Hyderabad");
		driver.findElement(By.id("state")).sendKeys("Telangana");
		driver.findElement(By.id("zipCode")).sendKeys("500044");
		WebElement Card= driver.findElement(By.id("cardType"));
		Select CardType=new Select(Card);
		CardType.selectByValue("amex");
		driver.findElement(By.id("creditCardNumber")).sendKeys("852774444444");
		WebElement Month=driver.findElement(By.id("creditCardMonth"));
		Month.clear();
		Month.sendKeys("09");
		WebElement Year=driver.findElement(By.id("creditCardYear"));
		Year.clear();
		Year.sendKeys("2024");
		driver.findElement(By.id("nameOnCard")).sendKeys("Jaitej");
		driver.findElement(By.xpath("//input[@id=\"rememberMe\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Purchase Flight\"]")).click();
		
		
		WebElement Confirmation=driver.findElement(By.xpath("/html/body/div[2]/div/h1"));
		if(Confirmation.getText().contains("Thank you")) {
			System.out.println("Booking Succesfull");
		}
		   
		
	}

}


//Alternate method producing stale error
//package blazeDemo;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class BlazeTesting {
//
//	public static void main(String[] args) throws InterruptedException {
//		
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		driver.get("https://blazedemo.com/");
//		
//		WebElement Departure=driver.findElement(By.name("fromPort"));
//		Select DepCity=new Select(Departure);
//		DepCity.selectByValue("Boston");
//		
//		WebElement Arrival=driver.findElement(By.name("toPort"));
//		Select ArrCity=new Select(Arrival);
//		ArrCity.selectByValue("London");
//		
//		driver.findElement(By.xpath("//div[@class=\"container\"]/input")).click();
//		
//		List<WebElement> Prices= driver.findElements(By.xpath("//table[@class=\"table\"]//td[6]"));
//		List<Double> PriceArray=new ArrayList<>();
//		
//		for(WebElement Price:Prices) {
//			String Small=Price.getText().replace("$", "");
//			double SmallPrice=Double.parseDouble(Small);
//			PriceArray.add(SmallPrice);
//		}
//		
//		Collections.sort(PriceArray);
//		double SmallestPrice= PriceArray.get(0);
//		
//		List<WebElement> Rows=driver.findElements(By.xpath("//table[@class=\"table\"]//tr"));
//		
//		//	driver.findElement(By.xpath("//table[@class=\"table\"]//tr//input[@type=\"submit\"]")).click();
//		for(WebElement Row:Rows) {
//			List<WebElement> Columns=Row.findElements(By.tagName("td"));
//			for(WebElement Col:Columns) {
//				if(Col.getText().contains(String.valueOf(SmallestPrice))) {
//					Row.findElement(By.tagName("input")).click();
//					break;
//				}
//			}
//		}
//		
//		
//		   
//		
//	}
//
//}