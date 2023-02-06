package com.oo.kj.community.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    private final Logger log =  LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Exception.class)
    private String ExceptionResponse(Exception e) {
        log.info("==== Exception Controller ====");
        log.info("[Error] : " + e.getMessage());
        log.info("[Error] : " + e.toString());
        e.printStackTrace();

        return "Error";
    }

}
