package com.prestashop.tests.smoke_tests;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ProductPage;
import com.prestashop.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ProductInformation extends TestBase {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    Select size;

    @Test
    public void priceTest() throws InterruptedException {
        homePage.open();
        homePage.blouse.click();
        String name1 = productPage.productName.getText();
        String price1 = productPage.price.getText();
        String quantity = productPage.quantity.getAttribute("value");
        WebElement select = productPage.size;
        Select options = new Select(select);

        String size = options.getFirstSelectedOption().getText();
        String[] sizes = new String[3];


        String actualOptions = "";
        for (int i = 0; i < options.getOptions().size(); i++){
            actualOptions += options.getOptions().get(i).getText() + ", ";
        }
        actualOptions = actualOptions.substring(0,actualOptions.length()-2);

        Assert.assertEquals(name1 , "Blouse" , "NAMETEST" );
        Assert.assertEquals(price1 , "$27.00" , "PRICETEST" );
        Assert.assertEquals(quantity  , "1" , "QUANTITYTEST" );
        Assert.assertEquals(size  , "S" , "SIZETEST" );
        Assert.assertEquals(actualOptions , "S, M, L"  , "SIZEOPTIONSTEST" );

        productPage.addToCart.click();
        Thread.sleep(5000);
        Assert.assertEquals(productPage.message.getText() , "Product successfully added to your shopping cart"  , "Cart Message" );
        Assert.assertEquals(productPage.quantityPopUp.getText()  , "1" , "QUANTITYTEST" );
        size = productPage.sizePopUp.getText().substring(productPage.sizePopUp.getText().length()-1);
        Assert.assertEquals(size  , "S" , "SIZETEST" );
        Assert.assertEquals(productPage.productNamePopUp.getText()  , name1 , "NAMETEST" );
        Assert.assertEquals(productPage.pricePopUp.getText()  , price1 , "PRICETEST" );

    }
}
