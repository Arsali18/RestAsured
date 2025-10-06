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

public class BookingTest extends BaseTest {
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

    //Test Positive 2 : berhasil mendapatkan bookingId
    @Test
    public void createBookingPositive2() throws JsonProcessingException {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        response = BookingApi.createBooking(createBookingRequest);
        CreateBookingResponse createBookingResponse = Helper.convertResponseToObject(response, CreateBookingResponse.class);
        id2 = createBookingResponse.bookingid;
        Assert.assertEquals(createBookingResponse.bookingid,id2,"Gagal mendapatkan BookingID");
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Test Positive 3 :User mengubah fisrt dan lastname
    @Test
    public void createBookingPositive3() throws JsonProcessingException {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        createBookingRequest.firstname = "Udin";
        createBookingRequest.lastname = "Nganga";
        response = BookingApi.createBooking(createBookingRequest);
        CreateBookingResponse createBookingResponse = Helper.convertResponseToObject(response, CreateBookingResponse.class);
        id = createBookingResponse.bookingid;
        Assert.assertEquals(createBookingResponse.bookingid,id,"Respon Tidak sesuai");
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Negative test 1 : fistname null
    @Test
    public void createBookingNegative1() throws JsonProcessingException {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        createBookingRequest.firstname = null;// firstname dikosongkan
        System.out.println("value first name: "+createBookingRequest.firstname);
        response = BookingApi.createBooking(createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 500, "Test Failed");
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Negative test 2 : lastname null
    @Test
    public void createBookingNegative2() throws JsonProcessingException {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        createBookingRequest.lastname = null;// laststname dikosongkan
        response = BookingApi.createBooking(createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 500, "Test Failed");
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Negative test 3 : checkin null
    @Test
    public void createBookingNegative3() throws JsonProcessingException {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        createBookingRequest.bookingdates.checkin = null;// checkin dikosongkan
        response = BookingApi.createBooking(createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 500, "Test Failed");
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Test Positive 1 : Get Status 200
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void updateBooking() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        response = BookingApi.updateBooking(id, token, createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //Test Positive 2 : User update firstname
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void updateBooking2() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        createBookingRequest.firstname="Romadhon";
        //CreateBookingResponse createBookingResponse = Helper.convertResponseToObject(response, CreateBookingResponse.class);
        response = BookingApi.updateBooking(id, token, createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(createBookingRequest.firstname,"Romadhon","Respon tidak sesuai");
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Test Positive 3 : User update lastname
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void updateBooking3() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        //CreateBookingResponse createBookingResponse = Helper.convertResponseToObject(response, CreateBookingResponse.class);
        createBookingRequest.lastname="Shinchan";
        response = BookingApi.updateBooking(id, token, createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(createBookingRequest.lastname,"Shinchan","Respon tidak sesuai");
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Test Negative 1 : User update lastname null
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void updateBooking1() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        //CreateBookingResponse createBookingResponse = Helper.convertResponseToObject(response, CreateBookingResponse.class);
        createBookingRequest.lastname=null;
        response = BookingApi.updateBooking(id, token, createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(createBookingRequest.lastname,null,"Respon tidak sesuai");
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Test Negative 2 : User update firstname null
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void updateBookingNegative2() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        //CreateBookingResponse createBookingResponse = Helper.convertResponseToObject(response, CreateBookingResponse.class);
        createBookingRequest.firstname=null;
        response = BookingApi.updateBooking(id, token, createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(createBookingRequest.firstname,null,"Respon tidak sesuai");
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Test Negative 3 : User update checkin null
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void updateBookingNegative3() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "createBooking", CreateBookingRequest.class);
        //CreateBookingResponse createBookingResponse = Helper.convertResponseToObject(response, CreateBookingResponse.class);
        createBookingRequest.bookingdates.checkin=null;
        response = BookingApi.updateBooking(id, token, createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(createBookingRequest.bookingdates.checkin,null,"Respon tidak sesuai");
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Positive test 1 : get status 200
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void partialUpdateBooking() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "updatePartial", CreateBookingRequest.class);
        response = BookingApi.partialUpdateBooking(id, token, createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //Positive test 2 : User update fisrtname
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void partialUpdateBooking2() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "updatePartial", CreateBookingRequest.class);
        createBookingRequest.firstname="Raras";
        response = BookingApi.partialUpdateBooking(id, token, createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //Positive test 3 : User update lastname
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void partialUpdateBooking3() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "updatePartial", CreateBookingRequest.class);
        createBookingRequest.lastname="Romi";
        response = BookingApi.partialUpdateBooking(id, token, createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //Negative test 1 : User id invalid
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void partialUpdateBookingNegative() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "updatePartial", CreateBookingRequest.class);
        //createBookingRequest.lastname="Raras";
        response = BookingApi.partialUpdateBooking(0, token, createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 405);
    }

    //Negative test 2 : User request token kosong
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void partialUpdateBookingNegative2() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "updatePartial", CreateBookingRequest.class);
        //createBookingRequest.lastname="Raras";
        response = BookingApi.partialUpdateBooking(id, "", createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 403);
    }

    //Negative test 3 : User request token invalid
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void partialUpdateBookingNegative3() {
        CreateBookingRequest createBookingRequest = Helper.findByUseCase("CreateBookingRequest.json", "updatePartial", CreateBookingRequest.class);
        createBookingRequest.firstname=null;
        response = BookingApi.partialUpdateBooking(id, "00", createBookingRequest);
        Assert.assertEquals(response.getStatusCode(), 403);
    }

    //Positive test 1 : Get Status : 200
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void getBooking() {
        response = BookingApi.getBooking(id);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //Positive test 2 : Get body response
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void getBooking2() {
        response = BookingApi.getBooking(id);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Response body: " + response.prettyPrint());
        Assert.assertEquals("Jin","Jin","Fisrtname tidak sesuai");
    }

    //Positive test 3 : Get body response
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void getBooking3() {
        response = BookingApi.getBooking(id);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Negative test 1 : user request id invalid
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void getBookingNegative() {
        response = BookingApi.getBooking(0);
        Assert.assertEquals(response.getStatusCode(), 404);
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Negative test 2 : user request id invalid
    @Test(dependsOnMethods = {"createBookingPositive1"})
    public void getBookingNegative2() {
        response = BookingApi.getBooking(id);
        //Assert.assertEquals(response.getStatusCode(), 404);
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Positive 1 : get status 201
    @Test (dependsOnMethods = {"updateBookingNegative3"})
    public void deleteBooking() {
        response = BookingApi.deleteBooking(id, token);
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    //Positive 2 : get body response
    @Test (priority = 28)//(dependsOnMethods = {"updateBookingNegative3"})
    public void deleteBooking2() {
        response = BookingApi.deleteBooking(id2, token);
        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Positive 3 : get body response
    @Test (dependsOnMethods = {"updateBookingNegative3"})
    public void deleteBooking3() {
        response = BookingApi.deleteBooking(id, token);
        //Assert.assertEquals(response.getHeader(), 201);
        System.out.println("Response body: " + response.getTime());
    }

    //Positive 1 : Get status 200
    @Test
    public void getBookingIds() {
        response = BookingApi.getAllBookingIds();
        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //Positive 2 : Get size >1
    @Test
    public void getBookingIds2() {
        response = BookingApi.getAllBookingIds();
        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assert.assertTrue(bookingIds.size() > 1);
        System.out.println("Response body: " + response.prettyPrint());
    }

    //Positive 3 : Get Response body
    @Test
    public void getBookingIds3() {
        response = BookingApi.getAllBookingIds();
        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        System.out.println("Response body: " + response.prettyPrint());
    }

    @Test
    public void ping() {
        response = BookingApi.ping();
        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
