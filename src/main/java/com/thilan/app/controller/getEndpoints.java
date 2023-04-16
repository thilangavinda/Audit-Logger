package com.thilan.app.controller;

import com.thilan.app.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/blog")
@Log4j2
public class getEndpoints {


    private final UserService service;
    @Autowired
    public getEndpoints(UserService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public ResponseEntity<?> getMessage(){
        log.debug("Inside Controller");
        service.addUser("thilan");
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

}
