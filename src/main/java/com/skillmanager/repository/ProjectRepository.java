package com.skillmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillmanager.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}