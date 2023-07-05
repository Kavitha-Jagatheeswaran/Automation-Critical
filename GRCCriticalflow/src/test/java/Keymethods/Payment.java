package Keymethods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import PageFactory.HomescreenPageobject;

public class Payment extends HomescreenPageobject {
	ExtentTest test;

	public Payment(WebDriver driver, ExtentTest test,ExtentReports extentreport) throws InterruptedException, IOException {
		Actions actions = new Actions(driver);
		ScreenShot screenshot = new ScreenShot();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String Date1 = dateFormat.format(new Date());
		try{HomescreenPageobject.Firstsericepaynow.click();
		
		  
		

		if (HomescreenPageobject.PaymentModes.isDisplayed()) {
			
			
			screenshot.screenshot18(driver, extentreport);
			test.log(Status.PASS,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"C:\\Users\\admin\\git\\Automation-Critical-Flow\\GRCCriticalflow\\Screenshots\\"+Date1+"\\Screenshots18.png",
							"Payment Cart page success").build());
			
			
		} else {
			screenshot.screenshot18(driver, extentreport);
			test.log(Status.FAIL,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"C:\\Users\\admin\\git\\Automation-Critical-Flow\\GRCCriticalflow\\Screenshots\\"+Date1+"\\Screenshots18.png",
							"Payment URL Failed").build());
			
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PaymentModes.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PaytmpaymentMode.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Paynow.click();
		Thread.sleep(2500);
		PhonepayBack.click();
		Thread.sleep(2500);
		
		
		Thread.sleep(4000);
		try {
			Yestocancel.click();
		} catch (ElementClickInterceptedException Yestocancel) {
			System.out.println("Action Performed");
			actions.click(driver.findElement(By.xpath("//button[contains(text(),'YES, CANCEL')]"))).build().perform();
		}catch (ElementNotInteractableException Yestocancel11) {
			driver.findElement(By.xpath("//small[contains(text(),'Back')]")).click();
			Thread.sleep(2000);
			Yestocancel.click();
			
		}
		Thread.sleep(3000);
		String currentUrl = driver.getCurrentUrl();

	
		
//		if (currentUrl.contains("retry")) {
//			test.log(Status.PASS, "Retry Cart page success");
//		} else {
//
//			test.log(Status.FAIL, "Retry Cart page failed");
//		}
		screenshot.screenshot19(driver, extentreport);
		test.log(Status.PASS,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"C:\\Users\\admin\\git\\Automation-Critical-Flow\\GRCCriticalflow\\Screenshots\\"+Date1+"\\Screenshots19.png",
						"payment Success").build());
		
		Thread.sleep(4000);
		}catch(NoSuchElementException payment1){
			screenshot.screenshot19(driver, extentreport);
			test.log(Status.FAIL,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"C:\\Users\\admin\\git\\Automation-Critical-Flow\\GRCCriticalflow\\Screenshots\\"+Date1+"\\Screenshots19.png",
							"Whole payment failed").build());
			
		}
	}
	}

