Feature: Verify that you cannot add more product in cart than the product available in store
Scenario: Adding poduct to cart
	Given User Open the Home Page URL
	When User click on Mobile Button
	Then User click on Add To Cart button
	Then User change the QTY value to 1000
	Then Verify the Error Message
	Then Verfiy Cart is Empty