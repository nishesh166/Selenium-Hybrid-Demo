package codenbox.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import codenbox.testBase.Base;
import codenbox.utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginDataDrivenTest extends Base{
	@Test (dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"Regression"})
	public void verify_loginDDT(String userName, String password, String expResult) {
		logger.info("***Starting Registration Test***");
		//homepage
		HomePage hm = new HomePage(driver);
		System.out.println("launch the site successfully");

		//login page
		logger.info("Clicked on My Account Link");
		hm.clickMyAccount();

		logger.info("Clicked on Login page");
		hm.clickLogin();

		logger.info("Enter the details to login");
		LoginPage lp=new LoginPage(driver);
//		lp.setEmail("test9820456@codenbox.com");
		logger.info("Enter email to login");
		lp.setEmail(userName);
		logger.info("Enter password to login");
		lp.setPassword(password);
		logger.info("Clicked login button");
		logger.info("Clicked on Login");
		lp.clickLoginBtn();

		logger.info("Account Page Verification");
		MyAccountPage myact=new MyAccountPage(driver);
		boolean targetPage = myact.isMyAccountExist(); //true or false

		logger.info("***validation is invalid result***");
		if(expResult.equalsIgnoreCase("invalid")) {
			if (targetPage) {
				myact.clickLogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}

		logger.info("***validation is valid result***");
		if(expResult.equalsIgnoreCase("valid")) {
			if (targetPage) {
				myact.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		logger.info("***Test for DDT is completed***");



	}

}
