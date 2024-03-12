package day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Countries {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		
		WebElement Option=driver.findElement(By.id("country-list"));
		
		Select Options=new Select(Option);
		
		List<WebElement> NoOptions=Options.getOptions();
		
		System.out.println("No of Countries:"+NoOptions.size());
		
		for(WebElement op:NoOptions) {
			System.out.println(op.getText());
		}
		
		Options.selectByVisibleText("France");
		
		//////////////////////////////////
		driver.findElement(By.id("state-list")).click();
		Thread.sleep(3000);
		List<WebElement> State= driver.findElements(By.xpath("//*[@id=\"state-list\"]/option"));
		
		System.out.println("No of States:"+State.size());
		
		for(int i=0;i<State.size();i++) {
			System.out.println(State.get(i).getText());
			if(State.get(i).getText().equals("Picardie")) {
				State.get(i).click();
				break;
			}
		}
		
	
	}
}
