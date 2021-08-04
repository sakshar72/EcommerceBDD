Feature: Change and Reorder added product 
Scenario: verify you are able to Change and Reorder added product 
	Given User Open the Home Page URL 
	When User click on my account link 
	Then User enter login credentials
	And click on Login Button
	Then Verify the user creentials
	Then Verify the product
	Then click on Reorder button
	Then Verify the product name to be reordered
	Then change the product quantity
	Then Verify the Product quantity and Price
	Then click on Continue button
	