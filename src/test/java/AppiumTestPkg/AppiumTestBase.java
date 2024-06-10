package AppiumTestPkg;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumTestBase 
{

	public AndroidDriver adriver;
	public AppiumDriverLocalService aservice;

	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException
	{
		aservice = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Dell\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.1.43").usingPort(4723).build();
		
		aservice.start();
		
		UiAutomator2Options optn = new UiAutomator2Options();
		
		optn.setDeviceName("Pixel 8 API 31"); // Emulator Device Name
		optn.setApp("F:\\SHIV NEWSCRIPTS\\AppiumBasicProject\\src\\main\\java\\ConfigPkg\\ApiDemos-debug.apk");
		optn.setAutomationName("UiAutomator2");
		optn.setPlatformName("ANDROID");
		
		
		adriver = new AndroidDriver(new URI("http://192.168.1.43:4723").toURL(),optn);
	
	    adriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	
	@AfterClass
	public void closeServerServices() 
	{
		adriver.quit();
		
		aservice.stop();
	}
}
