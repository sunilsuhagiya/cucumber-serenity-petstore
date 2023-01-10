package io.swagger.petstore.petstoreinfo;

import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.constants.EndPoints;
import io.swagger.petstore.model.UserPojo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class UserSteps {
    @Step("Creating user record with id: {0}, username: {1}, firstName: {2}, lastName: {3}, email: {4}, password: {5}, phone: {6} and userStatus: {7}  ")
    public ValidatableResponse createUserByUserName(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {

        UserPojo userPojo = new UserPojo();
        userPojo.setId(id);
        userPojo.setUsername(username);
        userPojo.setFirstName(firstName);
        userPojo.setLastName(lastName);
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        userPojo.setPhone(phone);
        userPojo.setUserStatus(userStatus);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .body(userPojo)
                .post(EndPoints.GET_ALL_USER)
                .then().log().all().statusCode(200);
    }
    @Step("Getting user record with username: {0}")
    public ValidatableResponse getUserByUserName(String username) {
        return SerenityRest.given().log().all()
                .when()
                .pathParam("username", username)
                .get(EndPoints.GET_SINGLE_USER_BY_USERNAME)
                .then().log().all();
    }
    @Step("Getting user by userName:{0}")
    public HashMap<String, Object> getUserByUserName1(String userName) {
        return SerenityRest.given().log().all()
                .when()
                .pathParam("username", userName)
                .get(EndPoints.GET_SINGLE_USER_BY_USERNAME)
                .then().extract().path("");
    }

    @Step("Updating existing user record with id: {0}, username: {1}, firstName: {2}, lastName: {3}, email: {4}, password: {5}, phone: {6} and userStatus: {7}  ")
    public ValidatableResponse updateUserByUserName(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        UserPojo userPojo = new UserPojo();
        userPojo.setId(id);
        userPojo.setUsername(username);
        userPojo.setFirstName(firstName);
        userPojo.setLastName(lastName);
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        userPojo.setPhone(phone);
        userPojo.setUserStatus(userStatus);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .when()
                .body(userPojo)
                .put(EndPoints.UPDATE_USER_BY_USERNAME)
                .then().log().all().statusCode(200);
    }
    @Step("Deleting existing user record with username: {0}")
    public void deleteUserByUserName(String username) {

        SerenityRest.given().log().all()
                .when()
                .pathParam("username", username)
                .delete(EndPoints.DELETE_USER_BY_USERNAME)
                .then().log().all().statusCode(200);
    }
}
