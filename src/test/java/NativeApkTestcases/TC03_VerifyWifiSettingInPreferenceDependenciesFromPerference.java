package NativeApkTestcases;


import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import AppiumTestPkg.AppiumTestBase;
import io.appium.java_client.AppiumBy;


public class TC03_VerifyWifiSettingInPreferenceDependenciesFromPerference extends AppiumTestBase {
	
	public WebElement elem;
	@Test
	public void EnableWifiSettinginTestAPK() throws MalformedURLException, URISyntaxException
	{
		
      /*TestCase:
       *Click on Apk File on the Emulator then Click on Preferences. 
		Go to PreferenceDependencies, then Check Wifi Click on Wifi Setting and Set Wifi Setting
	  */ 
	   
		elem = adriver.findElement(AppiumBy.accessibilityId("Preference"));
		elem.click();
		elem = adriver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"));
		elem.click();
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
