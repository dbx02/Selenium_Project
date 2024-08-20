Feature: Select and Verify Dropdown
  Scenario: Select a term from the dropdown and verify selection
    Given I am on the dropdown page
    When I select the "Green" option from the Old Style Select Menu
    Then The "Green" option should be selected
