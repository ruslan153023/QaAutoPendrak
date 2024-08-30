package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int countOfRetry = 0;
    private int maxOfRetry = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (countOfRetry < maxOfRetry){
            countOfRetry++;
            return true;
        }
        return false;
    }
}
