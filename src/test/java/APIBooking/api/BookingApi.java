package APIBooking.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingApi {

    public static Response createBooking(String body) {
         return given()
                .basePath("/booking")
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post();

    }

    public static Response updateBooking(int id, String token, String body) {
        return given()
                .basePath("/booking/{id}")
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(body)
                .when()
                .put();
    }

    public static Response partialUpdateBooking(int id, String token, String body) {
        return given()
                .basePath("/booking/{id}")
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(body)
                .when()
                .patch();
    }

    public static Response getBooking(int id) {
        return given()
                .basePath("/booking/{id}")
                .pathParam("id", id)
                .when()
                .get();
    }

    public static Response deleteBooking(int id, String token) {
        return given()
                .basePath("/booking/{id}")
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + token)
                .when()
                .delete();
    }

    public static Response getAllBookingIds() {
        return given()
                .basePath("/booking")
                .when()
                .get();
    }

    public static Response ping() {
        return given()
                .basePath("/ping")
                .when()
                .get();
    }
}

