package Keymethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageFactory.HomescreenPageobject;

public class Payment extends HomescreenPageobject {
	ExtentTest test;

	public Payment(WebDriver driver, ExtentTest test) throws InterruptedException {
		Actions actions = new Actions(driver);
		HomescreenPageobject.Firstsericepaynow.click();

		if (HomescreenPageobject.PaymentModes.isDisplayed()) {
			test.log(Status.PASS, "Payment Cart page is Working");
		} else {

			test.log(Status.FAIL, "Payment URL Notworking");
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
		Thread.sleep(4000);
	}

}