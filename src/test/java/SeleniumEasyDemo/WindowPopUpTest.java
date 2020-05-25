package SeleniumEasyDemo;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import section8.TestBase;

public class WindowPopUpTest  extends TestBase{
	
	@BeforeMethod
	public void setup() {
	  initialization();
	  driver.findElement(By.linkText("Window Popup Modal")).click();
	}

	@Test
	public void singlePopUpWindow() {
		driver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Twitter']")).click();
		Set<String> windows= driver.getWindowHandles();
		for(String handle : windows) {
			driver.switchTo().window(handle);
			System.out.println(driver.getTitle());
		}
	}
	
	@Test
	public void multiplePopUpWindow() {
		driver.findElement(By.xpath("//a[@title='Follow @seleniumeasy' and @class ='btn btn-primary ']")).click();
		Set<String> windows= driver.getWindowHandles();
		for(String handle : windows) {
			driver.switchTo().window(handle);
			System.out.println(driver.getTitle());
		}
	}
	
	@Test
	public void tearDown() {
		driver.quit();
	}
}

