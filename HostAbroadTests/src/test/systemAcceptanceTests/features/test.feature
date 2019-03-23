Feature: Login Feature GitHub
  Verify if user is able to Login in to GitHub

  Scenario: Login as a authenticated user
    Given user is on GitHub page
    When user navigates to Login Page
    And user enters username and Password
    Then user sees their repositories