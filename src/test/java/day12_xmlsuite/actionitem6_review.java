package day12_xmlsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class actionitem6_review {
    // define the global variable
    //define webdriver
    WebDriver driver;
    //soft asser
    SoftAssert softAssert;
    @BeforeSuite
    public void defineBrowser(){
        //define the chrome driver using reusable method
        driver = reusables.reusableMethods.chromeDriver();


    }

    @Test (priority = 1)
    public void testcase1() throws InterruptedException {

        //navigate to website
        driver.navigate().to("https://www.express.com");
        //hover over womens
        reusables.reusableMethods.mouseaction(driver, "//*[@href='/womens-clothing\']", "women");

        reusables.reusableMethods.mouseaction(driver,"//*[@href='/womens-clothing/accessories/cat740011\']", "accessories");
        reusables.reusableMethods.click(driver, "//*[@href='/womens-clothing/accessories/cat740011\']");
        reusables.reusableMethods.click(driver, "//*[text()='Jewelry']");
        reusables.reusableMethods.click(driver, "//*[text()='Earrings']");
        //assert that im on the right page
       /* softAssert.assertEquals("Earrings for women - Earrings", driver.getTitle());*/
        reusables.reusableMethods.mouseaction(driver, "//*[@class='active loaded']", "earrings");
        reusables.reusableMethods.click(driver, "//*[@class='express-view']");
        Thread.sleep(2000);
        reusables.reusableMethods.click(driver, "//*[@class='product-color ']");
        reusables.reusableMethods.click(driver, "//*[text()='Add to Bag']");
        reusables.reusableMethods.mouseaction(driver, "//*[@class='bag-icon']", " bagicon");
        reusables.reusableMethods.click(driver, "//*[text()='CHECKOUT']");



        }


        @Test(priority = 2)
        public void testcase2() throws InterruptedException {
            // allow page to load
            Thread.sleep(3000);
        //select quantity 2 on dropdown
            WebElement element = driver.findElement(By.xpath("//*[@id='qdd-0-quantity']"));
                    Select dropdown = new Select(element);
                    dropdown.selectByIndex(1);
                    reusables.reusableMethods.click(driver,"//*[@aria-label='Continue to Checkout']");
                    reusables.reusableMethods.click(driver, "//*[text()='Continue as Guest']");
            reusables.reusableMethods.sendkeys(driver, "//*[@name='firstname']", "issa");
            reusables.reusableMethods.sendkeys(driver, "//*[@name='lastname']", "ahmed");
            reusables.reusableMethods.sendkeys(driver, "//*[@name='email']", "ahmedesa@yahoo.com");
            reusables.reusableMethods.sendkeys(driver, "//*[@name='confirmEmail']", "ahmedesa@yahoo.com");
            reusables.reusableMethods.sendkeys(driver, "//*[@name='phone']", "3475767678");
            reusables.reusableMethods.click(driver,"//*[text()='Continue']");


        }
        @Test(priority = 3)
        public void testcase3() throws InterruptedException {
        Thread.sleep(2000);
            reusables.reusableMethods.sendkeys(driver, "//*[@name='shipping.firstName']", "issa");
            reusables.reusableMethods.sendkeys(driver, "//*[@name='shipping.lastName']", "ahmed");
            reusables.reusableMethods.sendkeys(driver, "//*[@name='shipping.line1']", "6815 3rd ave");
            reusables.reusableMethods.sendkeys(driver, "//*[@name='shipping.postalCode']", "11220");
            reusables.reusableMethods.sendkeys(driver, "//*[@name='shipping.city']", "brooklyn");
            WebElement country = driver.findElement(By.xpath("//*[@name='shipping.countryCode']"));
            Select dropdown = new Select(country);
            dropdown.selectByVisibleText("United States");
            WebElement state = driver.findElement(By.xpath("//*[@name='shipping.state']"));
            Select dropDown = new Select (state);
            dropDown.selectByVisibleText("New York");
            reusables.reusableMethods.click(driver, "//*[@type='submit']");
            String message = reusables.reusableMethods.getcontent(driver,"//*[@class='_1oFkX']");
            System.out.println("contact info " +  message);
        }

    @AfterSuite
    public void closedriver(){
        driver.quit();
        softAssert.assertAll();
    }








}
