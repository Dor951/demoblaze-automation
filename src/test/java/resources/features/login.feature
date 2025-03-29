Feature: User Login
  Scenario: Successful login with valid credentials
    Given User is on the home page
    When User click on login button
    And User enters username "ror" and password "ror"
    Then User should be logged in successfully

  Scenario: Login with invalid user
    Given User is on the home page
    When User click on login button
    When User enters username "invalidUser2" and password "password123"
    Then An alert appears with text "User does not exist."

  Scenario: Login with wrong password
    Given User is on the home page
    When User click on login button
    When User enters username "ror" and password "wrongPass"
    Then An alert appears with text "Wrong password."