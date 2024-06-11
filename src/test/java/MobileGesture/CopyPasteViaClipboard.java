package MobileGesture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import AppiumTestPkg.AppiumTestBase;
import io.appium.java_client.AppiumBy;

public class CopyPasteViaClipboard extends AppiumTestBase
{
 @Test

 public void CopyPasteThroughClipboard()
 {
		adriver.findElement(AppiumBy.accessibilityId("App")).click();
		
		adriver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		adriver.findElement(By.id("io.appium.android.apis:id/text_entry_button")).click();
	
		//Get and Set Clipboard
		adriver.setClipboardText("Rakesh Kumar");
		
		WebElement elem = adriver.findElement(By.id("io.appium.android.apis:id/username_edit"));
		elem.sendKeys(adriver.getClipboardText());
		
		adriver.setClipboardText("rk@123");
		
		elem= adriver.findElement(By.id("io.appium.android.apis:id/password_edit"));
		elem.sendKeys(adriver.getClipboardText());
		
		adriver.findElement(By.id("android:id/button1")).click();
 }
}
