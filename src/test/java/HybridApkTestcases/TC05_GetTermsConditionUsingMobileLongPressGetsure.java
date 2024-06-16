package HybridApkTestcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumLibPkg.AppiumBasePage;
import AppiumTestPkg.AndroidTestBase;

public class TC05_GetTermsConditionUsingMobileLongPressGetsure extends AndroidTestBase 
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
	 
	 abp.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture("Jordan Lift Off");
	 
	 List<WebElement> element = adriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']"));
	 
	 int esize = element.size();
	 
	 for(int i=0;i<esize;i++)
	 {
	  element = adriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")); 
	 
	  String elemname = element.get(i).getText();
	  
	  if(elemname.equals("Jordan Lift Off"))
	  { 
	   adriver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();	  
	  }	  
	 }
	 
	 adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/counterText']")).click();
	 
	 Thread.sleep(2000);
	  
	 elem = adriver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
	 
	 wait.until(ExpectedConditions.attributeContains(elem,"text","Cart"));
	 
	 String addedproduct = adriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='Jordan Lift Off']")).getText();
	 
     System.out.println("Added Product: "+addedproduct);
	 
	 elem = adriver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	 
	 abp.UseLongPressMobileGesture(elem, 2000);
	 
	 String actheading = adriver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
	 
	 String expheading = "Terms Of Conditions";
	 
	 Assert.assertEquals(actheading, expheading,"Actual Heading is not matched with Expected");
	 
	 System.out.println(adriver.findElement(By.id("android:id/message")).getText());
	 
	 adriver.findElement(By.id("android:id/button1")).click();
	 
	     }
	}