Feature: Mobile Listing Page Items are sorted by Name 
Background: User Navigation 
	Given User Open the Home Page URL 
	
	
Scenario: 
	On Mobile Page the user should be able to sort the listed products by name parameter 
	Then Verfiy the Title of the Page 
	When User click on Mobile Button 
	Then Verfiy title of the Page 
	And Select SORT BY name in the dropdown 
