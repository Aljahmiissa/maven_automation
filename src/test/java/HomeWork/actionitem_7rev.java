package HomeWork;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import reusables.reusableMethods;

import java.io.File;
import java.io.IOException;

public class actionitem_7rev {
    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;

    @BeforeSuite
    public void openDriver(){
        driver = reusableMethods.chromeDriver();
        report = new ExtentReports("C:\\Users\\Issa\\Documents\\extent report\\results.html",true);
    }

    @AfterSuite
    public void closeDriver(){
        //driver.quit();

        //line below will flush the report by adding all you log information to the log
        report.flush();

        //line below will close & end your report
        report.close();

    }

    @Test
    public void testScenario() throws InterruptedException, IOException {
        //log test name using logger
        logger= report.startTest("Action Item 7, UPS");

        //navigate to google.com
        logger.log(LogStatus.INFO,"navigating to UPS.com");
        driver.navigate().to("https://www.ups.com/us");

        //Wait few seconds
        logger.log(LogStatus.INFO,"Waiting for page to load");
        Thread.sleep(2500);

        //Assert that title page is ups
        logger.log(LogStatus.INFO,"Verify the title of the page is 'Shipping | UPS'");
        //Assert.assertEquals("Google",driver.getTitle());
        //to use assetions with Extend report
        String expectedTitle,actualTitle;
        expectedTitle="Shipping | UPS";
        actualTitle=driver.getTitle();


        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            logger.log(LogStatus.PASS,"Title of page is ups");
        } else{
            logger.log(LogStatus.FAIL,"Title of page is not \""+expectedTitle+ "\"it is: "+actualTitle);
            //define the path of the image
            String imagePath="C:\\Users\\Issa\\Documents\\extent report\\UPSTitle.png";

            //line below allows you to take the screenshot (don't need to memorize the command)
            File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //Now you can do whatever you need to do with this, for example copy somewhere
            FileUtils.copyFile(sourceFile, new File(imagePath));

            String image = logger.addScreenCapture(imagePath);

            logger.log(LogStatus.FAIL,"Verify UPS title",image);
        }

        Thread.sleep(2500);
        //Click on Quote form quickstart dropdown
        reusableMethods.click(driver,"//*[@id='ups-quickStartQuote']");
        Thread.sleep(2000);
        WebElement packages = driver.findElement(By.xpath("//*[@name='shipmentType']"));
        Select dropDown = new Select (packages);
        dropDown.selectByVisibleText("Letter");
        WebElement location = driver.findElement(By.xpath("//*[@name='origCountry']"));
        dropDown = new Select (location);
        dropDown.selectByVisibleText("United States");
        WebElement arrival = driver.findElement(By.xpath("//*[@name='destCountry']"));
        dropDown = new Select (arrival);
        dropDown.selectByVisibleText("United States");
        driver.findElement(By.xpath("//*[@name='weight']")).sendKeys("1");
        driver.findElement(By.xpath("//*[@name='origPostalCode']")).sendKeys("11209");
        driver.findElement(By.xpath("//*[@name='destPostalCode']")).sendKeys("10006");
        Boolean elementState = driver.findElement(By.xpath("//*[@class='ups-checkbox-custom-label']")).isSelected();
        if(elementState == true){
            logger.log(LogStatus.FAIL,"Checkbox is selected "+ elementState);
            //define the path of the image
            String imagePath="C:\\Users\\Issa\\Documents\\extent report\\UPS_checkbox.png";

            //line below allows you to take the screenshot (don't need to memorize the command)
            File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //Now you can do whatever you need to do with this, for example copy somewhere
            FileUtils.copyFile(sourceFile, new File(imagePath));

            String image = logger.addScreenCapture(imagePath);

            logger.log(LogStatus.FAIL,"ups_checkbox",image);
        }else{
            logger.log(LogStatus.PASS,"Checkbox is not Selected");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@name='--qs']")).click();




        //end to the test
        report.endTest(logger);


    }
    @Test(dependsOnMethods = "testScenario")
    public void testScenario2() throws IOException, InterruptedException {
        logger.log(LogStatus.INFO,"Verify the title of the page is 'Calculate Time and Cost'");
        //Assert.assertEquals("Google",driver.getTitle());
        //to use assetions with Extend report
        String expectedTitle,actualTitle;
        expectedTitle="Calculate Time and Cost";
        actualTitle=driver.getTitle();


        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            logger.log(LogStatus.PASS,"Title of page is  Calculate Time and Cost");
        } else{
            logger.log(LogStatus.FAIL,"Title of page is not  "+actualTitle);
            //define the path of the image
            String imagePath="C:\\Users\\Issa\\Documents\\extent report\\UPSTtle_calc.png";

            //line below allows you to take the screenshot (don't need to memorize the command)
            File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //Now you can do whatever you need to do with this, for example copy somewhere
            FileUtils.copyFile(sourceFile, new File(imagePath));

            String image = logger.addScreenCapture(imagePath);

            logger.log(LogStatus.FAIL,"Calculate Time and Cost",image);
        }
        Thread.sleep(2000);
        driver.findElements(By.xpath("//*[@id='ratesShipNow']")).get(0).click();

        logger.log(LogStatus.INFO,"Verify the title of the page is 'Shipping: UPS'");
        //Assert.assertEquals("Google",driver.getTitle());
        //to use assetions with Extend report

        expectedTitle="Shipping: UPS";
        actualTitle=driver.getTitle();


        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            logger.log(LogStatus.PASS,"Title of page is  'Shipping: UPS'");
        } else{
            logger.log(LogStatus.FAIL,"Title of page is not"  + actualTitle);
            //define the path of the image
            String imagePath="C:\\Users\\Issa\\Documents\\extent report\\UPSTtle_shipping.png";

            //line below allows you to take the screenshot (don't need to memorize the command)
            File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //Now you can do whatever you need to do with this, for example copy somewhere
            FileUtils.copyFile(sourceFile, new File(imagePath));

            String image = logger.addScreenCapture(imagePath);

            logger.log(LogStatus.FAIL,"Shipping: UPS",image);
        }


    }
}

