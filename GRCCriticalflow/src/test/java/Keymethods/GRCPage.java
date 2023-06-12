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

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
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
		WebDriverWait wait = new WebDriverWait(driver, 100);
		PageFactory.initElements(driver, GRCPageobject.class);

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
//	//	try {
//			Thread.sleep(1500);
//			GRCMailId0.click();
//			GRCMailIdConfirm.click();
//		} catch (NoSuchElementException Grcmail) {
//			GRCOTPConfirm.click();
//			Thread.sleep(1500);
//			GRCMailId0.click();
//			GRCMailIdConfirm.click();
//		}
		Thread.sleep(3500);
		try {
			Closepopup.click();
			}catch(Exception Closepopup) {
				System.out.println("No popup");
			}
		
		Thread.sleep(5500);
		String DashboardURL = driver.getCurrentUrl().substring(0, 41);//41
		System.out.println(DashboardURL);
		String DashboardURL1 = "https://grc.vakilsearch.com/grc/dashboard";
				if (DashboardURL1.contains(DashboardURL)) {
					test.log(Status.PASS, "Dashboard URL");
					System.out.println(DashboardURL);
				} else {
					test.log(Status.FAIL, "Dashboard URL Not Same  "+ DashboardURL);
					System.out.println(DashboardURL1);
				}
				try {
					Thread.sleep(3500);
					Actions act =  new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//img[@alt='closeIcon']"))).click().perform();
					//Closepopup.click();
					}catch(Exception Closepopup) {
						System.out.println("No popup");
					}
				try {
					Closepopup.click();
					}catch(Exception Closepopup) {
						System.out.println("No popup");
					}
		try {
			
			addnewEntity.click();
		} catch (Exception addnewEntity) {

			
			try {
				wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//button[@class='styles_dropdownBtn__I6_4i']/parent::div")));
				Thread.sleep(2500);
				OpenEntityList.click();
				Thread.sleep(2500);
				AddNewBusiness2.click();
			} catch(Exception openentity1) {
				Actions act =  new Actions(driver);
				
				
//			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='styles_dropdown__kgL4A']")));
				driver.findElement(By.xpath("//div[@class='styles_dropdown__kgL4A']")).click();
				Thread.sleep(2500);
//				
//				AddNewBusiness2.click();
//			} catch (ElementClickInterceptedException ex) {
//				
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='closeIcon']")));
//				act.moveToElement(driver.findElement(By.xpath("//img[@alt='closeIcon']"))).click().perform();
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='styles_dropdown__kgL4A']")));
//				driver.findElement(By.xpath("//div[@class='styles_dropdown__kgL4A']")).click();
//				Thread.sleep(2500);
//				
				AddNewBusiness2.click();
//			}
			
			}

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
		Thread.sleep(2500);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue')]")));
			Continue.click();
			Thread.sleep(2500);
		} catch (Exception e102) {
			wait.until(ExpectedConditions.elementToBeClickable(Continue));
			Continue.click();
			Thread.sleep(2500);
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Skip')]")));

		Skip.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Continue')]")));
		LetsGetStartedContinue.click();
		Thread.sleep(2500);
		try {
			Closepopup.click();
			}catch(Exception Closepopup) {
				System.out.println("No popup");
			}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		//wait.until(ExpectedConditions
		//		.elementToBeClickable(By.xpath("//button[@class='styles_dropdownBtn__I6_4i']/child::p")));
		Thread.sleep(2500);
		try {
			
		Closepopup.click();
		}catch(Exception Closepopup) {
			System.out.println("No popup");
		}
		Thread.sleep(2500);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='styles_dropdownBtn__I6_4i']/child::p"))).click();
		Thread.sleep(2500);
		// **just for option
//	OpenEntityList.click();
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("(//div[@class='styles_accountsList__qfPzH']/child::div)[2]"))).click();
	//	EntitySelect2.click();
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
					test.log(Status.FAIL, "ProfileInformationURL Not Same  "+ ProfileInformationURL);
					System.out.println(ProfileInformationURL1);
				}
		
		driver.navigate().back();
		Thread.sleep(2500);
		try {
			
			Closepopup.click();
			}catch(Exception Closepopup) {
				System.out.println("No popup");
			}
//		// actions.moveToElement(BuyNowService).click().perform();
//		js1.executeScript("arguments[0].scrollIntoView(true);", BuyNowService);
//		Thread.sleep(1000);
//		js1.executeScript("arguments[0].scrollIntoView(true);", BuyNowService);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Buy now ')])[1]")));
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		

		js1.executeScript("arguments[0].scrollIntoView(true);", BuyNowService);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//button[contains(text(),'Buy now')])[1]"))).click();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		//BuyNowService.click();
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
					Thread.sleep(2500);
					ContinueGST.click();
				} catch (NoSuchElementException ContinueGST) {
					Thread.sleep(3000);
				}
			}

		}

		String ServiceID = GetServiceID.getText().substring(1);
		System.out.println(ServiceID + "GRC");
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_R);
//		robot.keyRelease(KeyEvent.VK_R);
//		robot.keyRelease(KeyEvent.VK_CONTROL);

//		Thread.sleep(1500);
//		MessagesCTA.click();
//		Thread.sleep(1500);
//		ReplyMessage.click();
//		Thread.sleep(1500);
//		ReplyNote.click();
//		Thread.sleep(1500);
//		messageAttachment.click();
//		Thread.sleep(1500);
//		messageAttachment.sendKeys("C:\\Users\\admin\\eclipse-workspace\\GRCCriticalflow\\Excel\\Customer.xlsx");
//		Sendmessage.click();
		
		try {
			
			Closepopup.click();
			}catch(Exception Closepopup1) {
				System.out.println("No popup");
			}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		//actions.click(Needhelp);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Need help')]")));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[contains(text(),'Need help')]"))).click();
		//Needhelp.click();
		Thread.sleep(1500);
		String NeedHelpURL = driver.getCurrentUrl().substring(0, 36);
		String NeedHelpURL1 = "https://grc.vakilsearch.com/grc/help";
				if (NeedHelpURL1.contains(NeedHelpURL)) {
					test.log(Status.PASS, "NeedHelpURL");
					System.out.println(NeedHelpURL);
				} else {
					test.log(Status.FAIL, "NeedHelpURL Not Same  "+NeedHelpURL);
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
//		driver.get("https://helpdesk.vakilsearch.com/login");
////		Set<String> windowHandles = driver.getWindowHandles();
////		Iterator it = windowHandles.iterator();
////		String parentid = (String) it.next();
////		String childid = (String) it.next();
////		driver.switchTo().window(childid);
//		Thread.sleep(3000);
//		HelpdeskPageobject.Username.click();
//		HelpdeskPageobject.Username.sendKeys(Helpdeskuserid);
//		String text1 = HelpdeskPageobject.Username.getText();
//		String text2 = "testingsa_2_2020@vakilsearch.com";
//		System.out.println(text1);
//		if (text1.contentEquals(text2)) {
//			test.log(Status.PASS, "Yes");
//		} else {
//
//			test.log(Status.FAIL, "no1");
//		}
//
//		HelpdeskPageobject.Password.sendKeys(helpdeskpassword);
//		HelpdeskPageobject.Signin.click();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		HelpdeskPageobject.Helpdesk.click();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		HelpdeskPageobject.Tickets.click();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		HelpdeskPageobject.ticketid.sendKeys(ServiceID);
//
//		HelpdeskPageobject.Search.click();
//		HelpdeskPageobject.Firstservice.click();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		try {
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='editBtn']")));
//			js1.executeScript("arguments[0].scrollIntoView(true);", HelpdeskPageobject.Editticket);
//			HelpdeskPageobject.Editticket.click();
//
//		} catch (ElementClickInterceptedException elementintercptedEdit) {
//			robot.keyPress(KeyEvent.VK_PAGE_UP);
//			Thread.sleep(3000);
//			robot.keyRelease(KeyEvent.VK_PAGE_UP);
//			robot.keyPress(KeyEvent.VK_PAGE_UP);
//			robot.keyRelease(KeyEvent.VK_PAGE_UP);
//			driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
//		}
//
//		Thread.sleep(2500);
//		HelpdeskPageobject.Assignedto.click();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		Thread.sleep(1500);
//		HelpdeskPageobject.Assignedtoname.click();
//		HelpdeskPageobject.Assignedtoname.sendKeys(assignedtoName);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(1500);
//
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		HelpdeskPageobject.BDagentCTA.click();
//		Thread.sleep(1500);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		HelpdeskPageobject.Paymentstatus.click();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		
//		HelpdeskPageobject.Updateticket.click();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		Thread.sleep(1500);
//		driver.switchTo().alert().accept();
//		Thread.sleep(1500);
		// *** //driver.switchTo().window(parentid);

//		HelpdeskPageobject.EntityInfo.click();
//		Thread.sleep(3500);
//		HelpdeskPageobject.ChangeEntity.click();
//		Thread.sleep(2500);
//		HelpdeskPageobject.selectBusiness.click();Thread.sleep(1500);
//		HelpdeskPageobject.FirstEntity.click();Thread.sleep(1500);
//		HelpdeskPageobject.SaveEntity.click();Thread.sleep(1500);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_R);
//		robot.keyRelease(KeyEvent.VK_R);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		HelpdeskPageobject.EntityInfo.click();Thread.sleep(1500);
//		HelpdeskPageobject.VerifyTheEntity.click();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		HelpdeskPageobject.SaveEntity2.click();
//		driver.switchTo().alert().accept();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}

}
