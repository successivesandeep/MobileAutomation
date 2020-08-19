Feature: Changes after creation of work order
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
#    And  I click on create button
#    Then I will see the work order created with title "Successive" and description "Organization"
#    Then I click on edit work order button
#
#  Scenario: I will edit the title,description and priority
#    And I Enter data in title field as "Shiwani"
#    And I Enter data in description field as "Sharma"
#    And I click on Save button
#    And I will see the work order created with title "Shiwani" and description "Sharma"
#    And I close app
#
#
#
#
