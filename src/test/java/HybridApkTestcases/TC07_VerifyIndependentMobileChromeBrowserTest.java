package HybridApkTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import AppiumTestPkg.MobileBrowserTestBase;

public class TC07_VerifyIndependentMobileChromeBrowserTest extends MobileBrowserTestBase {

	@Test
	public void LaunchApplication() throws InterruptedException
	{		
		driver.get("https://www.saucedemo.com/v1/");
		
		System.out.println("Actual Title: "+driver.getTitle());
				
		Thread.sleep(2000);
		
		WebElement elem = driver.findElement(By.xpath("//input[@name='user-name']"));
		
		elem.click();
		
		elem.sendKeys("standard_user");
		
		driver.hideKeyboard();

		elem = driver.findElement(By.xpath("//input[@name='password']"));
				
		elem.click();
		
		elem.sendKeys("secret_sauce");
		
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Actual Home Title: "+driver.getTitle());
		
	}
}
