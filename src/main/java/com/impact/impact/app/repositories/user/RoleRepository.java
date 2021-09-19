package com.impact.impact.app.repositories.user;

import com.impact.impact.app.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query(value = "SELECT r FROM Role r where  r.role_id = ?1")
    Optional<Role> getRoleByRole_id(Long id);
}
