Feature: Login
 

@medium    
Scenario:  Check the page title 
    Given  The user open the login page
    Then   The page title should be is "ACME System 1 - Log In"
 
 @important       
Scenario Outline:  Enter a wrong password for the email registered before
    Given  The user open the login page
    When   The user enter an email not registered before "<email>"
    And    The user enter an invalid password "<password>"
    Then   The system appear an error message "<error message>"

    Examples: 
      | email                      | password | error message                               | 
      | s.mahallel99@gmail.com     |1231234as | These credentials do not match our records. | 
  
@currentTrace
 Scenario Outline:  Enter empty value in email field
    Given  The user open the login page
    When   The user enter empty value in email field "<email>"
    Then   The system appear an error email tooltip "<error tooltip>"

    Examples: 
      | email           | error tooltip              | 
      |                 | Please fill out this field.| 
  
     
    
    
    
@medium     
Scenario:  Check the intial status of remember me check box
    Given  The user open the login page
    Then   The remember me  check box is unchecked

@medium     
Scenario:  Check the Copyright year
    Given  The user open the login page
    Then   The Copyright year should be the actual year

@medium     
Scenario:  Check the label text 
    Given  The user open the login page
    Then   The label texts should be "Login" and "Home" and "To continue, please authenticate here" and  "Email:" and "Password:"
    
@important      
Scenario Outline:  Enter with valid email and password
  Given    The user open the login page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user check the remeber me check box
    Then   The system should redirect to the dashboard page

      Examples: 
      | email                     | password
      | s.mahallel99@gmail.comb   | 123456789a   
          

@low 
Scenario Outline:  Enter empty value in password field
    Given  The user open the login page
    When   The user enter empty value in password field "<password>"
    Then   The system appear an error password tooltip "<error tooltip>"

    Examples: 
      | password           | error message               | 
      |                    | Please fill out this field  | 
      
@medium                  
Scenario Outline:  Enter invaled email formate in email field
    Given  The user open the login page
    When   The user enter an invalid Email "<email>"
    Then   The system appear an error message "<error message>"

    Examples: 
      | email        | error message            | 
      | testets      | Please enter true Email  | 
      | test@test    | Please enter true Email  | 
      | test.test    | Please enter true Email  | 
      
@important        
Scenario Outline:  Enter with email not registered before
    Given  The user open the login page
    When   The user enter an email not registered before "<email>"
    Then   The system appear an error message "<error message>"

    Examples: 
      | email                      | error message                               | 
      | s.mahallel9999@gmail.com   | These credentials do not match our records. | 
      
    
@medium 
Scenario:   Check the login link
    Given   The user open the dashboard page
    When    The user clicks on the logout link
    Then    The system do nothing

@medium 
Scenario:   Check the home link
    Given   The user open the dashboard page
    When    The user clicks on the home link
    Then    The Login page appear
    
@medium 
Scenario:   Check the Switch to old theme link
    Given   The user open the dashboard page
    When    The user clicks on the Switch to old theme link
    Then    The system apply the new theme 
    
      
       
       