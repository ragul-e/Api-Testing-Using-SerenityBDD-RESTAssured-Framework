Feature: Product management



  Background: Automation exercise app is running
    Given User launch application

  @getproducts
  Scenario: get products
    When user gets product
    Then User should get the statuscode as 200

  @Addproducts
  Scenario Outline: Add product
    When user creates product
    Then User should get the statuscode as 200
    And User should get the responseCode <responsebodycode>
    And User responsemessage as <responsemessagebody>

    Examples: 
      | responsebodycode | responsemessagebody                     |
      |              405 | "This request method is not supported." |

  @getBrandlist
  Scenario Outline: Get Brands
    When user get brands
    Then User should get the statuscode as 200

  @putBrandlist
  Scenario Outline: create Brands
    When user create brands
    Then User should get the statuscode as 200
    And User responsemessage as <responsemessagebody>

    Examples: 
      | responsebodycode | responsemessagebody                     |
      |              405 | "This request method is not supported." |

  @searchproduct
  Scenario Outline: search product
    When user search products
    Then User should get the statuscode as 200

  @searchproductwithoutparam
  Scenario Outline: search product without param
    When user search products without value
    Then User should get the statuscode as 200
    And User should get the responseCode <responsebodycode>
    And User responsemessage as <responsemessagebody>

    Examples: 
      | responsebodycode | responsemessagebody                                                 |
      |              400 | "Bad request, search_product parameter is missing in POST request." |

  @verifyLoginwithValidCredentials
  Scenario Outline: login with valid credentials
    When user login with valid credentials
    And User should get the responseCode <responsebodycode>
    And User responsemessage as <responsemessagebody>

    Examples: 
      | responsebodycode | responsemessagebody |
      |              200 | "User exists!"      |

  @verifyLoginwithoutEmailCredentials
  Scenario Outline: login without valid credentials
    When user login without valid credentials
    Then User should get the statuscode as 200
    And User should get the responseCode <responsebodycode>
    And User responsemessage as <responsemessagebody>

    Examples: 
      | responsebodycode | responsemessagebody                                                    |
      |              400 | "Bad request, email or password parameter is missing in POST request." |

  @deletetoverifylogin
  Scenario Outline: verify delete login
    When user delete the login
    Then User should get the statuscode as 200
    And User should get the responseCode <responsebodycode>
    And User responsemessage as <responsemessagebody>

    Examples: 
      | responsebodycode | responsemessagebody                     |
      |              405 | "This request method is not supported." |

  @loginwithinvaliddetails
  Scenario Outline: login with invalid credentials
    When login with invalid credentials
    Then User should get the statuscode as 200
    And User should get the responseCode <responsebodycode>
    And User responsemessage as <responsemessagebody>

    Examples: 
      | responsebodycode | responsemessagebody |
      |              404 | "User not found!"   |

  @createuser
  Scenario Outline: create user 
    When user create new account
    Then User should get the statuscode as 200
    And User should get the responseCode <responsebodycode>
    And User responsemessage as <responsemessagebody>

    Examples: 
      | responsebodycode | responsemessagebody |
      |              201 | "User created!"     |

  @updateaccount
  Scenario Outline: update user
    When user update the account
    Then User should get the statuscode as 200
    And User should get the responseCode <responsebodycode>
    And User responsemessage as <responsemessagebody>

    Examples: 
      | responsebodycode | responsemessagebody |
      |              200 | "User updated!"     |

  @DeletUserAccount
  Scenario Outline: Delete user
    When user deletes the account
    Then User should get the statuscode as 200
    And User should get the responseCode <responsebodycode>
    And User responsemessage as <responsemessagebody>

    Examples: 
      | responsebodycode | responsemessagebody |
      |              200 | "Account deleted!"  |

  @getuserdetail
  Scenario Outline: get user account details
    When user get the details
    Then User should get the statuscode as 200
    And User should get the responseCode <responsebodycode>
    And User responsemessage as <responsemessagebody>

    Examples: 
      | responsebodycode | responsemessagebody |
      |              200 | "User updated!"     |
