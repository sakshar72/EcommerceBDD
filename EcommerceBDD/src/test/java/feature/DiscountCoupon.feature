Feature: Discount Code 
Scenario: Verify to successfully apply discount coupons 
	Given User Open the Home Page URL 
	When User click on Mobile Button
	Then User click on Add To Cart button
	Then Verify the product name to be reordered
	Then user add the coupon code
	And Click on Coupon code Apply button
	Then Verify the discounted price
	
	
	
	
