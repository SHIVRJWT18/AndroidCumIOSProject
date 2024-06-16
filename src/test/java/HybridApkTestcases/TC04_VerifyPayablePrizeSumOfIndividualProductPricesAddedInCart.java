package HybridApkTestcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import AppiumLibPkg.AppiumBasePage;
import AppiumTestPkg.AndroidTestBase;

public class TC04_VerifyPayablePrizeSumOfIndividualProductPricesAddedInCart extends AndroidTestBase 
{

	@Test
	public void EnterLoginDetailsForGenStoreAPK() throws InterruptedException
	{
	 adriver.setClipboardText("Neha Patel");	
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
	 
	 abp.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture("Brazil");
	 
	 adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Brazil']")).click();
	
	 adriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	 
	 Thread.sleep(2000);
	 
	 WebDriverWait wait = new WebDriverWait(adriver, Duration.ofSeconds(4));
	 
	 WebElement elem = adriver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
	 
	 wait.until(ExpectedConditions.attributeContains(elem, "text", "Products"));
	 
	 abp.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture("Air Jordan 1 Mid SE");
	 
	 adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='Air Jordan 1 Mid SE']/..//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
	 
	 abp.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture("Jordan 6 Rings");
	 
	 adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='Jordan 6 Rings']/..//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
	 
	 abp.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture("PG 3");
	 
	 adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='PG 3']/..//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
		 

	 adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/counterText']")).click();
	 
	 Thread.sleep(2000);
	  
	 elem = adriver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
	 	 
	 wait.until(ExpectedConditions.attributeContains(elem,"text","Cart"));
	 
	// abp.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture("PG 3");
	 
	 abp.UseScrollToMobileGesture(100, 100, 600, 600, "down", 0.9);
	 
	 Thread.sleep(2000);
	 
     int count =0;
     double sum =0;
     List<WebElement> elements = adriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']"));
     int esize = elements.size();
     for(int i =0;i<esize;i++)
     {
      elements = adriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']"));	 
    	 
      String s = elements.get(i).getText();
         
      double p = Double.valueOf(s.substring(1));
      sum = sum +p;
      count++;
     }	 
	 System.out.println("Payable Price: "+sum);
	 
	 System.out.println("Total Items: "+count);
	 	 
	}
}

