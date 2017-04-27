package test;

import or.HomePageElements;
import or.LoginPageElements;
import or.UserPageElements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserPage;
import core.ActionDriver;
import core.OpenAndCloseBrowser;

public class LoginPageTest extends OpenAndCloseBrowser{
	
	
	@BeforeMethod
	public void openURL(){
		ActionDriver browser=new ActionDriver(driverInstance());
		browser.navigateTo("http://www.meritnation.com/");
	
	}
	
	public static final String loginSteps="1. Click on LoginLink<br> 2. Fill in Credentials<br> 3. Verify user";	
	
	@Test(description=loginSteps,dataProviderClass=dataprovider.DataProviderForLogin.class,dataProvider="getDataFromXls")
	public void verifyUser(String username,String password) throws Exception{
		/*ActionDriver loginPage=new ActionDriver(driver);
		loginPage.navigateTo("http://www.meritnation.com/");
		try{
		loginPage.switchToFrame(HomePageElements.frame);
		loginPage.click(HomePageElements.close);
		loginPage.switchToParentFrame();
		}catch(Exception e){
			System.out.println("No frame present");
		}
		loginPage.click(HomePageElements.loginLink);
		loginPage.type(LoginPageElements.getUsername, "sunaina@test.com");
		loginPage.type(LoginPageElements.getPassword, "12345678");
		loginPage.click(LoginPageElements.getLoginBtn);
		assert loginPage.textIsEqualTo(UserPageElements.verifyUser, "What's new with you?"):"Expected: failed";*/
		
		
		HomePage homepage1=new HomePage(driverInstance());
		HomePage homePage=homepage1.handleFrame();
		LoginPage loginPage=homePage.clickLoginLink();
		UserPage userpage=loginPage.signIn(username, password);
		assert userpage.verifyUser("What's new    with you?"):"Expected: fail";
		
		
		/*HomePage homepage1=new HomePage(driver);
		HomePage homePage=homepage1.handleFrame();
		LoginPage loginPage=homePage.clickLoginLink();
		UserPage userpage=loginPage.getUsername("sunaina@test.com").getPassword("12345678").clickLogin();
		assert userpage.verifyUser("What's new   with you?"):"Expected: fail";*/
		
	}

}
