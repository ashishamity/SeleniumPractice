package section8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		/*driver.get("https://www.goindigo.in/");
		driver.findElement(By.xpath("//input[@name='or-src']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@data-iata='BOM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='bookFlightTab']/form/div[3]/div[1]/div[2]/div/div/div/div/div[3]")).click();
		*/
	//FOR SPICE JET- 
		//handle dynamic dropdown using indexes.
		
		driver.get("https://book.spicejet.com/");
		driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='KQH']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(("//div[@id='glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR'] //a[@value='MAA']"))).click();
		//Alternate is to use parent child relationship xpath
		// 
	}

}
