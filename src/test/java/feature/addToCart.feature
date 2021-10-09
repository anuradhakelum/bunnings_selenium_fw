Feature: Add item to the cart
  Scenario: Add an item to the cart after searching and filtering
    Given User is in Home page
    And User search for paint items
    And User filter items which are available for click and collect
    When User add item to the cart
    And Go to cart page
    Then User should see item quantity and amount in cart page