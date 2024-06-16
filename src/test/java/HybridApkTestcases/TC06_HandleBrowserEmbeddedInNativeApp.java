package HybridApkTestcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import AppiumLibPkg.AppiumBasePage;
import AppiumTestPkg.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC06_HandleBrowserEmbeddedInNativeApp extends AndroidTestBase
{
    /* Hybrid App is mixture of Native and Browser App
	   Ex- Gen Store is a native app which redirect to browser link (say Payment Link Page) in order  
	   to make payment of product added to the cart.
	*/
	@Test
	public void SwitchToBrowserPortionOfHybridApp() throws InterruptedException
	{
	  adriver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kapil Kuamr");
	  
	  adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']")).click();
	  
	  AppiumBasePage abp = new AppiumBasePage(adriver);
		 
	  abp.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture("Australia");
	  
	  adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Australia']")).click();
			
	  adriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	  
	  Thread.sleep(2000);
	  	  
	  abp.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture("Converse All Star");
		 
	  adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='Converse All Star']/..//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
	
	  adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/counterText']")).click();
		 
	  Thread.sleep(2000);
	  
	  adriver.findElement(By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")).click();
	  
	  adriver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	  
	  Thread.sleep(5000);
	  
	  // Native app driver need to access Web Browser
	  
	  Set<String> contextname = adriver.getContextHandles();
	  
	  for(String str: contextname)
	  {
		  System.out.println("Available Context: "+str);
	  }	  
	
	  adriver.context("WEBVIEW_com.androidsample.generalstore"); 
	  
	  /* Here inspection of element can be done with browser (Here chrome used with version 61.0.316) Or 
	   through Native app also (Here Gen Store is native) both are same.  
	   To use chrome we must set driver executable of required version in Appium Test base Class Or Update the
	   Chrome in Emulator
	  */
	  adriver.findElement(By.xpath("//*[@name='q']")).sendKeys("Facebook");
	  
	  adriver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
	  
	  // To get back access to Native app 
	  
	  adriver.pressKey(new KeyEvent(AndroidKey.BACK));
	  
	  adriver.context("NATIVE_APP");
	
	}
}
