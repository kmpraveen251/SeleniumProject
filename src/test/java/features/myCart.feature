#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.

Feature: Title of your feature
  I want to use this template for my feature file
            
   @smoketests
   Scenario: validate the cart application
   	Given I add four random items to my cart
   	When I vew my cart
   	Then i find total four items listed in my cart
   	When I search for lowest price item
   	When I am able to remove the lowest price item from my cart
   	Then I am able to verify three items in my cart
    