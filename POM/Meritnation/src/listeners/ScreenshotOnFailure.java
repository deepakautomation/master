package listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import core.OpenAndCloseBrowser;

public class ScreenshotOnFailure extends TestListenerAdapter {
	  
	  private static final String ESCAPE_PROPERTY="org.uncommons.reportng.escape-output";
	  
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  try {
			screenshot(tr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	 
	  @Override
	  public void onTestSkipped(ITestResult tr) {
	   
	  }
	 
	  @Override
	  public void onTestSuccess(ITestResult tr) {
	   
	  }

	  public void screenshot(ITestResult tr) throws IOException{
		  System.setProperty(ESCAPE_PROPERTY, "false");
		  WebDriver driver=OpenAndCloseBrowser.driverInstance();
		  File location=new File("./test-output");
		  Date date=new Date();
		  DateFormat dateFormat=new SimpleDateFormat("dd_MMM_yy_hh_mm_ssaa");
		  String scrName=location.getCanonicalPath()+"\\screenshot\\"+tr.getName()+dateFormat.format(date)+".png";
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File(scrName));
		  Reporter.log("<h4>Repro Steps</h4><br>");
		  Reporter.log(tr.getMethod().getDescription());
		  Reporter.log("<br><a href="+scrName+">Screenshot</a>");
		    
		  
	  }

}
