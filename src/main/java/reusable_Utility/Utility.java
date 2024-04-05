package reusable_Utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.AddContactPage;
import pageObjects.RegistrationPage;
import pageObjects.SettingPage;
import pageObjects.ViewContactPage;

public class Utility  {

	WebDriver driver;
	public Utility(WebDriver driver)
	{
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}

	
	
	
	@FindBy(name="username")
	WebElement username;
	

	@FindBy(name="password")
	WebElement password;
	
	

	@FindBy(name="submit")
	WebElement submit;
	
	
	
	//Go to registration
	public RegistrationPage GotoRegistration()
	{
		driver.get("http://localhost:9090/signup");
		RegistrationPage registrationPage=new RegistrationPage(driver);
		return registrationPage;
	}
	
	
	
	//login utility
	public List<Object> Login()
	{	
		username.sendKeys("test@dev.com");
		password.sendKeys("test");
		submit.click();	
		AddContactPage addContactPage=new AddContactPage(driver);
		ViewContactPage viewContactPage=new ViewContactPage(driver);
		SettingPage settingPage=new SettingPage(driver);
		List<Object>list=new ArrayList<Object>();
		list.add(viewContactPage);
		list.add(addContactPage);
		list.add(settingPage);
		return  list;
	}
	
	
	//wait for Add contact form page display	
	public void WaitUntilAddContactFormDisplay(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	
	
		
	//Wait to display Save Btn
	public void WaitForSaveBtn(WebElement waitToDisplaySaveBtn)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8)); 
		wait.until(ExpectedConditions.visibilityOfAllElements(waitToDisplaySaveBtn));

	}
	
	
	public void ScrollUptoSaveBtn()
	{		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
	}
	
	
	public void WaitForSuccessMsgDispaly(WebElement w)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8)); 
		wait.until(ExpectedConditions.visibilityOfAllElements(w));
				
	}
	
	
	//WaitTodisplay Update form
	public void WaitTodisplayUpdateform(WebElement w)
	{

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(w));
		

		
	}
	

	//wait for Registration Btn 
	public void WaitForSubmitBtn(WebElement w)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.visibilityOfAllElements(w));
	}
	
	
	
	
	
	
	
}
