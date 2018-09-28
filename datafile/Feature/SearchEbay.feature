Feature: Search on Ebay
  Enter to Ebay
  Search for shoes
  Select brand Adidas
  Select size 10
  Print the number of results
  Order by price ascendant
  Assert the order taking the first 5 results
  Take the first 5 products with their prices and print them in console.
  Order and print the products by name (ascendant)
  Order and print the products by price in descendant mode
  
  @TEST
  Scenario Outline: Search Puma Shoes 
    Given Navigate to Ebay Web Site
    When I enter <search_data>
    Then I click the search
    And I select the brand Puma
    And I select the size 10
    Then Print Results of the search  
    Then I input price <pricemin> to <pricemax> asc
    And I click order for price
        
   @QA
    Examples: 
      | search_data |pricemin |pricemax |
      | zapatillas  |0.00     |2000.00  |
