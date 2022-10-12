package objectRepository12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepageobj {
	
	WebDriver driver;
	
	By eticketlgn = By.linkText("eTicket Login");
	
	By otplogin = By.linkText("ATB/OPR Login");

	public Homepageobj(WebDriver driver) {
		
		this.driver = driver;
		
	}

	public WebElement EticketLogin()
	{
		return driver.findElement(eticketlgn);
	}

	public WebElement OtpLogin()
	{
		return driver.findElement(otplogin);
	}
	
	
}
