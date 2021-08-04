@accountCreationAndProductPurchase 
Feature: Account Creation and wishlist share 
Background: User Navigation 
	Given User Open the Home Page URL 
Scenario: 
	Check for the account creation wishlist share and then purchase the product 
	When User click on my account link 
	Then User Click on Create Account Button 
	Then User Enter the details 
	Then Verfiy User Account is created 
	Then User Add the product to wishlist 
	Then Verfiy the same product is added 
	Then click on wishlist share button 
	And Validate Wishlist is shared successfully 
	Then user click on Add to Cart link 
	Then verify same product is added to the cart 
	Then enter the billing details 
	Then validate the error fields 
	Then User click on Shipping information Continue button 
	Then User click on payment option 
	Then verify the product name and price
	Then user click on place order button
	Then verify order is placed successfully 
	
