package section8;

import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebtable {

	public static void main(String[] args) throws InterruptedException, ParseException {
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		Thread.sleep(2000);
		// get the number rows and column counts in the table
		
		int rows = driver.findElements(By.xpath("//div[@id ='leftcontainer']/table/tbody/tr/td[1]")).size();
		int columns = driver.findElements(By.xpath("//div[@id ='leftcontainer']/table/thead/tr/th")).size();
		System.out.println("Row count = "+  rows + " "+ " Column count =" +  columns);
		
		// Fetch cell value of a particular row and column of the Dynamic Table
		
		WebElement baseTable = driver.findElement(By.tagName("table"));
		
		WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[4]"));
		System.out.println(tableRow.getText());
		System.out.println(driver.findElement(By.xpath("//div[@id ='leftcontainer']/table/tbody/tr[4]/td[4]")).getText());
	
		// Get Maximum of all the Values in a Column of Dynamic Table
		String max;
		double m=0, r=0;
		for(int i= 1; i<=rows; i++){
		max= driver.findElement(By.xpath("//div[@id ='leftcontainer']/table/tbody/tr[" + (i) +"]/td[4]")).getText();
		NumberFormat f =NumberFormat.getNumberInstance(); 
        Number num = f.parse(max);
        max = num.toString();
        m = Double.parseDouble(max);
        if(m>r)
         {    
            r=m;
         }
    }
    System.out.println("Maximum current price is : "+ r);
		
	
	
	
	
	
		
	
	/*driver.findElement(By.xpath("//input[@name='email']")).sendKeys("tiwari.ashish.111@gmail.com");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Yellow@123");
	driver.findElement(By.xpath("//div[contains(text(), 'Login')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(text(), 'Contacts')]")).click();
	WebElement table = driver.findElement(By.xpath("//*[@id='ui']/div/div[2]/div[2]/div/div[2]/table/tbody"));
	List<WebElement> rowCount= table.findElements(By.xpath("//*[@id='ui']/div/div[2]/div[2]/div/div[2]/table/tbody/tr"));
	//int count = table.findElements(By.tagName("td")).size();
	System.out.println(rowCount.size());*/
}
}
