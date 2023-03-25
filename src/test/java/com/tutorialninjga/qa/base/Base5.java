package com.tutorialninjga.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base5 {
	
	 WebDriver driver;
	 public Properties prop;
	 public Properties dataprop;
	 
	
	
	//method  1 -public void  loadPropertiesFile() {
	 
	   public  Base5() {
	 
		
	    prop= new Properties();
		File propFile= new File("C:\\Users\\Lenovo\\eclipse-workspace\\TutorialNinjaProj\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		dataprop =new Properties();
		File datapropfile= new File("C:\\Users\\Lenovo\\eclipse-workspace\\TutorialNinjaProj\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		//File datapropfile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\testdata\\testdata.properties");
		try {
		
		FileInputStream datafiles1 =  new FileInputStream(datapropfile);
		dataprop.load(datafiles1);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		try {
		
		FileInputStream   fis=  new  FileInputStream(propFile);
		
		prop.load(fis);
		
		} catch(Throwable e) {
			
			e.printStackTrace();
		}
		
	}
	
	public  WebDriver initializeBrowserAndOpenApplication(String browsername) {
		

		
		
		if(browsername.equals("chrome"))
		{
			ChromeOptions chromeOption= new ChromeOptions();
			chromeOption.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
		    driver=  new ChromeDriver(chromeOption);
		    
		}else if (browsername.equals("firefox"))
		
		{
			WebDriverManager.firefoxdriver().setup();
		    driver=  new FirefoxDriver();
			
		}else if(browsername.equals("edge"))
				{
			       WebDriverManager.edgedriver().setup();
		           driver=  new EdgeDriver();
			
				}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		//driver.get("http://www.tutorialsninja.com/demo/");
		driver.get(prop.getProperty("url"));
	    return driver;
		}
}
