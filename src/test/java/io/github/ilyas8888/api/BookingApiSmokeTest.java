package io.github.ilyas8888.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

class BookingApiSmokeTest {
    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
    @Test
    @DisplayName("GET /ping returns 201 when the API is up")
    void apiIsUp(){
        given()
            .baseUri(BASE_URL)
        .when()
            .get("/ping")
        .then()
            .statusCode(201);
    }

    @Test
    @DisplayName("GET /booking returns a non-emptylist of bookings")
    void bookingListIsNotEmpty() {
        given()
                .baseUri(BASE_URL)
                .accept("application/json")
        .when()
                .get("/booking")
        .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
}
