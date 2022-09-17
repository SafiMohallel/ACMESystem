Feature: Login


 Scenario:  Login with valid username and valid password
    Given The user open the login page
    When The user enter a valid username <username>
    And The user enter a valid password <password>
    Then The system appear a successfull message "successfull message"

    Examples: 
      | username        | password    | 
      | SafiaMohallel   | a123456789  | 
      | SafiaMohallel2  | a123456789  |

 Scenario:  Login with invalid username or invalid password
    Given The user open the login page
    When The user enter an invalid username <username>
    And The user enter an invalid password <password>
    Then The system appear a successfull message <message> 

    Examples: 
      | username        | password    | message       |
      | SafiaMohallel   | a123456999  | login failed  |
      | SafiaMohallel5  | a123456789  | login failed  |
      | SafiaMohallel1  |             | login failed  |
      |                 | a123456789  | login failed  |
      | SafiaMohallel7  | a123666789  | login failed  |





