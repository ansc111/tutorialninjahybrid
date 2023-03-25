/*
 * package com.tutorialsninja.qa.listeners;
 * 
 * import java.io.File; import java.io.IOException;
 * 
 * import org.openqa.selenium.OutputType; import
 * org.openqa.selenium.TakesScreenshot; import org.openqa.selenium.WebDriver;
 * import org.openqa.selenium.io.FileHandler; import org.testng.ITestContext;
 * import org.testng.ITestListener; import org.testng.ITestResult;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.Status; import
 * com.tutorialsninja.qa.utils.ExtentReporter;
 * 
 * public class MyListerners implements ITestListener { ExtentReports
 * extentreport; ExtentTest extenttest; String testname;
 * 
 * @Override public void onStart(ITestContext context) {
 * extentreport=ExtentReporter.generateExtentReport();
 * 
 * //System.out.println("Execution of project started");
 * 
 * }
 * 
 * @Override public void onTestStart(ITestResult result) {
 * testname=result.getName(); extenttest=extentreport.createTest(testname);
 * extenttest.log(Status.INFO,testname +"started executing" );
 * 
 * //System.out.println(testname +"started executing");
 * 
 * }
 * 
 * @Override public void onTestSuccess(ITestResult result) {
 * 
 * //testname=result.getName(); //extenttest=extentreport.createTest(testname);
 * extenttest.log(Status.PASS,testname +"succesfully executing");
 * 
 * 
 * //System.out.println(testname +"succesfullyexecuted");
 * 
 * }
 * 
 * @Override public void onTestFailure(ITestResult result) {
 * 
 * // testname=result.getName(); System.out.println("screenshot taken");
 * //extenttest=extentreport.createTest(testname); WebDriver driver=null; try {
 * driver =
 * (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").
 * get(result.getInstance()); } catch (IllegalArgumentException |
 * IllegalAccessException | NoSuchFieldException | SecurityException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); } File srcScreenshot=
 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 * 
 * //extenttest.log(Status.INFO,testname +"got failed" );
 * 
 * String
 * destinationScreenshotpath=System.getProperty("user.dir"+"\\screenshot"+
 * "\\testname.png"); try { FileHandler.copy(srcScreenshot,new
 * File(destinationScreenshotpath)); } catch (IOException e) {
 * e.printStackTrace(); } //System.out.println(testname +"got  failed"); File
 * srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 * String destinationSreenshotPath =
 * System.getProperty("user.dir")+"\\Screenshots\\"+testname+".png";
 * 
 * try { FileHandler.copy(srcScreenshot,new File(destinationSreenshotPath)); }
 * catch (IOException e) { e.printStackTrace(); }
 * extenttest.addScreenCaptureFromPath(destinationSreenshotPath);
 * extenttest.log(Status.INFO,result.getThrowable());
 * //System.out.println(result.getThrowable());
 * extenttest.log(Status.INFO,testname +"got  failed"); }
 * 
 * @Override public void onTestSkipped(ITestResult result) {
 * 
 * String testname=result.getName();
 * extenttest.log(Status.INFO,result.getThrowable());
 * extenttest.log(Status.INFO,testname +"got  skipped");
 * //System.out.println(testname +"got  skipped");
 * 
 * //System.out.println(result.getThrowable());
 * 
 * }
 * 
 * 
 * 
 * @Override public void onFinish(ITestContext context) {
 * 
 * extentreport.flush();
 * 
 * //System.out.println("Execution of project finished");
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 */

package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;
import com.tutorialsninja.qa.utils.Utilities;

public class MyListeners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		
		extentReport = ExtentReporter.generateExtentReport();
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO,result.getName()+" started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS,result.getName()+" got successfully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriver driver = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		String destinationScreenshotPath = Utilities.captureScreenshot(driver,result.getName());
		
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,result.getName()+" got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" got skipped");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}