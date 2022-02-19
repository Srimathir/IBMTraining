Feature: Create user/send email/edit profile in elearning website 

Scenario Outline: Create 10 users in elearning website 
	Given User should be on eleaning homepage 
	When Sign up button is visible click on sign up button 
	Then Enter First name "<FirstName>" 
	And Enter Last name "<LastName>" 
	And Enter email address "<Email>" 
	And Enter user name "<Uname>" 
	And Enter password "<pass>" 
	And Enter confirm password "<Cpass>" 
	And Click on register button 
	Then Verify message "Your personal settings have been registered." 
	
	Examples: 
		|FirstName|LastName|Email|Uname|pass|Cpass|
		|fname87|lname1|email1@gmail.com|uuname48|pass1|pass1|
		|fname2|lname2|email1@gmail.com|uuname2|pass2|pass2|
		|fname3|lname3|email1@gmail.com|uuname3|pass1|pass1|
		|fname4|lname4|email1@gmail.com|uuname4|pass1|pass1|
		|fname5|lname5|email1@gmail.com|uuname5|pass1|pass1|
		|fname6|lname6|email1@gmail.com|uuname6|pass1|pass1|
		|fname7|lname7|email1@gmail.com|uuname7|pass1|pass1|
		|fname8|lname8|email1@gmail.com|uuname8|pass1|pass1|
		|fname9|lname9|email1@gmail.com|uuname9|pass1|pass1|
		|fname10|lname10|email1@gmail.com|uuname10|pass1|pass1|
		
Scenario: Compose and send email 
	Given User logged in using the login credentials "uuname48"  and "pass1" 
	When User is on my course page 
	Then Click on compose button 
	And enter recepient details 
	And enter subject 
	And enter message 
	And clickon send message button 
	
Scenario: Edit profile 
	Given User logged in using the login credentials "testUN"  and "testPass" 
	When User clicked on edit profile 
	Then Upload image 
	And Enter skype details "skypedetails"
	Then save the changes 
	
	
	
	
	