package io.swagger.petstore.petstoreinfo;

import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {

    @WithTag("petstore:NEGATIVE")
    @Title("Provide a 405 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod() {
        SerenityRest.given()
                .when()
                .get("/user")
                .then()
                .statusCode(405);
    }

    @WithTag("petstore:POSITIVE")
    @Title("This test will verify if a status code of 200 is returned for post request")
    @Test
    public void validMethod() {
        SerenityRest.given()
                .when()
                .get("/pat")
                .then()
                .statusCode(200);
    }

    @WithTags({
            @WithTag("petstore:NEGATIVE"),
            @WithTag("petstore:REGRESSION")
    })
    @Title("This test will provide an error code of 400 when user tries to access an invalid resource")
    @Test
    public void incorrectresources() {
        SerenityRest.given()
                .when()
                .get("/user123")
                .then()
                .statusCode(404);
    }
}
