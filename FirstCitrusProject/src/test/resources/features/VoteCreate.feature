Feature: Create voting

  As a user I want to create new votings. Each voting is given default vote  options.
  The user should be able to set custom vote options.

  Scenario: Default voting options
  	Given New default voting
    When I create new voting
    Then voting title should be "Do you like Mondays?"