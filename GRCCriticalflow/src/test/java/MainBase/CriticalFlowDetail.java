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
import org.codehaus.groovy.transform.sc.StaticCompilationMetadataKeys;
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
import org.openqa.selenium.interactions.Actions;
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

import Keymethods.GRCPage;
import Keymethods.GrcLogin;
import Keymethods.NewCRM;
import Keymethods.Payment;
import PageFactory.GRCPageobject;
import PageFactory.HelpdeskPageobject;
import PageFactory.HomescreenPageobject;
import PageFactory.LoginPageobjects;
import PageFactory.NewCRMPageobject;
import groovyjarjarantlr4.v4.codegen.model.Action;
import groovyjarjarantlr4.v4.parse.ANTLRParser.actionScopeName_return;
import groovyjarjarantlr4.v4.parse.ANTLRParser.action_return;
import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CriticalFlowDetail extends HelpdeskPageobject {

	JavascriptExecutor js;
	Robot robot;
	ExtentTest test;

	public CriticalFlowDetail(WebDriver driver, String Helpdeskuserid, String helpdeskpassword, String notesname,
			String notedescrption, String QNameOfCustomer, String qaddress, String qpincode, String Professionalfees,
			String assignedtoName, String BDAgentName, String CrossSaleName, String GRCMobileNumber,
			String CrmUsernames, String CrmUserpassword, String GRCNewCompanyName, String CINNumber,
			ExtentReports extentreport) throws InterruptedException, AWTException, ElementClickInterceptedException {
		Robot robot = new Robot();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		test = extentreport.createTest("Helpdesk");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		PageFactory.initElements(driver, GRCPageobject.class);
		PageFactory.initElements(driver, NewCRMPageobject.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
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
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Helpdesk.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Tickets.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// ticketid.sendKeys(GRCPage.e);
		ticketid.sendKeys("3284255");
		Search.click();
		Firstservice.click();

		/*
		 * try { try { wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//button[@id='editBtn']")));
		 * js.executeScript("arguments[0].scrollIntoView(true);", Editticket);
		 * Editticket.click();
		 * 
		 * } catch (ElementClickInterceptedException elementintercptedEdit) {
		 * robot.keyPress(KeyEvent.VK_PAGE_UP); Thread.sleep(3000);
		 * robot.keyRelease(KeyEvent.VK_PAGE_UP); robot.keyPress(KeyEvent.VK_PAGE_UP);
		 * robot.keyRelease(KeyEvent.VK_PAGE_UP);
		 * driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click(); }
		 * Thread.sleep(2500); Assignedto.click();
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * Thread.sleep(1500); Assignedtoname.click();
		 * Assignedtoname.sendKeys(assignedtoName);
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * Thread.sleep(1500);
		 * 
		 * Paymentstatus.click(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER); Thread.sleep(2000);
		 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_MINUS);
		 * robot.keyRelease(KeyEvent.VK_MINUS); robot.keyRelease(KeyEvent.VK_CONTROL);
		 * driver.findElement(By.xpath(
		 * "//span[@id='select2-city_filter_edit-container']")).click();
		 * Thread.sleep(1500);
		 * driver.findElement(By.xpath("(//input[@class='select2-search__field'])[3]")).
		 * sendKeys("chennai"); Thread.sleep(1500); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 * 
		 * driver.findElement(By.
		 * xpath("//span[contains(text(),'Please select a service')]")).click();
		 * Thread.sleep(1500);
		 * driver.findElement(By.xpath("(//input[@class='select2-search__field'])[3]")).
		 * sendKeys("Account Management"); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 * 
		 * Updateticket.click(); Thread.sleep(2000);
		 * wait.until(ExpectedConditions.alertIsPresent()).accept();
		 * test.log(Status.PASS, "Edit ticket success"); } catch (Exception Editticket1)
		 * { test.log(Status.FAIL, "Edit ticket Failed");
		 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyRelease(KeyEvent.VK_R);
		 * robot.keyPress(KeyEvent.VK_R); robot.keyRelease(KeyEvent.VK_CONTROL); }
		 */
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
			ChooseCriticalNoesFile.sendKeys(
					"C:\\Users\\admin\\git\\Automation-Critical-Flow\\GRCCriticalflow\\Excel\\sample-aadhaar-card-800x445.png");

			employtonotify.click();
			Thread.sleep(1500);
			robot.keyPress(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_D);
			robot.keyPress(KeyEvent.VK_H);
			robot.keyRelease(KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_U);
			robot.keyRelease(KeyEvent.VK_U);
			robot.keyPress(KeyEvent.VK_B);
			robot.keyRelease(KeyEvent.VK_B);
			robot.keyPress(KeyEvent.VK_O);
			robot.keyRelease(KeyEvent.VK_O);

			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_SPACE);

			robot.keyPress(KeyEvent.VK_B);
			robot.keyRelease(KeyEvent.VK_B);
			robot.keyPress(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_D);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			CriticalNoteSave.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Critical Note added");
		} catch (Exception CriticalNote) {
			test.log(Status.PASS, "Critical note Failed");
		}
		Thread.sleep(3500);
		// js.executeScript("arguments[0].scrollIntoView(true);",
		// RecentNoteVerification);
		String text = RecentNoteVerification.getText();
		System.out.println(text);
		if (text.contains("testing")) {

			Viewattachment.click();
			Thread.sleep(5000);
			List<String> all29 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(all29.get(1));
			driver.close();
			test.log(Status.PASS, "Critical Note verified");
		} else {
			test.log(Status.PASS, "Critical note verification failed");
		}
		List<String> all29 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(all29.get(0));
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
			addnoteattachment.sendKeys(
					"C:\\Users\\admin\\git\\Automation-Critical-Flow\\GRCCriticalflow\\Excel\\sample-aadhaar-card-800x445.png");
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

			addnoteTo.click();
			Thread.sleep(1500);
			robot.keyPress(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_D);
			robot.keyPress(KeyEvent.VK_H);
			robot.keyRelease(KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_U);
			robot.keyRelease(KeyEvent.VK_U);
			robot.keyPress(KeyEvent.VK_B);
			robot.keyRelease(KeyEvent.VK_B);
			robot.keyPress(KeyEvent.VK_O);
			robot.keyRelease(KeyEvent.VK_O);

			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_SPACE);

			robot.keyPress(KeyEvent.VK_B);
			robot.keyRelease(KeyEvent.VK_B);
			robot.keyPress(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_D);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			addnotesend.click();

			Thread.sleep(2500);
			/*
			 * addnote.click(); driver.manage().timeouts().implicitlyWait(30,
			 * TimeUnit.SECONDS); driver.findElement(By.
			 * xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[4]")).click();
			 * driver.findElement(By.
			 * xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[4]"))
			 * .sendKeys("Testing Add note CRM"); EmailTo.click(); emailsearchTo.click();
			 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 * emailsearchTo.sendKeys(assignedtoName);
			 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
			 * Thread.sleep(2000); Emailtoaddnote.click();Thread.sleep(1500);
			 * Emailtoaddnote.sendKeys("Testing");
			 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 * 
			 * EmailAddAttachment .sendKeys(
			 * "C:\\\\Users\\\\admin\\\\eclipse-workspace\\\\GRCCriticalflow\\\\Excel\\\\Customer.xlsx"
			 * ); EmailButtonSend.click(); driver.manage().timeouts().implicitlyWait(30,
			 * TimeUnit.SECONDS);
			 */
			test.log(Status.PASS, "Add Note Created");
		} catch (Exception AddNote) {
			test.log(Status.FAIL, "Add Note Failed");
		}
		Thread.sleep(3500);
		// js.executeScript("arguments[0].scrollIntoView(true);",
		// RecentNoteVerification);
		String textTo = RecentNoteVerification.getText();
		System.out.println(textTo);
		if (textTo.contains("test")) {

			Viewattachment.click();
			Thread.sleep(5000);
			List<String> all30 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(all30.get(1));
			driver.close();
			test.log(Status.PASS, "add Note verified");
		} else {
			test.log(Status.PASS, "add note verification failed");
		}
		List<String> all30 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(all30.get(0));

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

			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//a[@class='email-tempalte-object template_object_new'])[2]")));
			try {
				cannedFollowingEmail.click();
			} catch (StaleElementReferenceException e03) {
				cannedFollowingEmail1.click();
			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			cannedEmailaddattachment.sendKeys(
					"C:\\Users\\admin\\git\\Automation-Critical-Flow\\GRCCriticalflow\\Excel\\sample-aadhaar-card-800x445.png");
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
//*****if needed you can take this*****//

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

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='name']//child::input)[1]")));
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
		String AmountValidation1 = driver
				.findElement(By.xpath(
						"//td[@style='border-bottom:1px solid #f7f7f7;padding:10px 14px 10px 10px;text-align:right;']"))
				.getText().substring(2, 7);
		driver.findElement(By.xpath("(//a[contains(text(),'Pay Now')])[1]")).click();
		List<String> all32 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(all32.get(1));
		
		String PaynowAmountValidation = driver.findElement(By.xpath("(//div[@class='styles_totalPrice__1O_p9']/child::h2)[2]")).getText().substring(2, 7);
		
		if(AmountValidation1.contains(PaynowAmountValidation)){
		test.log(Status.PASS, "QuotationCreation amount verified");
	} else {
		test.log(Status.FAIL, "Quotation Creation amount verification failed "+AmountValidation1 + PaynowAmountValidation);
	}
		driver.close();
		driver.switchTo().window(all32.get(0));
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
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			String AmountValidation2 = driver
					.findElement(By.xpath(
							"//td[@style='border-bottom:1px solid #f7f7f7;padding:10px 14px 10px 10px;text-align:right;']"))
					.getText().substring(2, 7);
			driver.findElement(By.xpath("(//a[contains(text(),'Pay Now')])[1]")).click();
			List<String> all33 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(all33.get(1));
			
			String PaynowAmountValidation2 = driver.findElement(By.xpath("(//div[@class='styles_totalPrice__1O_p9']/child::h2)[2]")).getText().substring(2, 7);
			
			if(AmountValidation2.contains(PaynowAmountValidation2)){
			test.log(Status.PASS, "Edit Quotation amount verified ");
		} else {
			test.log(Status.FAIL, "Edit Quotation Creation amount verification failed "+ AmountValidation2 + PaynowAmountValidation2);
		}
			driver.close();
			driver.switchTo().window(all33.get(0));
			Thread.sleep(2500);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_CONTROL); 
			test.log(Status.PASS, "Edit Quotation success");
		} catch (Exception EditQuotation1) {
			test.log(Status.FAIL, "Edit Quotation Failed");
			System.out.println("Edit Quotation failed");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2500);
		wait.until(ExpectedConditions.elementToBeClickable(CreatenewQuotation));
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
			String AmountValidation3 = driver
					.findElement(By.xpath(
							"//td[@style='border-bottom:1px solid #f7f7f7;padding:10px 14px 10px 10px;text-align:right;']"))
					.getText();
			driver.findElement(By.xpath("(//a[contains(text(),'Pay Now')])[1]")).click();
			List<String> all35 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(all35.get(1));
			
			String PaynowAmountValidation3 = driver.findElement(By.xpath("//h3[@class='p-2']/child::b")).getText();
			driver.close();
			driver.switchTo().window(all35.get(0));
			if("This quotation has been deactivated.".contains(PaynowAmountValidation3)){
			test.log(Status.PASS, "Quotation Deactivation verified");
		} else {
			test.log(Status.FAIL, "Quotation Deactivation verification failed");
		}
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
		Thread.sleep(3000);
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
		Emailtoaddnote.click();
		Thread.sleep(2500);

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
		// **** Emailtoaddnote.sendKeys("Hi Testing");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		EmailAddAttachment
				.sendKeys("C:\\\\Users\\\\admin\\\\eclipse-workspace\\\\GRCCriticalflow\\\\Excel\\\\Customer.xlsx");
		EmailButtonSend.click();
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
			} catch (Exception Closepopup) {
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
			} finally {
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
		} catch (Exception Logout1) {
			System.out.println("already Logout");

		}
		NewCRM newCRM = new NewCRM();

		newCRM.newCRM(driver, GRCPage.e, CrmUsernames, CrmUserpassword, extentreport);
	}

}
