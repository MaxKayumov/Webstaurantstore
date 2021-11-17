package com.webStaurantStore.pages;

import com.webStaurantStore.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {

    public SearchResultPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='ag-item p-2 xs:p-4']")
    public List<WebElement> tableTypes;

    @FindBy(xpath = "//a[@data-testid='itemDescription']")
    public List<WebElement> eachTable;

    @FindBy(xpath = "(//input[@type='submit'])[61]")
    public WebElement lastTable;


}
