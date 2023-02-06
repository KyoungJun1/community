package com.oo.kj.community.request;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreateRequest {


    private String id;

    private String pw;

    private String name;

    private String nickName;

    private String email;


}
