package com.prestashop.tests.functional_tests.cart;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.OrderPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartLoginTest extends TestBase {
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    OrderPage orderPage = new OrderPage();

    @Test
    public void cartLoginTest()   {
        Actions action = new Actions(Driver.getDriver());
        homePage.open();
        action.moveToElement(homePage.blouse).perform();
        homePage.blouseCart.click();
        homePage.continueShopping.click();
        action.moveToElement(homePage.cart).perform();
        Assert.assertEquals(Driver.getDriver().findElement
                (By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt/div/div[1]/a")).getText()
                , "Blouse" );

        homePage.signIn.click();
        signInPage.login("osmanshn@gmail.com" , "Osman@1985");
        action.moveToElement(homePage.cart).perform();
        Assert.assertEquals(Driver.getDriver().findElement
                        (By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt/div/div[1]/a")).getText()
                , "Blouse" );
    }

    @Test
    public void cartLogoutTest() throws InterruptedException {
        Actions action = new Actions(Driver.getDriver());
        homePage.open();
        homePage.signIn.click();
        signInPage.login("osmanshn@gmail.com" , "Osman@1985");
        homePage.open();
        action.moveToElement(homePage.faded).perform();
        homePage.fadedCart.click();
        homePage.continueShopping.click();
        action.moveToElement(homePage.cart).perform();
        Thread.sleep(5000);
        Assert.assertTrue(Driver.getDriver().findElement
                        (By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt/div/div[1]/a")).getText().contains("Faded Shor"));
        homePage.signOut.click();
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[5]")).getText() , "(empty)");

    }

    @Test
    public void cartIconDelete() throws InterruptedException {
        Actions action = new Actions(Driver.getDriver());
        homePage.open();
        action.moveToElement(homePage.faded).perform();
        homePage.fadedCart.click();
        homePage.continueShopping.click();
        action.moveToElement(homePage.cart).perform();
        homePage.cartRemove.click();
        Thread.sleep(5000);
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[5]")).getText() , "(empty)");
    }

    @Test
    public void checkOutDelete() throws InterruptedException {
        Actions action = new Actions(Driver.getDriver());
        homePage.open();
        action.moveToElement(homePage.faded).perform();
        homePage.fadedCart.click();
        homePage.continueShopping.click();
        action.moveToElement(homePage.blouse).perform();
        homePage.blouseCart.click();
        Thread.sleep(1000);

        homePage.proceedToCheckOut.click();

        Assert.assertEquals(orderPage.cartMessage.getText() , "Your shopping cart contains: 2 Products");

        Driver.getDriver().findElement(By.xpath  ("//a[starts-with(@id,'1')]")).click();

        Thread.sleep(1000);
        Assert.assertEquals(orderPage.cartMessage.getText() , "Your shopping cart contains: 1 Product");

        Driver.getDriver().findElement(By.xpath  ("//a[starts-with(@id,'2')]")).click();

        Thread.sleep(2000);
        Assert.assertEquals(orderPage.emptyMessage.getText() , "Your shopping cart is empty.");

    }

}
