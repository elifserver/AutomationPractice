Feature: WEB UI Regression

  Background:
    Given User landed to Automation Practice home page

  @web
  Scenario Outline: Signin Automation Practice Website - Fauilure cases
    Given User clicks Signin
    When User sends "<email>" and "<password>"
    Then User should get "<error>" on the page
    Examples:
      | email   | password | error                      |
      |         |          | An email address required. |
      | e@e.com |          | Password is required.      |
      |         | 1111     | An email address required. |
      | e@e.com | 111111   | Authentication failed.     |



