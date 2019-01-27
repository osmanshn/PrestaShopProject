package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage(){
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy (xpath = "//h1[@itemprop='name']")
    public WebElement productName;

    @FindBy (xpath = "//span[@id='our_price_display']")
    public WebElement price;

    @FindBy (xpath = "//input[@name='qty']")
    public WebElement quantity;

    @FindBy (xpath = "//select[@name='group_1']")
    public WebElement size;

    @FindBy (name = "Submit")
    public WebElement addToCart;

    @FindBy (xpath = "//div/div/div/div/div/div[1]/h2")
    public WebElement message;

    @FindBy (id = "layer_cart_product_quantity")
    public WebElement quantityPopUp;

    @FindBy (id = "layer_cart_product_attributes")
    public WebElement sizePopUp;

    @FindBy (id = "layer_cart_product_title")
    public WebElement productNamePopUp;

    @FindBy (id = "layer_cart_product_price")
    public WebElement pricePopUp;
}
