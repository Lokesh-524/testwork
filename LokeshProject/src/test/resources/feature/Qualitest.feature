#Author: petlurulokesh.reddy@gmail.com
@REG
Feature: Qualitest code

  Scenario: 1. Add lowest price product to My Cart
    Given user login to demo page
    When user add 4 differnt products to 'My Wish' list
    Then verify added products in wishlist table
    And add lowest price product to 'My Cart'
    And verify 'My Cart' item
