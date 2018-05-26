package reusables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reusableMethods {

        // static variable which can be used on your method classes. for example, explicit timeout
        public static int timeout = 30;

        // method below allows you to create a reusable method to click on an element and you are passing two arguments
        // one is webdriver that you are using and second one is the locator you are locating the element with
        public static void click(WebDriver driver, String locator) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();

            } catch (Exception e) {
                System.out.println("Unable to click on an element " + e);

            }

        }
        /// 'locator', 'user value' 'sendkeys' on below line are all user defined

        public static void sendkeys(WebDriver driver, String locator, String userValue) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).sendKeys(userValue);


            } catch (Exception e) {
                System.out.println("Unable to enter user value on an element " + e);
            }

        }

        public static void mouseaction(WebDriver driver, String locator, String userValue) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                Actions mouseAction = new Actions(driver);
                WebElement uservalue = driver.findElement(By.xpath(locator));
                mouseAction.moveToElement(uservalue).build().perform();


            } catch (Exception e) {
                System.out.println("Unable to  enter user value on an element " + e);


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

        public static String getcontent(WebDriver driver, String locator) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);

            String message = null;
            try {
                message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).getText();


            } catch (Exception e) {
                System.out.println("unable to capture the text value " + e);
            }
            return message;
        }

        public static void scroll (WebDriver driver, String locator, String uservalue) {
            JavascriptExecutor jse = (JavascriptExecutor)  driver;
            jse.executeScript(uservalue);

        }
    }

