package Listener;

import Base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class MyListener implements ITestListener
{
    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    public Map<String,ExtentTest> deviceNodes = new HashMap<>();
    public Map<String,ExtentTest> classNodes = new HashMap<>();

    public void onStart(ITestContext context)
    {
        if(extentReports==null)
        {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
            String reportTime = localDateTime.format(dateTimeFormatter);

            extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Extent Reports/Reports/Report("+reportTime+").html");
            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setDocumentTitle("Page Object Model");
            extentSparkReporter.config().setReportName("Report with Devices --> Classes --> Methods");

            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);

            extentReports.setSystemInfo("Device Name",context.getCurrentXmlTest().getParameter("deviceName"));
            extentReports.setSystemInfo("App Package",context.getCurrentXmlTest().getParameter("appPackage"));
            extentReports.setSystemInfo("App Activity",context.getCurrentXmlTest().getParameter("appActivity"));
        }

        String deviceName = context.getCurrentXmlTest().getParameter("deviceName");
        if(!deviceNodes.containsKey(deviceName))
        {
            deviceNodes.put(deviceName,extentReports.createTest(deviceName));
        }
    }

    public void onTestStart(ITestResult result)
    {
        String deviceName = result.getTestContext().getCurrentXmlTest().getParameter("deviceName");
        String className = result.getTestClass().getRealClass().getSimpleName();
        if(!classNodes.containsKey(className))
        {
            ExtentTest deviceNode = deviceNodes.get(deviceName);
            classNodes.put(className,deviceNode.createNode(className));
        }
    }

    public void onTestSuccess(ITestResult result)
    {
        String className = result.getTestClass().getRealClass().getSimpleName();
        ExtentTest classNode = classNodes.get(className);
        ExtentTest methodNode = classNode.createNode(result.getMethod().getDescription());
        methodNode.log(Status.PASS,result.getMethod().getMethodName()+" --> Passed");
    }

    public void onTestFailure(ITestResult result)
    {
        String className = result.getTestClass().getRealClass().getSimpleName();
        ExtentTest classNode = classNodes.get(className);
        ExtentTest methodNode = classNode.createNode(result.getMethod().getDescription());
        methodNode.log(Status.FAIL,result.getMethod().getMethodName()+" --> Failed");
        methodNode.log(Status.FAIL,"Cause --> "+result.getThrowable());

        BaseClass baseClass = new BaseClass();
        try
        {
            baseClass.getScreenshot(result.getMethod().getMethodName());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result)
    {
        String className = result.getTestClass().getRealClass().getSimpleName();
        ExtentTest classNode = classNodes.get(className);
        ExtentTest methodNode = classNode.createNode(result.getMethod().getDescription());
        methodNode.log(Status.SKIP,result.getMethod().getMethodName()+" --> Skipped");
    }

    public void onFinish(ITestContext context)
    {
         extentReports.flush();
    }
}
