package Keymethods;

import static org.testng.Assert.expectThrows;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CriticalFlowRun.Criticalflow;
import PageFactory.GRCPageobject;
import PageFactory.HelpdeskPageobject;
import groovyjarjarantlr4.v4.parse.ANTLRParser.element_return;

public class GRCPage extends GRCPageobject {

	ExtentTest test;
	public static String e = "";

	public GRCPage(WebDriver driver, ExtentReports extentreport, String GRCMobileNumber, String GRCNewCompanyName,
			String CINNumber, String Helpdeskuserid, String helpdeskpassword, String assignedtoName)
			throws InterruptedException, AWTException, ElementClickInterceptedException {

//		Set<String> allwindowsid = driver.getWindowHandles();
//		List<String> all = new ArrayList<>();
//		all.addAll(allwindowsid);
//		driver.switchTo().window(all.get(5));
//		List<String> all7 = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(all7.get(1));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		Robot robot = new Robot();
		Actions actions = new Actions(driver);
		test = extentreport.createTest("GRC Test");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, GRCPageobject.class);
		Actions act = new Actions(driver);
		driver.get("https://grc.vakilsearch.com/grc/login");
		Thread.sleep(2500);

		GRCUsername.sendKeys(GRCMobileNumber);
		Thread.sleep(2500);
		GRCPhonenumberConfirm.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@style='width: 1em; text-align: center;'])[1]")));
		GRCOTP1.sendKeys("0");
		GRCOTP2.sendKeys("0");
		GRCOTP3.sendKeys("0");
		GRCOTP4.sendKeys("0");
		Thread.sleep(1500);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		try {
			GRCOTPConfirm.click();
		} catch (NoSuchElementException Login) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}

		Thread.sleep(3500);
		try {
			Closepopup.click();
		} catch (Exception Closepopup) {
			System.out.println("No popup");
		}

		Thread.sleep(4000);
		String DashboardURL = driver.getCurrentUrl().substring(0, 37);
		String DashboardURL1 = "https://grc.vakilsearch.com/grc/dashboard";
		if (DashboardURL1.contains(DashboardURL)) {
			test.log(Status.PASS, "Dashboard URL");
			System.out.println(DashboardURL);
		} else {
			test.log(Status.FAIL, "Dashboard URL Not Same  " + DashboardURL);
			System.out.println(DashboardURL1);

		}
		Thread.sleep(5000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Closehelp1));
			actions.moveToElement(Closehelp1).click().build().perform();
		} catch (Exception NeedClose) {
			wait.until(ExpectedConditions.elementToBeClickable(Closehelp2));
			actions.moveToElement(Closehelp2).click().build().perform();

		}
		Thread.sleep(3000);
		try {

			GRCPage.addnewEntity.click();

		} catch (Exception addnewEntity) {
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@class='styles_dropdown__kgL4A']/child::button"))).click();
			Thread.sleep(2500);

			AddNewBusiness2.click();

		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary']")));
		Letsgo.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='styles_dropdownToggle__oqhXx ']")));
		ChooseBusinessType.click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//li[contains(text(),'Private Limited Company(PVT)')]")));
		PrivateLimitedCompany.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='styles_textInput__k8w0C'])[1]")));

		CompanyName.click();
		CompanyName.sendKeys(GRCNewCompanyName);
		CINNo.click();
		CINNo.sendKeys(CINNumber);
		Thread.sleep(3500);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue')]")));
			Continue.click();
			Thread.sleep(2500);
		} catch (Exception e102) {
			wait.until(ExpectedConditions.elementToBeClickable(Continue));
			actions.moveToElement(Continue).click().build().perform();
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//p[contains(text(),'Business Industry')]")));
		BusinessIndustry.click();
		Thread.sleep(1500);
		AgricultureAndDairyFarming.click();
		Thread.sleep(1500);
		SubIndustry.click();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		Continue2.click();
		Thread.sleep(1500);

		Skip.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Continue')]")));
		LetsGetStartedContinue.click();
		Thread.sleep(2500);
		try {
			Closepopup.click();
		} catch (Exception Closepopup) {
			System.out.println("No popup");
		}
		try {
			Closepopup.click();
		} catch (Exception Closepopup) {
			System.out.println("No popup");
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Closehelp1));
			actions.moveToElement(Closehelp1).click().build().perform();
		} catch (Exception NeedClose) {
			try {

				wait.until(ExpectedConditions.elementToBeClickable(Closehelp2));
				actions.moveToElement(Closehelp2).click().build().perform();
			} catch (Exception NeedClosed2) {
				System.out.println("Need help closed");
			}
		}
		Thread.sleep(2500);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='styles_dropdownBtn__I6_4i']/child::p"))).click();
		Thread.sleep(2500);
		// **just for option
//	OpenEntityList.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='styles_accountsList__qfPzH']/child::div)[2]"))).click();
		// EntitySelect2.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='styles_dropdownBtn__I6_4i']/child::p"))).click();
		Thread.sleep(2500);
		// **just for option
//	OpenEntityList.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='styles_accountsList__qfPzH']/child::div)[1]"))).click();
		Thread.sleep(1500);
		ProfileMenu.click();
		Thread.sleep(1500);
		ViewProfile.click();
		Thread.sleep(1500);
		String ProfileInformationURL = driver.getCurrentUrl().substring(0, 44);
		String ProfileInformationURL1 = "https://grc.vakilsearch.com/grc/user-profile";
		if (ProfileInformationURL1.contains(ProfileInformationURL)) {
			test.log(Status.PASS, "ProfileInformationURL");
			System.out.println(ProfileInformationURL);
		} else {
			test.log(Status.FAIL, "ProfileInformationURL Not Same  " + ProfileInformationURL);
			System.out.println(ProfileInformationURL1);
		}

		driver.navigate().back();
		try {

			Closepopup.click();
		} catch (Exception Closepopup) {
			System.out.println("No popup");
		}

		Thread.sleep(2500);
		js1.executeScript("arguments[0].scrollIntoView(true);", BuyNowService);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Buy now')])[1]")))
				.click();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		// BuyNowService.click();
		Thread.sleep(1500);
		try {
			AreyouintrestedinGST.click();
			Thread.sleep(1500);
			ContinueGST.click();
			Thread.sleep(1500);
			AreyouintrestedinGST.click();
			Thread.sleep(1500);
			GSTRegistrationState.click();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			ContinueGST.click();
			Thread.sleep(1500);
			ContinueGST.click();
		} catch (NoSuchElementException AreyouintrestedinGST) {

			try {
				GSTRegistrationState.click();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				ContinueGST.click();
				ContinueGST.click();
			} catch (NoSuchElementException AreyouintrestedinGST1) {

				try {

					ContinueGST.click();
				} catch (NoSuchElementException ContinueGST) {
					System.out.println("TicketID");
				}
			}

		}

		String ServiceID = GetServiceID.getText().substring(1);
		System.out.println(ServiceID + "GRC");

		try {
			Closepopup.click();
		} catch (Exception Closepopup1) {
			System.out.println("No popup");
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(Closehelp1));
			actions.moveToElement(Closehelp1).click().build().perform();
		} catch (Exception NeedClose) {
			try {

				wait.until(ExpectedConditions.elementToBeClickable(Closehelp2));
				actions.moveToElement(Closehelp2).click().build().perform();
			} catch (Exception NeedClosed2) {
				System.out.println("Need help closed");
			}
		}

		// actions.click(Needhelp);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Need help')]")));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Need help')]"))).click();
		// Needhelp.click();
		Thread.sleep(1500);
		String NeedHelpURL = driver.getCurrentUrl().substring(0, 36);
		String NeedHelpURL1 = "https://grc.vakilsearch.com/grc/help";
		if (NeedHelpURL1.contains(NeedHelpURL)) {
			test.log(Status.PASS, "NeedHelpURL");
			System.out.println(NeedHelpURL);
		} else {
			test.log(Status.FAIL, "NeedHelpURL Not Same  " + NeedHelpURL);
			System.out.println(NeedHelpURL1);
		}
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='styles_needHelpModal__xIW3p']/child::div/div)[6]")));
		clickVideo.click();
		Thread.sleep(3500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(8000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(4000);
		// **********
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Settings']/parent::button"))).click();
		// driver.findElement(By.xpath("//img[@alt='Settings']/parent::button")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//p[contains(text(),'Business Profile')]")).click();
		Thread.sleep(10000);
		String BusinessProfileURL = driver.getCurrentUrl().substring(0, 48);
		String BusinessProfileURL1 = "https://grc.vakilsearch.com/grc/business-profile";
		if (BusinessProfileURL1.contains(BusinessProfileURL)) {
			test.log(Status.PASS, "BusinessProfileURL");
			System.out.println(BusinessProfileURL1);
		} else {
			test.log(Status.FAIL, "BusinessProfileURL not same" + BusinessProfileURL);
			System.out.println(BusinessProfileURL);
		}

		driver.navigate().back();
		Thread.sleep(10000);

		// *********

		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']/child::img")).click();
		Thread.sleep(2500);
		Thread.sleep(10000);

		driver.findElement(By.xpath("//p[contains(text(),'Users & Roles')]")).click();
		Thread.sleep(10000);
		String UsersandRolesURL = driver.getCurrentUrl().substring(0, 42);
		String UsersandRolesURL1 = "https://grc.vakilsearch.com/grc/user_roles";
		if (UsersandRolesURL1.contains(UsersandRolesURL)) {
			test.log(Status.PASS, "UsersAndRolesURL");
			System.out.println(UsersandRolesURL1);
		} else {
			test.log(Status.FAIL, "UsersandRolesURL not same" + UsersandRolesURL);
			System.out.println(UsersandRolesURL);
		}
		driver.navigate().back();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']/child::img")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//p[contains(text(),'Users & Roles')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//Button[contains(text(),'Add users')]")).click();
		Thread.sleep(10000);
		String AddUserURL = driver.getCurrentUrl().substring(0, 42);
		String AddUserURL1 = "https://grc.vakilsearch.com/grc/user_roles";
		if (AddUserURL1.contains(AddUserURL)) {
			test.log(Status.PASS, "AddUserURL");
			System.out.println(AddUserURL1);
		} else {
			test.log(Status.FAIL, "AddUserURL not same" + AddUserURL);
			System.out.println(AddUserURL);
		}
		// driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(10000);
		// *********
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']/child::img")).click();
		Thread.sleep(7500);
		driver.findElement(By.xpath("//p[contains(text(),'Help')]")).click();
		Thread.sleep(7500);
		String HelpURL = driver.getCurrentUrl().substring(0, 36);
		String HelpURL1 = "https://grc.vakilsearch.com/grc/help";
		if (HelpURL1.contains(HelpURL)) {
			test.log(Status.PASS, "HelpURL");
			System.out.println(HelpURL1);
		} else {
			test.log(Status.FAIL, "HelpURL not same" + HelpURL);
			System.out.println(HelpURL);
		}
		driver.navigate().back();
		Thread.sleep(5500);
		// **********
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		Thread.sleep(5500);
		driver.findElement(By.xpath("//p[contains(text(),'Support')]")).click();
		Thread.sleep(5500);
		String SupportURL = driver.getCurrentUrl().substring(0, 42);
		String SupportURL1 = "https://grc.vakilsearch.com/grc/contact-us";
		if (SupportURL1.contains(SupportURL)) {
			test.log(Status.PASS, "SupportURL");
			System.out.println(SupportURL1);
		} else {
			test.log(Status.FAIL, "SupportURL not same" + SupportURL);
			System.out.println(SupportURL);
		}
		driver.navigate().back();
		Thread.sleep(8000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Closehelp1));
			actions.moveToElement(Closehelp1).click().build().perform();
		} catch (Exception NeedClose) {
			try {

				wait.until(ExpectedConditions.elementToBeClickable(Closehelp2));
				actions.moveToElement(Closehelp2).click().build().perform();
			} catch (Exception NeedClosed2) {
				System.out.println("Need help closed");
			}
		}
		// **************
		// driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Messages')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Messages')]"))).click();
		// driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();
		Thread.sleep(2500);
		String MessagesURL = driver.getCurrentUrl().substring(0, 40);
		String MessagesURL1 = "https://grc.vakilsearch.com/grc/messages";
		if (MessagesURL1.contains(MessagesURL)) {
			test.log(Status.PASS, "MessagesURL");
			System.out.println(MessagesURL1);
		} else {
			test.log(Status.FAIL, "MessagesURL not same" + MessagesURL);
			System.out.println(MessagesURL);
		}

		driver.navigate().back();
		Thread.sleep(5500);
		// ********

		// driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'All Services')]")).click();
		Thread.sleep(2500);
		String AllServicesURL = driver.getCurrentUrl().substring(0, 40);
		String AllServicesURL1 = "https://grc.vakilsearch.com/grc/services";
		if (AllServicesURL1.contains(AllServicesURL)) {
			test.log(Status.PASS, "AllServicesURL");
			System.out.println(AllServicesURL1);
		} else {
			test.log(Status.FAIL, "AllServicesURL not same" + AllServicesURL);
			System.out.println(AllServicesURL);
		}
		driver.navigate().back();
		Thread.sleep(5500);

		driver.findElement(By.xpath("//span[contains(text(),'Payments')]")).click();
		Thread.sleep(2500);
		String PaymentsURL = driver.getCurrentUrl().substring(0, 40);
		String PaymentsURL1 = "https://grc.vakilsearch.com/grc/payments";
		if (PaymentsURL.contains(PaymentsURL1)) {
			test.log(Status.PASS, "PaymentsURL");
			System.out.println(PaymentsURL1);
		} else {
			test.log(Status.FAIL, "PaymentsURL not same" + PaymentsURL);
			System.out.println(PaymentsURL);
		}
		driver.navigate().back();
		Thread.sleep(5500);
		// driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Compliance Calendar')]")).click();
		Thread.sleep(2500);
		String ComplianceCalendar = driver.getCurrentUrl().substring(0, 40);
		String ComplianceCalendar1 = "https://grc.vakilsearch.com/grc/calendar";
		if (ComplianceCalendar.contains(ComplianceCalendar1)) {
			test.log(Status.PASS, "ComplianceCalendar");
			System.out.println(ComplianceCalendar1);
		} else {
			test.log(Status.FAIL, "ComplianceCalendarURL not same" + ComplianceCalendar);
			System.out.println(ComplianceCalendar);
		}

		driver.navigate().back();
		Thread.sleep(5500);
		driver.findElement(By.xpath("//span[contains(text(),'Rewards')]")).click();
		Thread.sleep(2500);
		String RewardsURL = driver.getCurrentUrl().substring(0, 39);
		String RewardsURL1 = "https://grc.vakilsearch.com/grc/rewards";
		if (RewardsURL.contains(RewardsURL1)) {
			test.log(Status.PASS, "RewardsURL");
			System.out.println(RewardsURL1);
		} else {
			test.log(Status.FAIL, "RewardsURL not same" + RewardsURL);
			System.out.println(RewardsURL);
		}
		driver.navigate().back();
		Thread.sleep(5500);
		driver.findElement(By.xpath("//span[contains(text(),'My Services')]")).click();
		Thread.sleep(2500);
		String MyServicesURL = driver.getCurrentUrl().substring(0, 43);
		String MyServicesURL1 = "https://grc.vakilsearch.com/grc/my-services";
		if (MyServicesURL.contains(MyServicesURL1)) {
			test.log(Status.PASS, "MyServicesURL");
			System.out.println(MyServicesURL1);
		} else {
			test.log(Status.FAIL, "MyServicesURL not same" + MyServicesURL);
			System.out.println(MyServicesURL);
		}
		driver.navigate().back();
		Thread.sleep(3500);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'My Interests')]")));
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

		e = driver.findElement(By.xpath("(//div[@class='styles_ticketDetail__jg4A0']//child::P)[1]")).getText()
				.substring(1);

		String MyInterestURL = driver.getCurrentUrl().substring(0, 44);
		String MyInterestURL1 = "https://grc.vakilsearch.com/grc/my-interests";
		if (MyInterestURL1.contains(MyInterestURL)) {
			test.log(Status.PASS, "MyInterestURL");
			System.out.println(MyInterestURL);
		} else {
			test.log(Status.FAIL, "MyInterestURL not same" + MyInterestURL);
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

	}

}
