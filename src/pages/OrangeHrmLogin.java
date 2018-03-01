package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class OrangeHrmLogin {
	WebDriver driver;
	
	@FindBy(id="txtUsername")
	WebElement usernameField;
	
	@FindBy(id="txtPassword")
	WebElement passwordField;
	
	@FindBy(id="btnLogin")
	WebElement login;
	
	@FindBy(id="logInPanelHeading")
	WebElement titleText;
	
	public OrangeHrmLogin(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
	}
	//set username in textbox
	public void setUserName(String strUserName) {
		usernameField.sendKeys(strUserName);
	}
	//set password in textbox
	public void setPassword(String strPassword) {
		passwordField.sendKeys(strPassword);
	}
	//click on login button
	public void clickLogin() {
		login.click();
	}
	//get title of login page
	public String getTitle() {
		String loginTitle = titleText.getText();
		return loginTitle;
	}
	/**
	 * This POM method will be used to login to OrangeHrmPage
	 */
	public void loginToOrangeHrmPage(String strUserName, String strPassword) {
		//Fill username
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPassword);
		//Click login button
		this.clickLogin();
	}
}
