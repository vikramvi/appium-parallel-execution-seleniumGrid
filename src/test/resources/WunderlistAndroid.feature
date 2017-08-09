Feature: Verify WL Sign In Page related user stories

Scenario: Verify Sign in button remains disabled state if only email id is entered
 Given User is on Sign In Page
 When User enters valid email id
 And   User keeps password field empty
 Then  Sign In button remains in disabled state
