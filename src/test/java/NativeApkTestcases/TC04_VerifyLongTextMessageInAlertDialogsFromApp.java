package NativeApkTestcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import AppiumTestPkg.AppiumTestBase;
import io.appium.java_client.AppiumBy;

public class TC04_VerifyLongTextMessageInAlertDialogsFromApp extends AppiumTestBase
{
	 /*TestCase:
      *Click on Apk File on the Emulator then Click on App. 
	  Go to AlertDialog, then Ok cancel dialog with a long message <Get the message>
	 */ 
	@Test
	public void GetLongTextMessage()
	{
		adriver.findElement(AppiumBy.accessibilityId("App")).click();
		
		adriver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		adriver.findElement(By.id("io.appium.android.apis:id/two_buttons2")).click();
		
		String actmsg = adriver.findElement(By.id("android:id/message")).getText();
		
		System.out.println(actmsg);
		
		if(actmsg.endsWith("dseg"))
		{
		 System.out.println("Correct Message is displayed");	
		}	
		else
		{
		 System.out.println("Incorrect Message is displayed");	
		}	
		
		adriver.findElement(By.id("android:id/button1")).click();
	
		
	
	
	
	}
}
