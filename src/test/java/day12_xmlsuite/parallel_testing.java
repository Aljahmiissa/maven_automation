package day12_xmlsuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.UUID;

public class parallel_testing {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    @Parameters("Browser")
    @BeforeMethod
    public void openbrowser (String Browser){
        reports = new ExtentReports("C:\\Users\\Issa\\Documents\\extent report\\results.html" + UUID.randomUUID());
        if (Browser.equalsIgnoreCase("firefox")){
            //define the path for geckodriver
            System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            //maximize firefox
            driver.manage().window().maximize();
        }else if(Browser.equalsIgnoreCase("chrome")){
            //defining the path for chrome driver
            System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
            //define the chrome option
            ChromeOptions options = new ChromeOptions();
            options.addArguments("incognito","start-maximized");
            driver = new ChromeDriver(options);
        }
    }

    @Test
    public void testScenario () throws InterruptedException, IOException {
        logger = reports.startTest("Bing search");
        logger.log(LogStatus.INFO,"navigating to bing.com");
        driver.navigate().to("https:www.bing.com");
        Thread.sleep(2000);
        //clicking on image tab
        reusables.reusableMethods_report.click(driver,"//*[@id='scpl']", logger, "clicking on image");




        reports.endTest(logger);


    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
