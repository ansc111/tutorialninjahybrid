package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchpage {
	
    WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement noproductmessage;
	
	
	public searchpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}





public boolean displaystatusofHPValidProduct() {
	
	boolean displaystatus=validHPProduct.isDisplayed();
	
	return displaystatus;
	
}

public String  retrievenoproductmessage() {
	
	String noproductmassageText=noproductmessage.getText();
	
	return noproductmassageText;
	
}



}