package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddContactPage;
import pageObjects.ViewContactPage;
import test_components.BaseTest;

public class AddContactsTests extends BaseTest
{	
	SoftAssert soft=new SoftAssert();


	@Test(dataProvider="getdata")
	public void AddContact(HashMap<String,String>input)
	{	
		List<Object> listOfPageObjects = loginpage.Login();	
		
		AddContactPage addContactPage =(AddContactPage) listOfPageObjects.get(1);	
		
		String HeaderText = addContactPage.ClickonAddContactTab();
		
		soft.assertEquals(HeaderText,"Add contact");
		
		String SuccessMsg = addContactPage.FilladdContactForm(input.get("firstname"),input.get("nickname"),input.get("phone"),input.get("email"),input.get("work"),input.get("description"));
		soft.assertEquals(SuccessMsg,"Contact added successfully");
	
	}

		
	@AfterTest	
	public void softassert()
	{
		soft.assertAll();
	}
	
	
	
	
@DataProvider	
public Object[][] getdata() throws IOException
{
	
	List<HashMap<String,String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\jsonTestData\\testData.json");
	
	return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}};
	
}
	

	
	
	
	
	
}
