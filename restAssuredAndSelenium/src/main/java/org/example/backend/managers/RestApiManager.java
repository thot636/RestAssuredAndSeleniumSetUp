package org.example.backend.managers;

import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.example.backend.reqres.enums.RestApiCallType;

import static io.restassured.RestAssured.given;

public class RestApiManager {
    public static synchronized Response executeRestApiCall(RestApiCallType callType, String url, Object request) {
        Gson gson = new Gson();
        //String authAccessToken = getAccessToken();
        RequestSpecification requestSpecification = given()
                .contentType("application/json");
                //.header(AUTHORIZATION, String.format("Bearer %s", authAccessToken));

        switch (callType) {
            case POST:
                return requestSpecification
                        .body(request)
                        .post(url)
                        .then()
                        .log()
                        .ifValidationFails()
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .response();
            case GET:
                return requestSpecification
                        .body(gson.toJson(request))
                        .get(url)
                        .then()
                        .log()
                        .ifValidationFails()
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .response();
            case PUT:
                return requestSpecification
                        .body(gson.toJson(request))
                        .put(url)
                        .then()
                        .log()
                        .ifValidationFails()
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .response();
            case DELETE:
                return given()
                        .log().all()
                        .contentType("application/json")
                        //.header(AUTHORIZATION, String.format("Bearer %s", authAccessToken))
                        .delete(url)
                        .then()
                        .log()
                        .ifValidationFails()
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .response();
        }
        return null;
    }
}
