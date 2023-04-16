package com.thilan.app.service;

import com.thilan.app.model.AuditEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {
    @Autowired
    private ApplicationEventPublisher publisher;


    public void addUser(String user) {


        log.debug("Adding user "+user);


        publisher.publishEvent(new AuditEvent("User Added"));

        log.debug("Method ends");
    }
}
