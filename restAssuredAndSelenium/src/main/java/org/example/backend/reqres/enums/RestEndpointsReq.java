package org.example.backend.reqres.enums;

public enum RestEndpointsReq {
    USERS("api/users"),
    REGISTER("api/register");

    private String endpoint;

    RestEndpointsReq(String endpoint){
        this.endpoint = endpoint;
    }

    public String getEndpointString(){
        return endpoint;
    }
}
