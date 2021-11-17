package com.webStaurantStore.step_definitions;

import com.webStaurantStore.pages.CartPage;
import com.webStaurantStore.pages.LandingPage;
import com.webStaurantStore.pages.SearchResultPage;
import com.webStaurantStore.utilities.BrowserUtils;
import com.webStaurantStore.utilities.ConfigurationReader;
import com.webStaurantStore.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchStepDefinitions {

    WebDriver driver = Driver.getDriver();
    LandingPage mainPage = new LandingPage();
    CartPage cart = new CartPage();
    SearchResultPage searchPage = new SearchResultPage();

    @Given("User is on WebStaurantStore landing page")
    public void userIsOnWebStaurentStoreLandingPage() {
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @Then("User should see title is {string}")
    public void userShouldSeeTitleIs(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expectedTitle);
    }

    @Given("User searches for {string}")
    public void userSearchesFor(String searchItem) {
        mainPage.searchBar.sendKeys(searchItem);
        mainPage.searchBtn.click();
    }

    @Then("User should see {string} as result page's title")
    public void userShouldSeeAsResultSPageTitle(String expectedSearchTitle) {
        String actualSearchTitle = driver.getTitle();
        assertEquals(expectedSearchTitle, actualSearchTitle);
        BrowserUtils.sleep(3);
    }

    @When("User should see {string} in every search result's title")
    public void user_should_see_in_every_search_result_s_title(String expectedTable) {
        List<WebElement> allTables = searchPage.tableTypes;
        for (WebElement eachTableType : allTables) {
            assertTrue(eachTableType.getText().contains(expectedTable));
            BrowserUtils.waitForVisibility(eachTableType, 5);
        }

        WebElement temp;
        int pageNum = 2;
        int issuePages;
        do {
            List<WebElement> actualTables = searchPage.eachTable;
            for (WebElement each : actualTables) {
                assertTrue(each.getText().contains(expectedTable) || each.getText().contains("Stainless"));
            }

            if (pageNum == 5 || pageNum == 7) {
                issuePages = 10;
            } else if (pageNum == 6) {
                issuePages = 11;
            } else {
                issuePages = 9;
            }
            temp = driver.findElement(By.xpath("//*[@id=\"paging\"]/nav/ul/li[" + issuePages + "]/a[@aria-label='Go to page " + pageNum++ + "']"));

            if (pageNum < 11) {
                temp.click();
            } else {
                List<WebElement> actualTables1 = searchPage.eachTable;
                for (WebElement each : actualTables1) {
                    assertTrue(each.getText().contains(expectedTable) || each.getText().contains("Stainless"));
                }
            }
        }
        while (pageNum < 10);

    }

    @Given("User adds last item from search result to the Cart")
    public void user_adds_last_item_from_search_result_to_the_cart() {
        searchPage.lastTable.click();
    }

    @When("User clicks View in popup")
    public void userClicksViewInPopup() {
        cart.popup.click();
    }

    @Then("User empties Cart")
    public void user_empties_cart() {
        cart.emptyCart.click();
       cart.checkCart.click();
        System.out.println("Actual size: " + cart.checkCart.getText());
        assertEquals("0", cart.checkCart.getText());

    }

}
