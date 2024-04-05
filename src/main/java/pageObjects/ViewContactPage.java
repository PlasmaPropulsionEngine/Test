package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import reusable_Utility.Utility;

public class ViewContactPage extends Utility{

	
	WebDriver driver;
	
	SoftAssert soft=new SoftAssert();
	
	public ViewContactPage(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}

	
	@FindBy(xpath="//a[@href='/user/show-contacts/0']")
	WebElement ClickonViewContactTab;
	
	
	
	@FindBy(xpath = "//h1")
	WebElement HeaderText;	
	
	
	@FindBy(xpath = "//tbody/tr[1]/td[7]/form/button")
	WebElement ClickOnUpdateBtn;
	
	
	@FindBy(xpath = "//h1[normalize-space()='Update contact']")
	WebElement WaitForToDisplayUpdateForm;
	
	
	@FindBy(xpath = "//h1[normalize-space()='Update contact']")
	WebElement UpdateFormHeading;
	
	
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
	
	@FindBy(css="div.alert-success span")
	WebElement SuccessMsg;	
	
	
	@FindBy(xpath = "//tbody/tr[1]/td[7]/a")
	WebElement DeleteBtn;
	
	
	@FindBy(css = "button.swal-button--danger")
	WebElement ConfirmBtn;
	
	@FindBy(css="div.alert-success span")
	WebElement DeleteMsg;
	
	public String ClickOnViewContactTab()
	{
		ClickonViewContactTab.click();
		String text = HeaderText.getText();
		return text;
	}
	
	
	public void ClickOnUpdateBtn()
	{
		ClickOnUpdateBtn.click();
	WaitTodisplayUpdateform(WaitForToDisplayUpdateForm);
		
	}
	
	public String getUpdateFormHeading()
	{
		String text = UpdateFormHeading.getText();
		return text;
	}
	
	
	public void ClearFileds()
	{
				
		String arr[]= {"firstname","nickname","phone","email","work","description"};

		for(int i=0;i<arr.length;i++)
		{
			driver.findElement(By.id(arr[i])).clear();

		}
	}
	
	
	public void EnterFields(String Firstname,String Nickname,String Phone ,String Email,String
			Work ,String Discription)
	{
		
		firstname.sendKeys(Firstname);
		nickname.sendKeys(Nickname);
		phone.sendKeys(Phone);
		email.sendKeys(Email);
		work.sendKeys(Work);
		discription.sendKeys(Discription);

		
	}
	
	public void ScrollUptoSaveBtn()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
	}

	
	public void FileUpload(String Upload)
	{
		upload.sendKeys(Upload);
	}
	

	
	public void ClickOnSaveBtn()
	{
		Actions a=new Actions(driver);
		a.moveToElement(SaveContactBtn).click().build().perform();
				
	}
	
	public String GetSuccessMsg()
	{
		String text = SuccessMsg.getText();
		return text;
	}
	
	
	
	public void ClickOnDeleteBtn()
	{
		DeleteBtn.click();
	}
	
	public void ClickOnConfirmBtn()
	{
		
		ConfirmBtn.click();
	}
	
	public String GetDeleteMsg()
	{
		String text = DeleteMsg.getText();
		return text;
	}
	
	
}
