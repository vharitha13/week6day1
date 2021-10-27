Feature: LeafTaps functionailities

Background: 
Given Open the Chrome browser
And Launch the URL as 'http://leaftaps.com/opentaps/control/login'
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click on login button
Then Homepage should be displayed
When Click on 'CRM/SFA' link
Then 'My Home' page should be displayed

Scenario Outline: Create a new lead

When Click on 'Leads' link
Then 'My Leads' page should be displayed
When Click on 'Create Lead' link
And Enter the company name as '<Company>'
And Enter the first name as '<FirstName>'
And Enter the last name as '<LastName>'
When Click on Create Lead button
Then Verify creation of the lead

Examples:
|Company|FirstName|LastName|
|Amazon|Haritha|Velpur|
|Amazon|Anne|Christina|

Scenario: Duplicate Lead

When Click on 'Leads' link
Then 'My Leads' page should be displayed
When Click on 'Find Leads' link
And Enter the first name as 'Haritha' to check duplication
When Click on Find Leads button
Then Click on first item in the list
When Click on 'Duplicate Lead' link
Then 'Create Lead' page should be displayed
When Click on Create Lead button
Then Verify if duplicate lead is created

Scenario Outline: Edit the company name of the lead

When Click on 'Leads' link
Then 'My Leads' page should be displayed
When Click on 'Find Leads' link
And Input the first name as '<FirstName>'
And Input the last name as '<LastName>'
When Click on Find Leads button in edit
Then Click on first item in the list for editing
When Click on 'Edit' link
And Change the company name to '<Company>'
When Click on Update button
Then Verify if company name is updated

Examples:
|Company|FirstName|LastName|
|TCS|Haritha|Velpur|
|TCS|Anne|C|

Scenario: Merge two leads

When Click on 'Leads' link
Then 'My Leads' page should be displayed
When Click on 'Merge Leads' link
Then 'My Leads' page should be displayed
When Click on From Lead button
And Enter the from first Name as 'Haritha'
When Click on Find Leads button for merging
Then Click on From first item in the list
When Click on To Lead button
And Enter the to first Name as 'Anne'
When Click on Find Leads button for merging
Then Click on To first item in the list
When Click on Merge button
Then Verify if the leads are merged

Scenario Outline: Delete a lead

When Click on 'Leads' link
Then 'My Leads' page should be displayed
When Click on 'Find Leads' link
And Enter the first name for delete as '<FirstName>'
When Click on Delete Find Leads button
Then Click on first item in the list for deleting
When Click on 'Delete' link
Then Verify if the lead is deleted

Examples:
|FirstName|
|Haritha|
|Anne|
