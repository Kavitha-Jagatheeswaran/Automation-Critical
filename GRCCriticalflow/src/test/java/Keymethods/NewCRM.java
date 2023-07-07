package Keymethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import PageFactory.GRCPageobject;

public class NewCRM extends GRCPageobject {
	ExtentTest test;
	public void newCRM(WebDriver driver,String e, String CrmUsernames, String CrmUserpassword,ExtentReports extentreport) throws InterruptedException, AWTException, IOException {
Robot robot = new Robot();
Thread.sleep(3000);test = extentreport.createTest("NewCRM");
WebDriverWait wait = new WebDriverWait(driver, 100);
ScreenShot screenshot = new ScreenShot();
try {
		driver.get("https://newcrm.vakilsearch.com/login");
		CrmUsername.sendKeys(CrmUsernames);
		Thread.sleep(1500);
		CrmPassword.sendKeys(CrmUserpassword);
		Thread.sleep(1500);
		CrmLoginCTA.click();
		Thread.sleep(1500); 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(2500);
		try {  
			wait.until(ExpectedConditions
					.elementToBeClickable(CrmAllBucket));
			CrmAllBucket.click();	
		} catch (Exception e322) {
			driver.findElement(By.xpath("//i[@class='fa-fw far vs-tickets']"));
		}
		//i[@class='fa-fw far vs-tickets']
		Thread.sleep(2500);
		CrmSearchforticketsIDorsubject.click();
		CrmSearchforticketsIDorsubject.sendKeys(e);
		Thread.sleep(2500);
		CrmFirstTicketSelect.click();
		String InternalNotes = CrmInternalNote.getText();
		String b = "testing";
		if ( InternalNotes.contains(e)) {
			screenshot.screenshot43(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\"+Date1+"\\Screenshots43.png",
							"InternalNotes").build());
		} else {
			screenshot.screenshot43(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.FAIL,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\"+Date1+"\\Screenshots43.png",
							"InternalNotes").build());
		}
		screenshot.screenshot44(driver, extentreport);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String Date1 = dateFormat.format(new Date());
		test.log(Status.FAIL,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\"+Date1+"\\Screenshots44.png",
						"Newcrnotevalidation").build());
} catch (Exception Newcrnotevalidation1) {
	screenshot.screenshot44(driver, extentreport);
	SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
	String Date1 = dateFormat.format(new Date());
	test.log(Status.FAIL,
			MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\"+Date1+"\\Screenshots44.png",
					"Newcrnotevalidation").build());
}
	}

}
