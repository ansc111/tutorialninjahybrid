package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 WebDriver driver;

	@FindBy(id="input-email")
	private WebElement emailaddressfield;
	
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement  loginButton;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement emailPasswordNoMatchWarning;

        
	    public LoginPage(WebDriver driver) {
		
		//First driver  is from  Login page  driver
		this.driver=driver;
		
	   PageFactory.initElements(driver,this);
	   
	   }
	    //Action  class
	   
	   public void enteremailaddress(String emailtext ) {
		   
		   emailaddressfield.sendKeys(emailtext);
		   }
	   
	   public  void  enterPassword(String passwordtext) {
		   
		   passwordfield.sendKeys(passwordtext);
		   
	   }
	   
	   public  AccountPage   clickonloginButton() {
		   loginButton.click();
		   
		   return new  AccountPage(driver);
	   }
	   //Above  two  method  optimize
	   public  AccountPage Login(String emailtext, String passwordtext)
	   
	   {
		   emailaddressfield.sendKeys(emailtext);
		   passwordfield.sendKeys(passwordtext);
            loginButton.click();
		   
		   return new  AccountPage(driver);
		   
	   }
	   public  String retriveemailpasswordnotmatchingwarningmessageText() {
		  String warningText= emailPasswordNoMatchWarning.getText();
		  return warningText;
	   }
	   
	
	
}
