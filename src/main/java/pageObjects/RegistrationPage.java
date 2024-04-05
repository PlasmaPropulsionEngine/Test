package pageObjects;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import reusable_Utility.Utility;

public class RegistrationPage extends Utility {

	
	WebDriver driver;
	
	SoftAssert soft=new SoftAssert();
	
	public RegistrationPage(WebDriver driver) 
	{	
		super(driver);
		this.driver=driver;		
		PageFactory.initElements(driver,this);		
	}
	

	
	@FindBy(id="name_field")
	WebElement Name;
	
	@FindBy(id="email_field")
	WebElement Email;

	@FindBy(id="password_field")
	WebElement Password;
	

	@FindBy(name="about")
	WebElement About;
	

	@FindBy(id="agreement")
	WebElement Tick;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement SubmitBtn;

	@FindBy(xpath="//button[normalize-space()='Submit']")
	WebElement Wait;
	
	@FindBy(css="div.alert-success")
	WebElement RegistrationSuccessMsg;
	
	
	
	public void EnterFields(String name,String email,String password,String about )
	{
		Name.sendKeys(name);
		Email.sendKeys(email);
		Password.sendKeys(password);
		About.sendKeys(about);
		Tick.click();
	}
	
	
	
	public void ClickOnSubmitBtn()
	{	
		ScrollUptoSaveBtn();
		WaitForSubmitBtn(Wait);
		SubmitBtn.click();
	}
	
	public String GetMsg()
	{
		String text = RegistrationSuccessMsg.getText();
		return text;
	}
	

	
	
	
}
