package RestFullBookerAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETSinglebookId {

    @Test

    public void restGETSinglebookId()
    {
        String bookingid="12";
        RequestSpecification rs;
        Response response;
        ValidatableResponse vr;

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
        rs.log().all();

        response = rs.when().log().all().get();

        vr= response.then().log().all();
        vr.statusCode(200);
    }
}
