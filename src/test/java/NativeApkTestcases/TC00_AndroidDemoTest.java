package NativeApkTestcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TC00_AndroidDemoTest {
	
	

	
	
	@Test
	public void AppiumEmulatorTest() throws MalformedURLException, URISyntaxException
	{
		
		//Start Appium Server Service automatically
		AppiumDriverLocalService apumservercie = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Dell\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.1.43").usingPort(4723).build();
		
		apumservercie.start();
		
		
		UiAutomator2Options optn = new UiAutomator2Options();
		optn.setDeviceName("Pixel 8 API 31"); // Emulator Device Name
		optn.setApp("F:\\SHIV NEWSCRIPTS\\AppiumBasicProject\\src\\main\\java\\ConfigPkg\\ApiDemos-debug.apk");
	
	   //Applicable locators to inspect elements are(5) - Xpath, Id,accessibilityId, className, androidUiAutomator 
	   
	   //AppiumBy is used instead of By in order to access 2 locator- accessibilityId ||  androidUiAutomator 
		
		AndroidDriver adriver = new AndroidDriver(new URI("http://192.168.1.43:4723").toURL(),optn);
	   
	   adriver.findElement(AppiumBy.accessibilityId("Preference")).click();
	   
	   adriver.quit();
	   
	   apumservercie.stop();
	
	
	}

    }
