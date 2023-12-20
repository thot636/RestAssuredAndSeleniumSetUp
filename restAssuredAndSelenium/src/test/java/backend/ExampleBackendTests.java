package backend;

import org.example.TestUtil;
import org.example.backend.reqres.response.UserListResponse;
import org.example.backend.reqres.response.UserRegResponse;
import org.example.backend.reqres.restapi.ExampleRestCalls;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ExampleBackendTests extends TestUtil {

    public ExampleBackendTests(){
        super();
    }


    @Test
    public void validateGetCallTest(){
        ExampleRestCalls exampleRestCalls = new ExampleRestCalls();
        UserListResponse userListResponse =
        exampleRestCalls.getListUsers();
        assertThat(userListResponse.getData()).isNotEmpty();
    }

    @Test
    public void registerUser(){
        String email = "eve.holt@reqres.in";
        String password = "1234";
        ExampleRestCalls exampleRestCalls = new ExampleRestCalls();
        UserRegResponse userRegResponse =
                exampleRestCalls.postRegisterUser(email, password);
        assertThat(userRegResponse.getId()).isNotNull();
        assertThat(userRegResponse.getToken()).isNotNull();
    }
}
