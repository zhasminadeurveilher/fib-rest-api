# fib-rest-api

**Goal:** Rest API responsible for the back-end of a bank module application

**Initial Setting**: assuming there are already existing customers

**Requirements:**

_Basic_
* The API will expose an endpoint which accepts the user information (customerID, initialCredit).
* Once the endpoint is called, a new account will be opened connected to the user whose ID is
  customerID.
* Also, if initialCredit is not 0, a transaction will be sent to the new account.
* Another Endpoint will output the user information showing Name, Surname,
  balance, and transactions of the accounts.

_Secondary_
* Accounts and Transactions are different services.
* Frontend (simple one is OK).
* Attention to CI/CD

_Tertiary_
* The application can authenticate customers by username and password
