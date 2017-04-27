package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class OpenAndCloseBrowser {
	
	protected static ThreadLocal<WebDriver> driver;
	static DesiredCapabilities caps;
	
	@BeforeSuite
	public void init(){
		driver= new ThreadLocal<WebDriver>();
	}
	
	@Parameters({"browser","grid"})
	@BeforeClass
	public void openBrowser(String browser,String grid) throws MalformedURLException{
		if(grid.equalsIgnoreCase("yes")){
			if(browser.equalsIgnoreCase("ff")||browser.equalsIgnoreCase("firefox")){
				caps=DesiredCapabilities.firefox();
				driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
			}else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				caps=DesiredCapabilities.chrome();
				driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
			}else{
				caps=DesiredCapabilities.firefox();
				driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
			}
			
		}
		else{
		if(browser.equalsIgnoreCase("ff")||browser.equalsIgnoreCase("firefox")){
			driver.set(new FirefoxDriver());
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver.set(new ChromeDriver());
		}else{
			driver.set(new FirefoxDriver());
		}
		}
		driverInstance().manage().window().maximize();
		driverInstance().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void closeBrowser(){
		driverInstance().quit();
	}

	public static WebDriver driverInstance() {
		// TODO Auto-generated method stub
		return driver.get();
	}
  
}
