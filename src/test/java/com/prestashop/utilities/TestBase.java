package com.prestashop.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;


import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions actions;

    @BeforeClass
    public void setUpClass(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
        actions = new Actions(driver);
    }

    @AfterClass
    public void tearDownMethod(){
        BrowserUtils.wait(3);
        Driver.closeDriver();
        softAssert.assertAll();
    }
}
