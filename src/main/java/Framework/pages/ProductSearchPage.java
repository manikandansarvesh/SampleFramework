package Framework.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class ProductSearchPage extends BasePage<ProductSearchPage> {
	ExcelDataReader excelreader=new ExcelDataReader();
	
	@AndroidFindBy(id="rs_search_src_text")
	private MobileElement SEARCH_PRODUCT_FIELD;
	
	@AndroidFindBy(id="iss_search_dropdown_item_text_layout")
	private MobileElement SELECT_PRODUCT;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Sony')]")
	private MobileElement SELECT_SEARCHED_PRODUCT;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Sony')]")
	private MobileElement PRODUCT_NAME;
	
	@AndroidFindBy(id="ourPrice_availability")
	private MobileElement PRODUCT_PRICE;
	
	@AndroidFindBy(xpath="//*[@text='Add to Cart']")
	private MobileElement ADD_TO_CART_BTN;
	
	@AndroidFindBy(accessibility="Cart")
	private MobileElement PROCEED_TO_CHECKOUT;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Sony')]")
	private MobileElement CHECKOUT_PRODUCT_NAME;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'$')]")
	private MobileElement CHECKOUT_PRODUCT_PRICE;
	
	//android.view.View[@content-desc="Sony X750H 65-inch 4K Ultra HD LED TV -2020 Model"]/android.widget.TextView
	public ProductSearchPage(AppiumDriver driver) {
		super(driver);
	}
	
	
	/**
	 * @author 
	 *
	 *	Search the product
	 * @return ProductSearchPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public ProductSearchPage searchProduct() throws Exception {
		clickAfterFindingElement(SEARCH_PRODUCT_FIELD);
		setvalues(SEARCH_PRODUCT_FIELD,getTestData("ProductName","TC01"));
		
		return this;
	}

	
	/**
	 * @author
	 *
	 *	Select the product
	 * @return ProductSearchPage
	 * @tag  @return
	 */
	public ProductSearchPage selectProduct() {
		clickAfterFindingElement(SELECT_PRODUCT);
		scrollDown(3);


		return this;
	}
	
	
	/**
	 * @author 
	 *
	 *
	 * @return ProductSearchPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public ProductSearchPage selectSearchedProduct() throws Exception {
		waitForElementToBeDisplayed(PRODUCT_NAME);
		clickAfterFindingElement(PRODUCT_NAME);

		return this;
	}
	
	
	/**
	 * @author 
	 *
	 *	Validate the product value vs Check out product
	 * @return ProductSearchPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public ProductSearchPage validateProductScreenValuesVsCheckout()throws Exception {
		scrollDown(1);
		String productName=getTextAfterFindingElement(PRODUCT_NAME);
		String productPrice=getTextAfterFindingElement(PRODUCT_PRICE);
		clickAfterFindingElement(ADD_TO_CART_BTN);
		clickAfterFindingElement(PROCEED_TO_CHECKOUT);
		getDriver().hideKeyboard();
		clickAfterFindingElement(ADD_TO_CART_BTN);
		Assert.assertEquals(getTextAfterFindingElement(PRODUCT_NAME),getTextAfterFindingElement(CHECKOUT_PRODUCT_NAME));
		Assert.assertEquals(getTextAfterFindingElement(PRODUCT_PRICE),getTextAfterFindingElement(CHECKOUT_PRODUCT_PRICE));
		
		return this;
	}
	
}
	