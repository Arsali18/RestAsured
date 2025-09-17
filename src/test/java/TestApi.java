import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


public class TestApi {

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

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        int statusCode = response.getStatusCode();

        System.out.println("Status Code: " + statusCode);
        System.out.println("Waktu Respon : " + response.getTime());
        System.out.println("Respon Status: " + response.getStatusLine());
        System.out.println(response.getHeader("cotent-type"));
        System.out.println(response.prettyPrint());


        System.out.println();
        Assert.assertEquals(statusCode, 200);

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

//    public static void main(String[] args) {
//        String id = passID(); // langsung panggil karena static
//        System.out.println("ID yang didapat: " + id);
//    }



}





