package com.skillmanager.service;

import java.util.List;
import com.skillmanager.entity.Role;

public interface RoleService {

    Role saveRole(Role role);

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    void deleteRole(Long id);
}