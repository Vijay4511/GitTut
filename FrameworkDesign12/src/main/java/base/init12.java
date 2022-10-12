package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class init12 {
	
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver BrowserInitialisation() throws IOException
	{

		prop = new Properties();
		String proppath = System.getProperty("user.dir")+"\\resources\\config12.properties";
		FileInputStream fis = new FileInputStream(proppath);
		prop.load(fis);
		//Getting browser details from maven command
		String browsername ="";
		browsername = System.getProperty("browser");
		if(browsername==null)
		{
			browsername = prop.getProperty("browser");
		}

		if(browsername.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();	
			driver = new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else 
		{
			WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	
		
	public String GetScreenshot(WebDriver driver, String Tcname) throws IOException
	{
				
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		String screenshotpath = System.getProperty("user.dir")+"\\reports\\"+Tcname+".png";
		
		FileUtils.copyFile(src, new File(screenshotpath));
		
		return screenshotpath;
	}

}
