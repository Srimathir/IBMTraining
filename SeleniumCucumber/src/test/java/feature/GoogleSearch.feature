Feature: Search in google 

#Scenario: Enter a text in search bar 
#	Given User should be on google homepage 
#	When the search bar is visible 
#	Then Enter text entering text 
	
	
Scenario: Register in janbasktraining website 
	Given User should be on janbasktraining register page 
	When  Register Now form is visible 
	Then Enter your name 
	And Enter mobile number 
	And Select course 
	And Enter email 
	And Retype email 
	And  Enter password 
	And Confirm password 
	And Check agree T&C checkbox 
	Then Click on Sign Up button