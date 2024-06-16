package MobileGesture;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import AppiumTestPkg.AndroidTestBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HandlingButtonsOnAndroidDevice extends AndroidTestBase 
{

	@Test
	public void HandlingKeyEvents() throws InterruptedException
	{
        adriver.findElement(AppiumBy.accessibilityId("App")).click();
		
		adriver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		adriver.pressKey(new KeyEvent(AndroidKey.BACK));
		
        Thread.sleep(2500);
		
		adriver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		adriver.findElement(By.id("io.appium.android.apis:id/checkbox_button")).click();
		
		adriver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
}
