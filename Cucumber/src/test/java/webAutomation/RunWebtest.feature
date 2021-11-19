@All
Feature: Test the FreshToHome dashboard page

#DataDriven Test in Cucumber Without Examples  
@Smoke
	 Scenario: Login to FreshToHome Parameterization without Examples
	 	Given The webpage is launched
	 	When I enter "8939216645" and "Test@123"
	 	Then I logged into the application

#DataDriven Test in Cucumber With Examples	 	
@Regression
   Scenario: Add one item to cart using Examples
    Given Page already launched
    When I click on item
    Then Item is added to cart
    And  Verify the item   
    
#DataDriven Test in Cucumber with Datatables
@Prod
   Scenario: Login to Freshtohome using DataTable
    Given Page already launched
    When User click on login button
    And User enters username and password     
  	| 8939216645 | Test@123 |
  
  	But User should not see error