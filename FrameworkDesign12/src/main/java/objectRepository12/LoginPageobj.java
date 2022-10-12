package objectRepository12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageobj {
	

	public WebDriver driver;
	

	@FindBy(id="userName")
	WebElement txtUsrnameObj;

	@FindBy(id="password")
	WebElement txtPwdObj;
	
	@FindBy(id="submitBtn")
	WebElement btnloginObj;
	
	@FindBy(linkText="SignUp")
	WebElement lnkSignupObj;
	
	@FindBy(linkText="Forgot Password")
	WebElement lnkFgtpwdObj;
	
	@FindBy(id="errorMsg")
	WebElement errorMsgObj;
	
	
	public LoginPageobj(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//performing actions
	public void Login(String usrname,String pwd)
	{
		txtUsrnameObj.sendKeys(usrname);
		txtPwdObj.sendKeys(pwd);
		btnloginObj.click();
		
	}
	
	public WebElement Forgetpwd()
	{
		return lnkFgtpwdObj;
		
	}
	public WebElement Signup()
	{
		return lnkSignupObj;
		
	}
	
	public WebElement ErrorMsg()
	{
		return errorMsgObj;
		
	}

}
