# spring_auth_server_keycloak

We will be using Admin Console Key Cloak Standalone server to connect to Spring boot application.

The link to download the zip is below.

https://www.keycloak.org/downloads.html

Once we download and unzip, we can go to the bin folder and start the server using the below command

./standalone.sh -Djboss.socket.binding.port-offset=100

In the browser, we can use the below url to go administrative login

http://localhost:8180

There are few steps to be configured in the Administrative console.

Step 1: Create a login, this will be the master or the admin login for the Master Realm.

Step 2: Create a Realm, this will be used in the application.yml file.
in our case, we are using student-realm.

![Create a Student Realm](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/1.png)

Step 3: Create a Client, 