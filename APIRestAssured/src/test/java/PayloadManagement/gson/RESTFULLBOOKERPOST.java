package PayloadManagement.gson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class RESTFULLBOOKERPOST {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;


    @Test
    public void testCreateBookingPost()
    {

        Booking booking = new Booking();
        booking.setFirstname("Saurabh");
        booking.setLastname("Tyagi");
        booking.setDepositpaid(true);
        booking.setTotalprice(765);
        booking.setAdditionalneeds("Breakfast");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2022-02-09");
        bookingdates.setCheckout("2024-09-02");
        booking.setBookingdates(bookingdates);

        Gson gson = new Gson();
        String bookingJsonString=gson.toJson(booking);


       requestSpecification= RestAssured.given();
       requestSpecification.baseUri("https://restful-booker.herokuapp.com");
       requestSpecification.basePath("/booking");
       requestSpecification.contentType(ContentType.JSON);
       requestSpecification.body(bookingJsonString).log().all();

       response= requestSpecification.when().post();
       String responsejsonString=response.asString();

       validatableResponse=response.then().statusCode(200);
       validatableResponse.log().all();

       BookingResponse bookingResponse = new BookingResponse();
       bookingResponse=gson.fromJson(responsejsonString,BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());

        Integer bookingResponseID = bookingResponse.getBookingid();
        System.out.println(bookingResponseID);

        String fName=bookingResponse.getBooking().getFirstname();

        Assert.assertNotNull(bookingResponseID);

        assertThat(bookingResponseID).isNotNull().isNotNegative();
        assertThat(fName).isNotEmpty().isNotNull().isEqualTo("Saurabh");



    }
}
