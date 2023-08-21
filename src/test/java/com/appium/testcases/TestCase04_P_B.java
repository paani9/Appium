package com.appium.testcases;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.generalStores.genericUtilities.BaseAppiumClass;
import com.generalstore.objectRepository.CartPage;
import com.generalstore.objectRepository.LoginPage;
import com.generalstore.objectRepository.ProductsPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestCase04_P_B extends BaseAppiumClass {
	@Test
	public void TestCase3() throws Throwable {
		
		
		loginPage.loginIntoGeneralStoreApp("Realme10");
		productsPage.addTheProductToAddToCart();
		Thread.sleep(1000);
		cartPage.getProduct().isDisplayed();
		
		
	}

}
