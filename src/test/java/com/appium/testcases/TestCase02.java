package com.appium.testcases;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestCase02 {
	@Parameters({"deviceName", "UDID", "port"})
	@Test
	public void TestCase2(String deviceName, String UDID, int port) throws Throwable {
	File f=new File("C:\\Users\\user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
	AppiumDriverLocalService server=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300L)).build();
	server.start();
	DesiredCapabilities dc=new DesiredCapabilities();
	//Identify specific device
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
	dc.setCapability(MobileCapabilityType.UDID,UDID);
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
	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Let's Shop']")).click();
	driver.quit();
	server.stop();
	
}
}
