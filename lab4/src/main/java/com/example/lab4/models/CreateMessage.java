package com.example.lab4.models;

import lombok.Data;

@Data
public class CreateMessage extends AuditMessage {
    private Object createdObject;

    @Override
    public String getInfo() {
        return "Object was created: %s".formatted(createdObject);
    }
}
