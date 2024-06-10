package AppiumLibPkg;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AppiumBasePage 
{
	public static AndroidDriver adriver;
    public static JavascriptExecutor jsExec;

	public AppiumBasePage(AndroidDriver driver)
	{
		adriver = driver;
		jsExec = ((JavascriptExecutor) adriver);
	}
	
	public void UseLongPressMobileGesture(WebElement elem, int timeduration)
	{
		  /*  // Java
		  ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) element).getId()
				));
	      */
		
		jsExec.executeScript("mobile: longClickGesture", 
		ImmutableMap.of("elementId",((RemoteWebElement)elem).getId()),"duration",timeduration);
		
	}
	
	public void UseScrollUptoDesiredTextByAndroidUIAutomatorGesture(String desiredtext)
	{

	 adriver.findElement(AppiumBy.androidUIAutomator
	 ("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+desiredtext+"\"));"));
		
	}
	
	public void UseScrollToMobileGesture(int left,int top,int width,int height,String direction,double percent)
	{
	 /*	// Java
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
		ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 1.0
		));
	 */	
		boolean canscrollmore;
		
		do
		{
		 canscrollmore = (Boolean)jsExec.executeScript("mobile: scrollGesture", 
		 ImmutableMap.of("left",left,"top",top,"width",width,"height",height,"direction",direction,"percent",percent));
		}
		while(canscrollmore); 
	  }
	
	
	public void UseSwipeMobileGesture(WebElement elem, String direction,double percent)
	{
	 /*	// Java
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "left",
		    "percent", 0.75
		));
	 */	

	  jsExec.executeScript("mobile: swipeGesture", 
	  ImmutableMap.of("elementId",((RemoteWebElement)elem).getId(),"direction",direction,"percent",percent));
		
	}	
	
	

}
