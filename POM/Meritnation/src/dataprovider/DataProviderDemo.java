package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	
	@DataProvider
	public Object[][] getNames(){
		String a="Rakesh";
		String b="Ram";
		String a1="Kumar";
		String b1="Sharma";
		return new Object[][]{{a,a1},{b,b1}};
	}
	
	@Test(dataProvider="getNames")
	public void getNames(String username,String password){
		System.out.println("Printing names "+username+" "+password);
	}
	
	/*@DataProvider
	public Object[][] getNames(){
		Object[][] obj=new Object[2][1];
		obj[0][0]="Rakesh";
		obj[1][0]="Ram";
		return obj;
	}
	
	@Test(dataProvider="getNames")
	public void getNames(String username){
		System.out.println("Printing names "+username);
	}*/
	

}
