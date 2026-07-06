package com.skillmanager.service;

import java.util.List;

import com.skillmanager.entity.AuditLog;

public interface AuditLogService {

    void log(String action,
             String entityName,
             Long entityId,
             String performedBy);

    List<AuditLog> getAllLogs();
}