package com.example.lab4.utils;

import com.example.lab4.models.AuditEvent;

public interface EventLogger {
    void log(Object entity, AuditEvent event);
}
