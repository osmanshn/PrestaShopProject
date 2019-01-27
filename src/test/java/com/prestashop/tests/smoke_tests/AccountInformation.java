package com.prestashop.tests.smoke_tests;

import com.prestashop.pages.*;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AccountInformation extends TestBase {
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    IdentityPage identityPage = new IdentityPage();
    AddressesPage addressesPage = new AddressesPage();
    AddressPage addressPage = new AddressPage();
    String accountHolder;


    @Test(priority = 0)
    public void myAccount() throws InterruptedException {
        homePage.open();
        homePage.signIn.click();
        signInPage.login("osmanshn@gmail.com" , "Osman@1985" );
        Assert.assertTrue(Driver.getDriver().getTitle().contains("My account"));
        accountHolder = myAccountPage.signIn.getText();
        Assert.assertEquals(accountHolder,"Osman Sahin");
    }

    @Test(priority = 1)
    public void myPersonalInformation()  {
        myAccountPage.myPersonalInformation.click();
        Assert.assertTrue(driver.getTitle().contains("Identity"));
        Assert.assertEquals(identityPage.firstName.getAttribute("value") + " " + identityPage.lastName.getAttribute("value"), accountHolder );
        identityPage.saveButton.click();
        Assert.assertEquals(identityPage.errorMessage.getText(), "The password you entered is incorrect.");
        identityPage.backButton.click();
        Assert.assertTrue(driver.getTitle().contains("My account"));
    }

   @Test (priority = 2)
    public void myAddress()  {
        myAccountPage.myAddresses.click();
        addressesPage.addNewAddressButton.click();
        Assert.assertEquals(addressPage.firstName.getAttribute("value") + " " +  addressPage.lastName.getAttribute("value"), accountHolder );
        addressPage.firstName.clear();
        addressPage.saveButton.click();
        Assert.assertEquals(addressPage.errorMessage.getText(), "firstname is required.");

    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
        softAssert.assertAll();
    }


}
