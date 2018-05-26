package day12_xmlsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class count_tabs {
    @Test
    public void tetscenario() throws InterruptedException {
        WebDriver driver= reusables.reusableMethods.chromeDriver();
        // navigate to google
        driver.navigate().to("https://www.google.com");
        //wait few seconds
        Thread.sleep(2000);
        //get all the navigation tab count
        List<WebElement> tabCount = driver.findElements(By.xpath("//*[@type='submit']"));
        System.out.println("tab count is " + tabCount.size());

        // iterate through each tab an get the name of the tab by printing
        for (int i =0; i<tabCount.size();i++){
            String getname = driver.findElements(By.xpath("//*[@type='submit']")).get(i).getText();
            System.out.println("my tab is " + getname);

        }

    }
}
