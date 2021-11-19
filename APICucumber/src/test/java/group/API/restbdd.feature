Feature: End to End Test for Tools Qa Book store

Background: User generates token for Authorisation
Given: I am an authorized user

Scenario: Verify one value of the webservice
Given: I Perform GET operation "/id"
And: I Perform get operation for id "5"
Then: I Should see the winnerId "23"