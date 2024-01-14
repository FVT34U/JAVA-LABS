package com.example.lab4.models;

import lombok.Data;

@Data
public class DeleteMessage extends AuditMessage {
    private Object deletedObject;

    @Override
    public String getInfo() {
        return "Object was deleted: %s".formatted(deletedObject);
    }
}
