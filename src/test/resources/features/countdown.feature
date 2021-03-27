Feature: Test countdown feature from Eggtimer Website

    Scenario: Countdown is happening every 1 second
        Given I visit e.ggtimer website
        And the page is completely loaded
        When I enter 25 seconds
        And I click on Start button to initiate the countdown
        Then the remaining time decreases in 1 second increment

    Scenario: Countdown is happening
        Given I visit e.ggtimer website
        And the page is completely loaded
        When I enter 25 seconds
        And I click on Start button to initiate the countdown
        Then the countdown is happening
