package APIBooking.tests;

import APIBooking.api.BookingApi;
import APIBooking.base.BaseTest;
import APIBooking.model.booking.response.CreateBookingResponse;
import APIBooking.model.booking.request.CreateBookingRequest;
import APIBooking.utils.Helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class IntegrationTest extends BaseTest{
    private int id;
    private int id2;
    private Response response;

    //Test Positive 1: respon status = 200
    @Test
    public void createBookingPositive1() throws JsonProcessingException {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        response = BookingApi.createBooking(createBookingRequest);
        CreateBookingResponse createBookingResponse = Helper.convertResponseToObject(response, CreateBookingResponse.class);
        id = createBookingResponse.bookingid;
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Response body: " + response.asString());
    }


}
