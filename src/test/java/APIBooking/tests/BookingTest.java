package APIBooking.tests;

import APIBooking.api.BookingApi;
import APIBooking.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import APIBooking.utils.TokenManager;

import java.util.List;

public class BookingTest extends BaseTest {
    private int id;


    @Test
    public void createBooking() {
        String body = "{\n" +
                "    \"firstname\" : \"Jin\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        response = BookingApi.createBooking(body);
        id = response.jsonPath().getInt("bookingid");
        Assert.assertEquals(response.getStatusCode(), 200);
        response.prettyPrint();
    }

    @Test(dependsOnMethods = {"createBooking"})
    public void updateBooking() {
        String body = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        response = BookingApi.updateBooking(id, token, body);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(dependsOnMethods = {"createBooking"})
    public void partialUpdateBooking() {
        String body = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";
        response = BookingApi.partialUpdateBooking(id, token, body);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(dependsOnMethods = {"createBooking"})
    public void getBooking() {
        response = BookingApi.getBooking(id);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test (dependsOnMethods = {"getBooking"})
    public void deleteBooking() {
        response = BookingApi.deleteBooking(id, token);
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void getBookingIds() {
        response = BookingApi.getAllBookingIds();
        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assert.assertTrue(bookingIds.size() > 1);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void ping() {
        response = BookingApi.ping();
        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
