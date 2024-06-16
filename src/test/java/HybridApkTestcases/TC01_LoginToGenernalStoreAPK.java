package HybridApkTestcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import AppiumLibPkg.AppiumBasePage;
import AppiumTestPkg.AndroidTestBase;

public class TC01_LoginToGenernalStoreAPK extends AndroidTestBase 
{

	@Test
	public void EnterLoginDetailsForGenStoreAPK()
	{
	 adriver.setClipboardText("Pheu Kumari");	
	 adriver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(adriver.getClipboardText());
	 
	 adriver.hideKeyboard();
	 
	 String gen = adriver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).getAttribute("checked");
	 if(gen.equals("true"))
	 {
		adriver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	 }	
	 else
	 {
		adriver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
	 }	
	 adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']")).click();
	 
	 AppiumBasePage abp = new AppiumBasePage(adriver);
	 
	 abp.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture("India");
	 
	 adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='India']")).click();
	
	 adriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}
}
