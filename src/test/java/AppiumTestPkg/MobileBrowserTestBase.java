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

public class MobileBrowserTestBase {

	public AndroidDriver driver;
	public AppiumDriverLocalService aservice;
	public String appiumServerPort  = "http://192.168.1.80:4723/";

	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException
	{
		aservice = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Dell\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.1.38").usingPort(4723).build();
		
	//	aservice.start();
		
		UiAutomator2Options optn = new UiAutomator2Options();
		
		optn.setDeviceName("Pixel 2 Orieo"); // Emulator Device Name
		optn.setCapability("browserName", "Chrome");			
		optn.setAutomationName("UiAutomator2");
		optn.setPlatformName("ANDROID");
		
		driver = new AndroidDriver(new URI(appiumServerPort).toURL(),optn);
	
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	
	@AfterClass
	public void closeServerServices() 
	{
		driver.quit();
		
		aservice.stop();
	}
}

