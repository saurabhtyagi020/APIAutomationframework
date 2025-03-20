package org.example.asserts.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.example.asserts.base.Basetest;
import org.example.endpoints.APIConstants;
import org.testng.annotations.Test;

public class TestHealthCheck extends Basetest {

    @Test(groups = "reg", priority = 1)
    @TmsLink("https://bugz.atlassian.net/browse/TS-1")
    @Owner("Saurabh")
    @Description("TC#3  - Verify Health")

    public void testGEThealthcheck()
    {
        requestSpecification.basePath(APIConstants.PING_URL);
        response = RestAssured.given(requestSpecification).when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

    }

}
