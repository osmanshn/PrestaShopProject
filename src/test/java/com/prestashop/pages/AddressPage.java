package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {

    public AddressPage(){
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy(xpath = "//*[@id='firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='lastname']")
    public WebElement lastName;

    @FindBy (name = "submitAddress")
    public WebElement saveButton;

    @FindBy (xpath = "//*[@id='center_column']/div/div/ol/li[1]")
    public WebElement errorMessage;



}



