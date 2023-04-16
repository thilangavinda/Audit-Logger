package com.thilan.app.components;

import com.thilan.app.model.AuditEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class AuditListener {

    @Async
    @EventListener
    public void handler(AuditEvent event) {
        log.debug("Thread Name "+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        }catch (Exception e){
            log.debug("Exception{}",e.getMessage());
        }

        log.debug("Auditing the event "+event.getName());
    }
}
