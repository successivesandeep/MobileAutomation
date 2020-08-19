Feature: Preview of work order before final creation of work order
#
#  Background:
#    Given I launch app
#    And   I login with credential
#      | userEmail                   | password   |
#      | payalgaur151@mailinator.com | 1234567890 |
#    When I click on Add work order button
#    And I Enter data in title field as "Successive"
#    And I Enter data in description field as "Organization"
#    And I select date in due date field
#    And I select "ACTIVITY FACILITY one" in facility field
#    And I select "Bbbbb" in unit field
#    And I select "Shashank Gwari" in assign to field
#    And I select "Low" in priority field
#    And I select "Customer Complaint" in category field
#    And I check checkboxes in notification field
#    And I check checkbox of "Shashank Gwari" in watchers field
#    And  I click on Preview button
#
#  Scenario: Preview of work order before final creation of work order
#    And   I will see the heading as "Preview"
#    Then  I will see the work order created with title "Successive" and description "Organization"
#    And   I close app
#
#
#  Scenario: Creation of work order after seeing preview
#    And   I will see the heading as "Preview"
#    Then  I will see the work order created with title "Successive" and description "Organization"
#    Then  I click on create button of preview screen
#    Then  I will see the work order created with title "Successive" and description "Organization"
#    And   I close app
#
#
#  Scenario: Cancelling the work order creation from preview screen
#    And   I will see the heading as "Preview"
#    And   I clicks on back button
#    And   I cancel the work order creation
#    And   I close app
#
#
