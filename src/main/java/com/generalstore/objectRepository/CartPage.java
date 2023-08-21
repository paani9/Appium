package com.generalstore.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CartPage {

	AndroidDriver driver;
	
	@FindBy(xpath="//android.widget.TextView[@text='Air Jordan 4 Retro']")
	private WebElement product;
	
	public CartPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProduct() {
		return product;
	}
	
	
	
}
