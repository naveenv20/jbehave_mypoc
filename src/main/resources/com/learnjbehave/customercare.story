Narrative:
In order to check the customer care page
As a Test team
I want to login into flipkart and needs to navigate to customer care page and check

Scenario: customer care page checks

Given The browser <browsertype> is opened
Then User opens the <URL>
Then user clicks on the customercare link
Then user select the case as <case_type>
Then user selects the <question_number>
Then user ends the test case and closed the browser

Examples:
|browsertype|URL|case_type|question_number|
|Firefox|http://www.flipkart.com/|Offers Redemption|2|
|Firefox|http://www.flipkart.com/|Offer Redemption|4|