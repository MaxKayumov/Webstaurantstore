package com.webStaurantStore.pages;

import com.webStaurantStore.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"watnotif-wrapper\"]/div/p/div[2]/div[3]/a[1]")
    public WebElement popup;

    @FindBy(xpath = "(//a[@aria-labelledby='remove-item'])[1]")
    public WebElement emptyCart;

    @FindBy(xpath = "//span[@id='cartItemCountSpan']")
    public WebElement checkCart;

}
