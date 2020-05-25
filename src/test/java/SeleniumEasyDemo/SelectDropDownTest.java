package SeleniumEasyDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import section8.TestBase;

public class SelectDropDownTest extends TestBase{
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		driver.findElement(By.linkText("Select Dropdown List")).click();
	}
	
	
	  @Test public void selectListDemo() { Select dropdown = new
	  Select(driver.findElement(By.id("select-demo")));
	  dropdown.selectByValue("Monday"); String text=
	  driver.findElement(By.xpath("//p[@class='selected-value']")).getText();
	  Assert.assertEquals("Day selected :- Monday",text); }
	 
	@Test
	public void multipleSelectListDemo() {
		Select dropdown = new Select(driver.findElement(By.id("multi-select")));
		dropdown.selectByValue("California");
		dropdown.selectByValue("Florida");
		dropdown.selectByValue("New Jersey");
		dropdown.deselectByValue("New Jersey");
		driver.findElement(By.id("printMe")).click();
		String text =driver.findElement(By.xpath("//p[@class='getall-selected']")).getText();
		Assert.assertEquals("First selected option is : undefined", text);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
