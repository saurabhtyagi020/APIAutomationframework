package org.example.asserts.tests.crud;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.example.asserts.base.Basetest;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import org.example.endpoints.APIConstants;
import org.example.pojos.BookingResponse;
import org.example.modules.PayloadManager;
import static org.assertj.core.api.Assertions.*;

public class TestCreateBooking extends Basetest {
    @Test(groups = "reg", priority = 1)
    @TmsLink("https://bugz.atlassian.net/browse/TS-1")
    @Owner("Saurabh")
    @Description("TC#INT1 - Step 1. Verify that the Booking can be Created")
    public void testCreateBookingPOST() {
        requestSpecification.basePath(APIConstants.CREATE_BOOKING_URL); //P -->preparation a request

        response = RestAssured.given(requestSpecification)//M
                .when().body(payloadManager.createPayloadBookingAsString())
                .post();

        validatableResponse = response.then().log().all();//V
        validatableResponse.statusCode(200);
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Saurabh");
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());







    }
}
