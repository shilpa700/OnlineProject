package com.qa.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class SeleniumListener implements WebDriverEventListener  {

	
	public void afterAlertAccept(WebDriver driver) {
	System.out.println("user accepted alert");
		
	}
	
	public void afterAlertDismiss(WebDriver driver) {
		
		System.out.println("user dismissed alert");
	}
	
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
		System.out.println("inside method afterChangeValueOf on " + arg0.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("user clicking on an element with name ");
		
	}
	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		
		System.out.println("user found a webelelment ");
	}
	
	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("Inside the after navigateback to " + arg0.getCurrentUrl());
		
	}
	
	public void afterNavigateForward(WebDriver arg0) {
		
		System.out.println("Inside the afterNavigateForward to " + arg0.getCurrentUrl());
	}
	
	public void afterNavigateRefresh(WebDriver arg0) {
		
		
	}
	
	public void afterNavigateTo(String url, WebDriver driver) {
		
		System.out.println("user navidated successfully "+url);
	}
	
	public void afterScript(String arg0, WebDriver arg1) {
		
		System.out.println("Inside the afterScript to, Script is " + arg0);
	}

	public void beforeAlertAccept(WebDriver driver) {
	 
		System.out.println("user accepting alert");
		
	}
	
	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("user dimissing alert");
		
	}
	
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
		System.out.println("Inside the beforeChangeValueOf method");
	}
	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		
		System.out.println("user click on an element with name ");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println("user finding a webelelment ");
		
		
	}
	
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("user navigated back ");
		
	}
	
	public void beforeNavigateForward(WebDriver arg0) {
		
		System.out.println("user navigated forward ");
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		
		
	}
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("user navidateing to new url "+url);
		
		
	}
	
	public void beforeScript(String arg0, WebDriver arg1) {
	
		System.out.println("Just before beforeScript " + arg0);
	}
	
	public void onException(Throwable throwable, WebDriver driver) {
		
		System.out.println("exception occured in the script "+throwable.getMessage());
	}

}
