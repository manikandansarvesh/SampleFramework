package Framework.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.Properties;

public class Utility {

		private AndroidDriver<MobileElement> driver=null;

		public Utility(AndroidDriver<MobileElement> driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}

		public Utility() {
			// TODO Auto-generated constructor stub
		}

		private Properties prop = new Properties();
	
			
			public static String captureScreenshot(AppiumDriver<MobileElement> driver, String screenshotFolder) throws Exception
			{
				String path = null;
				try{
				
				String tm = Long.toString(System.currentTimeMillis());
				//take the screenshot of the entire results page and save it to a png file
				TakesScreenshot scr= (TakesScreenshot)driver;
				File scrFile = scr.getScreenshotAs(OutputType.FILE);

				path = screenshotFolder + File.separator + "screenshot" + tm +".png";
				
					FileUtils.copyFile(scrFile, new File(path));
			    }catch(Exception e){
			    	System.out.println(e);
			    }
				
				System.out.println("The Screen Shot Path is: "+path);
				return path;
			}			

		
}
