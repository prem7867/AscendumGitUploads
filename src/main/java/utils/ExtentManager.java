package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.core.layout.CsvParameterLayout;

public class ExtentManager {
    private static ExtentReports report;
        public static ExtentReports getInstanceOf() {
            if (report == null) {
                ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
                report = new ExtentReports();
                spark.config().setTheme(Theme.DARK);
                spark.config().setDocumentTitle("Gaming Cashless Automation Report");
                spark.config().setEncoding("utf-8");
                spark.config().setReportName("Android Report");
                report.attachReporter(spark);
            }
            return report;
        }

}
