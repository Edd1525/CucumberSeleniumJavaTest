Feature: Sing Up
  As a customer
  I want to be able to sing up into the application
  so I can create a new account

  Scenario Outline: Sing Up should be Success with email
    Given I am a new user
    When I provide all valid required data <name> <last name> <password> <birthday> <sex>
    And I provide a valid <email>
    And I validate the facebook mail in the inbox
    Then I should be able to create my facebook account
    Examples:
      | name   | last name  | email            | password | birthday   | sex  |
      | Edward | Bustamante | edward@gmail.com | 123      | 10/01/1889 | Male |
  # For this type of scenario when a large amount of data is required, it is better to handle it in a .json

  Scenario Outline: Sing Up should be Success with phone number
    Given I am a new user
    When I provide all valid required data <name> <last name> <password> <birthday> <sex>
    And I provide a valid <phoneNumber>
    And I validate the code message in the application
    Then I should be able to create my facebook account
    Examples:
      | name   | last name  | phoneNumber     | password | birthday   | sex  |
      | Edward | Bustamante | +(57) 300000000 | 123      | 10/01/1889 | Male |

  Scenario Outline: Sing Up with invalid email should be failed
    Given I am a new user
    When I provide all valid required data <name> <last name> <password> <birthday> <sex>
    And I provide a invalid <email>
    Then I should see a <invalid message>
    Examples:
      | name   | last name  | email            | password | birthday   | sex  | <invalid message> |
      | Edward | Bustamante | edward@gmail.com | 123      | 10/01/1889 | Male | invalid email     |

  Scenario Outline: Sing Up should mark in red the missing fields
    Given I am a new user
    When I forgot fill 1 or more fields required <name> <last name> <password>
    Then I should see the forgotten fields in red
    Examples:
      | name   | last name  | password |
      | Edward | Bustamante | 123      |

  Scenario Outline: Sing Up with user that exists should be failed
    Given I am a new user
    When I provide all valid required data <name> <last name> <password> <birthday> <sex>
    And I provide an email that has been used
    Then I should see a message showing this Email is already in used
    Examples:
      | name   | last name  | email            | password | birthday   | sex  |
      | Edward | Bustamante | edward@gmail.com | 123      | 10/01/1889 | Male |