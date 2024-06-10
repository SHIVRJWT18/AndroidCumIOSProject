package MobileGesture;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import AppiumLibPkg.AppiumBasePage;
import AppiumTestPkg.AppiumTestBase;
import io.appium.java_client.AppiumBy;



public class LongPressGesture extends AppiumTestBase
{
    // In APK File, Click on views - Extendable List - 1. Custom Adapter - People Names <Long press on People Names>
	@Test
	public void MobileGestureLongPress() throws InterruptedException
	{
	  adriver.findElement(AppiumBy.accessibilityId("Views")).click();
	  
	  adriver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
	  
	  adriver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
	  
	  /* Java
	  ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));
      */
	  
	  WebElement elem = adriver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	  
	  ((JavascriptExecutor)adriver).executeScript("mobile: longClickGesture",
			  ImmutableMap.of("elementId",((RemoteWebElement)elem).getId()),
			  "duration",2000);


      adriver.navigate().back();
	  	  
	  AppiumBasePage abp = new AppiumBasePage(adriver);
	  
	   elem = adriver.findElement(By.xpath("//android.widget.TextView[@text='Dog Names']"));
	  
	  abp.UseLongPressMobileGesture(elem, 3000);
	  
	  Thread.sleep(3000);
	  
	  String actitem = adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Sample menu']")).getText();
	  
	  System.out.println("Popup Item: "+actitem);
	  
	  String expitem = "Sample menu";
	  
	  Assert.assertEquals(expitem, actitem, "Item name should be matched");
	  
	  
	
		
	//android.widget.TextView[@resource-id='android:id/title' and @text='Sample menu']

	
	
	
	
	
	}
 }