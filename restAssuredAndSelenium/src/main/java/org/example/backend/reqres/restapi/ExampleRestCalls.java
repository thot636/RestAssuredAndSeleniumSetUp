package org.example.backend.reqres.restapi;

import io.restassured.response.Response;
import org.example.backend.managers.RestApiManager;
import org.example.TestUtil;
import org.example.backend.reqres.enums.RestApiCallType;
import org.example.backend.reqres.enums.RestEndpointsReq;
import org.example.backend.reqres.request.RegisterRequest;
import org.example.backend.reqres.response.UserListResponse;
import org.example.backend.reqres.response.UserRegResponse;

public class ExampleRestCalls extends TestUtil {

    public ExampleRestCalls() {
        super();
    }

    public UserListResponse getListUsers() {
        String url = setUpUrl(RestEndpointsReq.USERS.getEndpointString());
        Response response =
                RestApiManager.executeRestApiCall(RestApiCallType.GET, url, null);
        return response.as(UserListResponse.class);
    }

    public UserRegResponse postRegisterUser(String email, String password){
        RegisterRequest registerRequest = RegisterRequest.builder()
                .email(email)
                .password(password)
                .build();
        String url = setUpUrl(RestEndpointsReq.REGISTER.getEndpointString());
        Response response =
                RestApiManager.executeRestApiCall(RestApiCallType.POST, url, registerRequest);
        return response.as(UserRegResponse.class);
    }

    private String setUpUrl(String endpoint) {
        String base = getUrlLink();
        return base.concat(endpoint);
    }
}
