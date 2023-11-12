# Selenium Hybrid FrameWork  
# Extent Report has been used in this framework.
## Have a look at the report [here](https://ragul-e.github.io/Web-Ui-Testing-Using-SeleniumHybrid-Framework/)


**TC1: Get All Products List.** 
**Steps:**
API 1: Get All Products List
API URL: https://automationexercise.com/api/productsList
Request Method: GET
Response Code: 200
Response JSON: All products list


**TC2: To validate Add to cart from recommended items and validate if products are successfully removed from the cart**
**Steps:**
1.	Launch the browser and navigate to https://automationexercise.com
2.	Verify that home page is visible successfully
3.	Scroll to bottom of page
4.	Verify 'RECOMMENDED ITEMS' are visible
5.	Validate the navigation buttons in recommended items section
6.	Click on 'Add to Cart' on ‘Winter Top ‘product 
7.	Click on 'View Cart' button
8.	Verify that product is displayed in cart page
9.	Add products to cart (more than 10, search using product name)
10.	 Click 'Cart' button and Verify that cart page is displayed
11.	Click 'X' button corresponding to product. Verify that product is removed from the cart

**TC3: To validate address details in checkout page**
**Steps:**
1.	Launch the browser and navigate to https://automationexercise.com
2.	Verify that home page is visible successfully
3.	Click 'Signup / Login' button
4.	Fill all details in Signup and create account
5.	Verify 'ACCOUNT CREATED!'. click 'Continue' button and Verify ' Logged in as username' at top
6.	Add products to cart
7.	Click 'Cart' button
8. Verify that cart page is displayed
9. Click Proceed to Checkout
10. Verify that the delivery address is same address filled at the time registration of account
11. Verify that the billing address is same address filled at the time registration of account
12.	Click 'Delete Account' button
13.	Verify 'ACCOUNT DELETED!' and click 'Continue' button


**TC4: To validate the Scroll up using arrow button and scroll down functionality**
**Steps:**
1.	Launch the browser and navigate to https://automationexercise.com
2.	Verify that home page is visible successfully
3.	Scroll down page to bottom
4.	Verify 'SUBSCRIPTION' is visible
5.	Click on arrow at bottom right side to move upward
6.	Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

**TC5: Validating invoice is downloaded after purchasing order.** 
**Steps:**
1.	Launch the browser and navigate to https://automationexercise.com.
2.Click on ‘products’ button
3.	Hover over the second product and third product and click ‘add to cart’.
4.	Click ‘continue’ shopping button’
5.Click on the cart icon in the top section.
6.	The Verify cart page is displayed.
7.	Click on ‘proceed to checkout’ button.
8.	Verify the billing and delivery address, review the order and capture the total amount.
9.	Click on 'place order’.
10.	Enter the payment details:
  *	Name on card
  *	Card Number
  *	cvv
  *	Expiration date
11.	Click ‘pay and confirm order’ button
12.	Verify success message is displayed.
13.	Click ‘Download invoice’ button.
14.	Validate if the invoice is downloaded successfully.
15.	Validate the text in the invoice. Hi ‘your name’, Your total purchase amount is ‘purchase amount’. Thank you

# Topics Implemented in Framework

1. Selenium-java
2. Data Driven Testing

## /Src
### Utilities
1. Excel Reader
2. Excel Writer
3. Selenium methods
4. Generics
5. Constants

## /resource
1. Configuration Reader
2. Drivers
3. Test Data Excel file

## TestNG
## Maven Build Tool
## loggers
1. log4j2

## listeners
1. TestNG TestListenerAdapter

## Extent Report
1. ExtentSparkReporter

## Retry Failed Test case
## DataSetters
## Funtion Library
1. Pre condition
2. Post condition

## User Defined Exception
## Screenshot for Failed Test cases
## Runner
1. Pom.xml
2. TestNG.xml

## Suite
1. Smoke
2. Regression
