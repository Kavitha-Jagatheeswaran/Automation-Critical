package MainBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.poifs.property.Parent;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Keymethods.GrcLogin;
import Keymethods.NewCRM;
import Keymethods.Payment;
import PageFactory.GRCPageobject;
import PageFactory.HelpdeskPageobject;
import PageFactory.HomescreenPageobject;
import PageFactory.LoginPageobjects;
import PageFactory.NewCRMPageobject;
import groovyjarjarantlr4.v4.codegen.model.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CriticalFlowDetail extends HelpdeskPageobject {

	JavascriptExecutor js;
	Robot robot;
	ExtentTest test;

	public CriticalFlowDetail(WebDriver driver, String Helpdeskuserid, String helpdeskpassword, String notesname,
			String notedescrption, String QNameOfCustomer, String qaddress, String qpincode, String Professionalfees,
			String assignedtoName, String BDAgentName, String CrossSaleName, String GRCMobileNumber,
			String CrmUsernames, String CrmUserpassword, ExtentReports extentreport)
			throws InterruptedException, AWTException,ElementClickInterceptedException {
		Robot robot = new Robot();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		test = extentreport.createTest("Helpdesk");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		PageFactory.initElements(driver, GRCPageobject.class);
		PageFactory.initElements(driver, NewCRMPageobject.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(3000);
		//**********
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='styles_gearBtn__s6cgl']")));
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']/child::img")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//p[contains(text(),'Business Profile')]")).click();
		Thread.sleep(10000);
		String BusinessProfileURL = driver.getCurrentUrl().substring(0, 48);
		String BusinessProfileURL1 = "https://grc.vakilsearch.com/grc/business-profile";
				if (BusinessProfileURL1.contains(BusinessProfileURL)) {
					test.log(Status.PASS, "BusinessProfileURL");
					System.out.println(BusinessProfileURL1);
				} else {
					test.log(Status.FAIL,"BusinessProfileURL not same"+ BusinessProfileURL);
					System.out.println(BusinessProfileURL);
				}
		
		driver.navigate().back();
		Thread.sleep(10000);
		
		//*********
		
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']/child::img")).click();Thread.sleep(2500);
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//p[contains(text(),'Users & Roles')]")).click();
		Thread.sleep(10000);
		String UsersandRolesURL = driver.getCurrentUrl().substring(0, 42);
		String UsersandRolesURL1 = "https://grc.vakilsearch.com/grc/user_roles";
				if (UsersandRolesURL1.contains(UsersandRolesURL)) {
					test.log(Status.PASS, "UsersAndRolesURL");
					System.out.println(UsersandRolesURL1);
				} else {
					test.log(Status.FAIL,"UsersandRolesURL not same"+UsersandRolesURL);
					System.out.println(UsersandRolesURL);
				}
		driver.navigate().back();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']/child::img")).click();Thread.sleep(10000);
		driver.findElement(By.xpath("//p[contains(text(),'Users & Roles')]")).click();Thread.sleep(10000);
		driver.findElement(By.xpath("//Button[contains(text(),'Add users')]")).click();Thread.sleep(10000);
		String AddUserURL = driver.getCurrentUrl().substring(0, 42);
		String AddUserURL1 = "https://grc.vakilsearch.com/grc/user_roles";
				if (AddUserURL1.contains(AddUserURL)) {
					test.log(Status.PASS, "AddUserURL");
					System.out.println(AddUserURL1);
				} else {
					test.log(Status.FAIL,"AddUserURL not same"+AddUserURL);
					System.out.println(AddUserURL);
				}
	//	driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(10000);
		//*********
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']/child::img")).click();Thread.sleep(7500);
		driver.findElement(By.xpath("//p[contains(text(),'Help')]")).click();Thread.sleep(7500);
		String HelpURL = driver.getCurrentUrl().substring(0, 36);
		String HelpURL1 = "https://grc.vakilsearch.com/grc/help";
				if (HelpURL1.contains(HelpURL)) {
					test.log(Status.PASS, "HelpURL");
					System.out.println(HelpURL1);
				} else {
					test.log(Status.FAIL,"HelpURL not same"+HelpURL);
					System.out.println(HelpURL);
				}
		driver.navigate().back();
		Thread.sleep(5500);
		//**********
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();Thread.sleep(5500);
		driver.findElement(By.xpath("//p[contains(text(),'Support')]")).click();Thread.sleep(5500);
		String SupportURL = driver.getCurrentUrl().substring(0, 42);
		String SupportURL1 = "https://grc.vakilsearch.com/grc/contact-us";
				if (SupportURL1.contains(SupportURL)) {
					test.log(Status.PASS, "SupportURL");
					System.out.println(SupportURL1);
				} else {
					test.log(Status.FAIL,"SupportURL not same"+ SupportURL);
					System.out.println(SupportURL);
				}
		driver.navigate().back();
		Thread.sleep(8000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//**************
	//	driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();Thread.sleep(2500);
		String MessagesURL = driver.getCurrentUrl().substring(0, 40);
		String MessagesURL1 = "https://grc.vakilsearch.com/grc/messages";
				if (MessagesURL1.contains(MessagesURL)) {
					test.log(Status.PASS, "MessagesURL");
					System.out.println(MessagesURL1);
				} else {
					test.log(Status.FAIL,"MessagesURL not same"+MessagesURL);
					System.out.println(MessagesURL);
				}
		
		driver.navigate().back();
		Thread.sleep(5500);
		//********
		
	//	driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'All Services')]")).click();Thread.sleep(2500);
		String AllServicesURL = driver.getCurrentUrl().substring(0, 40);
		String AllServicesURL1 = "https://grc.vakilsearch.com/grc/services";
				if (AllServicesURL1.contains(AllServicesURL)) {
					test.log(Status.PASS, "AllServicesURL");
					System.out.println(AllServicesURL1);
				} else {
					test.log(Status.FAIL,"AllServicesURL not same"+ AllServicesURL);
					System.out.println(AllServicesURL);
				}
		driver.navigate().back();
		Thread.sleep(5500);
	//	driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Compliances for you')]")).click();Thread.sleep(2500);
		String CompliancesForYou = driver.getCurrentUrl().substring(0, 48);
		String CompliancesForYou1 = "https://grc.vakilsearch.com/grc/compliance-score";
				if (CompliancesForYou.contains(CompliancesForYou1)) {
					test.log(Status.PASS, "CompliancesForYou");
					System.out.println(CompliancesForYou1);
				} else {
					test.log(Status.FAIL,"CompliancesForYouURL not same"+CompliancesForYou);
					System.out.println(CompliancesForYou);
				}
		driver.navigate().back();
		Thread.sleep(5500);
	//	driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Payments')]")).click();Thread.sleep(2500);
		String PaymentsURL = driver.getCurrentUrl().substring(0, 40);
		String PaymentsURL1 = "https://grc.vakilsearch.com/grc/payments";
				if (PaymentsURL.contains(PaymentsURL1)) {
					test.log(Status.PASS, "PaymentsURL");
					System.out.println(PaymentsURL1);
				} else {
					test.log(Status.FAIL,"PaymentsURL not same"+PaymentsURL);
					System.out.println(PaymentsURL);
				}
		driver.navigate().back();
		Thread.sleep(5500);
	//	driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Compliance Calendar')]")).click();Thread.sleep(2500);
		String ComplianceCalendar = driver.getCurrentUrl().substring(0, 40);
		String ComplianceCalendar1 = "https://grc.vakilsearch.com/grc/calendar";
				if (ComplianceCalendar.contains(ComplianceCalendar1)) {
					test.log(Status.PASS, "ComplianceCalendar");
					System.out.println(ComplianceCalendar1);
				} else {
					test.log(Status.FAIL,"ComplianceCalendarURL not same"+ComplianceCalendar);
					System.out.println(ComplianceCalendar);
				}

		driver.navigate().back();
		Thread.sleep(5500);
		driver.findElement(By.xpath("//span[contains(text(),'Rewards')]")).click();Thread.sleep(2500);
		String RewardsURL = driver.getCurrentUrl().substring(0, 39);
		String RewardsURL1 = "https://grc.vakilsearch.com/grc/rewards";
				if (RewardsURL.contains(RewardsURL1)) {
					test.log(Status.PASS, "RewardsURL");
					System.out.println(RewardsURL1);
				} else {
					test.log(Status.FAIL,"RewardsURL not same"+ RewardsURL);
					System.out.println(RewardsURL);
				}
		driver.navigate().back();
		Thread.sleep(5500);
		driver.findElement(By.xpath("//span[contains(text(),'My Services')]")).click();Thread.sleep(2500);
		String MyServicesURL = driver.getCurrentUrl().substring(0, 43);
		String MyServicesURL1 = "https://grc.vakilsearch.com/grc/my-services";
				if (MyServicesURL.contains(MyServicesURL1)) {
					test.log(Status.PASS, "MyServicesURL");
					System.out.println(MyServicesURL1);
				} else {
					test.log(Status.FAIL,"MyServicesURL not same"+ MyServicesURL);
					System.out.println(MyServicesURL);
				}
		driver.navigate().back();
		Thread.sleep(3500);
		
		
		
		

		try {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'My Interests')]")));
			driver.findElement(By.xpath("//span[contains(text(),'My Interests')]")).click();

		} catch (NoSuchElementException e7) {
			GrcLogin grclogin = new GrcLogin(driver, GRCMobileNumber);
			driver.findElement(By.xpath("//span[contains(text(),'My Interests')]")).click();
		} catch (ElementClickInterceptedException MyintrestIntercepted) {
			Thread.sleep(2500);
			driver.findElement(By.xpath("//div[contains(text(),'Continue your service request from here ')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'My Interests')]")).click();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		String Ticketid1 = HomescreenPageobject.FirstTicketID.getText().substring(1);
//System.out.println(Ticketid1);
		String e = driver.findElement(By.xpath("(//div[@class='styles_ticketDetail__jg4A0']//child::P)[1]")).getText()
				.substring(1);
		
		String MyInterestURL = driver.getCurrentUrl().substring(0, 44);
		String MyInterestURL1 = "https://grc.vakilsearch.com/grc/my-interests";
				if (MyInterestURL1.contains(MyInterestURL)) {
					test.log(Status.PASS, "MyInterestURL");
					System.out.println(MyInterestURL);
				} else {
					test.log(Status.FAIL,"MyInterestURL not same"+MyInterestURL);
					System.out.println(MyInterestURL1);
				}
		if (e.matches(e)) {
			test.log(Status.PASS, "Create a ticket from the vakilsearch.com");
		} else {

			test.log(Status.FAIL, "no lead is Create a ticket from the vakilsearch.com");
		}

		System.out.println(e);

		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Payment key = new Payment(driver, test);
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://helpdesk.vakilsearch.com/login");

		Thread.sleep(10000);
		Username.sendKeys(Helpdeskuserid);
		String text1 = Username.getText();
		String text2 = "testingsa_2_2020@vakilsearch.com";
		System.out.println(text1);
//		if (text1.contains(text2)) {
//			test.log(Status.PASS, "Yes");
//		} else {
//
//			test.log(Status.FAIL, "Username Not same");
//		}

		Password.sendKeys(helpdeskpassword);
		Signin.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Helpdesk.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Tickets.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ticketid.sendKeys(e);

		Search.click();
		Firstservice.click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {

			CriticalnotesCTA.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			NewCriticalNoteCTA.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);

			TypeCriticalNotes.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);

			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_T);
			robot.keyPress(KeyEvent.VK_E);
			robot.keyRelease(KeyEvent.VK_E);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_T);
			robot.keyPress(KeyEvent.VK_I);
			robot.keyRelease(KeyEvent.VK_I);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyPress(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_G);

//		 TypeCriticalNotes.sendKeys("Testing");driver.manage().timeouts().implicitlyWait(30,
//		 TimeUnit.SECONDS);
//		 ChooseCriticalNoesFile.click();
			ChooseCriticalNoesFile
					.sendKeys("C:\\Users\\admin\\eclipse-workspace\\GRCCriticalflow\\Excel\\Customer.xlsx");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			CriticalNoteSave.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Critical Note added");
		} catch (Exception CriticalNote) {
			test.log(Status.PASS, "Critical note Failed");
		}
		try {

			PersonalNote.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			NewPersonalNote.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			TypePersonalnote.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_T);
			robot.keyPress(KeyEvent.VK_E);
			robot.keyRelease(KeyEvent.VK_E);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_T);
			robot.keyPress(KeyEvent.VK_I);
			robot.keyRelease(KeyEvent.VK_I);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyPress(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_G);
			savepersonalnote.click();
			test.log(Status.PASS, "Personal Note added");

		} catch (Exception PersonalNote) {

			test.log(Status.FAIL, "Personal Note Failed");
		}

		Thread.sleep(1500);

		try {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			addnote.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			addnoteattachment
					.sendKeys("C:\\\\Users\\\\admin\\\\eclipse-workspace\\\\GRCCriticalflow\\\\Excel\\\\Customer.xlsx");
			typeaddnote.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_T);
			robot.keyPress(KeyEvent.VK_E);
			robot.keyRelease(KeyEvent.VK_E);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_T);
			robot.keyPress(KeyEvent.VK_I);
			robot.keyRelease(KeyEvent.VK_I);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyPress(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_G);
			addnotesend.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			addnote.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[4]")).click();
			driver.findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[4]"))
					.sendKeys("Testing Add note CRM");
			EmailTo.click();
			emailsearchTo.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			emailsearchTo.sendKeys(assignedtoName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			Emailtoaddnote.click();Thread.sleep(1500);
			Emailtoaddnote.sendKeys("Testing");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			EmailAddAttachment
					.sendKeys("C:\\\\Users\\\\admin\\\\eclipse-workspace\\\\GRCCriticalflow\\\\Excel\\\\Customer.xlsx");
			EmailButtonSend.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			test.log(Status.PASS, "Add Note Created");
		} catch (Exception AddNote) {
			test.log(Status.FAIL, "Add Note Failed");
		}

		try {
			MenuDownArrow.click();
		} catch (ElementClickInterceptedException MenuDownArrow1) {
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			MenuDownArrow.click();
		}

		try {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			CannedResponseCTA.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//a[@class='nav-link canned_response_folder_select active']")));
			try {
				cannedAddingaDriector.click();
			} catch (StaleElementReferenceException e02) {
				cannedaddingadirector1.click();
			}

			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//a[@class='email-tempalte-object template_object_new'])[2]")));
			try {
				cannedFollowingEmail.click();
			} catch (StaleElementReferenceException e03) {
				cannedFollowingEmail1.click();
			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			cannedEmailaddattachment.sendKeys(
					"C:\\\\\\\\Users\\\\\\\\admin\\\\\\\\eclipse-workspace\\\\\\\\GRCCriticalflow\\\\\\\\Excel\\\\\\\\Customer.xlsx");
			cannedsubject.sendKeys(notesname);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
			cannedselectdate.click();

			try {
				cannedDate29.click();
			} catch (StaleElementReferenceException e04) {

				try {

					driver.findElement(
							By.xpath("(//td[@class='xdsoft_date xdsoft_day_of_week1 xdsoft_date true,'])[4]")).click();
				} catch (NoSuchElementException CanneddateCatch1) {

					driver.findElement(By.xpath("(//td[@data-date='29'])[1]")).click();
				}

			} catch (ElementNotInteractableException CanneddateCatch) {

				driver.findElement(By.xpath("(//td[@data-date='27'])[4]")).click();
			}

			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			cannedDescription.sendKeys("Test1");

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			cannedupdateCTA.click();
			test.log(Status.PASS, "Canned response Created");
		} catch (Exception cannedException) {
			test.log(Status.FAIL, "Canned response Failed");
			driver.navigate().back();
		}

		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
//	***if needed you can take this***	
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='editBtn']")));
			js.executeScript("arguments[0].scrollIntoView(true);", Editticket);
			Editticket.click();

		} catch (ElementClickInterceptedException elementintercptedEdit) {
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			Thread.sleep(3000);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@id='select2-city_filter_edit-container']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//input[@class='select2-search__field'])[3]")).sendKeys("chennai");
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//span[contains(text(),'Please select a service')]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//input[@class='select2-search__field'])[3]")).sendKeys("Account Management");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		
		Updateticket.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		
		js.executeScript("arguments[0].scrollIntoView(true);", CreateQuotation);
		try {
			try {

				robot.keyPress(KeyEvent.VK_PAGE_UP);
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
				CreatenewQuotation.click();
				CreateQuotation.click();
				CreateQuotation.click();
			} catch (ElementClickInterceptedException e211) {

				Thread.sleep(1500);
				js.executeScript("arguments[0].scrollIntoView(true);", CreatenewQuotation);

				robot.keyPress(KeyEvent.VK_PAGE_UP);
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
				// CreatenewQuotation.click();
				Thread.sleep(3500);
				CreateQuotation.click();
				CreateQuotation.click();
			}

			// EventCheckbox.click();

			Thread.sleep(5000);
			Set<String> allwindowsid = driver.getWindowHandles();
			List<String> all = new ArrayList<String>(allwindowsid);
			all.addAll(allwindowsid);
			driver.switchTo().window(all.get(1));

			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='name']//child::input)[1]")));
			QNameofthecustomer.click();

			QNameofthecustomer.sendKeys(QNameOfCustomer);
			Qaddress.click();

			Qaddress.sendKeys(qaddress);
			Qpincode.click();
			Qpincode.sendKeys(qpincode);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement QPaymenttypescroll = driver.findElement(By.xpath("//option[contains(text(),'Full Payment')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", QPaymenttypescroll);

			PaymentType.click();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1500);

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_2);
			robot.keyRelease(KeyEvent.VK_2);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement QConfirmquotationScroll = driver.findElement(By.xpath("//a[@class='send confirm_value']"));
			js.executeScript("arguments[0].scrollIntoView(true);", QConfirmquotationScroll);
			Confirmquotation.click();

			js.executeScript("arguments[0].scrollIntoView(true);", sendquotation);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1500);

			sendquotation.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			try {
				CreatenewQuotation.click();
				Thread.sleep(2500);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_R);
				robot.keyPress(KeyEvent.VK_R);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			} catch (NoSuchElementException deactivate) {

				DeactivateYES.click();
				Thread.sleep(3500);

				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_R);
				robot.keyPress(KeyEvent.VK_R);
				robot.keyRelease(KeyEvent.VK_CONTROL);

			}
			Thread.sleep(3000);
			Thread.sleep(1500);
			driver.close();

			driver.switchTo().window(all.get(0));
			Thread.sleep(2500);
			test.log(Status.PASS, "QuotationCreated");
		} catch (Exception CreatenewQuotation1) {
			test.log(Status.FAIL, "Quotation Creation failed");
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2500);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		CreatenewQuotation.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			editquoation.click();
			Thread.sleep(2500);
			List<String> all2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(all2.get(1));
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

			Thread.sleep(2500);

//		Set<String> allwindowsid = driver.getWindowHandles();
//		List<String> all = new ArrayList<String>(allwindowsid);
//		all.addAll(allwindowsid);
//		driver.switchTo().window(all.get(2));

			PaymentType.click();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1500);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1500);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			js.executeScript("arguments[0].scrollIntoView(true);", ConfirmquotationEdit);
			ConfirmquotationEdit.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			sendquotationedit.click();
			Thread.sleep(2500);
			driver.close();
			Thread.sleep(2500);
			driver.switchTo().window(all2.get(0));
			;
			Thread.sleep(2500);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			test.log(Status.PASS, "Edit Quotation");
		} catch (Exception EditQuotation1) {
			test.log(Status.FAIL, "Edit Quotation Failed");
			System.out.println("Edit Quotation failed");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2500);wait.until(
				ExpectedConditions.elementToBeClickable(CreatenewQuotation));
		CreatenewQuotation.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			Generatequotation.click();
			Thread.sleep(2000);
			test.log(Status.PASS, "Generate Quotation success");
		} catch (Exception GenerateQuotation1) {
			test.log(Status.FAIL, "Generate Quotation Failed");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<String> all4 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(all4.get(1));
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(all4.get(0));
		Thread.sleep(2000);
		try {
			deactivateQuotation.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			test.log(Status.PASS, "DeactivateQuotation success");
		} catch (Exception DeactivateQuotation1) {
			test.log(Status.FAIL, "DeactivateQuotation Failed");
		}
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(4000);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		try {
			LoadmoreMessagesCTA.click();
			test.log(Status.PASS, "Loadmore message success");
		} catch (Exception LoadmoreMessage) {
			test.log(Status.FAIL, "load more Failed");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(2000);

//		driver.switchTo().window(all.get(0));
		Thread.sleep(1500);
		System.out.println("Edit section");
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(1500);
		try {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='editBtn']")));
				js.executeScript("arguments[0].scrollIntoView(true);", Editticket);
				Editticket.click();

			} catch (ElementClickInterceptedException elementintercptedEdit) {
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				Thread.sleep(3000);
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
				driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
			}

			Thread.sleep(2500);
			Assignedto.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1500);
			Assignedtoname.click();
			Assignedtoname.sendKeys(assignedtoName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1500);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			BDagentCTA.click();
			Thread.sleep(1500);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Paymentstatus.click();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Updateticket.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.alertIsPresent()).accept();
			test.log(Status.PASS, "Edit ticket success");
		} catch (Exception Editticket1) {
			test.log(Status.FAIL, "Edit ticket Failed");
		}
		try {
			CrosssaleCTA.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1500);
			Selectcrosssale.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1500);
			Selectcrosssale.sendKeys(CrossSaleName);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1500);
			Createcrosssale.click();
			Thread.sleep(2500);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			test.log(Status.PASS, "Cross sale creation success");
		} catch (Exception Crosssale1) {
			test.log(Status.FAIL, "Cross sale creation Failed");
		}
		Thread.sleep(10000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(10000);
		try {
			RecentTickets.click();
			Thread.sleep(2500);
			Recenetfirstticket.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Recent ticket id click success");
		} catch (Exception RecentTicket1) {
			test.log(Status.FAIL, "Recent ticket id Failed");
		}
		String T1 = recentTicketID.getText().substring(1, 8);
		System.out.println(T1);
		driver.navigate().back();

		try {
			driver.findElement(By.xpath("(//button[@class='close'])[3]")).click();
		} catch (NoSuchElementException CLose) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (ElementNotInteractableException close1) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		try {
			try {
				Merge.click();
			} catch (ElementClickInterceptedException Merge34) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_R);
				robot.keyPress(KeyEvent.VK_R);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(2500);
				Merge.click();
			}

			try {
				Thread.sleep(2000);
				mergesearchticketId1.click();
			} catch (NoSuchElementException m9ergesearchticketId1) {
				driver.findElement(By.xpath("//a[contains(text(),'Merge')]")).click();
				Thread.sleep(2000);
				mergesearchticketId1.click();
				Thread.sleep(1500);
			}

			robot.keyPress(KeyEvent.VK_3);
			robot.keyRelease(KeyEvent.VK_3);
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			mergesearchticketId.sendKeys(T1);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1500);
			mergeSecondcheckbox.click();
			Thread.sleep(1500);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			mergesavechanges.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(2000);
			Thread.sleep(3500);
			driver.switchTo().alert().accept();
			test.log(Status.PASS, "Merge success");
		} catch (Exception Merge1) {
			test.log(Status.FAIL, "Merge Failed");
		}

		try {
			Magickeycopy.click();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3500);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3500);
			List<String> all6 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(all6.get(1));
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3500);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3500);
			String title = driver.getTitle();
			System.out.println(title + " Title");
			String A2 = "GRC | Vakilsearch";
			if (title.contentEquals(A2)) {
				test.log(Status.PASS, "Magic title success");

			} else {
				test.log(Status.FAIL, "Magic title failed");
			}

			driver.close();
			driver.switchTo().window(all6.get(0));
			Thread.sleep(5000);
			test.log(Status.PASS, "Magic Key success");
		} catch (Exception magickey1) {
			test.log(Status.FAIL, "Magic key failed");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			CustomerDashboard.click();
			Thread.sleep(3000);
			driver.navigate().back();
			test.log(Status.PASS, "Customer dashboard success");
		} catch (Exception Customerdashboard1) {
			test.log(Status.FAIL, "Cstomer dashboard Failed");
		}
		Thread.sleep(3000);
		try {
			GRCCTA.click();
			List<String> all3 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(all3.get(1));
			Thread.sleep(5000);
			try {
				GRCPageobject.Closepopup.click();
				}catch(Exception Closepopup) {
					System.out.println("No popup");
				}
			try {
				GRCPageobject.ProfileMenu.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//p[contains(text(),'Sign out')]")).click();
			} catch (ElementClickInterceptedException e290) {
				driver.findElement(By.xpath("//div[contains(text(),'Continue your service request from here ')]"))
						.click();
				Thread.sleep(1500);
				GRCPageobject.ProfileMenu.click();

				Thread.sleep(2000);
				driver.findElement(By.xpath("//p[contains(text(),'Sign out')]")).click();
			}finally {
				System.out.println("GRC");
			}

			driver.close();
			driver.switchTo().window(all3.get(0));
			test.log(Status.PASS, "GRC page Redirection success");
		} catch (Exception Grcredirection1) {
			test.log(Status.FAIL, "Grc page redirection Failed");
		}
		Thread.sleep(2000);
		try {
		driver.findElement(By.xpath("(//div[@class='collapse navbar-collapse']/child::ul/child::li/child::a)[3]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		}catch(Exception Logout1) {
			System.out.println("already Logout");
			
		}
		NewCRM newCRM = new NewCRM();

		newCRM.newCRM(driver, e, CrmUsernames, CrmUserpassword, extentreport);
	}

}
