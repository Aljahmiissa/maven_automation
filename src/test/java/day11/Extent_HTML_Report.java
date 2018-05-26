package day11;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Extent_HTML_Report {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    @BeforeSuite
    public void opendriver(){
        driver = reusables.reusableMethods.chromeDriver();
        //define the path of the Extent report
       reports = new ExtentReports("C:\\Users\\Issa\\Documents\\extent report\\results.html", true);



    }
    @AfterSuite
    public void closedriver(){
        //driver.quit();
        //to close the test and report
        reports.flush();
        reports.close();
    }
    @Test
    public void test() throws InterruptedException, IOException {
        //log test name using logger
        logger = reports.startTest("Google Search");
        //navigate to google.com
        logger.log(LogStatus.INFO, "navigating to Google.com");
        driver.navigate().to("https://www.google.com");
        //wait few seconds for the page to load
        logger.log(LogStatus.INFO,"waiting on google page to load");
        Thread.sleep(2000);
        //assert that title page is google
        logger.log(LogStatus.INFO,"Google", driver.getTitle());
        //to use assertions with Extent report we should first store the getTitle as a variable
        String correcttitle = driver.getTitle();
        if (correcttitle.equalsIgnoreCase("gooooooogle")){
            logger.log(LogStatus.PASS, "Title of page is Google");
        }else{
            logger.log(LogStatus.FAIL,"Title of page is not Google " + correcttitle);
            // store the path of the image you want to capture as a variable
            String ImagePath = "C:\\Users\\Issa\\Documents\\extent report\\image.png";
            //line below allows you to take screenshot(don't need to memorize the command)
            File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//Now you can do whatever you need to do with, for example copy somewhere
            FileUtils.copyFile(sourceFile, new File(ImagePath));
            String image = logger.addScreenCapture(ImagePath);
            logger.log(LogStatus.FAIL, "Verify Google Title", image);
           /* //line below allows you to take Screenshot(dont need to memorize the command)
            File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //now you can do whatever you need to do with, for example copy somewhere
            FileUtils.copyFile(sourcefile, new File (imagepath));
            String image = logger.addScreenCapture(imagepath);
            logger.log(LogStatus.FAIL,"", image);*/



        }
        //end the test
        reports.endTest(logger);

    }

}
