Narrative:
In order to search into flipkart site
As a Test team
I want to use an interface and implementation in Java 

Scenario: Search for items in flipkart

Given The browser <browsertype> is opened
Then User opens the <URL>
Then the user logs into the system with the <username> and <password>
Then user searhces for <searchvalue>
Then selects the Third item from the search results
And View the item

Examples:
|browsertype|URL|username|password|searchvalue|
|Firefox|http://www.flipkart.com/|naveenkv20@gmail.com|test123|timex watch|