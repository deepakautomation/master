package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDriver {

	protected WebDriver driver;
	WebDriverWait wait;
	long shortTime=30;
	long longTime=60;
	
	public ActionDriver(WebDriver driver){
		this.driver=driver;
	}
	
	
	public void waitForElement(By loc){
		wait=new WebDriverWait(driver, longTime);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
			}
	
	public void click(By loc){
		waitForElement(loc);
		WebElement element=driver.findElement(loc);
		element.click();
	}
	
	public void type(By loc, String text){
		waitForElement(loc);
		WebElement element=driver.findElement(loc);
		element.clear();
		element.sendKeys(text);
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	
	public boolean textIsEqualTo(By loc, String text){
		waitForElement(loc);
		WebElement element=driver.findElement(loc);
		return element.getText().equalsIgnoreCase(text);
	}
	
	
	
	public void navigateTo(String url){
		driver.get(url);
	}
	
	
	public void switchToFrame(By loc){
		waitForElement(loc);
	driver.switchTo().frame(driver.findElement(loc));
	}
	
	public void switchToParentFrame(){
		driver.switchTo().parentFrame();
	}
	
	
	public boolean isElementPresent(By loc){
		waitForElement(loc);
		WebElement element=driver.findElement(loc);
		return element.isEnabled();
	}
	
	
	
	
	
	
}




//mouse house
//windowshanding
//dropdown -3
// frames-3
