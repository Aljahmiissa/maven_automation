package day_13;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.UUID;

public class AbstractClass {
    // declaring variable for webdriver
    public static WebDriver driver;
    //declaring variable for soft asseert
    public static SoftAssert softAssert;
    //declaring variable for extent repoorts
    public static ExtentReports reports;
    // declaring variable for extent logger
    public static  ExtentTest logger;

    @Parameters("Browser")
    @BeforeSuite
    public static void defineBrowser(String Browser){
        if (Browser.equalsIgnoreCase("firefox")){
            reports = new ExtentReports("C:\\Users\\Issa\\Documents\\extent report\\Firefox ExtentReport" + UUID.randomUUID()+".html", true);
            //define the path for geckodriver
            System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            //maximize firefox
            driver.manage().window().maximize();
        }else if(Browser.equalsIgnoreCase("chrome")){
            reports = new ExtentReports("C:\\Users\\Issa\\Documents\\extent report\\Chrome ExtentReport" + UUID.randomUUID()+".html", true);
            //defining the path for chrome driver
            System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
            //define the chrome option
            ChromeOptions options = new ChromeOptions();
            options.addArguments("incognito","start-maximized");
            driver = new ChromeDriver(options);
        }
    }

    //before method is only defined to capture your test method name to imported on your html report
    @BeforeMethod
    public static void methodName(Method method) {
        logger = reports.startTest(method.getName());

    }
    //@aftermethod to end the test that you are running on your xml suite
    @AfterMethod
    public static void endTest(){
        reports.endTest(logger);

    }
    //close and flush the report and either quit the driver or open your html report automatically
    @AfterSuite
    public static void endsuite(){
        //flush the report
        reports.flush();
        //close the report
        reports.close();
        //quit the driver
        driver.quit();
    }
}
