package convertdata;

import APIBooking.model.booking.response.CreateBookingResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData {
    public static void main(String[] args)throws JsonMappingException, JsonProcessingException {
        String responseBody = "{\n" +
                "    \"bookingid\": 1,\n" +
                "    \"booking\": {\n" +
                "        \"firstname\": \"Jim\",\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        CreateBookingResponse bookingRequest2 = objectMapper.readValue(responseBody, CreateBookingResponse.class);
        System.out.println(bookingRequest2.booking.lastname);
        System.out.println(bookingRequest2.booking.bookingdates.checkin);
    }


}
