package MobileGesture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumLibPkg.AppiumBasePage;
import AppiumTestPkg.AppiumTestBase;
import io.appium.java_client.AppiumBy;

public class SwipeGesture extends AppiumTestBase
{
 @Test	
 public void MobileGestureSwipe()
 {
	adriver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
	adriver.findElement(AppiumBy.accessibilityId("Gallery")).click();
	adriver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
	WebElement elem = adriver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"));
	String actfocus = elem.getAttribute("focusable");
	System.out.println("Inital Focus: "+actfocus);
	
	//swipe
	AppiumBasePage abp = new AppiumBasePage(adriver);
	abp.UseSwipeMobileGesture(elem, "left", 0.03f);
	
	String expfocus = adriver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]")).getAttribute("focusable");
	
	System.out.println("Final Focus: "+expfocus);
    
 }
}
