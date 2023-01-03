Feature: Login
  Perform login on username and password are inputted

  @login-feature
  Scenario Outline: Input username and password
    Given I have a login activity
    When I input username <username>
    And I input password "<password>"
    And I press submit button
    Then I should see on next activity

    Examples:
      | username | password    |
      | covid19  | 123456789 |
