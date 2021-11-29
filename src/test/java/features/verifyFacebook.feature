Feature: Verify Facebook login page

  @noparam
  Scenario: Scenario have no parameter
    Given Open facebook application
    When Input to Username textbox
    And Input to Password textbox
    And Click to Submit button
    And Close application
   
   @param 
   Scenario: Scenario have parameter
    Given Open facebook application
    When Input to Username textbox with "phong@gmail.com"
    And Input to Password textbox with "123456"
    And Click to Submit button
    And Close application
    
   @datatable_step
    Scenario Outline: Create new Customer with email <Username> 
    Given Open facebook application
    When Input to Username and Password
      | Username        | Password  	 | 
      | <Username> 			| <Password>   | 
    And Click to Submit button
    And Close application
  
    Examples: 
      | Username        | Password | 
      | phong@gmail.com | 123456   |
    
    