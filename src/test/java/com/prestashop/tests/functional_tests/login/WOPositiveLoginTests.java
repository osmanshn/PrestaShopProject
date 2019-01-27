package com.prestashop.tests.functional_tests.login;

import com.prestashop.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class WOPositiveLoginTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/\n" +
                "login.aspx");
    }

    @Test(priority = 0)
    public void PositiveLoginTest(){
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
  //      String test1 = "TITLE TEST: " + BrowserUtils.verifyTextMathces(driver.getTitle(), "Web Orders Login" );
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
 //       String test2 ="TITLE TEST: " + BrowserUtils.verifyTextMathces(driver.getTitle(), "Web Orders" );
//        System.out.println(test1 + "\n" + test2 + "\n" + "URL TEST: " + BrowserUtils.verifyTextMathces(driver.getCurrentUrl() , "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"));
        Assert.assertEquals(driver.getTitle(),"Web Orders");
        Assert.assertEquals(driver.getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx" );

    }


   @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
}
