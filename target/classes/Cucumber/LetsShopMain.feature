
@tag
Feature: purchase the order from the website
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Submitting the Order in website
    Given log in with username <userEmail> and password <userPassword>
    When I add product to CartPage
    And Checkout and submit the order
    Then ConfirmationPage 

    Examples: 
      | userEmail 				|    userPassword   |    
      | sun@gmail.com	    |    Jack@123       |   
     