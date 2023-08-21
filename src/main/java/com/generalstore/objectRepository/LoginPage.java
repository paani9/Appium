package com.generalstore.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	AndroidDriver driver;
	@FindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryDropdown;
	@FindBy(xpath="//android.widget.EditText[@text='Enter name here']")
	private WebElement country;
	@FindBy(xpath="//android.widget.EditText[@text='Enter name here']")
	private WebElement enterNameTextField;
	@FindBy(xpath="//android.widget.RadioButton[@text=\"Female\"]")
	private WebElement femaleRadioButton;
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement LetsShopButton;
	
	public LoginPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public WebElement getCountry() {
		return country;
	}
	public WebElement getEnterNameTextField() {
		return enterNameTextField;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public WebElement getLetsShopButton() {
		return LetsShopButton;
	}
	
	public void loginIntoGeneralStoreApp(String enterName) {
		getCountryDropdown().click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
		getCountry().click();
		getEnterNameTextField().sendKeys(enterName);
		driver.navigate().back();
		getFemaleRadioButton().click();
		getLetsShopButton().click();
		
	}
	
}

