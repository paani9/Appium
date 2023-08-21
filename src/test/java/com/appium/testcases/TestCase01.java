package com.appium.testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestCase01 {
	@Test
	public void TestCase1() throws Throwable {
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
	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Realme1");
	driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();
	Thread.sleep(3000);
	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@text='ADD TO CART']")).click();
	driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")).click();
	Thread.sleep(1000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']")).isDisplayed();
	driver.quit();
	server.stop();
	
}
	
	
}