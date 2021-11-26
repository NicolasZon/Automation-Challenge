Feature: Amazon search

  Scenario: Search Successful
    Given the user navigates to the base page
    When he searches for "Alexa"
    And navigates to the second page
    And he selects the third item
    Then the item would be available for purchase
