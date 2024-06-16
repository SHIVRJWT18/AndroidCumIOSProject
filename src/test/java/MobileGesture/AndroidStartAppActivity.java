package MobileGesture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumLibPkg.AppiumBasePage;
import AppiumTestPkg.AndroidTestBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class AndroidStartAppActivity extends AndroidTestBase 
{

	/*To Open APk Page directly without step by step navigation:
	  * Use Below commands in the CMD to get your App activity
	  * First open the desired page in android emulator say - App>Preference>PreferenceDependencies>Wifi
	  * >>adp devices
	  * >>adb shell dumpsys window | find "mCurrentFocus"
	 * To View document Link - https://www.repeato.app/identifying-the-current-activity-in-android-via-adb/#:~:text=To%20obtain%20the%20name%20of,focus%20and%20the%20focused%20application. 
	 * In order to view Appium App Activity documentation please refer
	 * https://github.com/appium/appium-uiautomator2-driver#mobile-startactivity
	 */
	public WebElement elem;
	@Test
	public void StartAppActivityDemo()
	{
	 	
	 //Activity act = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");	
	
	 AppiumBasePage abp = new AppiumBasePage(adriver);
	 
	 abp.UserStartAppActivity("io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies");
	
		elem = adriver.findElement(AppiumBy.className("android.widget.CheckBox"));
		boolean flag = false;
		if(elem.isSelected()==flag)
		{
			System.out.println("By default elem is unchecked");
			
			elem.click();
			
			System.out.println("Element is now selected");
		}
		else
		{
			Assert.fail("Element is checked by default");
		}	
     
     elem =  adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi settings']"));
     elem.click();
     elem = adriver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/edit']"));
     elem.sendKeys("Android Wifi");
	 adriver.findElement(By.id("android:id/button1")).click();
	}
}
