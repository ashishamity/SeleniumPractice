package SeleniumEasyDemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import section8.TestBase;

public class RadioBox extends TestBase{
	
	@BeforeMethod
	public void setup() {
		initialization();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
	}
	
	@Test
	public void singleRadioButton() {
		driver.findElement(By.xpath("//input[contains(text(),Male) and @name='optradio' and @value='Male']")).click();
		driver.findElement(By.id("buttoncheck")).click();
		String text = driver.findElement(By.xpath("//p[@class='radiobutton']")).getText();
		Assert.assertEquals(text,"Radio button 'Male' is checked");
	}
	
	@Test
	public void multipleRadioButton() {
		driver.findElement(By.xpath("//input[contains(text(),Female) and @name='gender' and @value='Female']")).click();
		driver.findElement(By.xpath("//input[@value ='5 - 15']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Get values')]")).click();
		String text = driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText();
		System.out.println(text);
		Assert.assertEquals("Sex : Female \r\n" + "Age group: 5 - 15", text);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
