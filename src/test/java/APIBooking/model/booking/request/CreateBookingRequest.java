package APIBooking.model.booking.request;

import APIBooking.model.booking.response.CreateBookingResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateBookingRequest {


        @JsonProperty("firstname")
        public String firstname;

        @JsonProperty("lastname")
        public String lastname;

        @JsonProperty("totalprice")
        public Integer totalprice;

        @JsonProperty("depositpaid")
        public Boolean depositpaid;

        @JsonProperty("bookingdates")
        public CreateBookingResponse.BookingDates bookingdates;
//        public static class BookingDates {

//        @JsonProperty("checkin")
//        public String checkin;
//
//        @JsonProperty("checkout")
//        public String checkout;
    //}



        @JsonProperty("additionalneeds")
        public String additionalneeds;

}


