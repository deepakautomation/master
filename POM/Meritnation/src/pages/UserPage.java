package pages;

import or.HomePageElements;
import or.UserPageElements;

import org.openqa.selenium.WebDriver;

import core.ActionDriver;

public class UserPage extends ActionDriver{

	
	public UserPage(WebDriver driver) throws Exception {
		super(driver);
		if(!isElementPresent(HomePageElements.loginLink)){
			throw new Exception("User is not on Userpage and is on "+getTitle());
		}
	
	}
	
	public boolean verifyUser(String text){
		return textIsEqualTo(UserPageElements.verifyUser, text);
	}
}
