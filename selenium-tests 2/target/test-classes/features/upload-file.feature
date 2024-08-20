Feature: Select and Upload File
  Scenario: Uploading a file
    Given I am on the Upload and Download page
    When I click the "uploadFile" button and select the "src/test/resources/sample.txt" file
    Then The file it's uploaded
    