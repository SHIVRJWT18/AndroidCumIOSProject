package MobileGesture;

import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import AppiumTestPkg.AndroidTestBase;
import io.appium.java_client.AppiumBy;

public class AndroidDeviceRotation extends AndroidTestBase
{

	@Test
	public void ChangeLandscapeMode()
	{
		adriver.findElement(AppiumBy.accessibilityId("Animation")).click();
		
		adriver.findElement(AppiumBy.accessibilityId("Cloning")).click();
		
		adriver.findElement(AppiumBy.accessibilityId("Run")).click();
		
		//Mobile Roatation
		
		DeviceRotation dr = new DeviceRotation(0,0,180);
		
		adriver.rotate(dr);
		
		adriver.findElement(AppiumBy.accessibilityId("Run")).click();
	}
}
