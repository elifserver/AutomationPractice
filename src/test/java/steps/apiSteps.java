package steps;

import Utils.TestDataBuild;
import Utils.Utils;
import Utils.APIResourceEnum;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.UserData;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class apiSteps extends Utils {
    TestDataBuild testdatabuilder;
    UserData payloadForBody = null;
    RequestSpecification res;
    Response response;
    JSONObject json;

    @Given("Create payload with {string}")
    public void createRegistrationPayloadFor(String userType) throws IOException {
        testdatabuilder = new TestDataBuild();
        switch (userType) {
            case "valid user":
                payloadForBody = testdatabuilder.validUser();
                break;
            case "xxx user":
                payloadForBody = testdatabuilder.xxxUser();
                break;
            default:
                break;
        }
            res = given().spec(RequestSpecification()).body(payloadForBody);
    }

    @When("User calls {string} with {string} request")
    public void userCallsWithRequest(String apiResource, String method) {
        APIResourceEnum enumValue = APIResourceEnum.valueOf(apiResource);
        switch (method) {
            case "POST":
                response = res.when().post(enumValue.getResource());
                break;
            case "DELETE":
                response = res.when().post(enumValue.getResource());
                break;
            case "GET":
                response = res.when().get(enumValue.getResource());
                break;
            default:
                break;
        }
    }

    @And("Token should be present")
    public void tokenShouldBePresent() throws JSONException {
        //1. way
//        Token tokenResponse = response.getBody().as(Token.class);
//        Assert.assertTrue("No token available", tokenResponse.token != null);

        //2. way
        json = getResponseAsJSONObject(response);
        Assert.assertTrue("There is no token available!!!", json.has("token"));
    }

    @Then("The API call response status should be {int}")
    public void theAPICallResponseStatusShouldBe(int expectedResponseCode) {
        Assert.assertEquals(response.getStatusCode(), expectedResponseCode);
    }

    @And("{string} should be {string}")
    public void shouldBe(String key, String value) {
        Assert.assertEquals(getResponseObjectKeyValue(response, key), value);
    }

    @Given("Create payload using {string} and {string}")
    public void createPayloadUsingAnd(String email, String password) throws IOException {
        testdatabuilder = new TestDataBuild();
        payloadForBody = testdatabuilder.invalidUser(email,password);
        res = given().spec(RequestSpecification()).body(payloadForBody);
    }

    @And("Response should have user list")
    public void responseShouldHaveUserList() throws JSONException {
        json = getResponseAsJSONObject(response);
        Assert.assertNotEquals("Data list is empty", "[]", json.getJSONArray("data"));
    }

    @Given("Create empty payload")
    public void createEmptyPayload() throws IOException {
        res = given().spec(RequestSpecification());
    }
}
