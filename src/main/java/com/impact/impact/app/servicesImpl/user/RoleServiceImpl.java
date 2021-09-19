package com.impact.impact.app.servicesImpl.user;

import com.impact.impact.app.models.Role;
import com.impact.impact.app.repositories.user.RoleRepository;
import com.impact.impact.app.services.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getRoleById(Long role_id) {
        return roleRepository.getRoleByRole_id(role_id);
    }
}
