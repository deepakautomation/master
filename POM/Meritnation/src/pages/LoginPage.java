package pages;

import or.HomePageElements;
import or.LoginPageElements;

import org.openqa.selenium.WebDriver;

import core.ActionDriver;

public class LoginPage extends ActionDriver {

	public LoginPage(WebDriver driver) throws Exception {
		super(driver);
		if(!isElementPresent(LoginPageElements.getUsername)){
			throw new Exception("User is not on LoginPage and is on "+getTitle());
		}
	
	}
	
	
	public UserPage signIn(String username,String password) throws Exception{
		type(LoginPageElements.getUsername, username);
		type(LoginPageElements.getPassword, password);
		click(LoginPageElements.getLoginBtn);
		return new UserPage(driver);
	}
	
	public LoginPage getUsername(String username){
		type(LoginPageElements.getUsername, username);
		return this;
	}
	
	public LoginPage getPassword(String password){
		type(LoginPageElements.getPassword, password);
		return this;
	}
	
	
	public UserPage clickLogin() throws Exception{
		click(LoginPageElements.getLoginBtn);
		return new UserPage(driver);
	}
	
	
	
	
	
	
	
}
