package com.oo.kj.community.controller;


import com.oo.kj.community.request.UserCreateRequest;
import com.oo.kj.community.response.UserCreateResponse;
import com.oo.kj.community.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger log =  LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    /*
    request : id, pw, name, nickname, email
     */
    @GetMapping(value = "/userCreate")
    public UserCreateResponse userCreate(@RequestBody UserCreateRequest userCreateRequest) throws Exception {

        userService.userCreate(userCreateRequest);
        return new UserCreateResponse(userCreateRequest.getName(), "이메일 인증 후 로그인 바람");
    }



    /*
    request : eamil_code
     */
    @GetMapping(value = "/userAdmission")
    public String userAdmission(String ky){
        userService.userAdmission(ky);

        // 성공 시 성공했다는 페이지로 이동
        return "성공";
    }






}
