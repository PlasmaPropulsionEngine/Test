package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import reusable_Utility.Utility;

public class SettingPage extends Utility {
	
	WebDriver driver;
	
	SoftAssert soft=new SoftAssert();	
	
	public SettingPage(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(xpath="//a[@href='/user/settings']")
	WebElement ClickOnSettingTab;
	
	@FindBy(xpath = "//h1")
	WebElement Heading;
	
	
	@FindBy(name = "old-password")
	WebElement oldpassword;
	
	@FindBy(name = "new-password")
	WebElement newpassword;
	
	@FindBy(css = "button.btn-outline-dark")
	WebElement ChangeBtn;
	
	@FindBy(css="div.alert-success span")
	WebElement successMsg;
	
	@FindBy(xpath ="//div/a[@href='/logout']")
	WebElement LogoutBtn;
	
	
	public void ClickonSettings()
	{
		
		ClickOnSettingTab.click();
	}
	
	
	
	
	public String getSettinPageTiltle()
	{
		String text = Heading.getText();
		return text;
	}
	
	
	public void ChangePassowrd(String oldpass,String newpass )
	{
		oldpassword.sendKeys(oldpass);
		
		newpassword.sendKeys(newpass);
		
	}
	
	public void ClickonChangeBtn()
	{
		ChangeBtn.click();
		
	}
	
	public String getSuccessMsg()
	{
		String text = successMsg.getText();
		return text;
	}
	
	public void Logout()
	{
		LogoutBtn.click();
	}
	
	
}
