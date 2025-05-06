package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseComponents{

	public HomePage (WebDriver driver) {
		super(driver);
	}


	//*[@id="top-links"]/ul/li[2]/a/span[1]


	//create locators
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement register;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement login;



	//*[@id="top-links"]/ul/li[2]/ul/li[1]/a

	//action methods

	public void clickMyAccount(){
		myAccount.click();
	}

	public void clickRegister(){
		register.click();
	}

	public void clickLogin() {
		login.click();
	}


}
