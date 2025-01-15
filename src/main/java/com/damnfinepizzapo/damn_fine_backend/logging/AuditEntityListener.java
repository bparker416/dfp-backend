package com.damnfinepizzapo.damn_fine_backend.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class AuditEntityListener {

    private static AuditLogService auditLogService;

    @Autowired
    public void setAuditLogService(AuditLogService auditLogService) {
        AuditEntityListener.auditLogService = auditLogService;
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @PrePersist
    public void beforeInsert(Object entity) {
        logChange("INSERT", entity);
    }

    @PreUpdate
    public void beforeUpdate(Object entity) {
        logChange("UPDATE", entity);
    }

    @PreRemove
    public void beforeDelete(Object entity) {
        logChange("DELETE", entity);
    }

    private void logChange(String action, Object entity) {
        try {
            String entityJson = objectMapper.writeValueAsString(entity);
            String tableName = entity.getClass().getSimpleName();
            String entityId = getEntityId(entity);

            String timestamp = dateFormat.format(new Date());
            String logEntry = String.format("[%s] ACTION: %s | TABLE: %s | ID: %s | DETAILS: %s",
                    timestamp, action, tableName, entityId, entityJson);

            auditLogService.logChange(logEntry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getEntityId(Object entity) {
        try {
            Method getIdMethod = entity.getClass().getMethod("getId");
            Object id = getIdMethod.invoke(entity);
            return (id != null) ? id.toString() : "UNKNOWN_ID";
        } catch (Exception e) {
            return "UNKNOWN_ID"; // Handle entities without `getId()`
        }
    }
}
