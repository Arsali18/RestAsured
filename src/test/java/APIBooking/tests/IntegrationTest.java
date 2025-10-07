package APIBooking.tests;

import APIBooking.api.BookingApi;
import APIBooking.base.BaseTest;
import APIBooking.model.booking.response.CreateBookingResponse;
import APIBooking.model.booking.request.CreateBookingRequest;
import APIBooking.model.booking.updateBooking.UpdateBooking;
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

    //Test Positive 1: Create > Get > Delete
    @Test
    public void integrationTest1() throws JsonProcessingException {
        //Melakukan Booking
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        response = BookingApi.createBooking(createBookingRequest);
        CreateBookingResponse createBookingResponse = Helper.convertResponseToObject(response, CreateBookingResponse.class);
        id = createBookingResponse.bookingid;
        //Get Booking
        BookingApi.getBooking(id);
        System.out.println("Berhasil Get Booking");
        //Delete Booking
        BookingApi.deleteBooking(id, token);
        System.out.println("Berhasil Delete Booking");
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Test Positive 2 : Create > Update > Delete
    @Test
    public void integrationTest2 ()throws JsonProcessingException{
        //Melakukan Booking
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        response = BookingApi.createBooking(createBookingRequest);
        CreateBookingResponse createBookingResponse = Helper.convertResponseToObject(response, CreateBookingResponse.class);
        id = createBookingResponse.bookingid;

        //UpdateBooking
        BookingApi.updateBooking(id, token, createBookingRequest);
        System.out.println("Berhasil melakukan update booking");

        //Delete Booking
        BookingApi.deleteBooking(id, token);
        System.out.println("Berhasil Delete Booking");
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Response body: " + response.prettyPrint());

    }

    //Test Positive 3 : Create > Update > Delete
    @Test
    public void integrationTest3 ()throws JsonProcessingException{
        //Melakukan Booking
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        response = BookingApi.createBooking(createBookingRequest);
        CreateBookingResponse createBookingResponse = Helper.convertResponseToObject(response, CreateBookingResponse.class);
        id = createBookingResponse.bookingid;

        //UpdateBooking patial
        BookingApi.partialUpdateBooking(id, token, createBookingRequest);
        System.out.println("Berhasil melakukan update partial booking");

        //Get Booking
        BookingApi.getBooking(id);
        System.out.println("Berhasil Get Booking");

    }



}
