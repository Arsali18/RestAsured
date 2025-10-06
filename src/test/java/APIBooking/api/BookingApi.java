package APIBooking.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingApi {

    public static <T> Response createBooking(T payload) {
         return given()
                .basePath("/booking")
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post();

    }

    public static <T> Response updateBooking(int id, String token, T payload) {
        return given()
                .basePath("/booking/{id}")
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(payload)
                .when()
                .put();
    }

    public static <T> Response partialUpdateBooking(int id, String token, T payload) {
        return given()
                .basePath("/booking/{id}")
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(payload)
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

