package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmDashboard {
	WebDriver driver;
	
	@FindBy(id="welcome")
	WebElement dashboardUserName;
	
	@FindBy(id="aboutDisplayLink")
	WebElement aboutDisplayLink;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/ul/li[1]/div/form/div/div/ul/li[3]/p")
	WebElement aboutWindowActiveEmployees;
	
	public OrangeHrmDashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Get username from dashboard page
	public String getDashboardUserName() {
		return dashboardUserName.getText();
	}
	
	//click username to get dropdown list
	public void clickUserName() {
		dashboardUserName.click();
	}
	
	//select about from username dropdown list
	public void selectAbout() {
		aboutDisplayLink.click();
	}
	
	//get active employees number from about window
	public String getAboutWindowActiveEmployeesNumber() {
		return aboutWindowActiveEmployees.getText();
	}
}
