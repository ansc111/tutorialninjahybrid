package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountsuccesspage {
	
WebDriver driver;
@FindBy(xpath="//div[@id='content']/h1")	
private WebElement  pageHeading;


public Accountsuccesspage(WebDriver driver) {
	
	this.driver=  driver;
	
	PageFactory.initElements(driver,this);
	
}

public String  retrieveaccountsuccesspageheading() {
	
	String accountsuccesspageheadingtext=pageHeading.getText();
	return accountsuccesspageheadingtext;
	
	
}



}
