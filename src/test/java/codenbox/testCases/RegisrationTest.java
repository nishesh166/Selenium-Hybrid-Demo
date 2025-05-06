package codenbox.testCases;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import codenbox.testBase.Base;
import codenbox.utilities.Retry;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class RegisrationTest extends Base{


	@Test (groups = {"Sanity","Regression"},retryAnalyzer=Retry.class)
	public void verify_registration() {

		logger.info("***Starting Registration Test***");
		HomePage hm = new HomePage(driver);

		logger.info("Clicked on My Account Link");
		hm.clickMyAccount();

		logger.info("Clicked on Register Link");
		hm.clickRegister();

		RegistrationPage rg = new RegistrationPage(driver);

		logger.info("Entered registration details");
		//rg.setFirstName("Justin");
		rg.setFirstName(getRandomString().toUpperCase());
		//rg.setlastName("Bieber");
		rg.setlastName(getRandomString().toUpperCase());
		//rg.setEmail("test9820456@codenbox.com");
		rg.setEmail(getRandomString() + "@codenbox.com");
		//rg.setTelephone("123456789");
		rg.setTelephone(getRandomNumber());
		String enterPassword = getRandomAlphaNumeric();
		//rg.setPassword("abc34569");
		rg.setPassword(enterPassword);
		//rg.setConfirmPassword("abc34569");
		rg.setConfirmPassword(enterPassword);

		logger.info("Clicked on privacy policy");
		rg.clickPolicy();

		logger.info("Clicked on Continue button");
		rg.clickContinue();

		logger.info("Validating expected VS actual message");
		String actualMsg = rg.getConfirmationMsg();// confirmation message
		if (actualMsg.equalsIgnoreCase("Your Account Has Been Created!")) {
			AssertJUnit.assertTrue(true); // pass
		} else {
			System.out.println("Didn't match. test fail");
			AssertJUnit.fail();
		}
		logger.info("***Completed Registration Test***");

	}





}
