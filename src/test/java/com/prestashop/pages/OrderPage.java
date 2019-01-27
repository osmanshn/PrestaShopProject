package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    public OrderPage(){
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy(xpath = "//*[@id=\"cart_title\"]/span")
    public WebElement cartMessage;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    public WebElement emptyMessage;



}
