package dataprovider;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemoXls {

	
	@DataProvider
	public Object[][] getNames() throws BiffException, IOException{
	File location=new File("C:\\Users\\dsood1\\Desktop\\Names.xls");
	Workbook wb=Workbook.getWorkbook(location);
	Sheet sh=wb.getSheet("Sheet1");
	Cell cell[]=sh.getColumn(0);
	Object[][] obj=new Object[cell.length][1];
	for(int i=0;i<cell.length;i++){
		obj[i][0]=cell[i].getContents();
	}
	return obj;
		
	}
	
	@Test(dataProvider="getNames")
	public void getNames(String username){
		System.out.println("Printing names "+username);
	}
}
