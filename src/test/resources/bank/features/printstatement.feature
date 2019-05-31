Feature: Print Statement

  Scenario: A few transactions
    Given a client makes a deposit of 1000 on 10-06-2019
    And a deposit of 2000 on 13-06-2019
    And a withdrawal of 500 on 14-06-2019
    When she prints her bank statement
    Then she would see
        """
        date       || credit   || debit    || balance
        14/06/2019 ||          || 500.00   || 2500.00
        13/06/2019 || 2000.00  ||          || 3000.00
        10/06/2019 || 1000.00  ||          || 1000.00
        """
