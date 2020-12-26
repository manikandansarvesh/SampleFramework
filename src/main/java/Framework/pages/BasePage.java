package Framework.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


/**
 * @Manikandan
 *
 * 09-Oct-2020
 */
public class BasePage<T extends BasePage<T>> {

	public String text;
	private AppiumDriver driver;
	
	public BasePage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()),this);
	}

	public AppiumDriver getDriver() {
		return this.driver;
	}
	
	/**
	 * @Manikandan 
	 *This method is for click on a Element after locating it
	 *
	 * @return void
	 * @tag  @param mobileElement
	 */
	public void clickAfterFindingElement(MobileElement mobileElement) {
		fastClick(mobileElement,10);
		
	}
	
	
	//Getting the text from a mobile element
	public String getTextAfterFindingElement(MobileElement mobileElement) {
		try{

			text=getElementText(mobileElement,10);
		}catch (Exception e){
			Assert.fail("Unable to get text for the specified object:"+e.getMessage());
		}
		System.out.println("---------------->>"+text);
		return text;
		
	}
	
	
	/**
	 * @Manikandan 
	 *
	 *	This method is for set the implicit wait
	 * @return void
	 * @tag  @param mobileElement
	 * @tag  @throws Exception
	 */
	public void waitForElementToBeDisplayed(MobileElement mobileElement) throws Exception {
		try {
			mobileElement.isDisplayed();
		} catch (java.util.NoSuchElementException e) {
			Assert.fail("Unable to find element: " + e.getMessage());
		}
	}

	
	private String getElementText(MobileElement mobileElement,int timeOutInSeconds) {
		getDriver().manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
		text=mobileElement.getText();


	return text;
	}
	
	//setting values on text field
	public void setvalues(MobileElement mobileElement, String value) {
		mobileElement.sendKeys(value);

		
	}
	
	// Clicking on a particular element
	private void fastClick(MobileElement mobileElement,int timeOutInSeconds) {
		Wait wait=new WebDriverWait(getDriver(),timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
		mobileElement.click();

		
	}
	
	
	/**
	 * @Manikandan 
	 *
	 * Method for Scrolling 
	 * @return void
	 * @tag  @param times
	 */
	public void scrollDown(int times) {
		for(int i=0;i< times;i++) {
			Dimension dim= getDriver().manage().window().getSize();
			int height=dim.getHeight();
			int width=dim.getWidth();
			int x=width/2;
			int starty=(int)(height*0.85);
			int endy=(int)(height*0.5);
			TouchAction action= new TouchAction(getDriver());
			action.press(PointOption.point(x,starty));
			action.moveTo(PointOption.point(x, endy));
			action.release().perform();
	}
	}

	
	/**
	 * @Manikandan 
	 *
	 * Rotation methods 1. Rotating Landscape 2. Rotating Portrait
	 * @return void
	 * @tag  @param times
	 */
	
	public T rotateToLandscape() {

		getDriver().rotate(ScreenOrientation.LANDSCAPE);
		return (T)this;
	}
	
	
	public T rotateToPortrait() {

		getDriver().rotate(ScreenOrientation.PORTRAIT);

		return (T)this;
	}


	public String getTestData(String columnName,String testcaseID){
		String testdata;
		ExcelDataReader excelDataReader=new ExcelDataReader();
		int columnIndex= excelDataReader.readHeaderIndex(System.getProperty("user.dir")+"/TestData/TestData.xlsx","TestData",columnName);
		testdata=excelDataReader.readXLatIndex(System.getProperty("user.dir")+"/TestData/TestData.xlsx","TestData",testcaseID,columnIndex);
		return testdata;

	}
}
