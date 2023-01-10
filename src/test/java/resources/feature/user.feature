Feature: Testing different request on user from Petstore
  As a user I check that petstore aplication is accessed by users

  Scenario: As a user I want to check that T can create user
    When User send a post request to create user
    Then User must be created and validate the response

  Scenario: As a user I want to check that user is created
    When User send a get request with username
    Then User should get data of created user and validate response code

  Scenario: As a user I want to updaet user
    When User send a Put request to upgate user
    Then User suould see updated user and validate response

  Scenario: As a user I want to delete the user
    When User send a delete request
    Then User should see user is deleted and check status code