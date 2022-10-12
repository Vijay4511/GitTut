package objectRepository12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegestrationPageObj {
	

	public WebDriver driver;

	//Page factory mechanism
	@FindBy(id="loginName")
	WebElement txtLoginNameObj;

	@FindBy(id="fullName")
	WebElement txtFullNameObj;
	
	@FindBy(id="email")
	WebElement txtEmailObj;
	
	@FindBy(id="genderId")
	WebElement lstGenderObj;
	
	@FindBy(name="SaveBtn")
	WebElement btnSubmitObj;
	
	@FindBy(name="mobileNo")
	WebElement txtMobileNoObj;
	
	//Date objects
	
	@FindBy(id="txtDob")
	WebElement txtDateObj;
	
	@FindBy(className="ui-datepicker-year")
	WebElement lstYearObj;
	
	@FindBy(className="ui-datepicker-month")
	WebElement lstMnthObj;
	
	@FindBy(xpath="//td[@data-handler='selectDay']/a")
	List<WebElement> daysobj;

	public RegestrationPageObj(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement LoginName()
	{
		return txtLoginNameObj;
		
	}
	public WebElement FullName()
	{
		return txtFullNameObj;
		
	}
	
	public WebElement Emailname()
	{
		return txtEmailObj;
		
	}
	
	
	public WebElement Submit()
	{
		return btnSubmitObj;
		
	}
	
	public WebElement MobileNum()
	{
		return txtMobileNoObj;
		
	}

	public void SelectGender(String gend)
	{
		Select gendselct = new Select(lstGenderObj);
		gendselct.selectByVisibleText(gend);
		
	}
		
		
	public void SelectDate(String strdate)
	{
		
		String[] dateArr = strdate.split("-");
		txtDateObj.click();
		
		Select selectYear = new Select(lstYearObj);
		selectYear.selectByVisibleText(dateArr[2]);
		
		Select selectMnth = new Select(lstMnthObj);
		selectMnth.selectByVisibleText(dateArr[1]);
	
			for(WebElement day :daysobj)
			{
				String actday = day.getText();
				
				if(actday.equalsIgnoreCase(dateArr[0]))
				{
					day.click();
					break;
				}
				
			}
		
	}
}
