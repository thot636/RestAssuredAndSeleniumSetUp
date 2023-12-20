package org.example.backend.reqres.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    Integer id;
    String email;
    String last_name;
    String first_name;
    String avatar;
}
