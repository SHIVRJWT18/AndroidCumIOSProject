package MobileGesture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumLibPkg.AppiumBasePage;
import AppiumTestPkg.AppiumTestBase;
import io.appium.java_client.AppiumBy;

public class DragAndDrop extends AppiumTestBase 
{

	@Test
	public void DoDragAndDrop()
	{
	 adriver.findElement(AppiumBy.accessibilityId("Views")).click();
	 
	 adriver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();;
	 
	 WebElement src = adriver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	 
	 AppiumBasePage abp = new AppiumBasePage(adriver);
	 
	// abp.UseDragDropMobileGesture(src, 0, 0);
	 
	 abp.UseDragDropMobileGesture(src, 629, 560);
	 
	 String result = adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='io.appium.android.apis:id/drag_result_text']")).getText();
	 
	 System.out.println("Result: "+result);
	 
	 Assert.assertEquals(result, "Dropped!","Drag and Drop action might not be yet performed");
	}
}
