package APIBooking.base;

import APIBooking.utils.Helper;
import APIBooking.utils.TokenManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class BaseTest {
    protected Response response;
    public static String baseURI;
    public static String token;
    //public static Integer id;






    @BeforeSuite
    public void setUp() {
        baseURI = Helper.getKey("BASE_URI");
        RestAssured.baseURI = baseURI;
        token = TokenManager.getToken();

        //RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

//    @BeforeMethod
//    public void setupRequestSpesification(){
//        System.out.println("Ini Before Method");
//        RestAssured.requestSpecification = given()
//                .basePath("/booking/{id}")
//                .pathParam("id", id)
//                .header("Content-Type", "application/json")
//                .header("Accept", "application/json")
//                .header("Cookie", "token=" + token);
//    }

//    public void createBooking() {
//        String body = "{\n" +
//                "    \"firstname\" : \"Jin\",\n" +
//                "    \"lastname\" : \"Brown\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";
//        response = BookingApi.createBooking(body);
//        id = response.jsonPath().getInt("bookingid");
//        Assert.assertEquals(response.getStatusCode(), 200);
//        response.prettyPrint();
//    }






//    @Test(priority = 1)
//    public void createToken() {
//        token = TokenManager.getToken();
//        Assert.assertNotNull(token);
//        System.out.println("Token: " + token);
//    }

    @AfterMethod
    public void tearDown() {
        response = null;
    }
}

