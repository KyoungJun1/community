package com.oo.kj.community.response;


import lombok.Data;

@Data
public class UserCreateResponse {

    private String name;

    private String content;

    public UserCreateResponse(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
