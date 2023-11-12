# API Testing using serenityBDD with REST Assured framework.
# Serenity Report 
## Have a look at the report [here]
## Refer the test case [here](https://automationexercise.com/api_list)


**TC1: Get All Products List.** 
**Steps:**
1. API URL: https://automationexercise.com/api/productsList
2. Request Method: GET
3. Response Code: 200
4. Response JSON: All products list


**TC2: POST To All Products List**
**Steps:**
1. API URL: https://automationexercise.com/api/productsList
2. Request Method: POST
3. Response Code: 405
4. Response Message: This request method is not supported.

**TC3: Get All Brands List**
**Steps:**

1.API URL: https://automationexercise.com/api/brandsList
2.Request Method: GET
3.Response Code: 200
4.Response JSON: All brands list


**TC4: PUT To All Brands List**
**Steps:**

1. API URL: https://automationexercise.com/api/brandsList
2. Request Method: PUT
3. Response Code: 405
4. Response Message: This request method is not supported.

**TC5: POST To Search Product.** 
**Steps:**

1.API URL: https://automationexercise.com/api/searchProduct
2.Request Method: POST
3.Request Parameter: search_product (For example: top, tshirt, jean)
4.Response Code: 200
5.Response JSON: Searched products list


**TC6: POST To Search Product without search_product parameter.** 
**Steps:**
1.API URL: https://automationexercise.com/api/searchProduct
2.Request Method: POST
3.Response Code: 400
4.Response Message: Bad request, search_product parameter is missing in POST request.

**TC7: POST To Verify Login with valid details.** 
**Steps:**

1.API URL: https://automationexercise.com/api/verifyLogin
2.Request Method: POST
3.Request Parameters: email, password
4.Response Code: 200
5.Response Message: User exists!

**TC8: POST To Verify Login without email parameter.** 
**Steps:**

1. API URL: https://automationexercise.com/api/verifyLogin
2. Request Method: POST
3. Request Parameter: password
4. Response Code: 400
5. Response Message: Bad request, email or password parameter is missing in POST request.

**TC9: DELETE To Verify Login.** 
**Steps:**

1. API URL: https://automationexercise.com/api/verifyLogin
2. Request Method: DELETE
3. Response Code: 405
4. Response Message: This request method is not supported.

**TC10: POST To Verify Login with invalid details.** 
**Steps:**

1. API URL: https://automationexercise.com/api/verifyLogin
2. Request Method: POST
3. Request Parameters: email, password (invalid values)
4. Response Code: 404
5. Response Message: User not found!

**TC11: POST To Create/Register User Account.** 
**Steps:**

1. API URL: https://automationexercise.com/api/createAccount
2. Request Method: POST
3. Request Parameters: name, email, password, title (for example: Mr, Mrs, Miss), birth_date, birth_month, birth_year, firstname, lastname, company, address1, address2, 
 country, zipcode, state, city, mobile_number
4. Response Code: 201
5. Response Message: User created!

**TC12: DELETE METHOD To Delete User Account.** 
**Steps:**

1. API 12: DELETE METHOD To Delete User Account
2. API URL: https://automationexercise.com/api/deleteAccount
3. Request Method: DELETE
4. Request Parameters: email, password
5. Response Code: 200
6. Response Message: Account deleted!

**TC13: PUT METHOD To Update User Account.** 
**Steps:**

1. API 13: PUT METHOD To Update User Account
2. API URL: https://automationexercise.com/api/updateAccount
3. Request Method: PUT
4. Request Parameters: name, email, password, title (for example: Mr, Mrs, Miss), birth_date, birth_month, birth_year, firstname, lastname, company, address1, address2, country, zipcode, state, city, mobile_number
5. Response Code: 200
6. Response Message: User updated!

**TC14: GET user account detail by email.** 
**Steps:**

1. API 14: GET user account detail by email
2. API URL: https://automationexercise.com/api/getUserDetailByEmail
3. Request Method: GET
4. Request Parameters: email
5. Response Code: 200
6. Response JSON: User Detail




# Topics Implemented in Framework

1. REST Assured - Java
2. SerenityBDD
3. Cucumber BDD


## /Src
### Utilities
1. Constants
2. Configuration reader

## /resource
1. Feature file
2. Configuration.properties files
3. log4j2. properties
   

## Json Schema Validation

## Rest Routes

## Request spec Builder

## Response spec Builder

## Refactoring of request headers

## Pojo

## Test context

## Sereialization

## Deserialization

## Jackson api for sereialization and deserialization

## Object Mapper for sererialization and deserialization


## JUnit
## Maven Build Tool
## loggers
1. log4j2


##  Report
1. Serenity Report


## Runner
1. Test runner


## Suite
1.Pom.xml
