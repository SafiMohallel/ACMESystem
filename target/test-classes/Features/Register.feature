Feature: Register

@not-implemented-yet
@low 
 Scenario Outline:  Enter empty value in email field
    Given  The user open the registration page
    When   The user enter empty value in email field "<email>"
    Then   The system appear an error message in registration page under email "<error message>"

    Examples: 
      | email           | error message               | 
      |                 | Please fill out this field  | 

@not-implemented-yet
@low 
Scenario Outline:  Enter empty value in password field
    Given  The user open the registration page
    When   The user enter empty value in password field "<password>"
    Then   The system appear an error message in registration page under password "<error message>"

    Examples: 
      | password           | error message               | 
      |                    | Please fill out this field  | 

@not-implemented-yet 
@low 
Scenario Outline:  Enter invalid value password field
    Given  The user open the registration page
    When   The user enter invalid value in password field "<password>"
    Then   The system appear an error message in registration page under password "<error message>"

    Examples: 
      | password           | error message               | 
      | abc                | The password must be at least 8 characters  | 
@not-implemented-yet
@low       
Scenario Outline:  Enter empty value in retype password field
    Given  The user open the registration page
    When   The user enter empty value in retype password field "<retypepassword>"
    Then   The system appear an error message in registration page under password "<error message>"

    Examples: 
      | retypePassword  | error message               | 
      |                 | Please fill out this field  | 

@implemented
@medium                  
Scenario Outline:  Enter invaled email formate in email field
    Given  The user open the registration page
    When   The user enter an invalid Email "<email>"
    Then   The system appear an error message in registration page under email "<error message>"

    Examples: 
      | email        | error message            | 
      | testets      | Please enter true Email  | 
      | test@test    | Please enter true Email  | 
      | test.test    | Please enter true Email  | 

@implemented 
@important        
Scenario Outline:  Registration with a valid email exists before
    Given  The user open the registration page
    When   The user enter a valid email exists before "<email>"
    And    The user enter a valid password in registration page  "<password>"
    And    The user enter a valid retypepassword in registration page "<retypepassword>"
    And    The user click on register button
    Then   The system appear an error message in registration page under email "<error message>"

    Examples: 
      | email                    | password        | retypepassword | error message                     | 
      | s.mahallel99@gmail.com   | 12345678S       | 12345678S      | The email has already been taken. | 

@implemented
@medium       
Scenario Outline:  Enter differnt password from retype password
    Given  The user open the registration page
    When   The user enter a valid username in registration page "<email>"
    And    The user enter a valid password in registration page  "<password>"
    And    The user enter a valid retypepassword in registration page "<retypepassword>"
    And    The user click on register button
    Then   The system appear an error message in registration page under password "<error message>"

    Examples: 
      | email                     | password        | retypepassword | error message  														|
      | s.mahallel99@gmail.comb   | 123456789       | 12345678S      | The password confirmation does not match.  |

@implemented
@medium 
Scenario Outline:  Uncheck the captcha check box
    Given  The user open the registration page
    When   The user enter a valid username in registration page "<email>"
    And    The user enter a valid password in registration page  "<password>"
    And    The user enter a valid retypepassword in registration page "<retypepassword>"
    And    The user uncheck the captcha
    And    The user check the terms ofuse and privacy policy
    And    The user click on register button
    Then   The system appear an error message in registration page under captcha "<error message>"

   Examples: 
      | email                     | password    | retypepassword | error message                         | 
      | s.mahallel99@gmail.comb   | 123456789a  | 123456789a     | Please validate that you are a human! | 
      
@implemented
@medium     
Scenario:  Check the intial status of the check boxes
    Given  The user open the registration page
    When   The user does not enter any data
    Then   The terms ofuse and privacy polic check box is unchecked
    And    The captcha check box is unchecked

@implemented
@medium     
Scenario:  Check the Copyright year
    Given  The user open the login page
    Then   The Copyright year should be "Copyright © "+the actual year +" ACME Systems" 

@implemented
@medium     
Scenario:  Check the label text 
    Given  The user open the registration page
    When   The user does not enter any data
    Then   The label text should be is "label text"

@implemented
@low     
Scenario:  Check the page title 
    Given  The user open the registration page
    When   The user does not enter any data
    Then   The page title should be is "ACME System 1 - Register"
       
@not-implemented-yet
@important      
Scenario Outline:  Enter true values in all fields
  Given    The user open the registration page
    When   The user enter a valid username in registration page "<email>"
    And    The user enter a valid password in registration page  "<password>"
    And    The user enter a valid retypepassword in registration page "<retypepassword>"
    And    The user check the captcha
    And    The user check the terms ofuse and privacy policy
    And    The user click on register button
    Then   The system should redirect to the dashboard page with the title "ACME System 1 - Dashboard"

      Examples: 
      | email                     | password    | retypepassword | 
      | s.mahallel99@gmail.comb   | 123456789a  | 123456789a     | 
      


