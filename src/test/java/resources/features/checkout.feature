Feature: Checkout Process
  Scenario: Completing a purchase
    Given User is on the home page
    When User adds "Nexus 6" to the cart
    And User navigates to cart page
    And User proceeds to checkout
    And User enters checkout details
    And User confirms the purchase
    Then User should see the purchase confirmation message