package tests;


import Framework.base.BaseTest;
import Framework.pages.LoginPage;
import Framework.*;
import Framework.utilities.Utility;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.LogStatus;



public class AmazonShoppingTest extends BaseTest {
	
	/*Test for login, 
	 * adding product and 
	 * validation
	 * @author 
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
		testReporter.log(LogStatus.PASS, "Product Shipped Successfully...",  testReporter.addScreenCapture(Utility.captureScreenshot(driver, screenShotPath)));

	}

	
}
