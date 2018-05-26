package day_13;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExpressTest extends AbstractClass {
    @Test
    public void expressCheckout() throws InterruptedException, IOException {
        //navigate to website
        driver.navigate().to("https://www.express.com");
        //hover over womens
        reusables.reusableMethods_report.mouseaction(driver, "//*[@href='/womens-clothing\']", logger,"women tab");

        reusables.reusableMethods_report.mouseaction(driver,"//*[@href='/womens-clothing/accessories/cat740011\']",logger, "accessories");
        reusables.reusableMethods_report.click(driver, "//*[@href='/womens-clothing/accessories/cat740011\']", logger, "accessories");
        reusables.reusableMethods_report.click(driver, "//*[text()='Jewelry']",logger,"jewelery");
        reusables.reusableMethods_report.click(driver, "//*[text()='Earrings']",logger,"earings");
        String pageName = driver.getTitle();
        if(pageName.equalsIgnoreCase("Earrings for Womennnnn - Earrings")){
            logger.log(LogStatus.PASS,"Page shows accurate title");
        } else {
            logger.log(LogStatus.FAIL,"Page title doesn't match.."+ pageName);
            reusables.reusableMethods_report.getScreenshot(driver,logger);
        }
        //assert that im on the right page
        /* softAssert.assertEquals("Earrings for women - Earrings", driver.getTitle());*/
        reusables.reusableMethods_report.mouseaction(driver, "//*[@class='active loaded']", logger,"earrings");
        reusables.reusableMethods_report.click(driver, "//*[@class='express-view']",logger,"express");
        Thread.sleep(2000);
        reusables.reusableMethods_report.click(driver, "//*[@class='product-color ']",logger,"color");
        reusables.reusableMethods_report.click(driver, "//*[text()='Add to Bag']",logger,"add to bag");
        reusables.reusableMethods_report.mouseaction(driver, "//*[@class='bag-icon']", logger," bagicon");
        reusables.reusableMethods_report.click(driver, "//*[text()='CHECKOUT']",logger,"checkout");




    }

    @Test(dependsOnMethods = "expressCheckout")
    public void addQuantitiy() throws IOException {
        //click on the quantity drop down
        reusables.reusableMethods_report.click(driver,"//*[@id='qdd-0-quantity']",logger,"Quantity Dropdown");
        //click on the quantity value
        reusables.reusableMethods_report.click(driver,"//*[@value='2']",logger,"Quantity Value");

    }
    
}
