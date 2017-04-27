package test;

import org.testng.annotations.Test;

import core.ActionDriver;
import core.OpenAndCloseBrowser;

public class GoogleLaunch extends OpenAndCloseBrowser {
	
	@Test
	public void Googlelaunch(){
		ActionDriver loginPage=new ActionDriver(driverInstance());
		loginPage.navigateTo("http://google.com/");
		System.out.println(loginPage.getTitle());
	}
	

}
