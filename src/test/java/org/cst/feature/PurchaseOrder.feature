@tag
Feature: Purchase the order form  ECommerce Website

  Background:
    Given I Landed on the ECommerce Page

  @tag2
  Scenario Outline: Positive Test of Submitting the order

    Given  Logged in with username <userName> and password <password>
    When   I Add product <productName> to cart
    And    Checkout <productName> and submit the order
    Then   "Thankyou for the order." message displayed on confirmationPage

    Examples:
      | userName                    | password    | productName |
      | vamshi.kuchikulla@gmail.com | Vamshi@2151 | ZARA COAT 3 |
