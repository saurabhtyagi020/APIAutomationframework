package org.example.asserts.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.example.asserts.base.Basetest;
import org.example.endpoints.APIConstants;
import org.testng.annotations.Test;

public class TestCreateToken extends Basetest {

    @Test(groups = "reg", priority = 1)
    @TmsLink("https://bugz.atlassian.net/browse/TS-1")
    @Owner("Promode")
    @Description("TC#2  - Create Token and Verify")
    public void testTokenPost()
    {
        requestSpecification.basePath(APIConstants.AUTH_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.setAuthPayload())
                .post();
        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);

        String token = payloadManager.getTokenfromjson(response.asString());
        assertActions.verifyStringKeyNotNull(token);
    }
}
