@all
Feature: As a customer, when I click on “Pay my Bill”, I should be able to choose to see the bill
  that I ordered on my table

  @bill
  Scenario: Verification of display of bill
    Given user scans QR code on the table
    Then user should be able to see "Pay my Bill" option
    When user clicks on the "Pay the Bill" option
    Then user should be able to see information of his table
    Then user should be able to see his bill information
    And user should be able to see his bill amount

