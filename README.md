# fib-rest-api

**Version:**
Spring Boot 3.1.1, Java 17

**Instructions to START the application:**
This part starts the backend (webservice) of the project. To see the results on the front end side, after the web service has been started,
please follow the instructions in the front-end app to start the front-end app

To run the back-end application
1. Open the FibRestApiApplication.java and from the right-click menu choose 'Run FibRestApiAppl..main()'
2. The users to use for testing are:

User 1:
- username: elena
- password: elena1

User 2:
- username: zhas
- password: zhas1

Testing the endpoints of the web service with Postman (without the front-end application):
1. Execute the request Login into the application with one of the two users
2. Copy the received token
3. On each of the folowing requests in the Authorization section set the Type: Bearer Token and paste
the token that was received earlier

Documentation for the end-points of the web service is provided at:
https://documenter.getpostman.com/view/4791317/2s946cfDeg

*REQUIREMENTS*

**Goal:** Rest API responsible for the back-end of a bank module application

**Initial Setting**: assuming there are already existing customers (inserted in the memory database when the application starts)

**Requirements:**

_Basic_
* Req1: The API will expose an endpoint which accepts the user information (customerID, initialCredit).
* Req2: Once the endpoint is called, a new account will be opened connected to the user whose ID is
  customerID.
* Req3: Also, if initialCredit is not 0, a transaction will be sent to the new account.
* Req4: Another Endpoint will output the user information showing Name, Surname,
  balance, and transactions of the accounts.

_Secondary_
* Req5: Accounts and Transactions are different services.
* Req6: Frontend (simple one is OK).
* Attention to CI/CD

_Tertiary_
* Req7: The application can authenticate customers by username and password
* Req8: User can create a new transaction
