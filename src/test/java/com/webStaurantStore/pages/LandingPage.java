package com.webStaurantStore.pages;

import com.webStaurantStore.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='searchval']")
    public WebElement searchBar;

    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchBtn;

}
