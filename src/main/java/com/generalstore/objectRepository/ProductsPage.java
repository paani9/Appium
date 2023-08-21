package com.generalstore.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ProductsPage {
AndroidDriver driver;
@FindBy(xpath="//android.widget.TextView[@text='Air Jordan 4 Retro']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@text='ADD TO CART']")
private WebElement productAddToCartBtn;
@FindBy(xpath="//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")
private WebElement addToCartIcon;

public ProductsPage(AndroidDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public AndroidDriver getDriver() {
	return driver;
}
public WebElement getProductAddToCartBtn() {
	return productAddToCartBtn;
}
public WebElement getAddToCartIcon() {
	return addToCartIcon;
}

public void addTheProductToAddToCart() {
	getProductAddToCartBtn().click();
	getAddToCartIcon().click();
	
}










}
