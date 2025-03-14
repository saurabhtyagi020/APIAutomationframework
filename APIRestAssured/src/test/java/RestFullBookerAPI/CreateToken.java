package RestFullBookerAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateToken {

    @Test
    public void restCreateToken()
    {
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification rs;
        Response response;
        ValidatableResponse vr;

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/Auth");
        rs.contentType(ContentType.JSON);
        rs.body(payload);
        rs.log().all();

        response =rs.when().post();
        rs.log().all();

        vr=response.then();
        vr.statusCode(200);
        vr.log().all();






    }
}
