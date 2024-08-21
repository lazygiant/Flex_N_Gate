package com.flexngate.erp.createthirdpartytest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.NewThirdPartiesPage;
import com.comcast.crm.objectrepositoryutility.ThirdPartiesDetailsPage;
import com.comcast.crm.objectrepositoryutility.ThirdPartiesPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)

public class CreateThirdParty_ProspectTest extends BaseClass 
{

	@Test(groups = {"smokeTest"})
	public void createNewThirdPartyAsProspectTest() throws Throwable {	

		/* read test script data from Excel file */	
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String thirdpartyName = eLib.getDataFromExcel("Third-party", 1, 2)+ jLib.getRandomNumber();
		String prosOrCust = eLib.getDataFromExcel("Third-party", 1, 3);
		
		/* navigate to third-parties module */
		UtilityClassObject.getTest().log(Status.INFO, "navigate to third-parties module");
		HomePage hp = new HomePage(driver);
		hp.getThirdpartiesLnk().click();

		/* click on new third-party link */
		UtilityClassObject.getTest().log(Status.INFO, "click on new third-party link");
		ThirdPartiesPage tp=new ThirdPartiesPage(driver);
		tp.getNewThirdpartyLnk().click();


		/* enter all the details & create third party */
		UtilityClassObject.getTest().log(Status.INFO, "enter all the details & create third party");
		NewThirdPartiesPage ntp=new NewThirdPartiesPage(driver);
		ntp.createThirdParty(thirdpartyName, prosOrCust);


		/*verify ThirdParty name*/
		UtilityClassObject.getTest().log(Status.INFO, thirdpartyName + "===>information is verified");
		ThirdPartiesDetailsPage tpdp=new ThirdPartiesDetailsPage(driver);
		String actThirdpartyName=tpdp.getActThirdpartyName().getText();
		boolean status=actThirdpartyName.contains(thirdpartyName);
		Assert.assertTrue(status);
		System.out.println(thirdpartyName + " information is verified==PASS");

	}

}


