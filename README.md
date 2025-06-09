
## Project Title:
Test sample with cucumber with selenium web driver on ACME website.
## Website:
https://acme-test.uipath.com/


## Motivation:
Sample for using selenium with cucumber BBD framework for sample practicing purpose 



## Build Status:
--
## Code Style:
Standard
## Screenshot:
--
## Technology/Framework Used: 
Technology Used : Java, Cucumber, Selenium, Maven
Framework Used: Page Object Model
## Features:
This project will help Automation Testing Companies to test their application using automation to reduce the manual time using the features files of cucumber and explain the structure of the cucumber project like hook file and inheritance form base class and separate web-driver locators on step definition file and page classes, and apply the config.properties with some utilities beside the features files and generated screen shots and reports
## Installation:
--
## API Reference:
--
## Tests and How to use:
-Open the required feature file to run
-Use annotation @current-implementation on the desired test case
-Click Run As maven test from pom.xml OR
-Click Run As JUnit Test from Runner/Test.java
-All Test cases with annotation @implemented are coded already
-All Test cases with annotation @not-implemented-yet are not coded yet
## Contribute:
-We need to improve the using of implicit waits or fluent waits instead of thread.sleep
-We need to using for-each instead of looping with counter as a step to clean code
## Credits:
--
## License:
--
## Tech Stack

- **Language**: Java  
- **Testing Framework**: TestNG  
- **Build Tool**: Maven  
- **Automation Tool**: Selenium WebDriver  
- **Design Pattern**: Page Object Model (POM)  
- **Reports**: TestNG HTML Report

##  Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/SafiMohallel/ACMESystem.git
cd ACMESystem
```

### 2. Prerequisites

- Java 11 or higher installed
- Maven installed

### 3. Run the Tests

```bash
mvn clean test
```

### 4. Generate HTML Report

Open `test-output/index.html` in your browser after test execution.

## Test Coverage

- [x] Login functionality  
- [x] Search scenarios  
- [x] UI validations  
- [ ] API integration *(Optional to add)*  
- [ ] Performance hooks *(Optional to add)*

## Future Enhancements

- GitHub Actions CI Integration  
- Dockerized test environment  
- Allure Reporting  
- Multi-browser support

## Author

**Sofia Mohallel**  
[GitHub Profile](https://github.com/SafiMohallel)  
[LinkedIn](https://www.linkedin.com/in/safia-mohallel-53aa4718/)
