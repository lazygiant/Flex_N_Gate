package com.flexngate.erp.createthirdpartytest;

import org.openqa.selenium.By;

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
public class CreateProspectTest extends BaseClass 
{

	@Test(groups = {""})
	public void createNewProspectTest() throws Throwable {	

		/* read test script data from Excel file */	
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String thirdpartyName = eLib.getDataFromExcel("Third-party", 4, 2)+ jLib.getRandomNumber();
		String aliasName = eLib.getDataFromExcel("Third-party", 4, 3);
		String prosOrCust = eLib.getDataFromExcel("Third-party", 4, 4);
		String thirdPartyAddress = eLib.getDataFromExcel("Third-party", 4, 5);
		String zipCode = eLib.getDataFromExcel("Third-party", 4, 6);
		String cityName = eLib.getDataFromExcel("Third-party", 4, 7);
		String stateOrProvince = eLib.getDataFromExcel("Third-party", 4, 8);
		String phoneNum = eLib.getDataFromExcel("Third-party", 4, 9);
		String faxNum = eLib.getDataFromExcel("Third-party", 4, 10);
		String emailAdd = eLib.getDataFromExcel("Third-party", 4, 11);
		String webAdd = eLib.getDataFromExcel("Third-party", 4, 12);
		String profId1 = eLib.getDataFromExcel("Third-party", 4, 13);
		String profId2 = eLib.getDataFromExcel("Third-party", 4, 14);
		String profId3 = eLib.getDataFromExcel("Third-party", 4, 15);
		String profId4 = eLib.getDataFromExcel("Third-party", 4, 16);
		String profId5 = eLib.getDataFromExcel("Third-party", 4, 17);
		String vatID = eLib.getDataFromExcel("Third-party", 4, 18);
		String thirdPartyType = eLib.getDataFromExcel("Third-party", 4, 19);
		String workforce = eLib.getDataFromExcel("Third-party", 4, 20);
		String capital = eLib.getDataFromExcel("Third-party", 4, 21);
		String parentCompny = eLib.getDataFromExcel("Third-party", 4, 22);
		String AsignedSalesRep = eLib.getDataFromExcel("Third-party", 4, 23);


		/* navigate to third-parties module */
		UtilityClassObject.getTest().log(Status.INFO, "navigate to third-parties module");
		HomePage hp = new HomePage(driver);
		hp.getThirdpartiesLnk().click();

		/* click on new third-party link */
		UtilityClassObject.getTest().log(Status.INFO, "click on new third-party link");
		ThirdPartiesPage tp=new ThirdPartiesPage(driver);
		tp.getNewProspectLnk().click();


		/* enter all the details & create third party */
		UtilityClassObject.getTest().log(Status.INFO, "enter all the details & create third party");
		NewThirdPartiesPage ntp=new NewThirdPartiesPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "enter thirdpartyName");
		ntp.createTPWithThirdpartyName(thirdpartyName);
		UtilityClassObject.getTest().log(Status.INFO, "enter aliasName");
		ntp.createTPWithAliasName(aliasName);
		UtilityClassObject.getTest().log(Status.INFO, "enter prosOrCust");
		ntp.createTPWithProsOrCustDD(prosOrCust);
		UtilityClassObject.getTest().log(Status.INFO, "enter thirdPartyAddress");
		ntp.createTPWithAddress(thirdPartyAddress);
		UtilityClassObject.getTest().log(Status.INFO, "enter zipCode");
		ntp.createTPWithZipCode(zipCode);
		UtilityClassObject.getTest().log(Status.INFO, "enter cityName");
		ntp.createTPWithCity(cityName);
		UtilityClassObject.getTest().log(Status.INFO, "enter stateOrProvince");
		ntp.createTPWithStateOrProvDD(stateOrProvince);
		UtilityClassObject.getTest().log(Status.INFO, "enter phoneNum");
		ntp.createTPWithPhoneNum(phoneNum);
		UtilityClassObject.getTest().log(Status.INFO, "enter faxNum");
		ntp.createTPWithFaxNum(faxNum);
		UtilityClassObject.getTest().log(Status.INFO, "enter emailAdd");
		ntp.createTPWithEmail(emailAdd);
		UtilityClassObject.getTest().log(Status.INFO, "enter webAdd");
		ntp.createTPWithWeb(webAdd);
		UtilityClassObject.getTest().log(Status.INFO, "enter profId1");
		ntp.createTPWithProId1(profId1);
		UtilityClassObject.getTest().log(Status.INFO, "enter profId2");
		ntp.createTPWithProId2(profId2);
		UtilityClassObject.getTest().log(Status.INFO, "enter profId3");
		ntp.createTPWithProId3(profId3);
		UtilityClassObject.getTest().log(Status.INFO, "enter profId4");
		ntp.createTPWithProId4(profId4);
		UtilityClassObject.getTest().log(Status.INFO, "enter profId5");
		ntp.createTPWithProId5(profId5);
		UtilityClassObject.getTest().log(Status.INFO, "enter vatID");
		ntp.createTPWithVatId(vatID);
		UtilityClassObject.getTest().log(Status.INFO, "enter thirdPartyType");
		ntp.createTPWithThirdPartyTypeDD(thirdPartyType);
		UtilityClassObject.getTest().log(Status.INFO, "enter workforce");
		ntp.createTPWithWorkforceDD(workforce);
		UtilityClassObject.getTest().log(Status.INFO, "enter capital");
		ntp.createTPWithCapital(capital);
		UtilityClassObject.getTest().log(Status.INFO, "enter parentCompny");
		ntp.createTPWithParentCompnyDD(parentCompny);
		UtilityClassObject.getTest().log(Status.INFO, "enter AsignedSalesRep");
		ntp.createTPWithAssignedSalesRepDD(AsignedSalesRep);
		UtilityClassObject.getTest().log(Status.INFO, "attach the file");
		ntp.createTPWithchooseFile();
		UtilityClassObject.getTest().log(Status.INFO, "click on ThirdpartyBtn");
		ntp.createTPWithThirdpartyBtn();


		/*verify ThirdParty name*/
		UtilityClassObject.getTest().log(Status.INFO, thirdpartyName + "===>information is verified");
		ThirdPartiesDetailsPage tpdp=new ThirdPartiesDetailsPage(driver);
		String actThirdpartyName=tpdp.getActThirdpartyName().getText();
		boolean status=actThirdpartyName.contains(thirdpartyName);
		Assert.assertTrue(status);
		System.out.println(thirdpartyName + " information is verified==PASS");

	}
}


