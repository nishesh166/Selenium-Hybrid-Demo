package codenbox.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import codenbox.testBase.Base;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginTest extends Base{

	@Test (groups = {"Regression"})
	public void verify_login() {
		logger.info("***Starting Registration Test***");
		//homepage
		HomePage hm = new HomePage(driver);

		//login page
		logger.info("Clicked on My Account Link");
		hm.clickMyAccount();

		logger.info("Clicked on Login page");
		hm.clickLogin();

		logger.info("Enter the details to login");
		LoginPage lp=new LoginPage(driver);
//		lp.setEmail("test9820456@codenbox.com");
		logger.info("Enter email to login");
		lp.setEmail(prop.getProperty("myEmail"));
		logger.info("Enter password to login");
		lp.setPassword(prop.getProperty("myPassword"));
		logger.info("Clicked login button");
		logger.info("Clicked on Login");
		lp.clickLoginBtn();

//		myaccount page
		logger.info("Account Page Verification");
		MyAccountPage myact=new MyAccountPage(driver);
		SoftAssert sa =new SoftAssert();
		myact.isMyAccountExist();
		sa.assertTrue(myact.isMyAccountExist());//true
		//System.out.println("LoginTest Failed");//will execute as object created for soft assert
		logger.info("Login Test failed");
		sa.assertAll();
		logger.info("***Completed Login Test***");
	}
}
