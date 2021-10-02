package com.impact.impact.app.models.dtos;

public class RoleDto {
    private String role_type;

    public RoleDto(String role_type) {
        this.role_type = role_type;
    }

    public String getRole_type() {
        return role_type;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }
}
