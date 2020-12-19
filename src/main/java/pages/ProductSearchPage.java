package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

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
		
		return this;
	}
	
}
	