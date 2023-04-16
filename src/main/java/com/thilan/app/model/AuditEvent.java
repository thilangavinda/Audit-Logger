package com.thilan.app.model;

import lombok.Data;

@Data

public class AuditEvent {
    private String name;

    public AuditEvent(String name) {
        this.name = name;
    }
}
