package test_components;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class BaseTest {

public WebDriver driver;
	
public LoginPage loginpage;
public RegistrationPage registrationPage;
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop=new Properties();
	
	
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resourses\\globaldata.properties");
		
		prop.load(fis);
		// browser parameter from mvn command
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		//prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications");
		     driver=new ChromeDriver(option);
	
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{			
			WebDriverManager.edgedriver().setup();
			EdgeOptions option=new EdgeOptions();
			option.addArguments("--disable-notifications");
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		
		loginpage=new LoginPage(driver);
	
		loginpage.GoToLoginPage();
		
		return loginpage;
				
	}
	

	@AfterMethod(alwaysRun=true)
	public void closebrowser()
	{
		
		driver.close();
		
	}
		
	
	////code for screen shot for failed test cases in extent report 
	
	public String GetScreenShot(String testcaseName,WebDriver driver) throws IOException
	{
		
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;	
		File source=takescreenshot.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+ testcaseName+".png");
		FileUtils.copyFile(source,file);
		
		return System.getProperty("user.dir")+"//reports//"+ testcaseName+".png";
		
		
	}
	
	
	public List<HashMap<String,String>> getJsonDataToMap(String filepath) throws IOException 
	{		
		
		System.out.println(filepath);
		//read json to string
		
		String jsoncontent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		
		// To convert String to HashMap we need Jackson Databind
		
		ObjectMapper mapper=new ObjectMapper(); 
		
		
		List<HashMap<String,String>>data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;  //return list of hashmap
		
	}	
	
	
	
	
	
	
	
}
