Narrative:
In order to login into google
As a Test team
I want to use an interface and implementation in Java 

Scenario: Login into ebay

Given The browser <browsertype> is opened
Then User opens the <URL>
Then I will enter the login name as <login_name> and password as <password>
Then I will hit enter
Then I will check whether the login is successfull or not

Examples:
|browsertype|URL|login_name|password|
|Firefox|http://www.flipkart.com|naveen_v201985@rediffmail.com|greffendor8*|