package org.cst.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
    public static ExtentReports getExtentReportObject(){
        String path = "";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("");
        reporter.config().setDocumentTitle("");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Vamshi Kuchikulla");
        extentReports.createTest(path);
        return extentReports;
    }
}
