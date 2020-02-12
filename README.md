# GCP

Once this SpringBoot application is running please use the following URL from either a web browser or Postman as a GET request:

http://localhost:8181/geographicsearch/users/London/50

The browser will prompt you for a username and password and in Postman you will need to add these into the Basic Authorization section before sending the request.

The Username = user
And the password can be copied from the console when you run the application in your IDE. I used Spring Tool Suite. Everytime you launch the application the password will change.

N.B. A valid GoogleAPI Key in the UserService class is required to run the app successfully.
