Feature: Change password functionality

  Background: Login with valid user credential and navigat to change password page
    Given I launch app
    And   I login with credential
      | userEmail                   | password   |
      | payalgaur151@mailinator.com | 1234567890 |
    When I click on Menu button
    And  I click on change password button

  Scenario: See message when new password and confirm password are less than required minimum length
    When I enters current password, new password and confirm password are
      | currentPassword | newPassword | confirmPassword |
      | 1234567890      | @#$%^       | @#$%^           |
    And   I Click on submit button
    Then  I see the error message saying "Password length should be between 8 to 20 characters."
    And   I Accept the dialog box

  Scenario: See message if current password is incorrect
    When I enters current password, new password and confirm password are
      | currentPassword | newPassword | confirmPassword |
      | @#$ffjs2345     | 1234567890  | 1234567890      |
    And   I Click on submit button
    Then  I see the error message saying "Entered current password is wrong. Please enter correct current password."
    And   I Accept the dialog box

  Scenario: See message if new password and confirm password are not same
    When I enters current password, new password and confirm password are
      | currentPassword | newPassword | confirmPassword |
      | 1234567890      | Shiwani@123 | Sharma@123      |
    And   I Click on submit button
    Then  I see the error message saying "New Password and Confirm Password doesn't match..!"
    And   I Accept the dialog box

  Scenario: See message if required fields are blank
    Then I can see message when required field is missing
      | currentPassword | newPassword | confirmPassword | message                                            |
      |                 |             |                 | Password field can't be empty.                     |
      |                 | Shiwani@123 |                 | Password field can't be empty.                     |
      | 1234567890      |             |                 | Password field can't be empty.                     |
      |                 |             | Shiwani@123     | Password field can't be empty.                     |
      |                 | Shiwani@123 | Shiwani@123     | Password field can't be empty.                     |
      | 1234567890      | Shiwani@123 |                 | New Password and Confirm Password doesn't match..! |
      | 1234567890      |             | Shiwani@123     | Password field can't be empty.                     |

    And   I Accept the dialog box

  Scenario: See message if current password, new password and confirm password are same
    When I enters current password, new password and confirm password are
      | currentPassword | newPassword | confirmPassword |
      | 1234567890      | 1234567890  | 1234567890      |
    And   I Click on submit button
    Then  I am able to see profile detail
      | name       | email                       | contactNumber |
      | Payal Gaur | payalgaur151@mailinator.com | 987654323456  |





