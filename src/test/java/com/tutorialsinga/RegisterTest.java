package com.tutorialsinga;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninjga.qa.base.Base5;
import com.tutorialsninja.qa.pages.Accountsuccesspage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTest extends Base5 {

	Accountsuccesspage accountsuccesspage;
	RegisterPage registerpage;

	public RegisterTest() {
		super();

	}

	public WebDriver driver;

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);

		registerpage = homepage.navigatetoregisterpage();

		// this two method clickOnMyAccount() and selectRegisterOption() are optimised.
		/*
		 * homepage.clickOnMyAccount(); registerpage =homepage.selectRegisterOption();
		 */
		// homepage.selectRegisterOption();

		/*
		 * String browsername="Edge";
		 * 
		 * if(browsername.equals("chrome")) { WebDriverManager.chromedriver().setup();
		 * driver= new ChromeDriver();
		 * 
		 * }else if (browsername.equals("firefox"))
		 * 
		 * { WebDriverManager.firefoxdriver().setup(); driver= new FirefoxDriver();
		 * 
		 * }else if(browsername.equals("Edge")) { WebDriverManager.edgedriver().setup();
		 * driver= new EdgeDriver();
		 * 
		 * }
		 * 
		 * 
		 * 
		 * WebDriverManager.chromedriver().setup(); driver= new ChromeDriver();
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 * driver.get("http://www.tutorialsninja.com/demo/");
		 */

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test(priority = 1)

	public void verifyRegisteringAnAccountWithMandatoryField() {
		// handled from line no 44
		// RegisterPage registerpage= new RegisterPage(driver);

		accountsuccesspage = registerpage.registerwithmandatoryfield(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"), Utilities.generateemailwithTimeStamp(),
				dataprop.getProperty("telephonenumber"), prop.getProperty("password"));
		// Below lines are handled by method register from registerpage
		/*
		 * registerpage.Enterfirstname(dataprop.getProperty("firstname"));
		 * registerpage.Enterlastname(dataprop.getProperty("lastname"));
		 * registerpage.EnterEmailAddress(Utilities.generateemailwithTimeStamp());
		 * registerpage.Entertelephonenumber(dataprop.getProperty("telephonenumber"));
		 * registerpage.enterpassword(prop.getProperty("password"));
		 * registerpage.enterConfirmpassword(prop.getProperty("password"));
		 * registerpage.privacypolicy();
		 * accountsuccesspage=registerpage.clickoncontinuebutton();
		 */

		// Nonneed of below lines as it is already covered in POM
		/*
		 * driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty(
		 * "firstname"));
		 * driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty(
		 * "lastname")); driver.findElement(By.id("input-email")).sendKeys(Utilities.
		 * generateemailwithTimeStamp());
		 * driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty(
		 * "telephonenumber"));
		 * driver.findElement(By.id("input-password")).sendKeys(prop.getProperty(
		 * "password"));
		 * driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty(
		 * "password"));
		 * //driver.findElement(By.xpath("//input[@name='newsletter'] [@value='1']")).
		 * click(); driver.findElement(By.name("agree")).click();
		 * driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 * 
		 */
		// Handled by line 93
		// Accountsuccesspage accountsuccesspage= new Accountsuccesspage(driver);
		// handled by POM
		String actualSuccessHeading = accountsuccesspage.retrieveaccountsuccesspageheading();

		// String actualSuccessHeading=
		// driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualSuccessHeading, dataprop.getProperty("accountsuccessfullcreatedHeading"),
				"account success page  not displayed");

	}

	@Test(priority = 2)

	public void verifyRegisteringAnAccountByprovidingallfield() {

		// RegisterPage registerpage= new RegisterPage(driver);

		accountsuccesspage = registerpage.registerwithALLfield(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"), Utilities.generateemailwithTimeStamp(),
				dataprop.getProperty("telephonenumber"), prop.getProperty("password"));
		/*
		 * registerpage.Enterfirstname(dataprop.getProperty("firstname"));
		 * registerpage.Enterlastname(dataprop.getProperty("lastname"));
		 * registerpage.EnterEmailAddress(Utilities.generateemailwithTimeStamp());
		 * registerpage.Entertelephonenumber(dataprop.getProperty("telephonenumber"));
		 * registerpage.enterpassword(prop.getProperty("password"));
		 * registerpage.enterConfirmpassword(prop.getProperty("password"));
		 * registerpage.selectYesNewsletteroption(); registerpage.privacypolicy();
		 * accountsuccesspage=registerpage.clickoncontinuebutton();
		 */

		// handled by POM
		/*
		 * driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty(
		 * "firstname"));
		 * driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty(
		 * "lastname"));
		 * //driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty(
		 * "firstname"));
		 * //driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty(
		 * "lastname")); driver.findElement(By.id("input-email")).sendKeys(Utilities.
		 * generateemailwithTimeStamp());
		 * driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty(
		 * "telephonenumber"));
		 * driver.findElement(By.id("input-password")).sendKeys(prop.getProperty(
		 * "password"));
		 * driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty(
		 * "password"));
		 * 
		 * driver.findElement(By.xpath("//input[@name='newsletter'] [@value='1']")).
		 * click(); driver.findElement(By.name("agree")).click();
		 * driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 */
		// Accountsuccesspage accountsuccesspage= new Accountsuccesspage(driver);
		// handled by POM
		String actualSuccessHeading = accountsuccesspage.retrieveaccountsuccesspageheading();
		// String actualSuccessHeading=
		// driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualSuccessHeading, dataprop.getProperty("accountsuccessfullcreatedHeading"),
				"account success page  not displayed");
	}

	@Test(priority = 3)

	public void verifyRegisteringAcoountWithExistingEmailAddress() {

		// RegisterPage registerpage= new RegisterPage(driver);
		
		accountsuccesspage = registerpage.registerwithALLfield(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"),prop.getProperty("validemail"),
				dataprop.getProperty("telephonenumber"), prop.getProperty("password"));

		/*
		 * registerpage.Enterfirstname(dataprop.getProperty("firstname"));
		 * registerpage.Enterlastname( dataprop.getProperty("lastname"));
		 * driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty(
		 * "firstname"));
		 * driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty(
		 * "lastname")); registerpage.EnterEmailAddress(prop.getProperty("validemail"));
		 * registerpage.Entertelephonenumber(dataprop.getProperty("telephonenumber"));
		 * registerpage.enterpassword(prop.getProperty("password"));
		 * registerpage.enterConfirmpassword(prop.getProperty("password"));
		 * registerpage.selectYesNewsletteroption(); registerpage.privacypolicy();
		 * accountsuccesspage=registerpage.clickoncontinuebutton();
		 */

		// Now below lines are handled by POM

		/*
		 * driver.findElement(By.id("input-email")).sendKeys(prop.getProperty(
		 * "validemail"));
		 * driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty(
		 * "telephonenumber"));
		 * driver.findElement(By.id("input-password")).sendKeys(prop.getProperty(
		 * "password"));
		 * driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty(
		 * "password"));
		 * driver.findElement(By.xpath("//input[@name='newsletter'] [@value='1']")).
		 * click(); driver.findElement(By.name("agree")).click();
		 * driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 */
		String actualwarning = registerpage.retrieveDuplicateEmailaddressWarning();
		// Handled by POM
		// String actualwarning= driver.findElement(By.xpath("//div[contains(@class,
		// 'alert-dismissible')]")).getText();
		System.out.println(actualwarning);
		Assert.assertTrue(actualwarning.contains(dataprop.getProperty("duplicateemailwarning")),
				"Warning message regarding duplicate is not displayed");

	}

	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutfillingAnydetails() {

		// RegisterPage registerpage= new RegisterPage(driver);
		registerpage.clickoncontinuebutton();
		
		Assert.assertTrue(registerpage.displaystatusofwarningMessages(dataprop.getProperty("privacypolicywarning"),dataprop.getProperty("firstnamewarning"),dataprop.getProperty("lastnamewarning"),dataprop.getProperty("emailwarning"),dataprop.getProperty("telephonewarning"),dataprop.getProperty("passwordwarning")));
		// Handled by POM
		// driver.findElement(By.xpath("//input[@value='Continue']")).click();
        //String actualPrivacyPolicyWarning = registerpage.retriveprivacypolicywarning();
		// String actualPrivacyPolicyWarning=
		// driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		/*
		 * Assert.assertTrue(registerpage.retriveprivacypolicywarning().contains(
		 * dataprop.getProperty("privacypolicywarning")),
		 * "privacy warning message is not displayed"); //String actualfirstnamewarning
		 * = registerpage.retrivefirstnamewarning(); // String //
		 * actualfirstnamewarning=driver.findElement(By.xpath(
		 * "//input[@id=\"input-firstname\"]/following-sibling::div")).getText();
		 * Assert.assertEquals(registerpage.retrivefirstnamewarning(),dataprop.
		 * getProperty("firstnamewarning"),
		 * "First name warning message is not displayed"); //String
		 * actuallastnamewarning = registerpage.retrivelastnamewarning(); // String //
		 * actuallastnamewarning=driver.findElement(By.xpath(
		 * "//input[@id=\"input-lastname\"]/following-sibling::div")).getText();
		 * Assert.assertEquals(registerpage.retrivelastnamewarning(),
		 * dataprop.getProperty("lastnamewarning"),
		 * "Last warning message is not displayed");
		 * 
		 * //String actualEmailWarning = registerpage.retriveemailwarning(); // String
		 * actualEmailWarning // =driver.findElement(By.xpath(
		 * "//input[@id=\"input-email\"]/following-sibling::div")).getText();
		 * Assert.assertEquals(registerpage.retriveemailwarning(),
		 * dataprop.getProperty("emailwarning"),
		 * "Email warning message is not displayed");
		 * 
		 * //String actualtelephoneWarning = registerpage.retrivetelephonewarning();
		 * 
		 * // String actualtelephoneWarning // =driver.findElement(By.xpath(
		 * "//input[@id=\"input-telephone\"]/following-sibling::div")).getText();
		 * Assert.assertEquals(registerpage.retrivetelephonewarning(),
		 * dataprop.getProperty("telephonewarning"),
		 * "Telephone warning message is not displayed"); String actualpasswordwarning =
		 * registerpage.retrivepasswordwarning(); // String actualpasswordwarning //
		 * =driver.findElement(By.xpath(
		 * "//input[@id=\"input-password\"]/following-sibling::div")).getText();
		 * Assert.assertEquals(registerpage.retrivepasswordwarning(),
		 * dataprop.getProperty("passwordwarning"),
		 * "password warning message is not displayed");
		 */
	}

}
