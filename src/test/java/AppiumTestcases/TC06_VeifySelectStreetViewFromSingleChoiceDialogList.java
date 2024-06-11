package AppiumTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumTestPkg.AppiumTestBase;
import io.appium.java_client.AppiumBy;

public class TC06_VeifySelectStreetViewFromSingleChoiceDialogList extends AppiumTestBase
{
	 /*TestCase:
      * Click on Apk File on the Emulator then Click on App. 
		Go to AlertDialog, then SingleChoice -Click Traffic -Click Cancel -Click StreetView -Click Ok
		<Verify that Street View as selected Option>
	  */ 
	@Test
	public void GetAndVerifySelectedOption_StreetView()
	{
		adriver.findElement(AppiumBy.accessibilityId("App")).click();
		
		adriver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		adriver.findElement(By.id("io.appium.android.apis:id/radio_button")).click();
		
		adriver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Traffic']")).click();
		
		adriver.findElement(By.id("android:id/button2")).click();
				
		adriver.findElement(By.id("io.appium.android.apis:id/radio_button")).click();
		
		WebElement elem = adriver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Street view']"));

		elem.click();
		
		adriver.findElement(By.id("android:id/button1")).click();
				
		adriver.navigate().back();
		
		adriver.findElement(By.id("io.appium.android.apis:id/radio_button")).click();
		
		elem = adriver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Street view']"));
		
		if(elem.getAttribute("checked").equals("true"))
		 {
		  String actchoice = elem.getText();	
		  System.out.println("Choice Selected: "+actchoice);	 
		  Assert.assertEquals(actchoice, "Street view","Selecting Radio for Street View is invalid");
		 }	 
		
		
		
	}
}
