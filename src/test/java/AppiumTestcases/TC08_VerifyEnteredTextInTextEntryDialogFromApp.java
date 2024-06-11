package AppiumTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumTestPkg.AppiumTestBase;
import io.appium.java_client.AppiumBy;

public class TC08_VerifyEnteredTextInTextEntryDialogFromApp extends AppiumTestBase
{
	 /*TestCase:
     * Click on Apk File on the Emulator then Click on App. 
	  Go to AlertDialog, then TextEntryDialog -Enter Name and Password then Click Ok
	  <Verify that text is inserted successfully>
	 */ 
	@Test
	public void GetAndVerifyEnteredNameAndPassword()
	{
		adriver.findElement(AppiumBy.accessibilityId("App")).click();
		
		adriver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		adriver.findElement(By.id("io.appium.android.apis:id/text_entry_button")).click();
		
		WebElement elem = adriver.findElement(By.id("io.appium.android.apis:id/username_edit"));
		elem.sendKeys("Arpit Kumar");
		
		elem= adriver.findElement(By.id("io.appium.android.apis:id/password_edit"));
		elem.sendKeys("ak@123");
		
		adriver.findElement(By.id("android:id/button1")).click();
		
		adriver.navigate().back();
		
		adriver.findElement(By.id("io.appium.android.apis:id/text_entry_button")).click();
				
        String name = adriver.findElement(By.id("io.appium.android.apis:id/username_edit")).getText();
		
		System.out.println("Entered Name: "+name);
		
		String Passwrd = adriver.findElement(By.id("io.appium.android.apis:id/password_edit")).getText();
		
		System.out.println("Entered Password: "+Passwrd);
		
		Assert.assertEquals(name, "Arpit Kumar","Name should be matched as per inserted details");
		
	}
}
