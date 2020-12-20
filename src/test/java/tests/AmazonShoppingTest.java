package tests;


import Framework.base.BaseTest;
import Framework.common.ExtendReport;
import Framework.common.LoggerAgent;
import Framework.pages.LoginPage;
import Framework.utilities.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.LogStatus;

import static sun.util.logging.LoggingSupport.log;


public class AmazonShoppingTest extends BaseTest {
	public static ExtentTest test;
	
	/*Test for login, 
	 * adding product and 
	 * validation
	 * @Manikandan
	*/
	@Test(priority=1,enabled=true)
	public void validateAmazonProductAdded() throws Exception {
		new LoginPage(driver)
		.selectSigninButton()
		.setEmailAddress()
		.selectContinue()
		.setPassword()
		.selectSignIn()
		.searchProduct()
		.selectProduct()
		.selectSearchedProduct()
		.validateProductScreenValuesVsCheckout()
		.rotateToPortrait();
		test.log(LogStatus.PASS, "Product Shipped Successfully...", test.addScreenCapture(Utility.captureScreenshot(driver, getProperty("ScreenShot_Path"))));

	}

	
}
