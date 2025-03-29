Feature: Cart Management
  Scenario: Adding a product to the cart
    Given User is on the home page
    When User adds "Sony vaio i5" to the cart
    And User navigates to cart page
    Then User should see the product in the cart

  Scenario: Add two products and verify total price
    Given User is on the home page
    When User adds "Samsung galaxy s6" to the cart
    And User navigates to home page
    And User adds "Nokia lumia 1520" to the cart
    And User navigates to cart page
    Then Total cart price should be 1180