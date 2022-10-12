package executiontest12;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.init12;
import objectRepository12.Homepageobj;
import objectRepository12.LoginPageobj;
import objectRepository12.RegestrationPageObj;

public class RegistrationModule12Test extends init12 {

	ArrayList<String> tcdata = new ArrayList();
	WebDriver driver;	
	@BeforeClass
	public void BrowserInitialisaiton() throws IOException
	{
		driver = BrowserInitialisation();
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	@Test
	public void FullnameValid() throws IOException
	{	
	
		
		tcdata = CommonMethods12.GetExcelData("FullnameValid");

		Homepageobj hp = new Homepageobj(driver);
		hp.EticketLogin().click();
		LoginPageobj lp = new LoginPageobj(driver);
		lp.Signup().click();
		RegestrationPageObj rp = new RegestrationPageObj(driver);
		rp.LoginName().sendKeys(tcdata.get(1));
		rp.FullName().sendKeys(tcdata.get(2));
		rp.Emailname().sendKeys(tcdata.get(4));
		rp.SelectGender("FEMALE");
		rp.SelectDate("02-Nov-2001");
		rp.MobileNum().sendKeys(tcdata.get(3));
		rp.Submit().click();
		
	}
	
	@Test
	public void LoginNameValid() throws IOException
	{
		tcdata = CommonMethods12.GetExcelData("LoginNameValid");

		Homepageobj hp = new Homepageobj(driver);
		hp.EticketLogin().click();
		LoginPageobj lp = new LoginPageobj(driver);
		lp.Signup().click();
		RegestrationPageObj rp = new RegestrationPageObj(driver);
		rp.LoginName().sendKeys(tcdata.get(1));
		rp.FullName().sendKeys(tcdata.get(2));
		rp.Emailname().sendKeys(tcdata.get(4));
		rp.SelectGender("FEMALE");
		rp.SelectDate("27-Jun-2014");
		
		rp.MobileNum().sendKeys(tcdata.get(3));
		rp.Submit().click();
		
	}
	
	@Test
	public void FieldValidation() throws IOException
	{
		tcdata = CommonMethods12.GetExcelData("FieldValidation");
		
		Homepageobj hp = new Homepageobj(driver);
		hp.EticketLogin().click();
		LoginPageobj lp = new LoginPageobj(driver);
		lp.Signup().click();
		RegestrationPageObj rp = new RegestrationPageObj(driver);
		rp.LoginName().sendKeys(tcdata.get(1));
		rp.FullName().sendKeys(tcdata.get(2));
		rp.Emailname().sendKeys(tcdata.get(4));
		rp.SelectGender("FEMALE");
		
		rp.MobileNum().sendKeys(tcdata.get(3));
		rp.Submit().click();
		
	}
/*	@AfterClass	
	public void CloseObjects()
	{
		driver.close();
	}*/
	
}
