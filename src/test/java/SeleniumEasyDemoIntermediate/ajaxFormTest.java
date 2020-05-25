package SeleniumEasyDemoIntermediate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import section8.TestBase;

public class ajaxFormTest extends TestBase{
	
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.id("btn_inter_example")).click();
		driver.findElement(By.linkText("Ajax Form Submit")).click();
	}

	
	@Test
	public void ajaxForm() {
		driver.findElement(By.id("title")).sendKeys("Ashish");
		driver.findElement(By.id("description")).sendKeys("Hello");
		driver.findElement(By.id("btn-submit")).click();
		WebElement element = driver.findElement(By.id("submit-control"));
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.textToBePresentInElement(element, "Form submited Successfully!"));
		String text = element.getText();
		Assert.assertEquals(text, "Form submited Successfully!");
	}

}
