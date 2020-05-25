package SeleniumEasyDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import section8.TestBase;

public class BootstrapAlertsTest extends TestBase{
	
	@BeforeMethod
	public void setup() {
	  initialization();
	  driver.findElement(By.linkText("Bootstrap Alerts")).click();
	}
	
	
	@Test
	public void autoAlert() {
		driver.findElement(By.id("autoclosable-btn-success")).click();
		String text = driver.findElement(By.xpath("//div[@class ='alert alert-success alert-autocloseable-success']"))
				.getText();
		Assert.assertEquals(text, "I'm an autocloseable success message. I will hide in 5 seconds.");
	}

	@Test
	public void normalAlert() throws InterruptedException {
		driver.findElement(By.id("normal-btn-success")).click();
		String text = driver.findElement(By.xpath("//div[@class ='alert alert-success alert-normal-success']")).getText();
		System.out.println(text);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(text, "×"
				+ " I'm a normal success message. To close use the appropriate button.");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class ='alert alert-success alert-normal-success']/button"))).click();
	}

}
