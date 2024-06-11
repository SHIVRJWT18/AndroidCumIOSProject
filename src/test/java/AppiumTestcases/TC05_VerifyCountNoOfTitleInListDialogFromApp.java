package AppiumTestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import AppiumTestPkg.AppiumTestBase;
import io.appium.java_client.AppiumBy;

public class TC05_VerifyCountNoOfTitleInListDialogFromApp extends AppiumTestBase
{
	 /*TestCase:
      * Click on Apk File on the Emulator then Click on App. 
		Go to AlertDialog, then ListDialog <Count & print the Header titles>
	 */ 
	@Test
	public void GetAndVerifyCountOfTitlesInHeaderList()
	{
		adriver.findElement(AppiumBy.accessibilityId("App")).click();
		
		adriver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		adriver.findElement(By.id("io.appium.android.apis:id/select_button")).click();
		
		List<WebElement> element = adriver.findElements(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']"));
		int esize = element.size();
		int count =0;
		for(int i=0;i<esize;i++)
		{
		 element = 	adriver.findElements(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']"));
		 String name = element.get(i).getText();
		 System.out.println("Header name: "+name);
		 count++;
		}	
	    System.out.println("Total Headers: "+count);
	}
 }