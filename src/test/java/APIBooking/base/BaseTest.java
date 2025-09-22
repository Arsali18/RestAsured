package APIBooking.base;

import APIBooking.utils.Helper;
import APIBooking.utils.TokenManager;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTest {
    protected Response response;
    public static String baseURI;
    public static String token;




    @BeforeSuite
    public void setUp() {
        baseURI = Helper.getKey("BASE_URI");
        RestAssured.baseURI = baseURI;
        token = TokenManager.getToken();
        //RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

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

