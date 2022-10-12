package executiontest12;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.init12;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository12.Homepageobj;
import objectRepository12.LoginPageobj;

public class LoginModule12Test extends init12 {

	WebDriver driver;
	String url;
	@BeforeClass
	public void Initialisation() throws IOException
	{
		driver = BrowserInitialisation();
		url = prop.getProperty("url");
		driver.get(url);
	}
	
	@Test(groups={"smoke"})
	public void NegativeLoginTc() throws IOException
	{	

				Homepageobj hp = new Homepageobj(driver);
				hp.EticketLogin().click();
				
				LoginPageobj lp = new LoginPageobj(driver);
				lp.Login("VijayKUmar", "Password11");
				//Taking screenshot
				//GetScreenshot(driver, "NegativeLoginTc");				
				String expErrormsg = "Login incorrect. Please try again";
				String actualerrormsg = lp.ErrorMsg().getText();
				Assert.assertEquals(actualerrormsg, expErrormsg);
				
				

	}
	
	@Test
	public void ForgetPwdTc() throws IOException
	{
		
		Homepageobj hp = new Homepageobj(driver);
		hp.EticketLogin().click();
		//Taking screenshot
		//GetScreenshot(driver, "ForgetPwdTc");
		LoginPageobj lp = new LoginPageobj(driver);
		lp.Forgetpwd().click();
		driver.findElement(By.id("userName")).sendKeys("xdljkf@mail.com");
		driver.findElement(By.id("submitBtn")).click();
		
	}
	
	@AfterClass
	public void CloseObjects()
	{
		//driver.close();
	}
	
}
