package com.impact.impact.app.services.user;

import com.impact.impact.app.models.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role getRoleById(Long role_id) throws Exception;
}
