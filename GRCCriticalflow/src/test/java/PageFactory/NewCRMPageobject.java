package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCRMPageobject  {
	
	
	@FindBy (xpath = "//input[@placeholder='Enter email']")
	public static WebElement CrmUsername ;
	
	@FindBy (xpath = "//input[@placeholder='Password']")
	public static WebElement CrmPassword ;
	
	@FindBy (xpath = "//button[contains(text(),'Log In')]")
	public static WebElement CrmLoginCTA ;
	
	@FindBy (xpath = "//parent::a//span[contains(text(),'All')]")
	public static WebElement CrmAllBucket ;
	
	@FindBy (xpath = "//input[@placeholder='Search for tickets ID or subject']")
	public static WebElement CrmSearchforticketsIDorsubject ;
	 
	@FindBy (xpath = "(//ul[@class='ticket-list']/child::li)[1]")
	public static WebElement CrmFirstTicketSelect ;
	
	@FindBy (xpath = "(//div[@class='markup']/child::p)[1]")
	public static WebElement CrmInternalNote ;
	
}
 