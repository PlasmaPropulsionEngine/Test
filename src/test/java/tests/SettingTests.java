package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddContactPage;
import pageObjects.SettingPage;
import test_components.BaseTest;

public class SettingTests  extends BaseTest{
	
	
	
	
@Test	
public void ChangePasswordTest()
{
	
	List<Object> listOfPageObjects = loginpage.Login();	
	
	SettingPage settingPage =(SettingPage) listOfPageObjects.get(2);
	
	settingPage.ClickonSettings();
		
	String settinPageTiltle = settingPage.getSettinPageTiltle();
	
	
	Assert.assertEquals(settinPageTiltle,"Change your Password");
	
	
	settingPage.ChangePassowrd("test","test");
	
	
	settingPage.ClickonChangeBtn();
	
	String successMsg = settingPage.getSuccessMsg();
	
	Assert.assertEquals(successMsg,"Password changed successfully..");
	
	settingPage.Logout();
	
}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
