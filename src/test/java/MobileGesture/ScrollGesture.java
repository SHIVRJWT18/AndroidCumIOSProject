package MobileGesture;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import AppiumLibPkg.AppiumBasePage;
import AppiumTestPkg.AppiumTestBase;


public class ScrollGesture extends AppiumTestBase
{

	
	@Test(enabled = false)
	public void AndroidUIAutomatorScrollGesture() throws InterruptedException
	{
	 adriver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		
	 AppiumBasePage abp = new AppiumBasePage(adriver);
	 
	 abp.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture("Tabs");
	 
	 Thread.sleep(3000);
	 
	 abp.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture("Custom");
	 		
	}
	
	@Test
	public void MobileGestureScroll()
	{
	  adriver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		
	  AppiumBasePage abp = new AppiumBasePage(adriver);
		 
	  abp.UseScrollToMobileGesture(100,100,200,200,"down",3.0);
	}
}
