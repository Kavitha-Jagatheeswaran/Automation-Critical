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
import Keymethods.Payment;
import PageFactory.GRCPageobject;
import PageFactory.HelpdeskPageobject;
import PageFactory.HomescreenPageobject;
import PageFactory.LoginPageobjects;
import groovyjarjarantlr4.v4.codegen.model.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CriticalFlowDetail extends HelpdeskPageobject {

	ExtentTest test;

	public CriticalFlowDetail(WebDriver driver, String Helpdeskuserid, String helpdeskpassword, String notesname,
			String notedescrption, String QNameOfCustomer, String qaddress, String qpincode, String Professionalfees,
			String assignedtoName, String BDAgentName, String CrossSaleName, String GRCMobileNumber,
			ExtentReports extentreport) throws InterruptedException, AWTException {
		Robot robot = new Robot();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		test = extentreport.createTest("Test1");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		PageFactory.initElements(driver, GRCPageobject.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(3000);

		try {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Interests')]")));
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
		if (e.matches(e)) {
			test.log(Status.PASS, "Yes");
		} else {

			test.log(Status.FAIL, "no");
		}

		System.out.println(e);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Payment key = new Payment(driver, test);
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://helpdesk.vakilsearch.com/login");

		Thread.sleep(10000);
		HelpdeskPageobject.Username.sendKeys(Helpdeskuserid);
		String text1 = HelpdeskPageobject.Username.getText();
		String text2 = "testingsa_2_2020@vakilsearch.com";
		System.out.println(text1);
		if (text1.contentEquals(text2)) {
			test.log(Status.PASS, "Yes");
		} else {

			test.log(Status.FAIL, "no1");
		}

		HelpdeskPageobject.Password.sendKeys(helpdeskpassword);
		HelpdeskPageobject.Signin.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.Helpdesk.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.Tickets.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.ticketid.sendKeys(e);

		HelpdeskPageobject.Search.click();
		HelpdeskPageobject.Firstservice.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.CriticalnotesCTA.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.NewCriticalNoteCTA.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);

		HelpdeskPageobject.TypeCriticalNotes.click();
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

//		 HelpdeskPageobject.TypeCriticalNotes.sendKeys("Testing");driver.manage().timeouts().implicitlyWait(30,
//		 TimeUnit.SECONDS);
//		 HelpdeskPageobject.ChooseCriticalNoesFile.click();
		HelpdeskPageobject.ChooseCriticalNoesFile
				.sendKeys("C:\\Users\\admin\\eclipse-workspace\\GRCCriticalflow\\Excel\\Customer.xlsx");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.CriticalNoteSave.click();
		Thread.sleep(10000);

		HelpdeskPageobject.PersonalNote.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.NewPersonalNote.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.TypePersonalnote.click();
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
		HelpdeskPageobject.savepersonalnote.click();

		Thread.sleep(1500);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.addnote.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.addnoteattachment
				.sendKeys("C:\\\\Users\\\\admin\\\\eclipse-workspace\\\\GRCCriticalflow\\\\Excel\\\\Customer.xlsx");
		HelpdeskPageobject.typeaddnote.click();
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
		HelpdeskPageobject.addnotesend.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		HelpdeskPageobject.addnote.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.EmailTo.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.emailsearchTo.sendKeys(assignedtoName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		HelpdeskPageobject.Emailtoaddnote.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		HelpdeskPageobject.EmailAddAttachment
				.sendKeys("C:\\\\Users\\\\admin\\\\eclipse-workspace\\\\GRCCriticalflow\\\\Excel\\\\Customer.xlsx");
		HelpdeskPageobject.EmailButtonSend.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		HelpdeskPageobject.MenuDownArrow.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.CannedResponseCTA.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='nav-link canned_response_folder_select active']")));
		try {
			HelpdeskPageobject.cannedAddingaDriector.click();
		} catch (StaleElementReferenceException e02) {
			HelpdeskPageobject.cannedaddingadirector1.click();
		}

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@class='email-tempalte-object template_object_new'])[2]")));
		try {
			HelpdeskPageobject.cannedFollowingEmail.click();
		} catch (StaleElementReferenceException e03) {
			HelpdeskPageobject.cannedFollowingEmail1.click();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.cannedEmailaddattachment.sendKeys(
				"C:\\\\\\\\Users\\\\\\\\admin\\\\\\\\eclipse-workspace\\\\\\\\GRCCriticalflow\\\\\\\\Excel\\\\\\\\Customer.xlsx");
		HelpdeskPageobject.cannedsubject.sendKeys(notesname);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		HelpdeskPageobject.cannedselectdate.click();

		try {
			HelpdeskPageobject.cannedDate29.click();
		} catch (StaleElementReferenceException e04) {

			driver.findElement(By.xpath("(//td[@class='xdsoft_date xdsoft_day_of_week1 xdsoft_date true,'])[4]")).click();
		} catch (ElementNotInteractableException CanneddateCatch) {

			driver.findElement(By.xpath("(//td[@data-date='27'])[1]")).click();
		}

		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.cannedDescription.sendKeys("Test1");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.cannedupdateCTA.click();

		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);

		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", HelpdeskPageobject.CreateQuotation);
		try {

			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			HelpdeskPageobject.CreatenewQuotation.click();
			HelpdeskPageobject.CreateQuotation.click();
			HelpdeskPageobject.CreateQuotation.click();
		} catch (ElementClickInterceptedException e211) {

			Thread.sleep(1500);
			js.executeScript("arguments[0].scrollIntoView(true);", HelpdeskPageobject.CreatenewQuotation);

			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			// HelpdeskPageobject.CreatenewQuotation.click();
			Thread.sleep(3500);
			HelpdeskPageobject.CreateQuotation.click();
			HelpdeskPageobject.CreateQuotation.click();
		}

		// HelpdeskPageobject.EventCheckbox.click();

		Thread.sleep(5000);
		Set<String> allwindowsid = driver.getWindowHandles();
		List<String> all = new ArrayList<String>(allwindowsid);
		all.addAll(allwindowsid);
		driver.switchTo().window(all.get(1));


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='name']//child::input)[1]")));
		HelpdeskPageobject.QNameofthecustomer.click();

		HelpdeskPageobject.QNameofthecustomer.sendKeys(QNameOfCustomer);
		HelpdeskPageobject.Qaddress.click();

		HelpdeskPageobject.Qaddress.sendKeys(qaddress);
		HelpdeskPageobject.Qpincode.click();
		HelpdeskPageobject.Qpincode.sendKeys(qpincode);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement QPaymenttypescroll = driver.findElement(By.xpath("//option[contains(text(),'Full Payment')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", QPaymenttypescroll);

		HelpdeskPageobject.PaymentType.click();
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
		HelpdeskPageobject.Confirmquotation.click();

		js.executeScript("arguments[0].scrollIntoView(true);", HelpdeskPageobject.sendquotation);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1500);

		HelpdeskPageobject.sendquotation.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
			HelpdeskPageobject.CreatenewQuotation.click();
			Thread.sleep(2500);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (NoSuchElementException deactivate) {

			HelpdeskPageobject.DeactivateYES.click();
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
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2500);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		HelpdeskPageobject.CreatenewQuotation.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.editquoation.click();
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

		HelpdeskPageobject.PaymentType.click();
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
		js.executeScript("arguments[0].scrollIntoView(true);", HelpdeskPageobject.ConfirmquotationEdit);
		HelpdeskPageobject.ConfirmquotationEdit.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		HelpdeskPageobject.sendquotationedit.click();
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		HelpdeskPageobject.CreatenewQuotation.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.Generatequotation.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<String> all4 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(all4.get(1));
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(all4.get(0));
		Thread.sleep(2000);
		HelpdeskPageobject.deactivateQuotation.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(4000);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		HelpdeskPageobject.LoadmoreMessagesCTA.click();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='editBtn']")));
			js.executeScript("arguments[0].scrollIntoView(true);", HelpdeskPageobject.Editticket);
			HelpdeskPageobject.Editticket.click();

		} catch (ElementClickInterceptedException elementintercptedEdit) {
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			Thread.sleep(3000);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
		}

		Thread.sleep(2500);
		HelpdeskPageobject.Assignedto.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1500);
		HelpdeskPageobject.Assignedtoname.click();
		HelpdeskPageobject.Assignedtoname.sendKeys(assignedtoName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1500);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		HelpdeskPageobject.BDagentCTA.click();
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

		HelpdeskPageobject.Updateticket.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3500);
		driver.switchTo().alert().accept();
		HelpdeskPageobject.CrosssaleCTA.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1500);
		HelpdeskPageobject.Selectcrosssale.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1500);
		HelpdeskPageobject.Selectcrosssale.sendKeys(CrossSaleName);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1500);
		HelpdeskPageobject.Createcrosssale.click();
		Thread.sleep(2500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(10000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(10000);
		HelpdeskPageobject.RecentTickets.click();
		Thread.sleep(2500);
		HelpdeskPageobject.Recenetfirstticket.click();
		Thread.sleep(5000);

		String T1 = HelpdeskPageobject.recentTicketID.getText().substring(1, 8);
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
			HelpdeskPageobject.Merge.click();
		} catch (ElementClickInterceptedException Merge) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2500);
			HelpdeskPageobject.Merge.click();
		}

		try {
			Thread.sleep(2000);
			HelpdeskPageobject.mergesearchticketId1.click();
		} catch (NoSuchElementException mergesearchticketId1) {
			driver.findElement(By.xpath("//a[contains(text(),'Merge')]")).click();
			Thread.sleep(2000);
			HelpdeskPageobject.mergesearchticketId1.click();
			Thread.sleep(1500);
		}
		

		robot.keyPress(KeyEvent.VK_3);
		robot.keyRelease(KeyEvent.VK_3);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelpdeskPageobject.mergesearchticketId.sendKeys(T1);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1500);
		HelpdeskPageobject.mergeSecondcheckbox.click();
		Thread.sleep(1500);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		HelpdeskPageobject.mergesavechanges.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Thread.sleep(3500);
		driver.switchTo().alert().accept();
		HelpdeskPageobject.Magickeycopy.click();

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
			test.log(Status.PASS, A2);

		} else {
			test.log(Status.FAIL, title);
		}

		driver.close();
		driver.switchTo().window(all6.get(0));
		Thread.sleep(5000);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		HelpdeskPageobject.CustomerDashboard.click();
		Thread.sleep(3000);
		driver.navigate().back();

		Thread.sleep(3000);
		HelpdeskPageobject.GRCCTA.click();
		List<String> all3 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(all3.get(1));
		Thread.sleep(5000);
	try {
		GRCPageobject.ProfileMenu.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'Sign out')]")).click();
	} catch (ElementClickInterceptedException e290) {
		driver.findElement(By.xpath("//div[contains(text(),'Continue your service request from here ')]")).click();
		Thread.sleep(1500);
		GRCPageobject.ProfileMenu.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'Sign out')]")).click();
	}
	
	    driver.close();
		driver.switchTo().window(all3.get(0));
		Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='collapse navbar-collapse']/child::ul/child::li/child::a)[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
}
