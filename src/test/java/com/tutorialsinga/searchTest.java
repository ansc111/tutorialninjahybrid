package com.tutorialsinga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninjga.qa.base.Base5;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.searchpage;

public class searchTest extends Base5 {
	
	searchpage  searchpage1;
	HomePage homepage;
	
	public searchTest() {
		super();
		
	}
	public WebDriver  driver;
	
	@BeforeMethod
	public  void  setup() {
		driver =initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	     homepage=  new HomePage (driver);
	}
	
	  @AfterMethod
	  
	  public void teardown() {
	  
	  driver.quit();
	  }
	 
	 
	
	
	
	@Test (priority=1)
	
   public void verifySearchwithvaliddata() {
		
		//HomePage homepage=  new HomePage (driver);
		//adjusted  from POM
		//driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("validproduct"));
		searchpage1=homepage.searchforaproduct(dataprop.getProperty("validproduct"));
		
		//Now finaloptimize these enterProductintoSearchboxField and enterProductintoSearchboxF()
		/*
		 * homepage.enterProductintoSearchboxField(dataprop.getProperty("validproduct"))
		 * ; searchpage searchpage1=homepage.enterProductintoSearchboxF();
		 */
		
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		//handled by line 48
		//searchpage  searchpage1=  new searchpage(driver);
		
		Assert.assertTrue(searchpage1.displaystatusofHPValidProduct());
		//Now not  required  handled by POM
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}
	
	
	@Test(priority=2)
	public   void  verifysearchwithinvalidproduct() {
		
		//HomePage homepage=  new HomePage (driver);
		
		
		//driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("invalidproduct"));
		
		//Now finaloptimize these enterProductintoSearchboxField and enterProductintoSearchboxF()
		searchpage1=homepage.searchforaproduct(dataprop.getProperty("invalidproduct"));
		
		/*
		 * homepage.enterProductintoSearchboxField(dataprop.getProperty("invalidproduct"
		 * )); searchpage searchpage1= homepage.enterProductintoSearchboxF();
		 */
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		//searchpage  searchpage1=  new searchpage(driver);
		String actualSearchMessage=searchpage1.retrievenoproductmessage();
		//String actualSearchMessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		//Assert.assertEquals(actualSearchMessage,dataprop.getProperty("NoProductTextinsearchresults"),"No matching found");
		Assert.assertEquals(actualSearchMessage,"abcd","No matching found");
		
				
	}

	
	@Test(priority=3, dependsOnMethods= {"verifySearchwithvaliddata","verifysearchwithinvalidproduct"})
	
	public   void  verifysearchwithoutanyproduct() {

		//HomePage homepage=  new HomePage (driver);
		searchpage  searchpage1=homepage.enterProductintoSearchboxF();
		//  These two  are not  below  now  not required
		/*
		 * driver.findElement(By.name("search")).sendKeys("");
		 * driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click(
		 * );
		 */
	     //searchpage  searchpage1=  new searchpage(driver);
		String actualSearchMessage = searchpage1.retrievenoproductmessage();
		/*
		 * String actualSearchMessage=driver.findElement(By.xpath(
		 * "//div[@id='content']/h2/following-sibling::p")).getText();
		 * Assert.assertEquals(actualSearchMessage,dataprop.getProperty(
		 * "NoProductTextinsearchresults"),"No matching found");
		 */
	}			
	
	
	}
