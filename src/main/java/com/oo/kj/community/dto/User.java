package com.oo.kj.community.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "COMMUMUNITY_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "user_starName", unique = true, nullable = false)
    private String userStarName;

    @Column(name = "user_email", unique = true, nullable = false)
    private String userEmail;

    @Column(name = "user_eamil_code", nullable = false)
    private String userEmailCode;

    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(name = "user_pw", nullable = false)
    private String userPw;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    @Column(name = "user_create_date")
    private Date userCreateDate;

    @Column(name = "user_fail_count", nullable = false)
    @ColumnDefault("0")
    private int userFailCount;

    @Column(name = "user_login_date")
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private Date userLoginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    @Column(name = "user_logout_date")
    @LastModifiedDate
    private Date userLogutDate;

    @Column(name = "user_status")
    private String userStatus;

    @Builder
    private void User(String id, String pw, String name, String nickName, String email, String emailCode) {
        this.userId = id;
        this.userPw = pw;
        this.userName = name;
        this.userStarName = nickName;
        this.userEmail = email;
        this.userEmailCode = emailCode;
    }
}
