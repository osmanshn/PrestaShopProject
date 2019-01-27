package com.prestashop.tests.functional_tests.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WONegativeLoginTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test(priority = 0)
    public void NegativeLoginTestWrongUsername(){
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        String currentUrl = driver.getCurrentUrl();
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Test");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        Assert.assertEquals(driver.getCurrentUrl(), currentUrl );
    }

    @Test(priority = 1)
    public void NegativeLoginTestWrongPassword(){
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        String currentUrl = driver.getCurrentUrl();
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        Assert.assertEquals(driver.getCurrentUrl(), currentUrl );
    }

    @Test(priority = 2)
    public void NegativeLoginTestBlankUsername(){
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        String currentUrl = driver.getCurrentUrl();
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        Assert.assertEquals(driver.getCurrentUrl(), currentUrl );
    }

    @Test(priority = 2)
    public void NegativeLoginTestBlankPassword(){
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        String currentUrl = driver.getCurrentUrl();
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        Assert.assertEquals(driver.getCurrentUrl(), currentUrl );
    }



    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }




    }
