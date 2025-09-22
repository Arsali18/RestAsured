package APIBooking.utils;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class TokenManager {

    private static String token;

    @BeforeClass
    public static String getToken() {
        if (token == null) {
            String bodyReqToken = "{\n" +
                    "    \"username\" : \"admin\",\n" +
                    "    \"password\" : \"password123\"\n" +
                    "}";

            Response response = given()
                    .basePath("/auth")
                    .header("Content-Type", "application/json")
                    .body(bodyReqToken)
                    .when()
                    .post();

            token = response.jsonPath().getString("token");
        }
        return token;
    }
}
