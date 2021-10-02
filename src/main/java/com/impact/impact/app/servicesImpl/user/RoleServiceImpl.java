package com.impact.impact.app.servicesImpl.user;

import com.impact.impact.app.models.Role;

import com.impact.impact.app.repositories.RoleRepository;
import com.impact.impact.app.services.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getRoleById(Long role_id) throws Exception {
        return roleRepository.getRoleByRole_id(role_id).orElseThrow(
                () -> new Exception("Role not found with role id -  " + role_id)
        );
    }
}
