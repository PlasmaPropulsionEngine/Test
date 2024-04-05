package pageObjects;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import reusable_Utility.Utility;

public class AddContactPage extends Utility 
{

	WebDriver driver;
	
	SoftAssert soft=new SoftAssert();
	
	public AddContactPage(WebDriver driver) 
	{	
		super(driver);
		this.driver=driver;		
		PageFactory.initElements(driver,this);		
	}

	
	@FindBy(xpath="//a[@href='/user/addcontact']")
	WebElement ClickonAddContactTab;
	
	@FindBy(xpath = "//h1[normalize-space()='Add contact']")
	WebElement Wait;
	
	@FindBy(xpath ="//h1[normalize-space()='Add contact']")
	WebElement HeaderText;
	
	@FindBy(id="firstname")
	WebElement firstname;
	
	@FindBy(id="nickname")
	WebElement nickname;
	
	@FindBy(id="phone")
	WebElement 	phone;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(css = "input#work")
	WebElement work;
	
	@FindBy(css="textarea#description")
	WebElement discription;
	
	@FindBy(css="input[type='file']")
	WebElement upload;
	
	@FindBy(css = "button.btn-outline-primary")
	WebElement SaveContactBtn;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement successMsg;
	
	@FindBy(css = "button.btn-outline-primary")
	WebElement WaitToDisplaySaveBtn;
	//upload.sendKeys("C:\\Users\\ASHOK\\Desktop\\New folder (5)\\tom-and-jerry-12357.png");

	public AddContactPage viewContactPage;
	
	//click on add contact
	public String ClickonAddContactTab()
	{
		ClickonAddContactTab.click();
		WaitUntilAddContactFormDisplay(Wait);
		String text = HeaderText.getText();
		return text;
	}
	
	
	public String FilladdContactForm(String Firstname,String Nickname,String Phone,String Email,String Work,
			String Discription)
	{
		
		firstname.sendKeys(Firstname);
		nickname.sendKeys(Nickname);
		phone.sendKeys(Phone);
		
		email.sendKeys(Email);
		
		work.sendKeys(Work);
		discription.sendKeys(Discription);
		ScrollUptoSaveBtn();
		
		//upload.sendKeys(Upload);
		
		WaitForSaveBtn(WaitToDisplaySaveBtn);
	
		Actions a=new Actions(driver);
		a.moveToElement(SaveContactBtn).click().build().perform();
		//SaveContactBtn.click();
		
		WaitForSuccessMsgDispaly(successMsg);
		String Successtext = successMsg.getText();
		
		return Successtext;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
