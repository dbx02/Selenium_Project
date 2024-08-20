Feature: Button Click Verification
  Scenario: Clicking a dynamically identified button
    Given I am on the homepage
    When I click the "Click Me" button
    Then I should see a confirmation message
