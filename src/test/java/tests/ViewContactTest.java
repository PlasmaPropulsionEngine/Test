package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ViewContactPage;
import test_components.BaseTest;

public class ViewContactTest extends BaseTest{

SoftAssert soft=new SoftAssert();	

@Test(priority=1)
public void UpdateContactTest()
{
	List<Object> listOfPageObjects = loginpage.Login();	
	
	 ViewContactPage contactPage =(ViewContactPage) listOfPageObjects.get(0);	
	
	String Heading =  contactPage.ClickOnViewContactTab();
	
	soft.assertEquals(Heading,"your contacts");
	
	 contactPage.ClickOnUpdateBtn();
	
	String updateFormHeading =  contactPage.getUpdateFormHeading();
	
	soft.assertEquals(updateFormHeading,"Update contact");
	
	 contactPage.ClearFileds();

	 contactPage.EnterFields("python", "testingpython", "15789602234", "pythontest@yahoo.com", "pythontests", "testesr");
	
	 contactPage.ScrollUptoSaveBtn();
	
	 //contactPage.FileUpload();

	
	 contactPage.ClickOnSaveBtn();
	String getSuccessMsg =  contactPage.GetSuccessMsg();

	soft.assertEquals(getSuccessMsg,"contact is updated..");
		
	System.out.println(getSuccessMsg);
}


@Test(priority=2)
public void DeleteContactTest()
{
	
	List<Object> listOfPageObjects = loginpage.Login();	
	
	 ViewContactPage contactPage =(ViewContactPage) listOfPageObjects.get(0);
	

		String Heading =  contactPage.ClickOnViewContactTab();
		
		soft.assertEquals(Heading,"your contacts");
	
		contactPage.ClickOnDeleteBtn();
		
		contactPage.ClickOnConfirmBtn();
		
	
		String getDeleteMsg = contactPage.GetDeleteMsg();

		
		soft.assertEquals(getDeleteMsg,"contact deleted successfully..");
	
	System.out.println(getDeleteMsg);
}




	
	
	
	
	
}
