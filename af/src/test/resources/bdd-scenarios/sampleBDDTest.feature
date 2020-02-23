Feature: Google search example
  I want to test google search feature

  Scenario Outline: Search for an item in google search
    When "<searchItem>" is entered in the google search box
    Then search pages opens with results
    And all the search items contain atleast one occurrence of the "<searchItem>"
    
    Examples:
    |searchItem|
    |sabarish|
  
   @dataFile:"src/test/resources/test-data/test.json" 
  Scenario: Search for an item in google search
    When "<searchItem>" is entered in the google search box
    Then search pages opens with results
    And all the search items contain atleast one occurrence of the "<searchItem>"
 

