package Keymethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import PageFactory.GRCPageobject;

public class NewCRM extends GRCPageobject {

	public void newCRM(WebDriver driver, String e, String CrmUsernames, String CrmUserpassword) throws InterruptedException, AWTException {
Robot robot = new Robot();
Thread.sleep(3000);
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
		driver.switchTo().alert().accept();
		Thread.sleep(2500);
		CrmAllBucket.click();
		Thread.sleep(2500);
		CrmSearchforticketsIDorsubject.click();
		Thread.sleep(2500);
		CrmFirstTicketSelect.click();
		String InternalNotes = CrmInternalNote.getText();
		System.out.println(InternalNotes);
		

	}

}
