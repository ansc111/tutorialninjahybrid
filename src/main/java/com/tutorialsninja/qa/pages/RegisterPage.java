package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver  driver;
	
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailaddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordconfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement ContinueField;
	
	@FindBy(xpath="//input[@name='newsletter'] [@value='1']")
	private WebElement  yesNewsletterOption;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	@FindBy(xpath="//input[@id=\"input-firstname\"]/following-sibling::div")
	private WebElement  firstnamewarning;
	
	@FindBy(xpath="//input[@id=\"input-lastname\"]/following-sibling::div")
	private WebElement lastnamewarning;
	
	@FindBy(xpath="//input[@id=\"input-email\"]/following-sibling::div")
	private WebElement emailwarning;
	
	@FindBy(xpath="//input[@id=\"input-telephone\"]/following-sibling::div")
	private  WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id=\"input-password\"]/following-sibling::div")
	private  WebElement passwordwarning;
	
	public  RegisterPage (WebDriver driver) 

    {
	
	this.driver=driver;
	
	PageFactory.initElements(driver, this);
	
    }

public  void Enterfirstname(String  firstNametext)
{
	firstNameField.sendKeys(firstNametext);
}


public  void Enterlastname(String  lastNametext)
{
	lastNameField.sendKeys(lastNametext);
	
}

public  void EnterEmailAddress(String  emailNametext)
{
	emailaddressField.sendKeys(emailNametext);
	
}


public  void Entertelephonenumber(String  telephoneNametext)
{
	telephoneField.sendKeys(telephoneNametext);
	
}

public  void enterpassword(String  passwordNametext)
{
	passwordField.sendKeys(passwordNametext);
	
}


public void enterConfirmpassword(String passwordConfirmText) {
	
	passwordconfirmField.sendKeys(passwordConfirmText);
}

 public void privacypolicy() {
	 
	 privacyPolicyField.click();
	 
	 }
 
 public Accountsuccesspage clickoncontinuebutton() {
	 
	    ContinueField.click();
	    return new Accountsuccesspage(driver);
	 }
 
 
 public void  selectYesNewsletteroption() {
	 yesNewsletterOption.click();
 }
 
 public String  retrieveDuplicateEmailaddressWarning() {
	String duplicatewarningText= duplicateEmailAddressWarning.getText();
	return duplicatewarningText;
	 
 }
 
 public String retriveprivacypolicywarning() {
	 
  String  privacyPolicyWarningText= privacyPolicyWarning.getText();
  return privacyPolicyWarningText;
	 
 }
 
 
    public String retrivefirstnamewarning() {
    	
	String firstnamewarningtext =firstnamewarning.getText();
	return firstnamewarningtext;
}

    public String retrivelastnamewarning() {
	String  lastnamewarningtext =lastnamewarning.getText();
	return  lastnamewarningtext;
	
}

    public String retriveemailwarning() {
    	String  emailwarningtext =emailwarning.getText();
    	return  emailwarningtext;
    	
    }
    
    public String retrivetelephonewarning() {
    	String  telephonewarningtext =telephoneWarning.getText();
    	return  telephonewarningtext;
    	
    }
    
    
    public String retrivepasswordwarning() {
    	String  passwordwarningtext =passwordwarning.getText();
    	return  passwordwarningtext;
    	
    }
    
    public Accountsuccesspage  registerwithmandatoryfield (String firstNametext,String lastNametext,String emailNametext,String telephoneNametext,String
    	passwordNametext){
    	firstNameField.sendKeys(firstNametext);
    	lastNameField.sendKeys(lastNametext);
    	emailaddressField.sendKeys(emailNametext);
    	telephoneField.sendKeys(telephoneNametext);
    	passwordField.sendKeys(passwordNametext);
    	passwordconfirmField.sendKeys(passwordNametext);
    	privacyPolicyField.click();
    	ContinueField.click();
 	    return new Accountsuccesspage(driver);
    }
    public Accountsuccesspage registerwithALLfield (String firstNametext,String lastNametext,String emailNametext,String telephoneNametext,String passwordNametext){
        	firstNameField.sendKeys(firstNametext);
        	lastNameField.sendKeys(lastNametext);
        	emailaddressField.sendKeys(emailNametext);
        	telephoneField.sendKeys(telephoneNametext);
        	passwordField.sendKeys(passwordNametext);
        	passwordconfirmField.sendKeys(passwordNametext);
        	yesNewsletterOption.click();
        	privacyPolicyField.click();
        	ContinueField.click();
     	    return new Accountsuccesspage(driver);
    	  	
    }
    
    public boolean displaystatusofwarningMessages(String expectedprivacyPolicyWarning,String expectedfirstnamewarning, String expectedlastnamewarning,String expectedemailwarning,String expectedtelephonewarning, String expectedpasswordwarning) {
    	
    	String actualprivacyPolicyWarningText=privacyPolicyWarning.getText();
    	boolean privacyPolicyWarningstatus=actualprivacyPolicyWarningText.contains(expectedprivacyPolicyWarning);
    	String actualfirstnamewarningtext = firstnamewarning.getText();
    	boolean firstnamewarningstatus=actualfirstnamewarningtext.contains(expectedfirstnamewarning);
    	String actuallastnamewarningtext =lastnamewarning.getText();
    	boolean lastnamewarningstatus=actuallastnamewarningtext.contains(expectedlastnamewarning);
    	String actualemailwarningtext =emailwarning.getText();
        boolean emailwarningstatus=actualemailwarningtext.contains(expectedemailwarning);
    	
    	String  actualtelephonewarningtext=telephoneWarning.getText();
        boolean telephonewarningstatus=actualtelephonewarningtext.contains(expectedtelephonewarning);
    	String  actualpasswordwarningtext =passwordwarning.getText();
    	boolean passwordwarningstatus=actualpasswordwarningtext.contains(expectedpasswordwarning);
    	return privacyPolicyWarningstatus && firstnamewarningstatus && lastnamewarningstatus &&emailwarningstatus && telephonewarningstatus && passwordwarningstatus;
    	
    	}
    
    }
