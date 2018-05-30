@getaquote
Feature: Get A Quote
  As an online shopper, I want to get a quote for car insurance in less than three minutes

  Background: Navigate to the home page
    Given The user is on the Home Page

  Scenario: Get a quote for car insurance
    And The user sets the zip code to "60606"
    And The user clicks the 'Get A Quote' button
    When The Previous Policy page loads
    And The user clicks on 'New Customer'
    When The Initial Quote page loads
    And The user sets the 'Year' to "2011"
    And The user sets the 'Make' to "CHEVROLET"
    And The user sets the 'Model' to "CRUZE LS"
    And The user sets the 'First Name' to "Bill"
    And The user sets the 'Last Name' to "Meyer"
    And The user sets the 'Garaging City' to "Chicago"
    And The user sets the 'Garaging Zip' to "60606"
    And The user sets the 'Email' to "abc123@gmail.com"
    And The user sets the 'Date of Birth' to "01/31/1970"
    And The user sets the 'Gender' to Male
    And The user sets the 'Marital status' to "Single"
    And The user sets the 'Credit score' to "Good"
    And The user sets the 'Employment status' to "Retired"
    And The user sets the 'Maintained Insurance' to "Yes, with no lapse in coverage"
    And The user sets the 'Own Home' to "Yes"
    And The user sets the 'Last 3 Years' to "No"
    And The user clicks on 'Continue'
    When The Initial Rate page loads
    Then The "Down Payment" should be "$61.00"
    And The "Second Payment" should be "$71.00"
    And The "Third Payment" should be "$71.00"
    And The "Fourth Payment" should be "$71.00"
    And The "Fifth Payment" should be "$71.00"
    And The "Final Payment" should be "$72.00"
    And The "Policy Term Total" should be "$417.00"
