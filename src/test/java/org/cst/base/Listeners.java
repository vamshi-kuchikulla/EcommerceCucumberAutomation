package org.cst.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.cst.report.ExtentReportNG;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    ExtentReports extentReports = ExtentReportNG.getExtentReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL,"Test Failed"+result.getThrowable());
        String filePath = "";// write a genric getScreenShotMethod to get the path
        test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed");
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }
}
