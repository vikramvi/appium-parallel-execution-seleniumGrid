Feature: Verify WL Sign In Page related user stories

Scenario: Verify Sign in button remains disabled state if only email id is entered
 Given User is on Sign In Page
 When User taps Forgot your password link
 Then  User completes reset password actions
