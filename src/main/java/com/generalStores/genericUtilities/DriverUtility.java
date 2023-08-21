package com.generalStores.genericUtilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverUtility {
	public void openMobileApp(String platformName,String deviceName,String automationName,String udid,String appPackage,String appActivity) throws Throwable
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		dc.setCapability(MobileCapabilityType.UDID, udid);
		dc.setCapability("appPackage", appPackage);
		dc.setCapability("appActivity", appActivity);
		dc.setCapability("noReset", true);
		dc.setCapability("autoGrantPermission", false);
		
		URL u=new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(u,dc);


	}
	
	public void openMobileAppWithLock(String platformName,String deviceName,String automationName,String udid,String appPackage,String appActivity,String unlockType,String unlockKey) throws Throwable
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		dc.setCapability(MobileCapabilityType.UDID, udid);
		dc.setCapability("appPackage", appPackage);
		dc.setCapability("appActivity", appActivity);
		dc.setCapability("noReset", true);
		dc.setCapability("autoGrantPermission", false);
		dc.setCapability("unlockType", unlockType);
		dc.setCapability("unlockKey", unlockKey);

		
		URL u=new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(u,dc);


	}
	
	public void contextHandles(AndroidDriver driver,String appPackage) {
		driver.context("WEBVIEW_"+appPackage);
	}
	
    
}
