Feature: Notification

  Background:
    Given I launch app
    And I login with credential
      | userEmail                   | password   |
      | payalgaur151@mailinator.com | 1234567890 |

  Scenario: Delete single notification
    When I navigate on "Notifications" pages
    Then I can delete a notification
    And I close app

  Scenario: Mark all notification as Read
    When I navigate on "Notifications" pages
    And I click on "Mark All as Read" button
    Then I can see popup with message "Are you sure want to read all"
    When I click on "OK" button
    Then I can see all notification marked as read
    And I close app

  Scenario: Cancel the marking all notification as read
    When I navigate on "Notifications" pages
    And I click on "Mark All as Read" button
    When I click on "CANCEL" button
    And I close app

  Scenario: Mark as read button disabled if going to mark already read notification
    When I navigate on "Notifications" pages
    Then I can mark a notification as read
    And I close app


