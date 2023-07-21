package Keymethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import CriticalFlowRun.Criticalflow;
import MainBase.CriticalFlowDetail;
import PageFactory.HomescreenPageobject;
import PageFactory.LoginPageobjects;

public class Base {
	ExtentTest test;

	public Base(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws InterruptedException, AWTException, IOException {
		test = extentreport.createTest("Vakilsearch Test");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ScreenShot screenshot = new ScreenShot();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMddyyyy");
		String Date11 = dateFormat1.format(new Date());
		driver.manage().window().maximize();

		driver.get("https://vakilsearch.com/");

		PageFactory.initElements(driver, LoginPageobjects.class);
		if (driver.getTitle() != "Online Legal Services for Startups & SMEs in India | Vakil Search") {
			screenshot.screenshot47(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot47.png",
					"VakilSearchURL launched").build());

		} else {
			screenshot.screenshot47(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot47.png",
					"VakilSearchURL").build());

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Business Setup']")));
		LoginPageobjects.Businesssetup.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@datainput='1']")));
		// Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//b[normalize-space()='Private Limited Company']")));
		LoginPageobjects.Pvtdcompany.click();
		System.out.println(driver.getTitle().toString());
		if (driver.getTitle() != "Private Limited (Pvt Ltd) Company Registration Online In India") {
			screenshot.screenshot48(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot48.png",
					"PVT page Launched").build());

		} else {
			screenshot.screenshot48(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot48.png",
					"PVT page Launched").build());

		}
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='service_form_primary_email']")));
		LoginPageobjects.Email.click();
		if (LoginPageobjects.Email.isEnabled()) {

			test.log(Status.PASS, "Email Username clicked");
		} else {

			test.log(Status.FAIL, "Email Username notfound");
		}
		LoginPageobjects.Email.sendKeys("shakthi"+Date11+"@yopmail.com");

		LoginPageobjects.Phonenumber.click();
		if (LoginPageobjects.Phonenumber.isEnabled()) {

			test.log(Status.PASS, " Phonenumber field clicked");
		} else {

			test.log(Status.FAIL, "Phonenumber field notfound");
		}
		LoginPageobjects.Phonenumber.sendKeys("9789955331");
		Thread.sleep(2000);
		LoginPageobjects.City.click();
		LoginPageobjects.City.sendKeys("chen");
		if (LoginPageobjects.City.isEnabled()) {

			test.log(Status.PASS, "Select City clicked");
		} else {

			test.log(Status.FAIL, "Select City field notfound");
		}

		Thread.sleep(16000);
		WebElement findElement12 = driver.findElement(By.xpath("//div[contains(text(),'Chennai, Tamil Nadu')]"));
		wait.until(ExpectedConditions.elementToBeClickable(findElement12)).click();
		Robot robot = new Robot();

//		if (LoginPageobjects.whatsapptogleoff.isSelected()) {
//
//			test.log(Status.PASS, "whatsapptogle off");
//		} else {
//System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}
		LoginPageobjects.whatsapptogleoff.click();
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[@class='fullwidth btn btn-primary']")));
			driver.findElement(By.xpath("//button[@class='fullwidth btn btn-primary']")).click();
			System.out.println("succes1");

		} catch (NoSuchElementException ek) {
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("succes2");
		} finally {
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("succes3");
		}
		Thread.sleep(1500);
	

			try {
				LoginPageobjects.noidonthaveacompany1.click();
				LoginPageobjects.Next.click();
			} catch (NoSuchElementException e) {
				
					System.out.println(e);
				

			

		}
		LoginPageobjects.Software.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPageobjects.Next.click();

		Thread.sleep(2000);
		LoginPageobjects.Ageofbusiness.click();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPageobjects.Next.click();

		Thread.sleep(3000);

		try {
			driver.findElement(By.xpath("//button[contains(text(),'Send OTP')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[1]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[2]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[3]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[4]"))
					.sendKeys("0");
			Thread.sleep(3000);

			driver.findElement(By.xpath("//p[contains(text(),'Next')]")).click();
			Thread.sleep(1500);
			// driver.findElement(By.xpath("//button[contains(text(),'View
			// account')]")).click();

			screenshot.screenshot49(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot49.png",
					"Payment Cart Page").build());

		} catch (NoSuchElementException MyIntrest1) {
			screenshot.screenshot49(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot49.png",
					"Otp Validation / Payment Cart Page").build());
		}
		try {
		driver.switchTo().alert().accept();
		}catch(Exception Alert34){
			System.out.println(Alert34);
		}

	}

}
