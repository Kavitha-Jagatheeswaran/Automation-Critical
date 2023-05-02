package Keymethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CriticalFlowRun.Criticalflow;
import MainBase.CriticalFlowDetail;
import PageFactory.HomescreenPageobject;
import PageFactory.LoginPageobjects;

public class Base {
	ExtentTest test;

	public Base (WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws InterruptedException, AWTException {
		test = extentreport.createTest("Vakilsearch Test");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.manage().window().maximize();

		driver.get("https://vakilsearch.com/");

		PageFactory.initElements(driver, LoginPageobjects.class);
		if (driver.getTitle() != "Online Legal Services for Startups & SMEs in India | Vakil Search") {

			test.log(Status.PASS, "VakilSearchURL launched");
		} else {

			test.log(Status.FAIL, "VakilsearchURL launch Failed");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Business Setup']")));
		LoginPageobjects.Businesssetup.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@datainput='1']")));
		// Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[normalize-space()='Private Limited Company']")));
		LoginPageobjects.Pvtdcompany.click();
		System.out.println(driver.getTitle().toString());
		if (driver.getTitle() != "Private Limited (Pvt Ltd) Company Registration Online In India") {

			test.log(Status.PASS, "PVT page Launched");
		} else {
 
			test.log(Status.FAIL, "PVT page launch failed");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='service_form_primary_email']")));
		LoginPageobjects.Email.click();
		if (LoginPageobjects.Email.isEnabled()) {

			test.log(Status.PASS, "Email Username clicked");
		} else {

			test.log(Status.FAIL, "Email Username notfound");
		}
		LoginPageobjects.Email.sendKeys(Username);
 
		LoginPageobjects.Phonenumber.click();
		if (LoginPageobjects.Phonenumber.isEnabled()) {

			test.log(Status.PASS, " Phonenumber field clicked");
		} else {

			test.log(Status.FAIL, "Phonenumber field notfound");
		}
		LoginPageobjects.Phonenumber.sendKeys(Mobilenumber);
	Thread.sleep(2000);
		LoginPageobjects.City.click();
		if (LoginPageobjects.City.isEnabled()) {

			test.log(Status.PASS, "Select City clicked");
		} else {
 
			test.log(Status.FAIL, "Select City field notfound");
		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='fullwidth btn btn-primary']")));
			driver.findElement(By.xpath("//button[@class='fullwidth btn btn-primary']")).click();
			System.out.println("succes1");
		
		} catch (NoSuchElementException ek) {
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("succes2");
		}finally {
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("succes3");
		}
		Thread.sleep(1500);
		try {
			Thread.sleep(1500);
		//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(@for,'noexistingBusiness')]")));
			LoginPageobjects.Q1newbusiness.click();
			LoginPageobjects.Next.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (NoSuchElementException Q1newbusine1ss) {
		Thread.sleep(1500);
		}
		
		try {LoginPageobjects.noidonthaveacompany.click();
			
		} catch (NoSuchElementException e) {
		 
			LoginPageobjects.noidonthaveacompany1.click();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LoginPageobjects.next2.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LoginPageobjects.Software.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPageobjects.next2.click();

		Thread.sleep(2000);
		LoginPageobjects.Ageofbusiness.click();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPageobjects.next2.click();

		Thread.sleep(3000);

	
		try {
			driver.findElement(By.xpath("//button[contains(text(),'Send OTP')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[1]")).sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[2]")).sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[3]")).sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[4]")).sendKeys("0");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//button[contains(text(),'View account')]")).click();
			
			
			
			
		} catch (NoSuchElementException MyIntrest1) {
			Thread.sleep(1500);
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	
	
	}
	

}
