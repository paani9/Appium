package com.appium.demo;

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


public class OpenApiDemos {
	
	@Test
	public void OpenApiDemosApp() throws Throwable {
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
		dc.setCapability("appPackage","io.appium.android.apis");
		dc.setCapability("appActivity",".ApiDemos");
		URL url=new URL("http://localhost:4723");
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		driver.quit();
		server.stop();
		
	}
	@Test
	
	public void OpenAjioApp() throws Throwable {
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
		dc.setCapability("appPackage","com.ril.ajio");
		dc.setCapability("appActivity",".home.AjioHomeActivity");
		URL url=new URL("http://localhost:4723");
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
		driver.quit();
		server.stop();
		
	}
	@Test
	
	public void OpenAjioAppInRealme() throws Throwable {
		File f=new File("C:\\Users\\user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService server=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300L)).build();
		server.start();
		DesiredCapabilities dc=new DesiredCapabilities();
		//Identify specific device
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Realme");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID,"2b9bfa58");
		dc.setCapability("noReset", "true");  
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("disableWindowAnimation", true);
		dc.setCapability("autoAcceptAlerts", true);
		//Open the particular app
		dc.setCapability("appPackage","com.ril.ajio");
		
		dc.setCapability("appActivity","com.ril.ajio.home.AjioHomeActivity");
		URL url=new URL("http://localhost:4723");
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
		driver.quit();
		server.stop();
		
	}

}
