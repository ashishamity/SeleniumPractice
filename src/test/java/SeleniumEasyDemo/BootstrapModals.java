package SeleniumEasyDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import section8.TestBase;

public class BootstrapModals extends TestBase{
	
	@BeforeMethod
	public void setup() {
	  initialization();
	  driver.findElement(By.linkText("Bootstrap Modals")).click();
	}
	
	@Test(enabled = false)
	public void singleModal() {
		driver.findElement(By.xpath("//a[@href ='#myModal0']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal fade in']/div/div")));
		System.out.println(driver.findElement(By.xpath("//div[@class='modal fade in']/div/div/div[3]")).getText());
		driver.findElement(By.xpath("//div[@class='modal fade in']/div/div/div[4]/a")).click();
	}
	
	@Test
	public void multipleModal() {
		
		driver.findElement(By.xpath("//a[@href ='#myModal']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal fade in']/div/div")));
		System.out.println(driver.findElement(By.xpath("//div[@class='modal fade in']/div/div/div[3]")).getText());
		driver.findElement(By.xpath("//a[@href ='#myModal2']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal fade rotate in']/div/div")));
		driver.findElement(By.xpath("//div[@class='modal fade rotate in']/div/div/div[6]/a[2]")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
