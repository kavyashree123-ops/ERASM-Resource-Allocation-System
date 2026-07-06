package com.skillmanager.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillmanager.entity.AuditLog;
import com.skillmanager.repository.AuditLogRepository;
import com.skillmanager.service.AuditLogService;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Override
    public void log(String action,
                    String entityName,
                    Long entityId,
                    String performedBy) {

        AuditLog audit = new AuditLog(
                action,
                entityName,
                entityId,
                performedBy,
                LocalDateTime.now());

        auditLogRepository.save(audit);
    }

    @Override
    public List<AuditLog> getAllLogs() {
        return auditLogRepository.findAll();
    }
}