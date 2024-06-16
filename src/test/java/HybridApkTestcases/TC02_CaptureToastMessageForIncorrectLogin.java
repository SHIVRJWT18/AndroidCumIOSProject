package HybridApkTestcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumTestPkg.AndroidTestBase;

public class TC02_CaptureToastMessageForIncorrectLogin extends AndroidTestBase 
{

	@Test
	public void GetErrorMessageForIncorrectLoginInGenStoreAPK() throws InterruptedException
	{	 
	 adriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	 String toastMessage = adriver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	 
	 System.out.println(toastMessage);
	 
	 String expmessage = "Please enter your name";
	 
	 Assert.assertEquals(toastMessage,expmessage,"Incorrect Message was displayed");
	 
	 Thread.sleep(5000);
	 
	 adriver.navigate().back();
	
	 toastMessage = adriver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	 
	 System.out.println(toastMessage);
	 
	 expmessage = "Press BACK again to exit";
	 
	 Assert.assertEquals(toastMessage,expmessage,"Incorrect Message was displayed");
	}
	
 }
