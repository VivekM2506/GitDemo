#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


@tag
Feature: Purchase the order from ecommerce website
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of  Submitting the order
    Given Logged in with username <name> and Password <password>
    When I add the product <ProdName> to cart
    And Checkout product <ProdName> and submit order 
    Then "THANK YOU FOR THE ORDER" message is displayed on confirmationPage

    Examples: 
      |name               |password    |ProdName|
      |vivek123@gmail.com |Vivek@123    |IPHONE 13 PRO |
      
