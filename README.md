# Authorizing Spring Boot Application using KeyCloak

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

![After creation](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/2.png)

Step 3: Create a Client.

![Client creation](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/3.png)
![Client creation1](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/4.png)
![Client creation2](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/5.png)
![Client creation3](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/6.png)

Step 4: Create a Role and a user
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/7.png)
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/8.png)
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/9.png)
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/10.png)
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/11.png)
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/12.png)
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/13.png)
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/14.png)
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/15.png)

Step 5: When you click on Endpoints: you will find all the endpoints along with other info:

{
  "issuer": "http://localhost:8180/auth/realms/student-realm",
  "authorization_endpoint": "http://localhost:8180/auth/realms/student-realm/protocol/openid-connect/auth",
  "token_endpoint": "http://localhost:8180/auth/realms/student-realm/protocol/openid-connect/token",
  "introspection_endpoint": "http://localhost:8180/auth/realms/student-realm/protocol/openid-connect/token/introspect",
  "userinfo_endpoint": "http://localhost:8180/auth/realms/student-realm/protocol/openid-connect/userinfo",
  "end_session_endpoint": "http://localhost:8180/auth/realms/student-realm/protocol/openid-connect/logout",
  "jwks_uri": "http://localhost:8180/auth/realms/student-realm/protocol/openid-connect/certs",
  "check_session_iframe": "http://localhost:8180/auth/realms/student-realm/protocol/openid-connect/login-status-iframe.html"
}

step 6: When we use the token endpoint in postman, with the other details as shown in the diagram, required access token is generated.
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/16.png)

# Configuration required for Spring Boot application:

Dependency in build.gradle

    compile group: 'org.keycloak', name: 'keycloak-spring-boot-starter', version: '11.0.0'
    
Configuration in application.yml file
    
    keycloak:
      auth-server-url: http://localhost:8180/auth
      realm: student-realm
      resource: student-app
      public-client: true
      security-constraints[0].authRoles[0]: student
      security-constraints[0].securityCollections[0].patterns[0]: /v1/student/*
      principal-attribute: preferred_username
      
   Spring Boot Application should run on port 20443


# Request to Spring Boot Application

when a get request posted to the Student application

    http://localhost:20443/v1/student/1abc
    
    Application is redirected to Student Realm app as shown below.
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/17.png)
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/18.png)
![Client Role](https://github.com/arun786/spring_auth_server_keycloak/blob/master/src/main/resources/image/19.png)
