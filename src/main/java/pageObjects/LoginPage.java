package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import reusable_Utility.Utility;

public class LoginPage extends Utility
{
	
	
	WebDriver driver;
	
	SoftAssert soft=new SoftAssert();	
	
	public LoginPage(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	@FindBy(name="username")
	WebElement username;
	

	@FindBy(name="password")
	WebElement password;
	
	

	@FindBy(name="submit")
	WebElement submit;
	
	
	@FindBy(xpath = "//h1")
	WebElement DashboardText;
	
	@FindBy(xpath ="//div/ul/li[3]/a")
	WebElement LogOutBtn;
	//Go to login page
	
	public void GoToLoginPage()
	{
		driver.get("http://localhost:9090/signin");
		
	}
	
	
	//valid username and password
	public void LoginValidUsernameAndPassword(String Username,String Password)
	{
	
		username.sendKeys(Username);		
		password.sendKeys(Password);
		submit.click();
	
		String actualtxt = DashboardText.getText();	

		soft.assertEquals(actualtxt,"Start adding your contacts");
		
		LogOutBtn.click();
		
		System.out.println("done");	
	
	}
	
	//valid username and Invalid password
	public void LoginValidUsernameAndInvalidPassword(String Username,String Password)
	{
	
		username.sendKeys(Username);		
		password.sendKeys(Password);
	
		submit.click();
	
		
		System.out.println("done");	
	
	}
	
	//Invalid usermname and valid password
	public void LoginInvalidUsernameAndvalidPassword(String Username,String Password)
	{
	
		username.sendKeys(Username);		
		password.sendKeys(Password);
	
		submit.click();
	
		
	System.out.println("done");	
	
	}
	
	//Invalid username and password
	public void LoginInvalidUsernameAndInvalidPassword(String Username,String Password)
	{
	
		username.sendKeys(Username);		
		password.sendKeys(Password);
		submit.click();
	
		System.out.println("done");	
	
	}

	
	
	
	
	
	
}
