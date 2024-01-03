spring-angular-oauth2-jwt

Preface:
  In this tutorial I show you how to secure a distributed application (front: Angular, back: Spring boot) with Oauth2/OIDC (JWT) Keycloak.
  To simplify, I created a single microservice with 3 rest-conrollers.

what’s Oauth2/OIDC?
  before starting, I would like to remind you of the principle of the Oauth2 and OIDC protocol

  Oauth2 : 
    Protocol and framework of authorization delegation
    has tree party
      client
      resource server
      authorization server
  OIDC:
    Protocol of identity management
    the ID TOKEN use (JWT)
      Access Token
      Refresh Token
Google is OIDC because generates JWT after authentication and code verify
GitHub is not OIDC because does not generate a JWT Token

  
Environement
  install vscode
  install jdk-17
  install maven 3.9
  install node latest version
  install npm	latest version
  create new project spring boot latest version
  create controller HelloWorld
  create GetForUser display "hello world with privilege user"
  create GetForAdmin display "hello world with privilege admin" 
