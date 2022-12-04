Feature: Work Item

@implemented
@Autom  
Scenario:  Check the items of type WI5 
    Given    The user open the login page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user check the remeber me check box
    And    The user click on submit button
    Then   The system should redirect to the dashboard page with the title "ACME System 1 - Dashboard"
    Given  The user open the Work Items
    And    check that only 15 items of type "WI5" is presented
      Examples: 
      | email                      | password    |
      | s.mahallel99@gmail.com     | 123456789a  |
      
@implemented     
@medium     
Scenario:  Check that item details shows the right values
   Given    The user open the login page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user check the remeber me check box
    And    The user click on submit button
    Then   The system should redirect to the dashboard page with the title "ACME System 1 - Dashboard"
    Given  The user open the Work Items
    And    Choose a random item and save the data of random item
    When   Click symbol search
    Then   Work Item details appear with the header "Work Items - Work Item Details"
    And    The url contain the the WIID of the seleced random item
    And    Under Work Item Details section shows the right data (WIID_Type_Status_Date) of selected random item
    When   User click on button Update Work Item
    Then   A new windows pop Up with the header "ACME System 1"
    Given  The User change the status of the item to rejected
    When   The user click on Update Work Item
    Then   An alert with following appears "Please fill in the complete update form!"
    Given  The user add comment "test comment" and click again on Update Work Item
    Then   An alert with following appears "Work Item was updated accordingly"
    Given  The user navigate back to work item table and check the status of random selected item
    Then   The item status is changed to "Rejected"
  		Examples: 
      | email                      | password    |
      | s.mahallel99@gmail.com     | 123456789a  |

@implemented  
@important      
Scenario Outline:  Change items status
    Given  The user open the login page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user check the remeber me check box
    And    The user click on submit button
    Then   The system should redirect to the dashboard page with the title "ACME System 1 - Dashboard"
    Given  The user open the Work Items
    And    The user choose item  "<WIID>"
    When   Click symbol search
    Then   Work Item details appear with the header "Work Items - Work Item Details"
    When   User click on button Update Work Item
    Then   A new windows pop Up with the header "ACME System 1"
    Given  The User change the status of the item to "<Status>" and add comment and click on Update Work Item
    Then   Then an alert with following appears "Work Item was updated accordingly"
    Given  The user navigate back to work item table and check the status of random selected item
    Then   The item status is changed to "<Status>"
    Given  The user click on reset data
    Then   "Account - Reset Test Data" appear
    When   The user click on Reset Test Data
    Then   Progress bar appear
    And    Alert with the following appear "Your Test Data has been successfully reset."
    When   The user click OK 
    Then   The alert disappear and the progress bar
    And    The data in Work item table is reseted

      Examples: 
      | email                      | password    | WIID       | Status   |
      | s.mahallel99@gmail.com     | 123456789a  | 88014979   | Completed|
      | s.mahallel99@gmail.com     | 123456789a  | 88014991   | Rejected |
          
