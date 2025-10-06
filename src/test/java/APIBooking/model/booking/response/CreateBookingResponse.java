package APIBooking.model.booking.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateBookingResponse {
   /* String responseBody = {
    bookingid: 1,
    booking: {
        firstname: Jim,
        lastname: Brown,
        totalprice: 111,
        depositpaid: true,
        bookingdates: {
            checkin: 2018-01-01,
            checkout: 2019-01-01
        },
        additionalneeds: Breakfast
    }
}*/

    @JsonProperty("bookingid")
    public Integer bookingid;

    @JsonProperty("booking")
    public Booking booking;

    public static class Booking {
        @JsonProperty("firstname")
        public String firstname;

        @JsonProperty("lastname")
        public String lastname;

        @JsonProperty("totalprice")
        public Integer totalprice;

        @JsonProperty("depositpaid")
        public Boolean depositpaid;

        @JsonProperty("bookingdates")
        public BookingDates bookingdates;



        @JsonProperty("additionalneeds")
        public String additionalneeds;
    }

    public static class BookingDates {
        @JsonProperty("checkin")
        public String checkin;

        @JsonProperty("checkout")
        public String checkout;
    }

}
