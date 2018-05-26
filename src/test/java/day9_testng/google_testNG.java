package day9_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reusables.reusableMethods;

import java.util.List;

public class google_testNG {
WebDriver driver;
SoftAssert softAssert;
    @BeforeMethod
    public void openbrowser(){
        //define the chrom driver using method
        driver = reusables.reusableMethods.chromeDriver();


    }
    @Test (priority = 1)
    public void testScenario(){
        softAssert = new SoftAssert();
        // navigate to google
        driver.navigate().to ("https://www.gooooogle.com/");
        List<WebElement> tabsCount = driver.findElements(By.xpath("//*[@id='hdtb-msb']"));
        // verify page is correct by using assertion
        softAssert.assertEquals("Google", driver.getTitle());
        //lets verify the gooogle image is displayed
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed(),"Logo should be present");
        // entering name on search field
        reusables.reusableMethods.sendkeys(driver,"//*[@name='q']", "Brooklyn");
        //click on somewhere outside of the page to minimized the search dropdown
        reusables.reusableMethods.click(driver,"//*[@id='body']");
        //click on search bar
        reusables.reusableMethods.click(driver,"//*[@name='btnK']");

    }
 /*   @Test
    public void testScenario2() {
        // navigate to google
        driver.navigate().to("https://www.google.com/");
        // verify page is correct by using assertion
        Assert.assertEquals("Google", driver.getTitle());
        //lets verify the gooogle image is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed(), "Logo should be present");
        // entering name on search field
        reusables.reusableMethods.sendkeys(driver, "//*[@name='q']", "Brooklyn");
        //click on somewhere outside of the page to minimized the search dropdown
        reusables.reusableMethods.click(driver, "//*[@id='body']");
        //click on search bar
        reusables.reusableMethods.click(driver, "//*[@name='btnK']");

    }*/
    @AfterMethod
    public void closeBrowser (){
        driver.quit();
        softAssert.assertAll();

    }
}

