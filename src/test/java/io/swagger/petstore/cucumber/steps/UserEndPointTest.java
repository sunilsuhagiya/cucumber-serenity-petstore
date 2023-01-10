package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.petstoreinfo.UserSteps;
import net.thucydides.core.annotations.Steps;


public class UserEndPointTest {
    static int id = 8;
    static String username = "Data";
    static String firstName = "Important";
    static String lastName = "Very";
    static String email = "Very@gmail.com";
    static String password = "Important654";
    static String phone = "4567891322";
    static int userStatus = 0;
    static ValidatableResponse response;
    @Steps
    UserSteps userSteps;

    @When("^User send a post request to create user$")
    public void userSendAPostRequestToCreateUser() {
        response=userSteps.createUserByUserName(id,username,firstName,lastName,email,password,phone,userStatus);
    }

    @Then("^User must be created and validate the response$")
    public void userMustBeCreatedAndValidateTheResponse() {
        response.statusCode(200);
    }

    @When("^User send a get request with username$")
    public void userSendAGetRequestWithUsername() {
    }

    @Then("^User should get data of created user and validate response code$")
    public void userShouldGetDataOfCreatedUserAndValidateResponseCode() {
        response.statusCode(200);
    }

    @When("^User send a Put request to upgate user$")
    public void userSendAPutRequestToUpgateUser() {
        username=username+"_add";
        response=userSteps.updateUserByUserName(id,username,firstName,lastName,email,password,phone,userStatus);

    }

    @Then("^User suould see updated user and validate response$")
    public void userSuouldSeeUpdatedUserAndValidateResponse() {
        response.statusCode(200);
    }

    @When("^User send a delete request$")
    public void userSendADeleteRequest() {

    }

    @Then("^User should see user is deleted and check status code$")
    public void userShouldSeeUserIsDeletedAndCheckStatusCode() {
        response=userSteps.getUserByUserName(username).statusCode(404);
    }
}
