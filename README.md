## Demo Challenge
https://github.com/nicholasgorgone-nbcuni/SQEDemonstrationChallengeUIProject

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: sqedemonstrationchallenge@nbcuni.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases

1	Ensure cust can order a S,L pizza without any toppings with credit card
2	Ensure cust can order a s pizza with one topping with credit card
3	Ensure cust can order a M,L pizza with two toppings with credit card
4	Repeat 1-3 with 99999 quantity and ensure cost calculations are correct
5	Repeat 1-3 with cash on pickup
6	Choose 1 topping pizza with all values from "Toppings 1" list
7	Choose 1 topping pizza with all values from "Toppings 2" list
8	Choose 2 topping pizza with with combinations from "Topping 1" and "Topping 2"
9	Validate limit for Name and phone no. field with long strings
10	Verify pizza, topping, quantity, name, phone, email are cleared after RESET button


### Defects:

1	Quantity field allows decimal nos like 10.7
2	You can place order without any pizza selection and payment info(oder total 0)
3	Both payment modes can be selected at same order
4	Can oder M or L with 2 toppings without selecting toppings
5	Phone field allows alphabets
6	Quantity allows non-numbers
7	Phone can be more than 10 digits
