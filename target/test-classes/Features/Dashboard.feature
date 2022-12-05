Feature: Dashboard
  
@current-implementation
@medium     
Scenario:  Check the label text 
    Given  The user open the login page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user check the remeber me check box
    And    The user click on submit button
    Then   The system should redirect to the dashboard page with the title "ACME System 1 - Dashboard"
    Then   The label text should be "Welcome, " plus "s.mahallel99@gmail.com" plus " to System 1."
 Examples: 
      | email                      | password    |
      | s.mahallel99@gmail.com     | 123456789a  |
      
@not-implemented-yet
@important 
Scenario Outline:  Check the buttons text and tool tip
    Given  The user open the login page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user check the remeber me check box
    And    The user click on submit button
    Then   The system should redirect to the dashboard page with the title "ACME System 1 - Dashboard"
    Then   The system appear the button text "<button text>" 
    And    The system appear First tool tip link "<first tooltip link>"
    And    The system appear First tool tip link "<second tooltip link>"
    And    The system appear First tool tip link "<third tooltip link>"
    And    The system appear First tool tip link "<forth tooltip link>"
    And    The system appear First tool tip link "<fifth tooltip link>"
    And    The system appear First tool tip link "<sixth tooltip link>"
    And    The system appear First tool tip link "<seventh tooltip link>"
    And    The system appear First tool tip link "<eighth tooltip link>"
    And    The system appear First tool tip link "<ninth tooltip link>" 

    Examples: 
      | email                      | password    | button text         | first tooltip link           | second tooltip link          | third tooltip link          | forth tooltip link         | fifth tooltip link   | sixth tooltip link | seventh tooltip link | eighth tooltip link | ninth tooltip link  |                                       
      | s.mahallel99@gmail.com     | 123456789a  | User options        | Download Client and Support  | Reset test data              | Change password             | Check training assignments |                      |                    |                      |                     |                     |
      | s.mahallel99@gmail.com     | 123456789a  | Work Items          |                              |                              |                             |                            |                      |                    |                      |                     |                     |
      | s.mahallel99@gmail.com     | 123456789a  | Accounts            | Add account modification     | View account history         |                             |                            |                      |                    |                      |                     |                     |
      | s.mahallel99@gmail.com     | 123456789a  | Checks              | Search for Check             | Submit Check Copy            |                             |                            |                      |                    |                      |                     |                     |
      | s.mahallel99@gmail.com     | 123456789a  | Vendors             | Search for Vendor            | Add Vendor                   | Download Resource Report    | Resource Order             | Download Vendor List | Vendor Inventory   | Upload Order         |Vendors Stock        | Create Order        |
      | s.mahallel99@gmail.com     | 123456789a  | Invoices            | Search for Invoice           | Add Invoice Details          | Delete Invoice              |                            |                      |                    |                      |                     |                     |
      | s.mahallel99@gmail.com     | 123456789a  | Internal Invoices   | Download Monthly Invoices    | Download Full Invoice Report |                             |                            |                      |                    |                      |                     |                     |
      | s.mahallel99@gmail.com     | 123456789a  | Reports             | Download Monthly Report      | Upload Yearly Report         |                             |                            |                      |                    |                      |                     |                     | 
      | s.mahallel99@gmail.com     | 123456789a  | Students            | Download Enrollment Report   | Download Result Report       | Score Card                  |                            |                      |                    |                      |                     |                     |
      | s.mahallel99@gmail.com     | 123456789a  | Health Care         | Download Daily Appointment   | Download Treatment Report    | National Insurance Planning |                            |                      |                    |                      |                     |                     |
      | s.mahallel99@gmail.com     | 123456789a  | Employees           |                              |                              |                             |                            |                      |                    |                      |                     |                     |
      | s.mahallel99@gmail.com     | 123456789a  | Bank                | Add Account                  |                              |                             |                            |                      |                    |                      |                     |                     |
      | s.mahallel99@gmail.com     | 123456789a  | Customer Service    |                              |                              |                             |                            |                      |                    |                      |                     |                     |
      
@not-implemented-yet
@important 
Scenario Outline:  Check the buttons redirect to other page
    Given  The user open the login page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user check the remeber me check box
    And    The user click on submit button
    Then   The system should redirect to the dashboard page with the title "ACME System 1 - Dashboard"
    When   The user clicks on the specific button "<button text>"
    Then   The system redirect to a page "<redirection page>" 
    
    Examples: 
      | email                      | password    | button text         | redirection page                                               
      | s.mahallel99@gmail.com     | 123456789a  | Work Items          | work-items
      | s.mahallel99@gmail.com     | 123456789a  | Employees           | employees
      | s.mahallel99@gmail.com     | 123456789a  | Customer Service    | callcenter
      
@not-implemented-yet  
@important 
Scenario:   Check the logout link
    Given  The user open the login page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user check the remeber me check box
    And    The user click on submit button
    Then   The system should redirect to the dashboard page with the title "ACME System 1 - Dashboard"
    When    The user clicks on the logout link
    Then    The system sign out
    And     The system redirect to the login page

  Examples: 
      | email                      | password    |
      | s.mahallel99@gmail.com     | 123456789a  |
      
@not-implemented-yet
@medium 
Scenario:   Check the home link
    Given  The user open the login page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user check the remeber me check box
    And    The user click on submit button
    Then   The system should redirect to the dashboard page with the title "ACME System 1 - Dashboard"
    When    The user clicks on the home link
    Then    The system do nothing
  Examples: 
      | email                      | password    |
      | s.mahallel99@gmail.com     | 123456789a  |
      
@not-implemented-yet
@medium 
Scenario:   Check the switch to old theme link
    Given  The user open the login page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user check the remeber me check box
    And    The user click on submit button
    Then   The system should redirect to the dashboard page with the title "ACME System 1 - Dashboard"
    When    The user clicks on the Switch to old theme link
    Then    The system apply the new theme 
     Examples: 
      | email                      | password    |
      | s.mahallel99@gmail.com     | 123456789a  | 
    
    
    
    
    
    
    
    
    
    
    
    
    
