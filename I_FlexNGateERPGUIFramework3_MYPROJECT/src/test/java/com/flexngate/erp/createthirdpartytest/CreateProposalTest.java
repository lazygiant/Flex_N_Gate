package com.flexngate.erp.createthirdpartytest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CustomerDetailsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ListOfCustomersPage;
import com.comcast.crm.objectrepositoryutility.NewCommercialProposalPage;
import com.comcast.crm.objectrepositoryutility.NewThirdPartiesPage;
import com.comcast.crm.objectrepositoryutility.ProposalCardPage;
import com.comcast.crm.objectrepositoryutility.ThirdPartiesDetailsPage;
import com.comcast.crm.objectrepositoryutility.ThirdPartiesPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateProposalTest extends BaseClass 
{

	@Test(groups = {""})
	public void createProposalWithSourceTest() throws Throwable {	

		// Ok
		/* read test script data from Excel file */	
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String thirdpartyName = eLib.getDataFromExcel("Third-party", 9, 3)+ jLib.getRandomNumber();
		String prosOrCust = eLib.getDataFromExcel("Third-party", 9, 4);
		String source = eLib.getDataFromExcel("Third-party", 9, 2);
         

		/* navigate to third-parties module */
		UtilityClassObject.getTest().log(Status.INFO, "navigate to third-parties module");
		HomePage hp = new HomePage(driver);
		Thread.sleep(2500);
		hp.getThirdpartiesLnk().click();
		
		/* click on new third-party link */
		UtilityClassObject.getTest().log(Status.INFO, "click on new third-party link");
		ThirdPartiesPage tp=new ThirdPartiesPage(driver);
		Thread.sleep(2500);
		tp.getNewThirdpartyLnk().click();


		/* enter all the details & create third party */
		UtilityClassObject.getTest().log(Status.INFO, "enter all the details & create third party");
		NewThirdPartiesPage ntp=new NewThirdPartiesPage(driver);
		Thread.sleep(2500);
		ntp.createThirdParty2(thirdpartyName, prosOrCust);
		Thread.sleep(2500);
		
		
		/* navigate to Customer link & click on create proposal button */
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Customer link & click on create proposal button");
		ThirdPartiesDetailsPage tpdp=new ThirdPartiesDetailsPage(driver);
		tpdp.getCustomerLnk().click();
		CustomerDetailsPage cdp=new CustomerDetailsPage(driver);
		cdp.getCreateProposalBtn().click();

		/* select valid Source from the dropdown List & Click on CreateDraft button */
		UtilityClassObject.getTest().log(Status.INFO, "select valid Source from the dropdown List & Click on CreateDraft button");
		NewCommercialProposalPage ncpp=new NewCommercialProposalPage(driver);
		ncpp.createDraft(source);
		

		/* verify source */
		UtilityClassObject.getTest().log(Status.INFO, source + "===>is verified");
		ProposalCardPage pcp=new ProposalCardPage(driver);
		String actSource=pcp.getActSource().getText();
		boolean status=actSource.contains(source);
		Assert.assertTrue(status);
		System.out.println(source + " is verified==PASS");


	}
}

//