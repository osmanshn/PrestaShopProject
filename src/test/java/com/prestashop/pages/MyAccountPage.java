package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    public static String title = Driver.getDriver().getTitle();

    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")
    public WebElement myPersonalInformation;

    @FindBy(xpath =  "//*[@id='center_column']/div/div[1]/ul/li[3]/a/span")
    public WebElement myAddresses;





}
