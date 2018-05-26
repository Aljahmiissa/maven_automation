package reusables;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class reusableMethods_report {

        // static variable which can be used on your method classes. for example, explicit timeout
        public static int timeout = 30;

        // method below allows you to create a reusable method to click on an element and you are passing two arguments
        // one is webdriver that you are using and second one is the locator you are locating the element with
        public static void click(WebDriver driver, String locator, ExtentTest logger, String elementName) throws IOException {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO,"Clicking on an element" + elementName);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();

            } catch (Exception e) {
                logger.log(LogStatus.FAIL,"Unable to click on an element" + e);
                getScreenshot(driver, logger);

            }

        }
        /// 'locator', 'user value' 'sendkeys' on below line are all user defined

        public static void sendkeys(WebDriver driver, String locator, String userValue, ExtentTest logger, String elementname) throws IOException {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO,"enter a value " +userValue+ " on element" + elementname);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).sendKeys(userValue);


            } catch (Exception e) {
                System.out.println("Unable to enter user value on an element " + e);
                logger.log(LogStatus.FAIL, "unable to enter info on element " + elementname);
                getScreenshot(driver, logger);
            }

        }

        public static void mouseaction(WebDriver driver, String locator, ExtentTest logger, String elementname) throws IOException {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO,"Hovering using mouse movement on element " + elementname);
                Actions mouseAction = new Actions(driver);
                WebElement uservalue = driver.findElement(By.xpath(locator));
                mouseAction.moveToElement(uservalue).build().perform();


            } catch (Exception e) {
                System.out.println("Unable to  enter user value on an element " );
                logger.log(LogStatus.FAIL,"Unable to hover over element " + elementname );
                getScreenshot(driver, logger);


            }

        }


        // chromdriver method needs to be a return class to be used on your execution class
        public static WebDriver chromeDriver() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Issa\\IdeaProjects\\MavenAutomation\\src\\main\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            WebDriver driver = new ChromeDriver(options);
            //we are returning the driver variable because its storing the chromedriver (option)
            return driver;
        }

        public static String getcontent(WebDriver driver, String locator, ExtentTest logger, String elementname) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);

            String message = null;
            try {
                logger.log(LogStatus.INFO, " Capturing text from element " + elementname);
                message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).getText();


            } catch (Exception e) {
                System.out.println("unable to capture the text value " + e);
                logger.log(LogStatus.FAIL,"unable to capture text" + elementname);
            }
            return message;
        }

        public static void scroll (WebDriver driver, String locator, String uservalue) {
            JavascriptExecutor jse = (JavascriptExecutor)  driver;
            jse.executeScript(uservalue);

        }
    public static void getScreenshot(WebDriver driver, ExtentTest logger) throws IOException {
        String path = "C:\\Users\\Issa\\Documents\\extent report\\";
        //String path = "src\\main\\java\\externalFiles\\ScreenShots\\";
        String fileName = "image"+ UUID.randomUUID() + ".png";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Now you can do whatever you need to do with, for example copy somewhere
        FileUtils.copyFile(sourceFile, new File(path + fileName));
        //String imgPath = directory + fileName;
        String image = logger.addScreenCapture(fileName);
        logger.log(LogStatus.FAIL, "", image);
    }
    }

