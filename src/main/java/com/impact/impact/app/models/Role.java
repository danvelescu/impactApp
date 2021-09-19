package com.impact.impact.app.models;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long role_id;

    @Column(name = "role_type")
    private String role_type;

    @ManyToMany(mappedBy = "userRoles")
    private Collection<User> users;

    public Role(){}

    public Role(long role_id, String role_type) {
        this.role_id = role_id;
        this.role_type = role_type;
    }

    public Role(Long role_id, String role_type, Collection<User> users) {
        this.role_id = role_id;
        this.role_type = role_type;
        this.users = users;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getRole_type() {
        return role_type;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
