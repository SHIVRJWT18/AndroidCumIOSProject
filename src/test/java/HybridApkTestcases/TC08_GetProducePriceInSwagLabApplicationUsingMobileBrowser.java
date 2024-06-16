package HybridApkTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import AppiumTestPkg.MobileBrowserTestBase;

public class TC08_GetProducePriceInSwagLabApplicationUsingMobileBrowser extends MobileBrowserTestBase
{

	@Test
	public void LaunchApp() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com/v1/");
		
		driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("problem_user");
	
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
	
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
		
		WebElement elem = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
	
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",elem);
	    
	    Thread.sleep(2000);
	    
	    System.out.println("Product Name: "+elem.getText());
	    
	    elem.click();
	    
	    ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	    
	    Thread.sleep(2000);
	    
	    elem = driver.findElement(By.xpath("//div[text()='9.99']"));
	    
	    System.out.println("Product Price: "+elem.getText());


	}
}
