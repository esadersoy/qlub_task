@all

Feature:  As a customer, when I see the bill, I should be able to see the payment option, which are
  card payment or wallet payment (ApplePay/GooglePay)

  @cardpayment @option
  Scenario: Verification of the card payment
    Given user scans QR code on the table
    Then user should be able to see "Pay the Bill" option
    When user clicks on the "Pay the Bill" option
    Then user should able to see card payment option

  @applepay @option
  Scenario: Verification of the apple pay
    Given user scans QR code on the table
    Then user should be able to see "Pay the Bill" option
    When user clicks on the "Pay the Bill" option
    Then user should able to see apple pay option

  @googlepay @option
  Scenario: Verification of the google pay
    Given user scans QR code on the table
    Then user should be able to see "Pay the Bill" option
    When user clicks on the "Pay the Bill" option
    Then user should be able to see google pay option