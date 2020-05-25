package section8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://book.spicejet.com/");
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(2000);
		Select adult = new Select(driver.findElement(By.xpath("//div[contains(@id,'divpaxOptions')]/div[2]/p[2]/select")));
		adult.selectByValue("3");
		Select child = new Select(driver.findElement(By.xpath("//div[contains(@id,'divpaxOptions')]/div[2]/p[2]/select")));
		child.selectByValue("2");
		Select infant = new Select(driver.findElement(By.xpath("//div[contains(@id,'divpaxOptions')]/div[2]/p[3]/select")));
		infant.selectByValue("1");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
