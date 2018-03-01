package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.OrangeHrmDashboard;
import pages.OrangeHrmLogin;

public class TestOrangeHrmAbout {
	WebDriver driver;
	OrangeHrmLogin objLogin;
	OrangeHrmDashboard objDashboard;
	
	@BeforeTest
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://opensource.demo.orangehrmlive.com/");
	}
	
	/**
     * This test case will login in http://opensource.demo.orangehrmlive.com/
     * Click "Welcome user" link, chose about from list and check employees number info
     */
	@Test(priority=0)
	public void test_Employee_Number_Info_Correctedess() {
		//create login page object
		objLogin = new OrangeHrmLogin(driver);
		//verify page title
		String loginPagerTitle = objLogin.getTitle();
		Assert.assertTrue(loginPagerTitle.contains("LOGIN Panel"));
		//login to application
		objLogin.loginToOrangeHrmPage("Admin", "admin");
		//go to dashboard page
		objDashboard = new OrangeHrmDashboard(driver);
		//click "Welcome" link
		objDashboard.clickUserName();
		//click "About" link
		objDashboard.selectAbout();
		//verify employee number from about info
		String employeesInfo = objDashboard.getAboutWindowActiveEmployeesNumber();
		Assert.assertTrue(employeesInfo.contains("Active Employees: 9"));
	}

		@AfterTest
		public void tearDown() {
			driver.quit();
		}
}
