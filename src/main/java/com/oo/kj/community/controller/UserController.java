package com.oo.kj.community.controller;


import com.oo.kj.community.dto.COMMUMUNITY_USER;
import com.oo.kj.community.request.UserRequest;
import com.oo.kj.community.response.UserCreateResponse;
import com.oo.kj.community.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    /*
    request : id, pw, name, nickname, email
     */
    @GetMapping(value = "/userCreate")
    public UserCreateResponse userCreate(@RequestBody UserRequest userRequest) throws Exception {

        userService.userCreate(userRequest);
        return new UserCreateResponse(userRequest.getName(), "이메일 인증 후 로그인 바람");
    }


    /*
    request : eamil_code
     */
    @GetMapping(value = "/userAdmission")
    public String userAdmission(String ky) {
        userService.userAdmission(ky);

        // 성공 시 성공했다는 페이지로 이동
        return "성공";
    }

    /*
    request : id, pw
     */
    @PostMapping(value = "/userLogin")
    public String userLogin(@RequestBody UserRequest userRequest, HttpServletRequest request) {

        COMMUMUNITY_USER user = userService.userLogin(userRequest);

        //HTTP Session
        HttpSession session = request.getSession();
        // user 정보 체크
        if (user != null)
            session.setAttribute("user", user);


        //return "페이지/정보";
        return "성공";

    }

    @GetMapping(value = "/userLogout")
    public String userLogout(HttpSession session){
        //세션 제거
        session.invalidate();

        return "성공";
    }
}
