# fib-rest-api

**Goal:** Rest API responsible for the back-end of a bank module application

**Initial Setting**: assuming there are already existing customers

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
