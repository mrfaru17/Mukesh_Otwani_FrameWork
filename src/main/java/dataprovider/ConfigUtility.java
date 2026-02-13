package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility 
{
	
	public static String readProperty(String keyName)
	{
		Properties pro=new Properties();
		
		try 
		{
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Configuration/config.properties")));
		} catch (IOException e) 
		{
			System.out.println("Could not read the file "+e.getMessage());
		}
		
		String value=pro.getProperty(keyName);
		
		return value;
		
	}
	
}
