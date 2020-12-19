package main.java.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class LoginPage extends pages.BasePage<LoginPage> {
	
	pages.ExcelDataReader excelreader=new pages.ExcelDataReader();
	@AndroidFindBy(id="sign_in_button")
	private MobileElement ALLOW_SIGNIN;
	
	
	@AndroidFindBy(className="android.widget.EditText")
	private MobileElement EMAIL_ADDRESS;
	
	@AndroidFindBy(xpath="//*[@text='Amazon password']")
	private MobileElement PASSWORD_FIELD;
	
	@AndroidFindBy(xpath="//*[@text='Continue']")
	private MobileElement CONTINUE_BTN;
	
	@AndroidFindBy(className="android.widget.Button")
	private MobileElement SIGN_IN_BTN;
	
	
	public LoginPage(AppiumDriver driver) {
		super(driver);
	}
	
	
	/**
	 * @author 
	 *
	 *  login 
	 * @return LoginPage
	 * @tag  @return
	 */
	public LoginPage selectSigninButton() {
		clickAfterFindingElement(ALLOW_SIGNIN);
		
		return this;
	}

	
	/**
	 * @author 
	 *
	 *	Set Email Address
	 * @return LoginPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public LoginPage setEmailAddress() throws Exception {
		setPassword(EMAIL_ADDRESS,)

		
		return this;
	}

	public String getTestData(String columnName){
		String testdata;
		 int columnIndex= excelreader.readHeaderIndex(System.getProperty("user.dir")+"/TestData/TestData.xlsx");



	}
	
	/**
	 * @author 
	 *
	 *	Click on Continue button
	 * @return LoginPage
	 * @tag  @return
	 */
	public LoginPage selectContinue() {
		
		return this;
	}
	
	/**
	 * @author 
	 *
	 *	Enter the password
	 * @return LoginPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public LoginPage setPassword() throws Exception {
		
		return this;
	}
	
	
	/**
	 * @author 
	 *
	 * Click on Sign in button
	 * @return ProductSearchPage
	 * @tag  @return
	 */
	public ProductSearchPage selectSignIn() {
		
		return new ProductSearchPage(getDriver());
	}
	

}
