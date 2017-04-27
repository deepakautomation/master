package dataprovider;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataProviderForLogin {
	
	/*@DataProvider
	public static Object[][] getDataFromXml(ITestContext context){
		String username=context.getCurrentXmlTest().getParameter("username");
		String password=context.getCurrentXmlTest().getParameter("password");
		return new Object[][]{{username,password}};
		
	}*/
	
	
	
	@DataProvider
	public static Object[][] getDataFromXls() throws BiffException, IOException{
		File location=new File("./resources/Names.xls");
		Workbook wb=Workbook.getWorkbook(location);
		Sheet sh=wb.getSheet("Sheet1");
		String username=sh.getCell(0, 0).getContents();
		String password=sh.getCell(1, 0).getContents();
		return new Object[][]{{username,password}};	
		
	}
	

}
