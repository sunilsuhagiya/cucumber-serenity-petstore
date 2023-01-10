package io.swagger.petstore.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.petstoreinfo.UserSteps;
import io.swagger.petstore.utils.TestUtils;
import net.thucydides.core.annotations.Steps;

public class UserStepDefs {
    static ValidatableResponse response;
    static int userId;
    static String userName1 ="Hello" + TestUtils.getRandomValue();
    @Steps
    UserSteps userSteps;

    @When("^I create user with id \"([^\"]*)\" username \"([^\"]*)\" firstname\"([^\"]*)\" lastname\"([^\"]*)\" email\"([^\"]*)\" password\"([^\"]*)\" phone\"([^\"]*)\" userstatus\"([^\"]*)\"$")
    public void iCreateUserWithIdUsernameFirstnameLastnameEmailPasswordPhoneUserstatus(int id, String username,
                                                                                       String firstname, String lastname,
                                                                                       String email, String password,
                                                                                       String phone, int userstatus){
        response = userSteps.createUserByUserName(id,username,firstname,lastname,email,password,phone,userstatus);
        userId = (int) response.extract().path("id");
    }

    @And("^I verify user created$")
    public void iVerifyUserCreated() {
        response.statusCode(201);
    }

    @And("^I update user with id \"([^\"]*)\" username \"([^\"]*)\" firstname\"([^\"]*)\" lastname\"([^\"]*)\" email\"([^\"]*)\" password\"([^\"]*)\" phone\"([^\"]*)\" userstatus\"([^\"]*)\"$")
    public void iUpdateUserWithIdUsernameFirstnameLastnameEmailPasswordPhoneUserstatus(int id, String username,
                                                                                       String firstname, String lastname,
                                                                                       String email, String password,
                                                                                       String phone, int userstatus){
        userName1 = userName1 + "Jimmy";
        response = userSteps.updateUserByUserName(id,userName1,firstname,lastname,email,password,phone,userstatus);

    }

    @And("^I check user is updated successfully$")
    public void iCheckUserIsUpdatedSuccessfully() {
        response.statusCode(200);
    }

    @And("^I delete user$")
    public void iDeleteUser() {
    }

    @Then("^I verify that user is deleted successfully$")
    public void iVerifyThatUserIsDeletedSuccessfully() {
    }


}
