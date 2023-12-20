package org.example.backend.reqres.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserListResponse {
    Integer page;
    Integer per_page;
    Integer total;
    Integer total_pages;
    List<Users> data;
    Support support;

}
