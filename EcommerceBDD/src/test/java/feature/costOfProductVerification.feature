Feature: Verify the cost of the product in list page and details 
Background: User Navigation 
	Given User Open the Home Page URL 
	When User click on Mobile Button 
	
Scenario:
	On Mobile Page the Verify the cost of the product in list page and details 
	Then Read the cost of Sony Xperia Mobile
	And Click on Sony Xperia Mobile
	Then Read the Price of Sony Xperia Mobile from Details Page 
	And Verify the two values to be equal
