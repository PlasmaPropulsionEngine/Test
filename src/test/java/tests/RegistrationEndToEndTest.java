package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.RegistrationPage;
import reusable_Utility.Utility;
import test_components.BaseTest;

public class RegistrationEndToEndTest extends BaseTest {


@Test	
public void RegistrationTest()
{
	
	RegistrationPage registrationPage = loginpage.GotoRegistration();
	//new user added
	registrationPage.EnterFields("lambda","whitewolf@gmail.com","cucumber","devlops");
	
	registrationPage.ClickOnSubmitBtn();
	
	String Msg = registrationPage.GetMsg();
	
	assertEquals(Msg,"successfully registered");
	System.out.println(Msg);
}
	
	


}
