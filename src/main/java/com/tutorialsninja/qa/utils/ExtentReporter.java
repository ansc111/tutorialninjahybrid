package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	
	    public static ExtentReports  generateExtentReport() {
		
		/*ExtentReports extentreport= new ExtentReports();
		 File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		//File extentReportsfile=new  File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("extentReportsfile");
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("TutorialsNinja Test automation result");
		sparkreporter.config().setDocumentTitle("TN Automation Report");
		sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentreport.attachReporter(sparkreporter);
		Properties configprop=  new Properties();
		File configpropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		//File configpropfile= new File("C://Users//Lenovo//eclipse-workspace//TutorialNinjaProj//src//main//java//com//tutorialsninja//qa//config//config.properties");
		try {
		FileInputStream fis= new FileInputStream(configpropFile);
		configprop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		extentreport.setSystemInfo("Application url",configprop.getProperty("url"));
		extentreport.setSystemInfo("browsername",configprop.getProperty("browser"));
		extentreport.setSystemInfo("email",configprop.getProperty("validemail"));
		extentreport.setSystemInfo("Password",configprop.getProperty("password"));
		extentreport.setSystemInfo("operating system",System.getProperty("os.name"));
		extentreport.setSystemInfo("username",System.getProperty("user.name"));
		extentreport.setSystemInfo("version",System.getProperty("java.version"));
			
		return extentreport;
	}*/
	    	
	    	ExtentReports extentReport = new ExtentReports();
			
			File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
			
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setReportName("TutorialsNinja Test Automation Results Report");
			sparkReporter.config().setDocumentTitle("TN Automation Report");
			sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
			
			extentReport.attachReporter(sparkReporter);
			
			Properties configProp = new Properties();
			File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
			
			try {
				FileInputStream fisConfigProp = new FileInputStream(configPropFile);
				configProp.load(fisConfigProp);
			}catch(Throwable e) {
				e.printStackTrace();
			}
			
			extentReport.setSystemInfo("Application URL",configProp.getProperty("url"));
			extentReport.setSystemInfo("Browser Name",configProp.getProperty("browserName"));
			extentReport.setSystemInfo("Email",configProp.getProperty("validEmail"));
			extentReport.setSystemInfo("Password",configProp.getProperty("validPassword"));
			extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
			extentReport.setSystemInfo("Username",System.getProperty("user.name"));
			extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
			
			return extentReport;
}}
