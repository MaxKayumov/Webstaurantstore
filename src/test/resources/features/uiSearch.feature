@wip
  Feature: Search functionality validation
    Agile Story: As a user, when I am on the main search page,
      I should be able to search whatever I want, and see relevant information

    @landingPage
      Scenario: WebstaurantStore home page title verification
      Given User is on WebStaurantStore landing page
      Then User should see title is "WebstaurantStore: Restaurant Supplies & Foodservice Equipment"

    @resultPageTitle
      Scenario: Search results page title verification
      Given User searches for "stainless work table"
      Then User should see "Stainless Work Table - WebstaurantStore" as result page's title

    @searchResult
      Scenario: Search results verification
      Given User should see "Table" in every search result's title

    @Cart
    Scenario: Adding item from search result to cart and deletion
      Given User adds last item from search result to the Cart
      When User clicks View in popup
      Then User empties Cart
