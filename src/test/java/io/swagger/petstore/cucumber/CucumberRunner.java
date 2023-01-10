package io.swagger.petstore.cucumber;

import cucumber.api.CucumberOptions;
import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
// Feature file on folder level path from content root and at the end /
@CucumberOptions(features = "src/test/java/resources/feature/userCRUDtest.feature")

public class CucumberRunner extends TestBase {
}
