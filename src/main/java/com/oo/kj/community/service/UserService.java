package com.oo.kj.community.service;

import com.oo.kj.community.common.mail.Mail;
import com.oo.kj.community.dto.COMMUMUNITY_USER;
import com.oo.kj.community.repository.UserRepository;
import com.oo.kj.community.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void userCreate(UserRequest userCreateRequest) throws Exception {
        //EMAIL CODE CREATE
        String code = RandomStringUtils.randomAlphabetic(10);

        //USER BUILD
        COMMUMUNITY_USER user = new COMMUMUNITY_USER();
        user.builder().id(userCreateRequest.getId())
                .pw(userCreateRequest.getPw())
                .name(userCreateRequest.getName())
                .nickName(userCreateRequest.getNickName())
                .email(userCreateRequest.getEmail())
                .emailCode(code)
                .build();

        //TABLE INSERT
        userRepository.save(user);

        //MAIL SEND
        Mail mail = new Mail();
        mail.sendMail(user.getUserEmail(), user.getUserEmailCode());


    }

    public void userAdmission(String ky) {
        //TABLE UPDATE
        userRepository.updateUserStatus(ky);

    }

    public COMMUMUNITY_USER userLogin(UserRequest userRequest) {
        //TABLE USER SELECT
        COMMUMUNITY_USER user = userRepository.findByUserIdAndUserPw(userRequest.getId(), userRequest.getPw());

        return user;
            }
}
