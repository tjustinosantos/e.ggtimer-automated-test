# E.ggtime Automated Test

### About the project

Simple Test to validate the countdown provided by https://e.ggtimer.com/

### Project Dependencies

* Maven version 3.5.0
* Java version 1.8
* Selenium Webdriver 2.44.0

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

* Project Installation

             $ git clone https://gitlab.com/thiagojsantos/e.ggtimer-automated-test.git
             $ mvn clean install


### Running Tests

            $ mvn test
            