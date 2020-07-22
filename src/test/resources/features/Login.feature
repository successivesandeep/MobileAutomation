Feature: Login

  Scenario: Login with valid user credential
    When user enters emailId as "payalgaur151@mailinator.com"
    And user enters password as "1234567890"
    And user clicks on SignIn Button

  Scenario: Login with valid email and wrong password
    When user enters emailId as "payalgaur151@mailinator.com"
    And user enters password as "0987654321"
    And user clicks on SignIn Button

  Scenario: Login with invalid user credential
    When user enters emailId as "xyz@gmail.com"
    And user enters password as "12345678"
    And user clicks on SignIn Button