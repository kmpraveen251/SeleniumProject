#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.

Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    When I send Get request api
    Then verify the response status code as 200
           
   @tag2
   Scenario Outline: Title1 of your scenario
   	When I send post request api with "<id>","<email>","<firstName>","<lastName>","<avatar>","<url>","<text>"
    Then verify the response status code as 201
    Examples:
    |id|email|firstName|lastName|avatar|url|text|
    |2|janet.weaver@reqres.in|test|Weaver|https://reqres.in/img/faces/2-image.jpg|https://reqres.in/#support-heading|To keep|       