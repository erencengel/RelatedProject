@regression
Feature: Login functionality
  @wip
  Scenario: User should be able to login with valid credentials(Positive Scenario)
    Given Navigate to home page
    When Send valid email and password
    And Proceed to captcha and click login button
    Then Verify that user is on the home page

  Scenario Outline: User should not be able to login with valid credentials(Negative Scenario)
    Given Navigate to home page
    When Send invalid "<email>" and "<password>"
    And Proceed to captcha and click login button
    Then Verify that user can not login
    Examples:
    #blank-blank
    #blank-valid password
    #blank-wrong password
    #valid email-blank
    #wrong email-blank
    #wrong email-wrong password
    |email               |password   |
    |                    |           |
    |                    |Ec.06050425|
    |                    |abc123     |
    |erencengel@gmail.com|           |
    |abc123              |           |
    |abc123              |abc123     |


    Scenario: User should be able to see 'This field is required' warning when name is blanked
      Given Navigate to home page
      When Click the email button and leave it blank
      And Click the password button
      Then Verify that warning is seen under email tab

    Scenario: User should be able to see 'This field is required' warning when password is blanked
      Given Navigate to home page
      When Sends a space String to the password button
      And Click the email button
      Then Verify that warning is seen under password tab

    Scenario: User should be able to get a new password by using 'ForgetMyPassword' bar
      Given Navigate to home page
      When Click ForgetMyPassword bar
      And Send a valid email as "erencengel@gmail.com" and verify captcha step
      And Click send button
      Then Verify that email is successfully sent
