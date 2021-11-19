Feature: Test sample Rest Api test 
  I want to use this template for my feature file
  @API
  Scenario Outline: Get 200 response
    Given I have sample requestGetRequest "https://reqres.in/api"
    When header resourceid is <resourceId> 
    And header Content-Type is "application/json"
    And header citrus_http_method is "GET"
    Then header citrus_http_status_code is <hTTPStatusCode>
    

  Examples:
     | resourceId | hTTPStatusCode |
     | "/unknown" | 200            |
