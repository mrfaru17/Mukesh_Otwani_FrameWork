package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import dataprovider.ConfigUtility;

public class RetryAnalyzer implements IRetryAnalyzer
{
    int retryCount = 0;
    int maxRetry = Integer.parseInt(ConfigUtility.readProperty("retry"));   

    @Override
    public boolean retry(ITestResult result) 
    {
        if(retryCount < maxRetry)
        {
            retryCount++;
            return true;
        }
        return false;
    }
}