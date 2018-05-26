package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class actionitem_inclass {

    @Test
    public void actionitem() throws InterruptedException {
        SoftAssert softAssertassert = new SoftAssert();
        WebDriver driver= reusables.reusableMethods.chromeDriver();
        driver.navigate().to("https://www.yahoo.com");
        softAssertassert.assertEquals("Yahoo", driver.getTitle());
        Thread.sleep(2500);
        List<WebElement> tabCount = driver.findElements(By.xpath("//*[contains(@class,'Mstart(21px)')]"));
        System.out.println("tab count is " + tabCount.size());
        for(int i = 0; i<tabCount.size(); i++){
            String getname = driver.findElements(By.xpath("//*[contains(@class,'Mstart(21px')]")).get(i).getText();
            System.out.println("my tab is " + getname);
        }
        reusables.reusableMethods.sendkeys(driver, "//*[@name='p']", "Nutrition");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,10000)","");

        String message = reusables.reusableMethods.getcontent(driver, "//*[contains(@class, 'reg searchBottom')]");

        String [] arraymessage = message.split("Next");
        System.out.println(arraymessage[1]);
        jse.executeScript("window.scrollBy(0,-10000)","");
        Thread.sleep(2000);

        reusables.reusableMethods.click(driver, "//*[@id='yucs-login_signIn']");
        boolean elementState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        System.out.println("is element selected " + elementState);
        reusables.reusableMethods.sendkeys(driver, "//*[@id='login-username']", "ahmedesa");
        reusables.reusableMethods.click(driver, "//*[@id='login-signin']");
        String err = reusables.reusableMethods.getcontent(driver, "//*[@id= 'username-error']");
        softAssertassert.assertEquals("Sorry, we don't recognize this email.",err);
        Thread.sleep(2500);
        driver.quit();
        softAssertassert.assertAll();


    }
}

