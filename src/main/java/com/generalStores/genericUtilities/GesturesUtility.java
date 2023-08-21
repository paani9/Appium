package com.generalStores.genericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class GesturesUtility {
	
	public void longClickGesture(AndroidDriver driver,WebElement element){
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));

	}
	public void doubleClickGesture(AndroidDriver driver,WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));

	}
	public void clickGesture(AndroidDriver driver,WebElement element) {
		driver.executeScript("mobile: clickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));

	}
	public void dragGesture(AndroidDriver driver,WebElement element ,int endX,int endY) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", endX,
			    "endY", endY
			));

	}
	public void pinchOpenGesture(AndroidDriver driver,WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", 0.75
			));

	}
	public void pinchCloseGesture(AndroidDriver driver,WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", 0.75
			));

	}
	
	public void swipeGesture(AndroidDriver driver,int left,int top,int width,int height) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", left, "top", top, "width", width, "height", height,
			    "direction", "left",
			    "percent", 1
			));

	}
    public void scrollGesture(AndroidDriver driver,int left,int top,int width,int height) {
    	((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
    		    "left", left, "top", top, "width", width, "height", height,
    		    "direction", "down",
    		    "percent", 3.0
    		));
    }
    
}
