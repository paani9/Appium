package com.appium.testcases;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.generalstore.objectRepository.CartPage;
import com.generalstore.objectRepository.LoginPage;
import com.generalstore.objectRepository.ProductsPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestCase03_P {
	@Test
	public void TestCase3() throws Throwable {
		File f=new File("C:\\Users\\user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService server=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300L)).build();
		server.start();
		DesiredCapabilities dc=new DesiredCapabilities();
		//Identify specific device
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 23");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID,"emulator-5554");
		//Open the particular app
		dc.setCapability("appPackage","com.androidsample.generalstore");
		dc.setCapability("appActivity",".MainActivity");
		URL url=new URL("http://localhost:4723");
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginIntoGeneralStoreApp("Realme10");
		ProductsPage productsPage=new ProductsPage(driver);
		productsPage.addTheProductToAddToCart();
		Thread.sleep(1000);
		CartPage cartPage=new CartPage(driver);
		cartPage.getProduct().isDisplayed();
		driver.quit();
		server.stop();
		
	}

}
