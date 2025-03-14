package RestFullBookerAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateBooking {

    @Test
    public void restCreateBooking()
    {
        String payload="{\n" +
                "    \"firstname\" : \"Raja\",\n" +
                "    \"lastname\" : \"Ram\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        RequestSpecification rs;
        Response response;
        ValidatableResponse vr;

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(payload).log().all();

        response = rs.when().post();
        rs.log().all();

        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
