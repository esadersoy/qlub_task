@all

Feature: As a customer, when I scan the QR code, I should be able to choose to see restaurant’s menu

    @menu
    Scenario: Verification of display of the menu
      Given user scans QR code on the table
      Then  user should be able to choose "View the Menu" option
      When user clicks on the "View the Menu" option
      Then user should be displayed "Diner's QA" menu
      And menu should be displayed as pdf file to the user

