Feature: Test CRM Application scenario

  Scenario: Test CRM login with valid credentials
    Given Open Chrome and start application
    When I enter valid username and valid password
    Then user should be able to login successfully
