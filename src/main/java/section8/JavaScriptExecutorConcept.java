package section8;

import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://book.spicejet.com/");
		
		WebElement search = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit"));
        flash(search, driver);
        search.click();
	}
	
	public static void flash(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgColor = element.getCssValue("background");
		for(int i=0;i<=10;i++){
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgColor, element, driver);
		}
		
	}

	public static void changeColor(String color, WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor= '"+color+"'", element);
		try{
			Thread.sleep(20);
		}catch(InterruptedException e){
			
		}

	}
}
