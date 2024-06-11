package AppiumTestcases;


import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.testng.annotations.Test;
import AppiumTestPkg.AppiumTestBase;
import io.appium.java_client.AppiumBy;


public class TC01_VerifyClickPreferenceTabInTestingAPKFile extends AppiumTestBase {
	
	
	@Test
	public void EnableWifiSettinginTestAPK() throws MalformedURLException, URISyntaxException
	{
		
      /*TestCase:
         Click on Apk File on the Emulator then Click on Preferences. 		
	  */ 
	   
		adriver.findElement(AppiumBy.accessibilityId("Preference")).click();
	   

	
	
	}

    }
