package com.appium.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBrowserStack {
	public static final String userName="paavani_hsaAeG";
	public static final String accessKey="SiCdcXKbPQcGgsYEonqn";
	public static final String url="https://"+userName+":"+accessKey+"@hub.browserstack.com/wd/hub";
	//https://<USERNAME>:<ACCESS_KEY>@hub.browserstack.com/wd/hub
	@Test
	public void mobileBrowser() throws Throwable {
		//System.out.println(url);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Vivo Y21");
	     // dc.setCapability("os_version", "11")
	     
	       dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	      dc.setCapability("build", "2.2.3");
	      dc.setCapability("name", "My Mobile Test");
				URL u=new URL(url);
				WebDriver driver = new RemoteWebDriver(u,dc);
				driver.get("https://www.amazon.com");
				driver.quit();
	     
	      
	      
	      
	      
	}
	
	

}
