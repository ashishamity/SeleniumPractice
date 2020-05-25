package SeleniumEasyDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import section8.TestBase;

public class CheckBoxTest extends TestBase{
	
	
	@BeforeMethod
	public void setup(){
		initialization();
		driver.findElement(By.linkText("Check Box Demo")).click();
	}
	
	
	  @Test public void singleCheckBoxDemo() {
	  driver.findElement(By.id("isAgeSelected")).click();
	  Assert.assertEquals("Success - Check box is checked",
	  "Success - Check box is checked"); }
	 
	
	@Test
	public void multipleCheckBoxDemo() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//input[@id='check1']"));
		element.sendKeys(Keys.ENTER);
		String text = element.getAttribute("value");
		System.out.println(text);
		Assert.assertEquals("Uncheck All", text);
		driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[4]/label/input")).click();
		String text1 = element.getAttribute("value");
		Assert.assertEquals("Check All", text1);
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
