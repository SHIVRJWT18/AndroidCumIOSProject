package NativeApkTestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumTestPkg.AppiumTestBase;
import io.appium.java_client.AppiumBy;

public class TC07_VerifySelectedWeekdayInRepeatAlarmFromApp extends AppiumTestBase
{
	 /*TestCase:
     * Click on Apk File on the Emulator then Click on App. 
	   Go to AlertDialog, then RepeatAlarm -Choose weekdays for alarm
	   <Verify that No Of Selected days 5>
	 */ 
	@Test
	public void GetAndVerifyCountOfDaysForAlarm()
	{
		adriver.findElement(AppiumBy.accessibilityId("App")).click();
		
		adriver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		adriver.findElement(By.id("io.appium.android.apis:id/checkbox_button")).click();
		
		List<WebElement> element = adriver.findElements(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"));
		int esize = element.size();
		
		System.out.println("Total List: "+esize);
		
		int count =0;
		
		for(int i=0;i<esize-2;i++)
		{
		  element = adriver.findElements(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"));
		  
		  String flag = element.get(i).getAttribute("checked");
		  
		  System.out.println(flag+".."+i);
		  
		  if(flag.equals("false"))
		  {
		   element.get(i).click();  
		  }	  
		}
		adriver.findElement(By.id("android:id/button1")).click();
		
		adriver.navigate().back();
		
		adriver.findElement(By.id("io.appium.android.apis:id/checkbox_button")).click();

		for(int i=0;i<esize;i++)
		{
		 element = adriver.findElements(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"));
		  
		 if(element.get(i).getAttribute("checked").equals("true"))
		 {
		  System.out.println("Days Selected: "+element.get(i).getText());	 
		  count++;
		 }	 
		}
		
		Assert.assertEquals(count, 5,"Setting RepeatedAlarm for Weekdays is invalid");
		
	    }

}
