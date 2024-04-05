package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import test_components.BaseTest;

public class LoginTests extends BaseTest 
{
	

		///DDT
		
		//username t,password t
		//username t,password f		
		//username f,password t
		//username f,password f
	
		//testcae writing numbers, alphanumric ,special charater or combinations instead  email ID
		
		@Test(priority=1)
		public void LoginValidUsernameAndPassword()
		{
		
			
			loginpage.LoginValidUsernameAndPassword("test@dev.com","test");
			
			
		}
		
		
		@Test(priority=2)
		public void LoginValidUsernameAndInvalidPassword()
		{
		
			loginpage.LoginValidUsernameAndInvalidPassword("test@dev.com","demo");
		
		}
		
		@Test(priority=3)
		public void LoginInvalidUsernameAndvalidPassword()
		{
		
			loginpage.LoginInvalidUsernameAndvalidPassword("testtt@dev.com","test");
		
		}
		
		@Test(priority=4)
		public void LoginInvalidUsernameAndInvalidPassword()
		{
		
			loginpage.LoginInvalidUsernameAndInvalidPassword("testssa@dev.com","demo");
		
		}

		
			
		
				
			
			
			
			
		

	

}
