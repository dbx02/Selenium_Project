Feature: Select new date
  Scenario: Select a new date from the date picker section
    Given I am on the date picker page
    When I select the date "Monday, May 27th, 2024"
    Then The date "05/27/2024" should be selected
