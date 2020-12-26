package Framework.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class LoginPage extends BasePage<LoginPage> {
	
	ExcelDataReader excelreader=new ExcelDataReader();
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
	 * @Manikandan 
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
	 * @Manikandan 
	 *
	 *	Set Email Address
	 * @return LoginPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public LoginPage setEmailAddress() throws Exception {
		setvalues(EMAIL_ADDRESS,getTestData("Username","TC01"));

		
		return this;
	}

	
	/**
	 * @Manikandan 
	 *
	 *	Click on Continue button
	 * @return LoginPage
	 * @tag  @return
	 */
	public LoginPage selectContinue() {
		clickAfterFindingElement(CONTINUE_BTN);
		return this;
	}
	
	/**
	 * @Manikandan 
	 *
	 *	Enter the password
	 * @return LoginPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public LoginPage setPassword() throws Exception {
		setvalues(PASSWORD_FIELD,getTestData("Password","TC01"));
		
		return this;
	}
	
	
	/**
	 * @Manikandan 
	 *
	 * Click on Sign in button
	 * @return ProductSearchPage
	 * @tag  @return
	 */
	public ProductSearchPage selectSignIn() {
		
		return new ProductSearchPage(getDriver());
	}
	

}
