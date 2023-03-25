package com.tutorialsinga;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninjga.qa.base.Base5;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends Base5 {
	//Method 2
	LoginPage loginpage;
	AccountPage accountpage;
	public LoginTest() {
		super();
		
	}
	
	public WebDriver  driver;
	
	
    
	
	
	@BeforeMethod
	public void setup() {
		
		// option 1-->>loadPropertiesFile();
		driver=initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		/*
		 * WebDriverManager.chromedriver().setup(); String browserName="chrome";
		 * if(browserName.equals("chrome")) {
		 * 
		 * driver= new ChromeDriver(); } else if(browserName.equals("firefox")) {
		 * driver= new FirefoxDriver(); } else if(browserName.equals("edge"))
		 * 
		 * { driver= new EdgeDriver(); } driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 * driver.get("http://www.tutorialsninja.com/demo/");
		 */
		HomePage  homepage= new HomePage(driver);
		//Now  this  line homepage.clickOnMyAccount(); is  not required
		//homepage.clickOnMyAccount();
		
		//Making  it Global so  removing  local  declaration below  line
		//LoginPage loginpage = homepage.selectloginOption();
		//Now  this  line  loginpage = homepage.selectloginOption();is also  not required
		//loginpage = homepage.selectloginOption();
		
		loginpage=homepage.navigatetologinoption();
		
		//  Not  these  two    lines  not  required
		/*
		 * driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 * driver.findElement(By.linkText("Login")).click();
		 */
		
		
	}
	
	
	
	
	@AfterMethod
	public  void teardown() {
		driver.quit();
	}
	
	
	@Test(priority=1,dataProvider="validcredentialsupplier")
	public void verifyLoginWithValidCredentials(String email,String password) {
		
		//LoginPage loginpage=new LoginPage(driver);
		
		accountpage=loginpage.Login(email, password);
		//Now  below  3  line not  required
		/*loginpage.enteremailaddress(email);
		loginpage.enterPassword(password);
		AccountPage accountpage=loginpage.clickonloginButton();*/
		
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemail"));
		//from input  excel  email
		/* Now  this  line  not required*/
		//driver.findElement(By.id("input-email")).sendKeys(email);
		
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		//from input  excel  password
		/* Now  this password line  not required*/
		//driver.findElement(By.id("input-password")).sendKeys(password);
		/* Now  this login button line  not required*/
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//Now below line not required.( handle in Login page)
		//AccountPage accountpage= new AccountPage(driver);
		
		/*  old way to  new  POM model  from Accountpage*/
//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"EDit  your  account Information  not   displayed");
		Assert.assertTrue(accountpage.getDisplayStatusofEditYourAccountInformationOption(),"EDit  your  account Information  not   displayed");	
		
	
	}
	
	@DataProvider(name="validcredentialsupplier")
	public Object[][] supplytestdata() {
		
		//Object[][]data= {{"amotooricap9@gmail.com","12345"},{"amotooricap1@gmail.com","12345"},{"amotooricap3@gmail.com","12345"}};
		
		Object[][]data=Utilities.getTestDatafromExcel("Login");
		return data;
		
		
}
	@Test(priority=2)
	
	
	public void verifyLoginWithInValidCredentials() {
		//WebDriverManager.chromedriver().setup();
		//driver.findElement(By.id("input-email")).sendKeys("amotooric9"+generateTimeStamp()+"@gmail.com");
		//LoginPage loginpage=new LoginPage(driver);
		accountpage=loginpage.Login(Utilities.generateemailwithTimeStamp(),prop.getProperty("password"));
		
		//Now  below  3  lines  not  required  as optimized by  Login  method above 
		/*
		 * loginpage.enteremailaddress(Utilities.generateemailwithTimeStamp());
		 * loginpage.enterPassword(prop.getProperty("password"));
		 * loginpage.clickonloginButton();
		 */
		
		/* ALL   are  replaced  to  POM   above  3 lines
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateemailwithTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		 * 
		 */
		
		/*This  below  line  is  replace  by  POM  from loginpage*/
		//String ActualWarningMessage= driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String ActualWarningMessage= loginpage.retriveemailpasswordnotmatchingwarningmessageText();
	    String expeectedwarningMessage=dataprop.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(ActualWarningMessage.contains(expeectedwarningMessage), "Expected Warning message is not displayed");
		//driver.quit();
}
	
	
 @Test(priority=3)
		
	public void verifyLoginWithInValidemailandvalidpassword() {
		//WebDriverManager.chromedriver().setup();
	   //driver.findElement(By.id("input-email")).sendKeys("amotooric9"+generateTimeStamp()+"@gmail.com");
		 //LoginPage loginpage=new LoginPage(driver);
	 
	accountpage=  loginpage.Login(Utilities.generateemailwithTimeStamp(),prop.getProperty("password"));
	 
	   //Now  below  3  lines  not  required  as optimized by  Login  method above
	 
		/*
		 * loginpage.enteremailaddress(Utilities.generateemailwithTimeStamp());
		 * loginpage.enterPassword(prop.getProperty("password"));
		 * loginpage.clickonloginButton();
		 */
	 
		    String ActualWarningMessage= loginpage.retriveemailpasswordnotmatchingwarningmessageText();
		    String expeectedwarningMessage=dataprop.getProperty("emailPasswordNoMatchWarning");
			Assert.assertTrue(ActualWarningMessage.contains(expeectedwarningMessage), "Expected Warning message is not displayed");
	      //Now  below  6 lines  not required  as  covered  in  POM
	    //driver.findElement(By.id("input-email")).sendKeys(Utilities.generateemailwithTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
	 
	 
		//String ActualWarningMessage= driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
	    //String expeectedwarningMessage=dataprop.getProperty("emailPasswordNoMatchWarning");
		//Assert.assertTrue(ActualWarningMessage.contains(expeectedwarningMessage), "Expected Warning message is not displayed");
		//driver.quit();
		}

@Test(priority=5)


public void verifyLoginWithoutcredential() {
	//WebDriverManager.chromedriver().setup();

	//Not  required unnnesary steps
	/*
	 * driver.findElement(By.id("input-email")).sendKeys("");
	 * driver.findElement(By.id("input-password")).sendKeys("");
	 */
	//LoginPage loginpage=new LoginPage(driver);
	loginpage.clickonloginButton();
	String ActualWarningMessage= loginpage.retriveemailpasswordnotmatchingwarningmessageText();
    String expeectedwarningMessage=dataprop.getProperty("emailPasswordNoMatchWarning");
	Assert.assertTrue(ActualWarningMessage.contains(expeectedwarningMessage), "Expected Warning message is not displayed");
	
	
	//below  line  from POM
	//driver.findElement(By.xpath("//input[@value='Login']")).click();
	/*
	 * String ActualWarningMessage=
	 * driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).
	 * getText(); //String
	 * expeectedwarningMessage="Warning: No match for E-Mail Address and/or Password."
	 * ; String
	 * expeectedwarningMessage=dataprop.getProperty("emailPasswordNoMatchWarning");
	 * Assert.assertTrue(ActualWarningMessage.contains(expeectedwarningMessage),
	 * "Expected Warning message is not displayed"); //driver.quit();
	 */
	
}

@Test(priority=4)

public void verifyLoginWithValidemailandInvalidpassword() {
	//WebDriverManager.chromedriver().setup();
	
	//LoginPage loginpage=new LoginPage(driver);
	
accountpage=loginpage.Login(prop.getProperty("validemail"),dataprop.getProperty("invalidpassword"));
	
	////Now  below  3  lines  not  required  as optimized by  Login  method above
	/*
	 * loginpage.enteremailaddress(prop.getProperty("validemail"));
	 * loginpage.enterPassword(dataprop.getProperty("invalidpassword"));
	 * loginpage.clickonloginButton();
	 */
	// below  3  line  not required as per POM
	/*
	 * driver.findElement(By.id("input-email")).sendKeys(prop.getProperty(
	 * "validemail"));
	 * driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty(
	 * "invalidpassword"));
	 * driver.findElement(By.xpath("//input[@value='Login']")).click();
	 * 
	 */
	
	String ActualWarningMessage= loginpage.retriveemailpasswordnotmatchingwarningmessageText();
    String expeectedwarningMessage=dataprop.getProperty("emailPasswordNoMatchWarning");
	Assert.assertTrue(ActualWarningMessage.contains(expeectedwarningMessage), "Expected Warning message is not displayed");
	// below  3  line  not required as per POM
	/*String ActualWarningMessage= driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
    //String expeectedwarningMessage="Warning: No match for E-Mail Address and/or Password.";
    String expeectedwarningMessage=dataprop.getProperty("emailPasswordNoMatchWarning");
	Assert.assertTrue(ActualWarningMessage.contains(expeectedwarningMessage), "Expected Warning message is not displayed");
	//driver.quit();
}*/

	
	
	
/*
 * public String generateemailwithTimeStamp() {
 * 
 * Date date= new Date();
 * 
 * //return(date.toString().replace(" ", "_").replace(":","_")); String
 * timestamp =(date.toString().replace(" ", "_").replace(":","_")); return
 * "amotorie"+timestamp+"gmail.com";
 * 
 * }
 */
	
	
}}