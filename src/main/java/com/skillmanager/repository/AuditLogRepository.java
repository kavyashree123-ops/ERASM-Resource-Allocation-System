package com.skillmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillmanager.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

}