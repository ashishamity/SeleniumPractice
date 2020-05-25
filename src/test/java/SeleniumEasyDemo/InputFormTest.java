package SeleniumEasyDemo;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import section8.TestBase;

public class InputFormTest extends TestBase{
	
	@BeforeMethod
	public void setup() {
		initialization();
		driver.findElement(By.linkText("Simple Form Demo")).click();
	}
	
	@Test
	public void enterMessage() {
		driver.findElement(By.id("user-message")).sendKeys("Practice until you are perfect");
		driver.findElement(By.xpath("//button[contains(text(), 'Show Message')]")).click();
	}
	
	@Test
	public void enterTotal() {
		driver.findElement(By.id("sum1")).sendKeys("5");
		driver.findElement(By.id("sum2")).sendKeys("10");
		driver.findElement(By.xpath("//button[contains(text(), 'Get Total')]")).click();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
