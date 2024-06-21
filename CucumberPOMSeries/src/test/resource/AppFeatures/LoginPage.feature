Feature: Login page feature

  @tag1
  Scenario: Login page Title
    Given user is on login page
    When user enters username "standard_user"
    When user enters password "secret_sauce"
    Then page title should be "Swag Labs"
