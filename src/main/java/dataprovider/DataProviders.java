package dataprovider;

import org.testng.annotations.DataProvider;

import com.aventstack.chaintest.plugins.ChainTestListener;

public class DataProviders 
{
	
	@DataProvider(name="logincredentials")
	public static Object[][] getData()
	{
		//System.out.println("LOG:INFO - DataProvider Getting Ready For Test Data");
		
		ChainTestListener.log("LOG:INFO - DataProvider Getting Ready For Test Data");
		
		Object [][]arr=ExcelUtility.getData("logindetails");
		
		ChainTestListener.log("LOG:INFO - DataProvider Ready With Test Data");
		
		//System.out.println("LOG:INFO - DataProvider Ready With Test Data");
		
		return arr;
	}
	
	

}
