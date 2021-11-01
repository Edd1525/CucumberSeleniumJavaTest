Feature: Add Item to Card
  As a customer
  I want to be able to add a product to the Cart
  So I can accurately see the price of a product

  @AmazonTests
  Scenario Outline: Adding and removing items from a cart
    Given The user is on the amazon page
    And the user Search for <itemName>
    When the user Add the first <productNumber> with <quantity> to the cart
    And the total price and quantity <quantity> are correct
    And the user reduce the quantity of items to <quantityReduce>
    Then the total price and quantity <quantityReduce> are correct
    Examples:
    |itemName     |quantity|quantityReduce|productNumber|
    |hats for men |2       |1             |1            |
