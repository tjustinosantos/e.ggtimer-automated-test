# E.ggtime Automated Test

### About the project

Simple Test to validate the countdown provided by https://e.ggtimer.com/

### Project Dependencies

* Maven version 3.5.0
* Java version 11
* Selenium Webdriver 3.141.59
* [Chromedriver 89.0.4389.23](https://chromedriver.storage.googleapis.com/index.html?path=89.0.4389.23/)
* Chrome Browser (tested with Version 89.0.4389.90)
   

### Project Structure

               .
               +-- src
                  +-- test
                  |   +-- java
                  |   |  +-- page
                  |   |      +-- CountDownPage
                  |   |      +-- HomePage
                  |   |      +-- Page
                  |   |  +-- stepdefinition
                  |   |      +-- StepDefinition
                  |   |      +-- CucumberConfigTest
                  |   +-- resources
                  |            +-- features
                  |               +-- countdown.feature
               +-- .gitignore
               +-- pom.xml
               +-- README.md

### Installation Instructions

* Download and extract [Chromedriver](https://chromedriver.storage.googleapis.com/index.html?path=89.0.4389.23/)
* Start it:
             $chromedriver start
  
  
It should start locally at localhost:9515, which is address that the project is already set for connection.

* Project Installation

             $ git clone https://gitlab.com/thiagojsantos/e.ggtimer-automated-test.git
             $ mvn clean install


### Running Tests

            $ mvn test
            