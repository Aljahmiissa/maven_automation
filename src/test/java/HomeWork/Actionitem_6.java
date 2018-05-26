/*package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Actionitem_6 {
    WebDriver driver;
    @BeforeMethod
        public void openbrowser(){
        driver = reusables.reusableMethods.chromeDriver();
        }
        @Test (priority = 1)
    public void testing() throws InterruptedException {
        driver.navigate().to("https://www.express.com");
        reusables.reusableMethods.mouseaction(driver, "//*[contains(@aria-label,'Women')]", "women");
        reusables.reusableMethods.mouseaction(driver, "//*[contains(@aria-label,'Accessories')]", "accessories");
        reusables.reusableMethods.click(driver, "//*[contains(@aria-label,'Jewelry']");
        reusables.reusableMethods.click(driver, "//*[contains(@href, 'earings']");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='header top-padding']")).isDisplayed(),"Earrings for Women - Earrings");
        reusables.reusableMethods.mouseaction(driver, "//*[@alt='large metal hoop earrings']","largeearings");
        reusables.reusableMethods.click(driver, "//*[@class='express-view']");
        reusables.reusableMethods.click(driver, "//*[@class='color-swatch']");
        reusables.reusableMethods.click(driver, "//*[@role='button']");
        reusables.reusableMethods.mouseaction(driver, "//*[@class='bag-icon']", "bag icon");
        reusables.reusableMethods.click(driver, "//*[@class='exp-medium'");
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'grid--direction-column']")).isDisplayed(),"My Shopping Bag | Express");
        String Qty = driver.findElement(By.xpath("//*[@id='qdd-0-quantity']").click());
        Select dropDown = new Select(Qty);
        dropDown.selectByVisibleText("2");
        reusables.reusableMethods.click(driver, "//*[@aria-label='Continue to Checkout']");
        reusables.reusableMethods.click(driver, "//*[@class='btn _2u-IO _1n1el _1MBdF']");
        reusables.reusableMethods.sendkeys(driver, "//*[@name='firstname']", "issa");
        reusables.reusableMethods.sendkeys(driver, "//*[@name='lastname']", "ahmed");
        reusables.reusableMethods.sendkeys(driver, "//*[@name='email']", "ahmedesa@yahoo.com");
        reusables.reusableMethods.sendkeys(driver, "//*[@name='confirmEmail']", "ahmedesa@yahoo.com");
        reusables.reusableMethods.sendkeys(driver, "//*[@name='phone']", "3475767678");
        reusables.reusableMethods.sendkeys(driver, "//*[@name='shipping.firstName']", "issa");
        reusables.reusableMethods.sendkeys(driver, "//*[@name='shipping.lastName']", "ahmed");
        reusables.reusableMethods.sendkeys(driver, "//*[@name='shipping.line1']", "6815 3rd ave");
        reusables.reusableMethods.sendkeys(driver, "//*[@name='shipping.postalCode']", "11220");
        reusables.reusableMethods.sendkeys(driver, "//*[@name='shipping.city']", "brooklyn");
        WebElement country = driver.findElement(By.xpath("//*[@name='shipping.countryCode']"));
        Select dropDown = new Select(country);
        dropDown.selectByVisibleText("United States");
        WebElement state = driver.findElement(By.xpath("//*[@name='shipping.state']"));
        Select dropDown = new Select(country);
        dropDown.selectByVisibleText("New York");
        boolean shipping = driver.findElement(By.xpath("//*[@type='checkbox']")).isSelected();
        reusables.reusableMethods.click(driver, "//*[@type='submit']");
        String message = reusables.reusableMethods.getcontent(driver,"//*[@class='_1oFkX']");
        System.out.prinln("contact info " + String message);





    }

}*/
