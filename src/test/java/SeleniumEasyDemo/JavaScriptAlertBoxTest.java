package SeleniumEasyDemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import section8.TestBase;

public class JavaScriptAlertBoxTest extends TestBase {
	
	@BeforeMethod
	public void setup() {
	  initialization();
	  driver.findElement(By.linkText("Javascript Alerts")).click();
	}
	@Test
	public void alertBoxTest() {
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		driver.switchTo().alert().accept();
	}
	@Test
	public void confirmBox() {
		driver.findElement(By.xpath("//button[@onclick ='myConfirmFunction()']")).click();
		driver.switchTo().alert().accept();
		String okText = driver.findElement(By.id("confirm-demo")).getText();
		Assert.assertEquals(okText,"You pressed OK!");
	}
	@Test
	public void promptBox() {
		driver.findElement(By.xpath("//button[@onclick ='myPromptFunction()']")).click();
		driver.switchTo().alert().sendKeys("Ashish");
		driver.switchTo().alert().accept();
		String promptText = driver.findElement(By.id("prompt-demo")).getText();
		Assert.assertEquals(promptText,"You have entered 'Ashish' !");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
