package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//objects/locator/web element
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private  WebElement  searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private  WebElement  searchBoxButton;
	
	public HomePage(WebDriver  driver) {
		
		this.driver=driver;
		//Both  are same  for understanding
		//PageFactory.initElements(driver,HomePage.class);
		  PageFactory.initElements(driver,this);
		}
	
//actions
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
		
	}
	
	public LoginPage  selectloginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	// For above two method  optimize  clickOnMyAccount and selectloginOption
	public LoginPage navigatetologinoption() {
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
		
	}
	
	
	public RegisterPage  selectRegisterOption() {
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	
	//Action
	public void enterProductintoSearchboxField(String productText) {
		
		searchBoxField.sendKeys(productText);
	}
	
	
    public searchpage enterProductintoSearchboxF() {
		
    	searchBoxButton.click();
    	
    	return  new searchpage(driver);
	}
    //optimising two method enterProductintoSearchboxField and enterProductintoSearchbox	
    public searchpage  searchforaproduct(String producttext) {
    	searchBoxField.sendKeys(producttext);
        searchBoxButton.click();
    	return  new searchpage(driver);
    }
	
    //optimising two method selectRegisterOption(),clickOnMyAccount()
    public RegisterPage navigatetoregisterpage() {
    	
		myAccountDropMenu.click();
		RegisterOption.click();
		return new RegisterPage(driver);
		}
	
	
	  
	
	
	
	
	
	
	
	
	
	
	

		
	

}
