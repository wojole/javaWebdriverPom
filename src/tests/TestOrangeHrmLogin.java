package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.OrangeHrmDashboard;
import pages.OrangeHrmLogin;

public class TestOrangeHrmLogin {
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
     * Verify login page title as a "LOGIN Panel"
     * Login to application
     * Verify the home page using Dashboard message
     */
	@Test(priority=0)
	public void test_Dashboard_Page_Appear_Correct() {
		//create login page object
		objLogin = new OrangeHrmLogin(driver);
		//verify page title
		String loginPagerTitle = objLogin.getTitle();
		Assert.assertTrue(loginPagerTitle.contains("LOGIN Panel"));
		//login to application
		objLogin.loginToOrangeHrmPage("Admin", "admin");
		//go to dashboard page
		objDashboard = new OrangeHrmDashboard(driver);
		//verify username name from dasboard contains "Welcome Admin"
		String dashboardMessage = objDashboard.getDashboardUserName();
		Assert.assertTrue(dashboardMessage.contains("Welcome Admin"));
	}

		@AfterTest
		public void tearDown() {
			driver.quit();
		}
}
