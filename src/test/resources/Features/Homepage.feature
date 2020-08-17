Feature: Navigate to the Royal Bank of Scotland site
 Scenario Outline: Open the browser and navigate to the site
Given Open site in "<browser>"  
When navigate to the site
Then verify the home page title
And click view all article button


Examples: Different browser parameter
      		|browser|
      		|edge|
      		|chrome|
      		|firefox|
      		
      		
      		