Feature: API Regression

  @api
  Scenario: Successful registration
    Given Create payload with "valid user"
    When User calls "RegisterAPI" with "POST" request
    Then The API call response status should be 200
    And Token should be present

  @add
  Scenario Outline: Failed registration
    Given Create payload using "<email>" and "<password>"
    When User calls "RegisterAPI" with "POST" request
    Then The API call response status should be 400
    And "error" should be "<errorMessage>"
    Examples:
      | email              | password | errorMessage                                  |
      | eve.holt@reqres.in |          | Missing password                              |
      |                    | pistol   | Missing email or username                     |
      |                    |          | Missing email or username                     |
      | e@e.com            | 111111   | Note: Only defined users succeed registration |

  @api
  Scenario: Get the list of
    Given Create empty payload
    When User calls "ListAPI" with "GET" request
    Then The API call response status should be 200
    And Response should have user list