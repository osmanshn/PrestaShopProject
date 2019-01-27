package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdentityPage {

    public IdentityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id='firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='lastname']")
    public WebElement lastName;

    @FindBy(name = "submitIdentity")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id='center_column']/div/div/ol/li")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/a/span")
    public WebElement backButton;








}
