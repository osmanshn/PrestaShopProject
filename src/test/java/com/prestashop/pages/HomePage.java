package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
    public WebElement signOut;

    @FindBy (xpath = "//*[@id='homefeatured']/li[2]/div/div/div/a/img")
    public WebElement blouse;

    @FindBy (xpath = "//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img")
    public WebElement faded;


    @FindBy (xpath = "//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]")
    public WebElement blouseCart;

    @FindBy (xpath = "    //*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span\n")
    public WebElement fadedCart;


    @FindBy (xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
    public WebElement continueShopping;

    @FindBy (xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    public WebElement proceedToCheckOut;

    @FindBy (xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    public WebElement cart;

    @FindBy (xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt/span/a")
    public WebElement cartRemove;



    @FindBy (xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt/div/div[1]/a")
    public WebElement cartItem;



    public void open(){
        Driver.getDriver().get("http://automationpractice.com/index.php");
    }

}
