package base;


import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import common.PropertyExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(common.MyTestListener.class)
public class BaseTest extends PropertyExecutor{
	DesiredCapabilities androidDC=new DesiredCapabilities();
	public AppiumDriver<MobileElement> driver;

	
	/**
	 * @Manikandan
	 *
	 *
	 * @return void
	 * @tag  @throws MalformedURLException
	 * @tag  @throws Exception
	 */
	@BeforeClass
	public void setup() throws MalformedURLException, Exception {
		androidDC.setCapability(MobileCapabilityType.PLATFORM_NAME, getProperty("platformName"));
		androidDC.setCapability(MobileCapabilityType.PLATFORM_VERSION,getProperty("platformVersion"));
		androidDC.setCapability(MobileCapabilityType.DEVICE_NAME,getProperty("deviceName"));
		androidDC.setCapability(MobileCapabilityType.UDID,getProperty("udid"));
		androidDC.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/APK/Amazon_shopping.apk");
		androidDC.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,getProperty("appPackage"));
		androidDC.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,getProperty("appActivity"));
		androidDC.setCapability(MobileCapabilityType.AUTOMATION_NAME,getProperty("automationName"));
		driver=new AndroidDriver<MobileElement>(new URL(getProperty("URL")),androidDC);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	

	
	/**
	 * @author 
	 *
	 *
	 * @return void
	 * @tag  @param m
	 */
	@BeforeMethod
	public void beforeMethod(Method m)  {
		
		
	}	
	
	

/**
 * @author 
 *
 *
 * @return void
 * @tag  @param result
 * @tag  @throws FileNotFoundException
 */
@AfterMethod
public void afterMethod(ITestResult result) throws FileNotFoundException {
	
	}
	
	
	/**
	 * @author 
	 * @return void
	 * @tag  
	 */
	@AfterClass
	public void tearDown() {
		
	}
	
	
	
}
