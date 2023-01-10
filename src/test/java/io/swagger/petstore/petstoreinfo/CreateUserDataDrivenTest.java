package io.swagger.petstore.petstoreinfo;

import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

//Faster execution
@Concurrent(threads = "2x")
//// Use content root path for locating file
@UseTestDataFrom("src/test/java/resources/testdata/user.csv")
//// When using data driven using SerenityParameterizedRunner
//// Run test at class level to create students
@RunWith(SerenityParameterizedRunner.class)

public class CreateUserDataDrivenTest extends TestBase {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    @Steps
    UserSteps userSteps;

    @Title("Data driven test for adding multiple users to the application")
    @Test
    public void createMultipleUsers(){
        userSteps.createUserByUserName(id,username,firstName,lastName,email,password,phone,userStatus).statusCode(200);
    }
}
