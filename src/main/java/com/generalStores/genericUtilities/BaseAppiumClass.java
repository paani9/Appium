package com.generalStores.genericUtilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.generalstore.objectRepository.CartPage;
import com.generalstore.objectRepository.LoginPage;
import com.generalstore.objectRepository.ProductsPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseAppiumClass {
	AppiumDriverLocalService server;
	public AndroidDriver driver;
	public LoginPage loginPage;
	public ProductsPage productsPage;
	public CartPage cartPage;
	
	@BeforeSuite
	public void startServer() {
		File f=new File("C:\\Users\\user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		server=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300L)).build();
		server.start();
	}
	@BeforeMethod
	public void openApp() throws Throwable {
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
		 driver=new AndroidDriver(url,dc);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
		
		 loginPage=new LoginPage(driver);
		 productsPage=new ProductsPage(driver);
		 cartPage=new CartPage(driver);
	}
	
	@AfterMethod
	public void closeApp()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void closeServer() {
		server.stop();
	}

}
