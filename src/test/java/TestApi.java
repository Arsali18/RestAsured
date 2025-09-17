import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;


public class TestApi {

    Response response;

    @BeforeMethod
    public void setUrl(){
        RestAssured.baseURI="https://reqres.in/api";
    }

    @AfterMethod
    public void statusCode(){


        if(response!= null){
            response=null;
        }
    }

     String idObjeect;

     String reqBody = "{\n" + //
            "   \"name\": \"Apple MacBook Pro 16\",\n" + //
            "   \"data\": {\n" + //
            "      \"year\": 2019,\n" + //
            "      \"price\": 1849.99,\n" + //
            "      \"CPU model\": \"Intel Core i9\",\n" + //
            "      \"Hard disk size\": \"1 TB\"\n" + //
            "   }\n" + //
            "}";
    String url = "https://api.restful-api.dev";


    @Test
    public void getMethod() {

        response = given()
                .basePath("/users")
                .queryParam("page",2)
                .when()
                .get();
        response.prettyPrint();
        System.out.println("Status Code GET: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        long responseTimeSec = response.getTimeIn(TimeUnit.SECONDS);
        assertTrue(responseTimeSec < 1, "Response time lebih dari 2 detik");
    }

    @Test
    public void getUser() {

        response = given()
                .basePath("/users")
                .queryParam("page",2)
                .queryParam("per_page",5)
                .header("accept","application/json")
                .header("x-api-key","reqres-free-v1")
                .when()
                .get();
        response.prettyPrint();
        System.out.println("Status Code GET: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        long responseTimeSec = response.getTimeIn(TimeUnit.SECONDS);
        assertTrue(responseTimeSec < 3, "Response time lebih dari 2 detik");
    }


    @Test
    public void testGetDat() {


        given()
                .baseUri(url)
                .basePath("/objects")
                //.queryParam("id", "1")
                .header("Content-Type", "application/json")
                //.pathParam("id","1" )

                .when()
                .get("/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Google Pixel 6 Pro"))
                //.body("data.first_name", equalTo("Michael"))
                .body("data.capacity", equalTo("128 GB"))
                //.body("data.last_name", equalTo("Lawson"))
                .log().all();
    }

    @Test
    public void testPost() {

        given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type", "application/json")
                .body(reqBody)
        .when()
                .post()
        .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public String passID() {
        Response response = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type", "application/json")
                .body(reqBody)
        .when()
                .post();

        idObjeect = response.jsonPath().getString("id");
        return idObjeect;
    }

    @Test
    public void deleteObject(){
        if (idObjeect==null){
            idObjeect=passID();
        }
        System.out.printf("baseUri : %s",url);
    }





}





