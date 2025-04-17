package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.*;

public class PayloadManager {

    // Convert Java Objects to JSON
    // Gson -> Ser and DeSer.

    Gson gson;
    public static String createPayloadBookingAsString()
    {
        Booking booking  = new Booking();
        booking.setFirstname("Saurabh");
        booking.setLastname("Tyagi");
        booking.setDepositpaid(true);
        booking.setTotalprice(123);
        booking.setAdditionalneeds("Lunch");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-06");
        booking.setBookingdates(bookingdates);

        // Java Object -> JSON

        Gson gson = new Gson();
        String jsonStringbooking = gson.toJson(booking);
        System.out.println(jsonStringbooking);
        return jsonStringbooking;

    }
    // Converting the String to the JAVA Object
    public BookingResponse bookingResponseJava(String responseString) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString,BookingResponse.class);
        return bookingResponse;

    }

    /// ----Token
    ///

    public String setAuthPayload()
    {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        Gson gson = new Gson();
        String jsonPayloadString=gson.toJson(auth);
        return jsonPayloadString;
    }

    // JSON to Java
    public String getTokenfromjson(String tokenResponse)
    {
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken().toString();
    }

    public Booking getResponsefromjson(String getResponse)
    {
        gson = new Gson();
        Booking  booking= gson.fromJson(getResponse,Booking.class);
        return booking;
    }

    public String fullUpdatePayloadAsString()
    {
        Booking booking = new Booking();
        booking.setFirstname("Gaurav");
        booking.setLastname("kumar");
        booking.setDepositpaid(true);
        booking.setTotalprice(123);
        booking.setAdditionalneeds("Lunch");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-06");
        booking.setBookingdates(bookingdates);
        String fullUpdatepaylaod= gson.toJson(booking);
        return fullUpdatepaylaod;
    }

}
