package com.impact.impact.app.models.dtos;

import com.impact.impact.app.models.Role;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDtoInfo {
    private String username;
    private Collection<RoleDto> roles;

    public UserDtoInfo(String username, Collection<Role> roles) {
        Collection<RoleDto> roleDtos = new ArrayList<>();
        this.username = username;
        roles.stream().forEach(role -> {
            roleDtos.add(new RoleDto(role.getRole_type()));
        });
        this.roles = roleDtos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }
}
