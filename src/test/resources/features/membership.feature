@regression
  Feature: Adding a new membership
    @wip
    Scenario: User should be able to add a new member
      Given Navigate to home page
      When Send valid email and password
      And Proceed to captcha and click login button
      Then Verify that user is on the home page
      When Click Üyelerini Ekle bar
      And Click Yeni Liste Oluştur bar
      And Name the list as "firstList" and save it
      And Add new member using add with form